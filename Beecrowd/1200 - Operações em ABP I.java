public class Main {
    public static void main (String[] args){

    }
}

class Arvore{
    No raiz;

    public Arvore(){
        raiz = null;
    }
    
    public void adiciona(char a){
        if (raiz == null) {
            raiz = new No(a);
            return;
        }
        
        No aux = raiz;
        while (true) {
            if (a > aux.content) {
                if (aux.direita == null)
                    break;
                aux = aux.direita;
            }
            else {
                if (aux.esquerda == null)
                    break;
                aux = aux.esquerda;
            }
        }
    }
}
class No{
    No direita;
    No esquerda;
    char content;

    public No(char content){
        direita = null;
        esquerda = null;
        this.content = content;
    }
}
