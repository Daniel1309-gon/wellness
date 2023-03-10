package wellness;

public class ArrayList <T> {

    private T[] Array;
    private int size;
    private int capacity;

    public ArrayList(int size) {
        Array = (T[]) new Object[size];
        this.size = size;
        capacity = size;
    }

    public void pushBack(T data) {
        if(size == capacity) {
            T[] newArray = (T[]) new Object[2*capacity];
            for(int i = 0; i < capacity; i++) {
                newArray[i] = Array[i];
            }
            capacity *= 2;
            Array = newArray;
        }
        Array[size] = data;
        size++;
    }

    public void popBack() {
        if(size == 0) {
            System.out.println("Null Array");
        }
        size--;
    }

    public T popFront() throws Exception {
        T removed = null;
        if(size == 0) {
            System.out.println("Null Array");
        }
        try{
            removed = remove(0);
        }catch(Exception e) {
        }
        return removed;
    }

    public T remove(int index){
        if(size == 0) {
            System.out.println("Null Array");
        }
        T removed = Array[index];
        for(int i = index ; i < size - 1; i ++) {
            Array[i] = Array[i + 1];
        }
        size--;
        return removed;
    }

    public void deleteValue(T value) throws Exception {
        boolean found = false;
        for(int i = 0 ; i < size ; i ++) {
            T c = Array[i];
            if(c == value) {
                found = true;
                try {
                    remove(i);
                }catch(Exception e){
                }
            }
        }
        if(!found) {
            throw new Exception("Element not found");
        }
    }

    public T get(int index) {
        return Array[index];
    }

    public void set(int index, T value) {
        Array[index] = value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}