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


            int[] caminho = grafo.caminho(origem, destino);
            if (caminho[destino] == 0)
                System.out.println("Não há caminho entre os vértices");
            else
                for(int i = 0; i < caminho.length; i++)
                    if (i != caminho.length-1)
                        System.out.print(caminho[i] + " ");
                    else
                        System.out.println(caminho[i]);

            System.out.println("Número de componentes conexas: " + grafo.numCompConexa());

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
    private boolean[] jaFez;


    public Grafo(int tam){
        matrizAdjacencia = new int[tam][tam];
        list = new List[tam];
        for (int i = 0; i < tam; i++)
            list[i] = new ArrayList<>();
        this.tam = tam;
        dist = new int[tam][tam];
        ant = new int[tam][tam];
        jaFez = new boolean[tam];
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

        while (!(fila.isEmpty())){
            atual = fila.remove();

            for (int j = 0; j < list[atual].size(); j++){
                if (!(flag[list[atual].get(j)])){ //pegar o indicie que se refere ao no na lista e ver se esse no ja foi visto
                    ant[inicio][list[atual].get(j)] = atual+1;

                    flag[list[atual].get(j)] = true;
                    fila.add(list[atual].get(j));

                    dist[inicio][list[atual].get(j)] = atual + 1;
                }
            }
        }
        return ant[inicio];
    }

    /*public void printVetor(int[][] matriz, int indice){
        for (int i = 0; i < matriz.length; i++){
            System.out.print(matriz[indice][i] + " ");
        }
        System.out.println();
    }

    public void printVetor(int[] vetor){
        for(int i = 0; i < vetor.length; i++)
            System.out.print(vetor[i] + " ");
        System.out.println();
    }*/

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
                retorno[i] = aux;
                aux = ant[origem][aux];
            }
            return retorno;
        }

    }

    public int numCompConexa(){
        int quant = 0;
        int[] pai = dfs();

        for (int i = 0; i < pai.length; i++)
            if (pai[i] == 0)
                ++quant;

        return quant;
    }

    private int[] dfs(){
        boolean[] flag = new boolean[tam];
        Stack<Integer> pilha = new Stack<>();
        int[] pai = new int[tam];

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
