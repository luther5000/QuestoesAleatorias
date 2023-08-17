import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner tc = new Scanner(System.in);

        int tamVet = Integer.parseInt(tc.next());
        int quant = Integer.parseInt(tc.nextLine().substring(1));

        Lista vetor = new Lista(tamVet);
        for (int i = 0; i < tamVet; i++)
            vetor.adiciona(Integer.parseInt(tc.next()));
        tc.nextLine();

        for (int i = 0; i < quant; i++)
            System.out.println(vetor.compara(Integer.parseInt(tc.next()), Integer.parseInt(tc.nextLine().substring(1))));

    }
}

class Lista {
    private int vet[];
    private final int tamMax;
    private int tamAtual;

    public Lista(int quant){
        vet = new int[quant];
        tamAtual = 0;
        tamMax = quant;
    }

    public boolean adiciona (int num){
        if (tamAtual < tamMax) {
            vet[tamAtual] = num;
            tamAtual++;
            return true;
        } else {
            return false;
        }
    }

    public int compara(int ocorrencia, int numero){
        int i = 0;
        int indiceAtual = 0;
        while (i != ocorrencia && indiceAtual < tamMax){
            if (vet[indiceAtual] == numero)
                i++;
            indiceAtual++;
        }
        if (i == ocorrencia)
            return indiceAtual;
        else
            return 0;
    }
}
