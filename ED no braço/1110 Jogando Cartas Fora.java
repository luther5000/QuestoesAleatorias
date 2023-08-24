import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner tc = new Scanner(System.in);
        while(true) {
            int quant = Integer.parseInt(tc.nextLine());
            if (quant == 0)
                System.exit(0);
            Fila baralho = new Fila();
            for (int i = quant; i >= 1; i--)
                baralho.adiciona(i);
            baralho.printaAll();
            Fila jogadasFora = new Fila();
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


class Fila{
    int[] vet;
    int inicio;
    int fim;

    public Fila(){
        vet = new int[15];
        inicio = 0;
        fim = 0;
    }

    public void adiciona(int num){
        vet[fim++] = num;
    }

    public int remove(){
        return vet[inicio++];
    }

    public void mudaPosicao(){
        int a = vet[inicio];
        for (int i = inicio; i < fim-1; i++){
            vet[i] = vet[i+1];
        }
        vet[fim] = a;
    }

    public void printaAll(){
        for ()
    }

    public int getTam(){
        return fim;
    }
    /*public void printa(){
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
}*/
}
