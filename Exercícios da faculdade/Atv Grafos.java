import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        List<String> texto = Files.readAllLines(Path.of("/home/lutero/IdeaProjects/beecrowd/src/pcv4.txt"),
                StandardCharsets.UTF_8);
        int tam = Integer.parseInt(texto.get(0));
        texto.remove(0);

        Grafo grafo = new Grafo(tam);
        grafo.adicionar(trata(texto, tam));

        while (true) {
            Scanner tc = new Scanner(System.in);

            System.out.println("Qual o vértice de origem?");
            int origem = Integer.parseInt(tc.nextLine())-1;


            System.out.println("Qual o vértice de destino?");
            int destino = Integer.parseInt(tc.nextLine())-1;

            grafo.bfs(origem);
            int[] caminho = grafo.caminho(origem, destino);

            for(int i = 0; i < caminho.length; i++)
                if (i != caminho.length-1)
                    System.out.print(caminho[i] + " ");
                else
                    System.out.println(caminho[i]);

            System.out.println("Deseja sair?\n1. Sim\n2. Não");
            origem = Integer.parseInt(tc.nextLine());
            if (origem == 1)
                System.exit(0);
        }
    }

    public static int[][] trata(List<String> entrada, int tam){
        int[][] matriz = new int[tam][tam];

        for (int i = 0; i < tam; i++) {
            String[] nums = entrada.get(i).split("\t");

            for (int j = 0; j < tam; j++) {
                matriz[i][j] = Integer.parseInt(nums[j]);
            }
        }
        return matriz;
    }
}

class Grafo {
    private int[][] matrizAdjacencia;
    private List<Integer>[] list;
    private int tam;
    private int[][] dist;
    private int[][] ant;


    public Grafo(int tam){
        matrizAdjacencia = new int[tam][tam];
        list = new List[tam];
        for (int i = 0; i < tam; i++)
            list[i] = new LinkedList<>();
        this.tam = tam;
        dist = new int[tam][tam];
        ant = new int[tam][tam];
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
        int[] teste = new int[tam];
        if (!(Arrays.equals(ant[inicio], teste)))
            return ant[inicio];
        teste = null;

        boolean[] flag = new boolean[tam];
        Queue<Integer> fila = new LinkedList<>();

        int atual;
        fila.add(inicio);
        flag[inicio] = true;

        while (!(fila.isEmpty())){
            atual = fila.remove();

            for (int j = 0; j < list[atual].size(); j++){
                if (!(flag[list[atual].get(j)])){ //pegar o indicie que se refere ao no na lista e ver se esse no ja foi visto
                    ant[inicio][list[atual].get(j)] = atual;

                    flag[list[atual].get(j)] = true;
                    fila.add(list[atual].get(j));

                    dist[inicio][list[atual].get(j)] = atual + 1;
                }
            }
        }
        printVetor(ant, inicio);
        printVetor(dist, inicio);
        return ant[inicio];
    }

    public void printVetor(int[][] matriz, int indice){
        for (int i = 0; i < matriz.length; i++){
            System.out.print(matriz[indice][i] + " ");
        }
        System.out.println();
    }

    public void printVetor(int[] vetor){
        for(int i = 0; i < vetor.length; i++)
            System.out.print(vetor[i] + " ");
        System.out.println();
    }

    public int[] caminho(int origem, int destino){
        int aux = ant[origem][destino];
        int[] retorno = new int[dist[origem][destino]];
        for (int i = 0; i < dist[origem][destino]; i++) {
            retorno[i] = aux;
            aux = ant[origem][aux];
        }
        printVetor(retorno);
        return retorno;
    }
}
