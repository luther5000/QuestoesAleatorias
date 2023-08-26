import java.util.Scanner;

class Main{
    public static void main (String[] args) {
        Scanner tc = new Scanner(System.in);
        int quant = Integer.parseInt(tc.nextLine());
        while (quant > 1) {

            Fila baralho = new Fila();
            Fila jogadasFora = new Fila();

            for (int i = 1; i <= quant; i++)
                baralho.adiciona(i);

            while (baralho.getTam() >= 2){
                jogadasFora.adiciona(baralho.remove());
                baralho.trocaPosicao();
            }

            System.out.print("Discarded cards: ");
            jogadasFora.printa();
            System.out.print("Remaining card: ");
            baralho.printa();

            quant = Integer.parseInt(tc.nextLine());
        }
    }
}

class Fila {

    private No inicio;
    private No fim;
    private int tam;

    public Fila (){
        inicio = null;
        fim = null;
        tam = 0;
    }

    public void adiciona(int num){
        No novoNo = new No(); novoNo.setCarta(num);
        if (tam == 0){
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProx(novoNo);
            fim = novoNo;
        }
        ++tam;
    }

    public void trocaPosicao(){
        No novoNo = new No();
        novoNo.setCarta(inicio.getCarta());
        fim.setProx(novoNo);
        fim = novoNo;
        inicio = inicio.getProx();
    }

    public int remove(){
        int a = inicio.getCarta();
        inicio = inicio.getProx();
        --tam;
        return a;
    }

    public void printa(){
        No aux = inicio;
        while (aux.getProx() != null){
            System.out.print(aux.getCarta() + ", ");
            aux = aux.getProx();
        }
        System.out.println(aux.getCarta());
    }

    public int getTam() {
        return tam;
    }
}
class No {
    private int carta;
    private No prox;

    public No(){
        prox = null;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public int getCarta() {
        return carta;
    }

    public void setCarta(int carta) {
        this.carta = carta;
    }
}
