import java.util.Scanner;

class Main {
    public static void main (String[] args){
        Scanner tc = new Scanner(System.in);
        int tam = Integer.parseInt(tc.nextLine());
        
        while (tam != 0) {
            Lista l = new Lista(tam);
            
            int res = fazTudo(l, tam);
            System.out.println(res);
            
            tam = Integer.parseInt(tc.nextLine());
        }
    }

    public static int fazTudo(Lista l, int tam){
        int a = 1;
        
        while (!(l.remove(a))){
            l = new Lista(tam);
            ++a;
        }
        
        return a;
    }
}

class Lista {
    private No cabeca;
    private No fim;
    private int tam;
    private No atual;

    public Lista(int tam) {
        adiciona(tam);
        
        this.tam = tam;
        atual = cabeca;
    }

    public void adiciona(int tam) {
        No aux = new No(1);
        cabeca = aux;
        
        for (int i = 2; i <= tam; i++) {
            No aux2 = new No(i);
            
            aux.setProx(aux2);
            aux = aux2;
        }
        
        aux.setProx(cabeca);
        fim = aux;
    }

    public boolean remove (int pulos){
        No aux = atual;
        No aux2  = fim;
        
        aux2.setProx(aux.getProx());
        atual = aux.getProx();
        aux = aux.getProx();
        --tam;
        
        while (!(vazia())) {
            for (int i = 1; i < pulos; i++) {
                aux2 = aux;
                aux = aux.getProx();
            }
            
            aux2.setProx(aux.getProx());
            atual = aux.getProx();
            --tam;
            
            if (!(vazia()) && aux.getRegiao() == 13){
                return false;
            }
            
            aux = atual;
        }
        return true;
    }
    
    public boolean vazia(){
        return tam==0;
    }
}


class No {
    private No prox;
    private int regiao;

    public No(int regiao){
        prox = null;
        this.regiao = regiao;
    }

    public int getRegiao() {
        return regiao;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}
