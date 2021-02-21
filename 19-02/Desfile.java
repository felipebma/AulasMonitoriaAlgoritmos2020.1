import java.util.Scanner;

public class Desfile {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Scanner in = new Scanner(System.in);
        Carro last = null;
        while(in.hasNextLine()){
            String tema = in.nextLine();
            Double numPessoas = Double.parseDouble(in.nextLine());
            Carro novoCarro = new Carro(tema, numPessoas);
            if(pilha.isEmpty()){
                pilha.push(novoCarro);
            }else{
                while(!pilha.isEmpty() && novoCarro.compareTo(pilha.peek()) > 0){
                    Carro inserido = pilha.pop();
                    if(last != null && inserido.compareTo(last) < 0){
                        System.out.println("False");
                        return;
                    }
                    last = inserido;
                }
                pilha.push(novoCarro);
            }
        }
        if(last != null && !pilha.isEmpty() && pilha.peek().compareTo(last) < 0){
            System.out.println("False");
        }else{
            System.out.println("True");
        }        
    }
}

class Pilha{
    Node top;

    public Pilha(){}

    public Boolean isEmpty(){
        return top == null;
    }

    public void push(Carro carro){
        Node newNode = new Node(carro);
        newNode.next = this.top;
        this.top = newNode;
    }

    public Carro pop(){
        if(top == null){
            return null;
        }
        Carro carro = top.carro;
        top = top.next;
        return carro;
    }

    public Carro peek(){
        return this.top.carro;
    }
}

class Node{
    Carro carro;
    Node next;

    public Node(){}

    public Node(Carro carro){
        this.carro = carro;
    }
}

class Carro implements Comparable<Carro>{
    String name;
    Double numPeople;

    public Carro(String name, Double numPeople){
        this.name = name;
        this.numPeople = numPeople;
    }

    @Override
    public int compareTo(Carro o) {
        if(this.numPeople < o.numPeople){
            return -1;
        }else if(this.numPeople == o.numPeople){
            return o.name.compareTo(this.name);
        }
        return 1;
    }
}