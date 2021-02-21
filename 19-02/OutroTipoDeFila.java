public class OutroTipoDeFila{

    public static void main(String[] args) {
        
    }
}

class DequeReversivel{
    Deque deque;
    Boolean invertida;

    public DequeReversivel(){
        deque = new Deque();
        invertida = false;
    }

    public void pushFront(Integer value){
        if(invertida){
            deque.pushBack(value);
        }else{
            deque.pushFront(value);
        }
    }

    public Integer popFront(){
        if(invertida){
            return deque.popBack();
        }else{
            return deque.popBack();
        }
    }

    public void pushBack(Integer value){
        if(invertida){
            deque.pushFront(value);
        }else{
            deque.pushBack(value);
        }
    }

    public Integer popBack(){
        if(invertida){
            return deque.popFront();
        }else{
            return deque.popBack();
        }
    }

    public void inverter(){
        this.invertida = !this.invertida;
    }
}

class Deque{
    Node head;
    Node tail;
    int size;

    public Deque(){
        head = null;
        tail = null;
        size = 0;
    }

    public void pushFront(Integer value){
        if(size == 0){
            head = new Node(value);
            tail = head;
        }else{
            Node newNode = new Node(value);
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        size++;
    }

    public Integer popFront(){
        if(size == 0){
            return -1;
        }
        size--;
        Integer value = this.head.value;
        this.head = this.head.next;
        this.head.prev = null;
        return value;
    }

    public void pushBack(Integer value){
        if(size == 0){
            head = new Node(value);
            tail = head;
        }else{
            Node newNode = new Node(value);
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        size++;
    }

    public Integer popBack(){
        if(size == 0){
            return -1;
        }
        size--;
        Integer value = this.tail.value;
        this.tail = this.tail.prev;
        this.tail.next = null;
        return value;        
    }
}

class Node{
    Integer value;
    Node prev;
    Node next;

    public Node(){}

    public Node(Integer value){
        this.value = value;
    }
}