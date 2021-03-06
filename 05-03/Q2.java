import java.util.List;

package 05-03;

public class Q2 {
    public static void main(String[] args) {
        
    }
    
}

class Node{
    Node left, right;
    Character value;

    public Node(){}

    public Node(Character value){
        this.value = value;
    }
}

class Tree{
    Node root = new Node();

    public boolean inserir(String codigo, Character ch){
        Node aux = root;
        for(char c : codigo.toCharArray()){
            if(c == '.'){
                if(aux.left == null) aux.left = new Node();
                aux = aux.left;
            }else if(c == '-'){
                if(aux.right == null) aux.right = new Node();
                aux = aux.right;
            }
        }
        if(aux.value == null){
            aux.value = ch;
            return true;
        }
        return false;
    }

    public Character remover(String codigo){
        Node aux = root;
        for(char c : codigo.toCharArray()){
            if(c == '.'){
                if(aux.left == null) return null;
                aux = aux.left;
            }else if(c == '-'){
                if(aux.right == null) return null;
                aux = aux.right;
            }
        }
        if(aux.value != null){
            Character ch = aux.value;
            aux.value = null;
            return ch;
        }
        return aux.value;
    }

    public Character buscar(String codigo){
        Node aux = root;
        for(char c : codigo.toCharArray()){
            if(c == '.'){
                if(aux.left == null) return null;
                aux = aux.left;
            }else if(c == '-'){
                if(aux.right == null) return null;
                aux = aux.right;
            }
        }
        return aux.value;
    }

    public String decodificar(List<String> codigos){
        StringBuilder result = new StringBuilder();
        for(String codigo : codigos){
            Character ch = buscar(codigo);
            if(ch == null){
                return null;
            }
            result.append(ch);
        }
        return result.toString();
    }

}
