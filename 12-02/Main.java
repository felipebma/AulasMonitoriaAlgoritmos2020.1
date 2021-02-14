public class Main{

    public static void main(String[] args) {
        Listas lista = new Listas();
        lista.insert(1);
        lista.insert(2);
        lista.insert(3);
        System.out.println(lista);
        lista.removeAll(2);
        System.out.println(lista);
    }
}

class Listas{

    ListNode head;
    ListNode last;

    public Listas(){
        this.head = null;
        this.last = null;
    }

    public void insert(Integer valor){
        if(this.head == null){
            this.head = new ListNode(valor);
            this.last = head;
        }else{
            this.last.proximo = new ListNode(valor, last, null);
            this.last = this.last.proximo;
        }
    }

    public void removeAll(Integer valor){
        ListNode aux = head;
        while(aux != null){
            if(aux.valor == valor){
                if(aux != head && aux != last){
                    ListNode proxAux = aux.proximo;
                    ListNode antAux = aux.anterior;
                    antAux.proximo = proxAux;
                    proxAux.anterior = antAux;
                }else if(aux == head){
                    this.head = aux.proximo;
                    this.head.anterior = null;
                }else if(aux == last){
                    this.last = this.last.anterior;
                    this.last.proximo = null;
                }
            }
            aux = aux.proximo;
        }
    }

    @Override
    public String toString(){
        return this.head.toString();
    }

}

class ListNode{

    Integer valor;
    ListNode anterior;
    ListNode proximo;

    public ListNode(Integer valor){
        this.valor = valor;
    }

    public ListNode(Integer valor, ListNode anterior, ListNode proximo){
        this.valor = valor;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    @Override
    public String toString(){
        if(this.proximo == null){
            return "" + this.valor;
        }
        return this.valor + " -> " + this.proximo.toString();
    }
}