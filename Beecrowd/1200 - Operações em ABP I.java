import java.util.Stack;

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

        if (aux.content > a)
            aux.esquerda = new No(a);
        else
            aux.direita = new No(a);
    }

    public void pesquisa(char a){
        if (raiz.content == a)
            System.out.print("existe");

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

            if (aux.content == a){
                System.out.print("existe");
                return;
            }
        }

        System.out.print("nao existe");
    }
    public void infixo(){
        No aux = null;
        Stack<No> pilha = new Stack<>();
        pilha.add(raiz);
        while (!(pilha.isEmpty())){
            aux = pilha.pop();
            System.out.print(aux.content);

            if (aux.direita != null)
                pilha.push(aux.direita);
            if (aux.esquerda != null)
                pilha.push(aux.esquerda);
        }

        if (!(pilha.isEmpty()))
            System.out.print(" ");
    }

    public void prefixo(No atual){
        if (atual == null)
            return;
        if (atual.esquerda != null) {
            System.out.print(atual.esquerda.content + " ");
            prefixo(atual.esquerda);
        }

        System.out.print(atual.content + " ");

        if (atual.direita != null){
            System.out.print(atual.direita.content + " ");
            prefixo (atual.direita);
        }
    }

    public void posfixo(No atual){
        if (atual == null)
            return;
        if (atual.esquerda != null) {
            System.out.print(atual.esquerda.content + " ");
            prefixo(atual.esquerda);
        }

        System.out.print(atual.content + " ");

        if (atual.direita != null){
            System.out.print(atual.direita.content + " ");
            prefixo (atual.direita);
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
