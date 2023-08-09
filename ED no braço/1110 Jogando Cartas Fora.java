import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner tc = new Scanner(System.in);
        while(true) {
            int quant = Integer.parseInt(tc.nextLine());
            if (quant == 0)
                System.exit(0);
            Lista baralho = new Lista();
            for (int i = quant; i >= 1; i--)
                baralho.adiciona(i);
            baralho.printaAll();
            Lista jogadasFora = new Lista();
            while (baralho.getTam() >= 2){
                jogadasFora.adiciona(baralho.remove());
                baralho.mudaPosicao();
            }
            System.out.print("Discarded cards: ");
            jogadasFora.printa();
            System.out.print("Remaining card: ");
            baralho.printa();
        }
    }
}


class Lista{
    private No cabeca;
    private int tam;
    private No ultimo;

    public Lista() {
        cabeca = null;
        tam = 0;
        ultimo = null;
    }

    public void adiciona(int num){
        No novoNo = new No(num);
        novoNo.setProx(cabeca);
        cabeca = novoNo;
        if (tam == 0)
            ultimo = novoNo;
        tam++;
    }

    public int remove(){
        if (tam > 0) {
            int aux = cabeca.getCarta();
            cabeca = cabeca.getProx();
            tam--;
            return aux;
        }
        return -1;
    }

    public void mudaPosicao() {
        if (tam >= 2) {
            ultimo.setProx(cabeca);
            cabeca = cabeca.getProx();
        }
    }

    public void printa(){
        if (tam == 0)
            System.out.println();
        else if (tam == 1)
            System.out.println(cabeca.getCarta());
        else if (tam > 1) {
            int[] aux = new int[tam];
            No auxiliar = cabeca;
            for (int i = tam; i >= 1; i--) {
                aux[i - 1] = auxiliar.getCarta();
                auxiliar = auxiliar.getProx();
            }
            for (int i = 0; i < aux.length; i++)
                if (i != aux.length - 1)
                    System.out.print(i + ", ");
                else
                    System.out.println(i);
        }
    }

    public void printaAll(){
        No aux = cabeca;
        for (int i = 1; i <= tam; i++)
            System.out.println(aux.getCarta());
    }

    public int getTam(){ return tam; }
}

class No {
    private int carta;
    private No prox;

    public No(int carta) {
        this.carta = carta;
        prox = null;
    }

    public int getCarta() {
        return carta;
    }

    public No getProx(){
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}
