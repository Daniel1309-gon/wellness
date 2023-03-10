package wellness;

public class LinkedList<T> {

    public class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> prev;

        Node() {
            this.data = null;
            this.next = null;
            this.prev = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

    }

    Node<T> head;
    Node<T> tail;
    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void pushFront(T data) {
        Node<T> a = new Node<T>();
        a.data=data;
        a.next=null;
        head = a;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void popFront() {
        if (head == null) {
            System.out.println("Error: empty list");
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    public T topFront() {
        return head.data;
    }

    public void pushBack(T data) {
        Node<T> a = new Node<T>();
        a.data=data;
        a.next=null;
        if(tail == null) {
            head = a;
            tail = a;
            a.prev = null;
        }else{
            tail.next = a;
            a.prev = tail;
            tail = a;
        }
        size++;
    }

    public void popBack() {
        if (head == null) {
            System.out.println("Error: empty list");
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public T topBack() {
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean find(T data) {
        boolean f = false;
        for (Node<T> a = head; a != null; a = a.next) {
            f = a.data == data;
            if (f == true) {
                break;
            }
        }
        return f;
    }

    public int size() {
        return size;
    }

    public void remove(T data) {
        for (Node<T> a = head; a.next != null; a = a.next) {
            if (a.next.data.equals(data)) {
            a.next = a.next.next;
            break;
            }
        }
    }

    public void addBefore(Node<T> a, T data) {
        Node<T> b = new Node<T>();
        b.data=data;
        b.next=a;
        b.prev = a.prev;
        a.prev = b;
        if (b.next != null) {
            b.prev.next = b;
        }
        if (head == a) {
            head = b;
        }
        size++;
    }

    public void addAfter(Node<T> a, T data) {
        Node<T> b = new Node<T>();
        b.data=data;
        b.next=a.next;
        b.prev = a;
        a.next = b;
        if (b.next != null) {
            b.next.prev = b;
        }
        if (head == a) {
            head = b;
        }
        size++;
    }

    public int getIndex(T data) {
        int c = 0;
        for (Node<T> a = head; a != null; a = a.next) {
            if (a.data == data) {
                break;
            }
            c++;
        }
        return c;
    }

    public T get(int index){
        Node <T> a = head;
        for (int i = 0; i < index; i++) {
            a=a.next;
        }
        return a.data;
    }

    public void clear() {
        while(!isEmpty()){
            popFront();
        }
    }

    public void print() {
        if (head != null) {
            for (Node<T> a = head; a != null; a = a.next) {
                System.out.print(a.data+"");
                if (a.next != null) {
                    System.out.print(" ");
                }
            }
        }
    }

    public void clone(LinkedList<T> A) {
        Node a = A.head;
        clear();
        for (int i = 0; i < A.size; i++) {
            pushBack((T) a.data);
            a = a.next;
        }
    }

}