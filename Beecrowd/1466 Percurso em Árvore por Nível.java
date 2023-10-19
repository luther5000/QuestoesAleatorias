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
        int cont = 0;
        if (raiz == null){
            No novoNo = new No(num, cont++);
            raiz = novoNo;
            return;
        }

        insere(raiz, num, cont);
    }

    private void insere(No atual, int num, int cont){
        if (num > atual.num) {
            if (atual.direita == null)
                atual.direita = new No(num, cont++);
            else
                insere(atual.direita, num, cont);
        }
        else
            if (atual.esquerda == null)
                atual.esquerda = new No(num, cont++);
            else
                insere(atual.esquerda, num, cont);
    }

    public void printa(int quant){
        Queue<No> fila = new LinkedList<>();
        boolean[] flag = new boolean[quant];

        flag[raiz.ordem] = true;
        fila.add(raiz);
        int cont = 0;
        while (!(fila.isEmpty())){
            No atual = fila.remove();

            if (cont < quant) {
                System.out.print(atual.num + " ");
                ++cont;
            } else
                System.out.println(atual.num);


            if (atual.esquerda != null && !(flag[atual.esquerda.ordem])) {
                flag[atual.esquerda.ordem] = true;
                fila.add(atual.esquerda);
            }
            if (atual.direita != null && !(flag[atual.direita.ordem])){
                flag[atual.direita.ordem] = true;
                fila.add(atual.direita);
            }
        }
    }
}

class No{
    int ordem;
    int num;
    No esquerda;
    No direita;

    public No(int c, int ordem){
        this.ordem = ordem;
        this.num = c;
        esquerda = null;
        direita = null;
    }
}
