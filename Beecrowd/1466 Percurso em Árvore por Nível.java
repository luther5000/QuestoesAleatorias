import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int casos = Integer.parseInt(tc.nextLine());
        int cont = 1;

        while (cont <= casos) {
            int tam = Integer.parseInt(tc.nextLine());
            Arvore arvore = new Arvore();

            for (int i = 0; i < tam; i++){
                arvore.insere(Integer.parseInt(tc.next()));
            }
            tc.nextLine();

            System.out.println("Case " + cont + ":");
            arvore.printa(tam);

            ++cont;
        }
    }
}

class Arvore{
    No raiz;

    public Arvore(){
        raiz = null;
    }

    public void insere(int num){
        if (raiz == null){
            raiz = new No(num);
            return;
        }

        insere(raiz, num);
    }

    private void insere(No atual, int num){
        if (num > atual.num) {
            if (atual.direita == null)
                atual.direita = new No(num);
            else
                insere(atual.direita, num);
        }
        else
        if (atual.esquerda == null)
            atual.esquerda = new No(num);
        else
            insere(atual.esquerda, num);
    }

    public void printa(int quant){
        Queue<No> fila = new LinkedList<>();

        fila.add(raiz);
        int cont = 0;
        while (!(fila.isEmpty())){
            No atual = fila.remove();

            if (cont < quant-1) {
                System.out.print(atual.num + " ");
                ++cont;
            } else
                System.out.println(atual.num + "\n");


            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null){
                fila.add(atual.direita);
            }
        }
    }
}

class No {
    int num;
    No esquerda;
    No direita;

    public No(int c) {
        this.num = c;
        esquerda = null;
        direita = null;
    }
}
