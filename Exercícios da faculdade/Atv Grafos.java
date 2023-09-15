import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }
}

class Grafo {
    private int[][] matrizAdjacencia;
    private List<Integer>[] list;
    private int tam;


    public Grafo(int tam){
        matrizAdjacencia = new int[tam][tam];
        list = new List[tam];
        for (int i = 0; i < tam; i++)
            list[i] = new LinkedList<>();
        this.tam = tam;
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

    public int[] bfs(int inicio){
        int[] retorno = new int[tam];
        boolean[] flag = new boolean[tam];
        Queue<Integer> fila = new LinkedList<>();

        int atual;
        fila.add(inicio);
        while (!(fila.isEmpty())){
            atual = fila.remove();
            for (int j = 0; j < list[atual].size(); j++){
                if (!(flag[list[atual].get(j)])){ //pegar o indicie que se refere ao no na lista e ver se esse no ja foi visto
                    flag[list[atual].get(j)] = true;
                    fila.add(list[atual].get(j));
                }
            }
        }
    }
}
