package wellness;

public class HashTable {

    class NodeHash {

        public String key;
        public String data;

        public NodeHash(String key, String data) {
        this.key = key;
        this.data = data;
        } 
        
    }
    
    public ArrayList<LinkedList<NodeHash>> table;
    public int cardinality;
    public int size;
    private double loadFactor;

    public HashTable(int cardinality) {
        
        table = new ArrayList<LinkedList<NodeHash>>(cardinality);
        for (int i=0;i<cardinality;i++){
            table.pushBack(new LinkedList<>());
        }
        this.cardinality = cardinality;
        this.size = 0;
    }
    
    public int hash(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash+= (int) str.charAt(i);
        }
        return (hash*7)%cardinality;
    }

    public void set(String key, String data)  {
        int hashCode = hash(key);
        LinkedList<NodeHash> L = table.get(hashCode);
        int listSize = 0;
        NodeHash aux = null;
        
        if(L!=null){
            listSize = L.size;
        }else{
            table.set(hashCode, new LinkedList<>());
            L = table.get(hashCode);
        }
        
        for(int i = 0 ; i < listSize ; i++) {
            aux = L.get(i);
            if(key.equals(aux.key)) {
                aux.data = data;
                return;
            }
        }


        aux = new NodeHash(key, data);
        L.pushBack(aux);
        this.size++;
        updateLoadFactor();
        if(this.loadFactor > 0.9){
            reHashing();
        }
    }
    
    public String get(String key) {
        
        String data = "";
        int hashValue = hash(key);
        LinkedList<NodeHash> L = table.get(hashValue);
        
        for (LinkedList<NodeHash>.Node<NodeHash> a = L.head; a != null; a=a.getNext()) {
            if(key.equals(a.getData().key))
            return a.getData().data;
        }
        return "";
    }

    public boolean containsKey(String key){
        if(get(key)==""){
            return false;
        }
        return true;
    }
    
    public boolean isEmpty(){
        for (int i = 0; i < cardinality; i++) {
            if(!(table.get(i).isEmpty())){
                return true;
            }
        }
        return false;
    }
    
    private void reHashing() {

        ArrayList<LinkedList<NodeHash>> temporalTable = table;
        table = new ArrayList<LinkedList<NodeHash>> (cardinality*2);
        this.size=0;
        for(int i=0;i<cardinality*2;i++){
            table.pushBack(new LinkedList<>());
        }
        this.cardinality *=2;
        int tempListSize=0;


        for(int i=0;i<temporalTable.getSize();i++){
            LinkedList<NodeHash> temporalList = temporalTable.get(i);
            if(temporalList!=null){
                tempListSize=temporalList.size;
            }
            for (int j=0;j<tempListSize;j++){
                try{
                    String key = temporalList.get(j).key;
                    String value = temporalList.get(j).data;
                    set(key,value);
                }catch(Exception e){}
            }
        }
    }
    
    private void updateLoadFactor(){
        this.loadFactor = 1.0*this.size/this.cardinality;
    }
    
}