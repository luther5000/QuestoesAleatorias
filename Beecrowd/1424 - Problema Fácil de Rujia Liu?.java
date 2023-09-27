import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);

        while (tc.hasNext()){
            int numVet = Integer.parseInt(tc.next());
            int casos = Integer.parseInt(tc.next());
            tc.nextLine();

            int[] vet = new int[numVet];
            int tamanho = 0;
            for (int i = 0; i < numVet; i++){
                vet[i] = Integer.parseInt(tc.next());
                if (vet[i] > tamanho)
                    tamanho = vet[i];
            }
            tc.nextLine();

            Gambiarra teste = new Gambiarra(tamanho);
            teste.adiciona(vet);

            while (casos > 0){
                System.out.println(teste.verifica(Integer.parseInt(tc.next()),
                        Integer.parseInt(tc.next())));
                tc.nextLine();
                --casos;
            }
        }

    }
}

class Gambiarra{
    private List<Tudo>[] lista;
    private int tam;

    public Gambiarra (int tam) {
            this.tam = tam + 1;
            lista = new List[this.tam];

        for (int i = 0; i < this.tam; i++)
            lista[i] = new LinkedList<>();
    }

    public void adiciona(int[] tudo){
        for (int i = 0; i < tudo.length; i++){
            Tudo novo = new Tudo(tudo[i], i);
            lista[tudo[i]].add(novo);
        }
    }

    public int verifica (int quants, int num){
        if (lista[num].size() < quants)
            return 0;
        else {
            int cont = 0;
            for (int i = 0; i < lista[num].size(); i++) {
                if (lista[num].get(i).value == num)
                    ++cont;

                if (cont == quants)
                    return lista[num].get(i).indice + 1;
            }

        }
        return 0;
    }
}

class Tudo {
    int value;
    int indice;
    public Tudo (int value, int indice){
        this.indice = indice;
        this.value = value;
    }
}
