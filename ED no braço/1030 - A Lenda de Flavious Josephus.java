import java.util.Scanner;
import java.util.SimpleTimeZone;

class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int quant = Integer.parseInt(tc.nextLine());

        int i = 1;
        while (i <= quant) {
            Lista lista = new Lista(Integer.parseInt(tc.next()));
            int pulos = Integer.parseInt(tc.next()); tc.nextLine();

            System.out.println("Case " + i + ": " + lista.remove(pulos));
            ++i;
        }
    }
}

class Lista{
    private No cabeca;
    private int tam;
    private No atual;

    public Lista(int tam){
        adiciona(tam);
        this.tam = tam;
        atual = cabeca;
    }

    public void adiciona(int tam){
        No aux = null;
        No aux2 = null;
        for (int i = 1; i <= tam; i++){
            No novoNo = new No(i);
            if (i == 1){
                cabeca = novoNo;
                aux = cabeca;
            } else {
                aux.setProx(novoNo);
                aux = novoNo;
            }
        }
        aux.setProx(cabeca);
    }

    public int remove(int pulo){
        No aux = atual;
        if (tam == 1){
            return aux.getIndice();
        } else {
            No aux2 = aux;
            for (int i = 1; i < pulo; i++) {
                aux2 = aux;
                aux = aux.getProx();
            }
            aux2.setProx(aux.getProx());
            atual = aux.getProx();
            --tam;
            return remove(pulo);
        }
    }
}


class No {
    private int indice;
    private No prox;

    public No (int nome){
        this.indice = nome;
        prox = null;
    }

    public void setProx(No prox){
        this.prox = prox;
    }

    public int getIndice(){
        return indice;
    }

    public No getProx() {
        return prox;
    }
}
