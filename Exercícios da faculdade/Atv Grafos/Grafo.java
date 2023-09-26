import java.util.*;

public class Grafo {
    private int[][] matrizAdjacencia;
    private List<Integer>[] list;
    private int tam;
    private int[][] dist;
    private int[][] ant;
    private boolean[] jaFez;


    public Grafo(int tam){
        matrizAdjacencia = new int[tam][tam];

        list = new List[tam];
        for (int i = 0; i < tam; i++)
            list[i] = new ArrayList<>();

        this.tam = tam;
        dist = new int[tam][tam]; //guarda as distancias
        ant = new int[tam][tam]; // guarda os antecessores
        jaFez = new boolean[tam]; //flag para saber se determinado bfs ja foi feito
    }

    public void printaMatriz(){
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam - 1; j++)
                System.out.print(matrizAdjacencia[i][j] + " - ");
            System.out.println(matrizAdjacencia[i][tam-1]);
        }
    }

    public void adicionar (int[][] matriz){
        matrizAdjacencia = matriz;

        for (int i = 0; i < tam; i++){
            for (int j = 0; j < tam; j++){
                if (matriz[i][j] != 0){
                    list[i].add(j);
                }
            }
        }
    }

    private int[] bfs(int inicio){
        boolean[] flag = new boolean[tam];
        Queue<Integer> fila = new LinkedList<>();

        int atual;
        fila.add(inicio);
        flag[inicio] = true;
        Arrays.fill(ant[inicio], -1);

        while (!(fila.isEmpty())){
            atual = fila.remove();

            for (int j = 0; j < list[atual].size(); j++){
                if (!(flag[list[atual].get(j)])){
                    ant[inicio][list[atual].get(j)] = atual;

                    flag[list[atual].get(j)] = true;
                    fila.add(list[atual].get(j));

                    dist[inicio][list[atual].get(j)] = dist[inicio][atual] + 1;
                }
            }
        }
        return ant[inicio];
    }

    public int[] caminho(int origem, int destino){
        if (jaFez[origem]) {
            int aux = ant[origem][destino];
            int[] retorno = new int[dist[origem][destino]];

            for (int i = dist[origem][destino] - 1; i >= 0; i--) {
                retorno[i] = aux;
                aux = ant[origem][aux];
            }

            return retorno;
        } else {
            jaFez[origem] = true;
            bfs(origem);

            int aux = ant[origem][destino];
            int[] retorno = new int[dist[origem][destino]];

            for (int i = dist[origem][destino] - 1; i >= 0; i--) {
                if (aux == -1)
                    break;

                retorno[i] = aux+1;
                aux = ant[origem][aux];
            }

            return retorno;
        }

    }

    public int numCompConexa(){
        int quant = 0;
        int[] pai = dfs();

        for (int i = 0; i < pai.length; i++)
            if (pai[i] == -1)
                ++quant;

        return quant;
    }

    private int[] dfs(){
        boolean[] flag = new boolean[tam];
        Stack<Integer> pilha = new Stack<>();
        int[] pai = new int[tam];
        Arrays.fill(pai, -1);

        for (int j = 0; j < list.length; j++) {
            if (!(flag[j])) {
                pilha.push(j);
                flag[j] = true;
            }

            while (!(pilha.isEmpty())) {
                int ant = pilha.pop();

                for (int i = 0; i < list[ant].size(); i++) {
                    if (!(flag[list[ant].get(i)])) {
                        flag[list[ant].get(i)] = true;
                        pai[list[ant].get(i)] = ant;

                        pilha.push(list[ant].get(i));
                    }
                }
            }
        }
        return pai;
    }
}
