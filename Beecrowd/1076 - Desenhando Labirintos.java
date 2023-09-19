import java.util.*;

class Main {


    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int casos = Integer.parseInt(tc.nextLine());
        while (casos > 0){
            int inicio = Integer.parseInt(tc.nextLine());
            int vertices = Integer.parseInt(tc.next());
            
            int[] vet = new int[Integer.parseInt(tc.next())*2]; tc.nextLine();
            for (int i = 0; i < vet.length; i += 2){
                vet[i] = Integer.parseInt(tc.next());
                vet[i+1] = Integer.parseInt(tc.next());
                tc.nextLine();
            }
            
            Grafo grafo = new Grafo()
            
            --casos;
        }
    }
}

class Grafo {
    private int tam;
    private List<Integer>[] adjacencia;
    private int[] pai;

    public Grafo(int tam){
        adjacencia = new List[tam];
        this.tam = tam;
        pai = new int[tam];

        for (int i = 0; i < tam; i++) {
            adjacencia[i] = new ArrayList<>();
            pai[i] = -1;
        }
    }

    public void adiciona(int[] vertices){
        for (int i = 0; i < vertices.length; i += 2){
            adjacencia[vertices[i]].add(vertices[i+1]);
            adjacencia[vertices[i+1]].add(vertices[i]);
        }
    }

    public boolean verifica(){
        for (int i = 0; i < tam; i++)
            if (pai[i] == -1)
                return false;
        return true;
    }

    private void bfs(int inicio){
        boolean[] flag = new boolean[tam];
        Stack<Integer> pilha = new Stack<>();

        pilha.push(inicio);
        flag[inicio] = true;
        int contador = 0;
        while(!(pilha.isEmpty())){
            int ant = pilha.pop();
            for (int i = 0; i < adjacencia[ant].size(); i ++){
                ++contador;
                if (!(flag[adjacencia[ant].get(i)])) {
                    pai[adjacencia[ant].get(i)] = ant;
                    flag[adjacencia[ant].get(i)] = true;
                    pilha.push(adjacencia[ant].get(i));
                }
            }
        }
    }
}