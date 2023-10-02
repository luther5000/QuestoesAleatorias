import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int casos = Integer.parseInt(tc.nextLine());
        int quantos = 1;

        while (casos > 0){
            int tam = Integer.parseInt(tc.nextLine());
            int[] estradas = new int[Integer.parseInt(tc.nextLine())*2];
            for (int i = 0; i < estradas.length; i += 2){
                estradas[i] = Integer.parseInt(tc.next())-1;
                estradas[i+1] = Integer.parseInt(tc.next())-1;
                tc.nextLine();
            }

            Grafo grafo = new Grafo(tam);
            grafo.adiciona(estradas);
            int componentes = grafo.compConexas();

            if (componentes == 1)
                System.out.println("Caso #" + quantos + ": a promessa foi cumprida");
            else
                System.out.println("Caso #" + quantos + ": ainda falta(m) " + (componentes-1) + " estrada(s)");

            ++quantos;
            --casos;
        }
    }
}

class Grafo{
    private List<Integer>[] lista;
    private int tam;

    public Grafo(int tam){
        lista = new List[tam];
        for (int i = 0; i < tam; i++)
            lista[i] = new LinkedList<>();

        this.tam = tam;
    }

    public void adiciona(int[] tudo){
        for (int i = 0; i < tudo.length; i += 2){
            lista[tudo[i]].add(tudo[i+1]);
            lista[tudo[i+1]].add(tudo[i]);
        }
    }

    public int compConexas(){
        boolean[] flag = new boolean[tam];
        Stack<Integer> pilha = new Stack<>();
        int componentes = 0;
        int atual;

        for (int i = 0; i < lista.length; i++){
            if (!(flag[i])){
                flag[i] = true;
                pilha.push(i);
                ++componentes;
            }

            while (!(pilha.isEmpty())){
                atual = pilha.pop();
                for (int j = 0; j < lista[atual].size(); j++)
                    if (!(flag[lista[atual].get(i)])){
                        flag[lista[atual].get(i)] = true;
                        pilha.push(lista[atual].get(i));
                    }
            }
        }

        return componentes;
    }
}
