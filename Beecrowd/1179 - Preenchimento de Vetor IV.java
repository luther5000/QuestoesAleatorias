import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner tc = new Scanner(System.in);
        int compara;
        Lista impar = new Lista();
        Lista par = new Lista();
        for (int i = 0; i < 15; i++){
            compara = Integer.parseInt(tc.nextLine());
            if (compara % 2 != 0){
                if (impar.cheia()){
                    for (int j = 0; j < 5; j++){
                        System.out.println("impar[" + j + "] = " + impar.getVet(j));
                    }
                    impar.zeraLista();
                }
                impar.adiciona(compara);
            } else {
                if (par.cheia()){
                    for (int j = 0; j < 5; j++){
                        System.out.println("par[" + j + "] = " + par.getVet(j));
                    }
                    par.zeraLista();
                }
                par.adiciona(compara);
            }
        }
        if (!(impar.vazia()))
            for (int i = 0; i < impar.getTamAtual(); i++)
                System.out.println("impar[" + i + "] = " + impar.getVet(i));
        if (!(par.vazia()))
            for (int i = 0; i < par.getTamAtual(); i++)
                System.out.println("par[" + i + "] = " + par.getVet(i));

    }
}

class Lista {
    private int vet[];
    private final int tamMax = 5;
    private int tamAtual;

    public Lista(){
        vet = new int[5];
        tamAtual = 0;
    }

    public boolean adiciona (int num){
        if (tamAtual <= tamMax) {
            vet[tamAtual] = num;
            tamAtual++;
            return true;
        } else {
            return false;
        }
    }

    public int getTamAtual(){
        return tamAtual;
    }

    public int getVet(int indice){
        return vet[indice];
    }

    public void zeraLista(){
        tamAtual = 0;
    }

    public boolean cheia(){
        return (tamAtual == tamMax);
    }

    public boolean vazia(){
        return (tamAtual == 0);
    }
}
