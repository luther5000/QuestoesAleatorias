import java.util.*;

class Main {


    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int tam = Integer.parseInt(tc.next());
        int numEstradas = Integer.parseInt(tc.next());
        int destino =  Integer.parseInt(tc.next()) - 1;
        int inicio = Integer.parseInt(tc.next());
        tc.nextLine();

        while (tam != 0 && numEstradas != 0 && destino != 0 && inicio != 0) {
            int[] tudo = new int[numEstradas * 3];
            for (int i = 0; i < tudo.length; i += 3){
                tudo[i] = Integer.parseInt(tc.next());
                tudo[i+1] = Integer.parseInt(tc.next());
                tudo[i+2] = Integer.parseInt(tc.next());
                tc.nextLine();
            }

            Grafo grafo = new Grafo(tam, destino);
            grafo.adiciona(tudo);

            System.out.println(grafo.pedagio(inicio));

            tam = Integer.parseInt(tc.next());
            numEstradas = Integer.parseInt(tc.next());
            destino =  Integer.parseInt(tc.next()) - 1;
            inicio = Integer.parseInt(tc.next());
            tc.nextLine();
        }
    }
}

class Grafo {
    private List<Cidade>[] lista;
    private int tam;
    private List<Integer> rota;

    public Grafo (int tam, int destino){
        this.tam = tam;
        lista = new List[tam];
        for (int i = 0; i < tam; i++){
            lista[i] = new LinkedList<>();
        }
        rota = new ArrayList(destino);
        for (int i = 0; i < destino; i++)
            rota.add(i, i);
    }

    public void adiciona(int[] tudo){
        for (int i = 0; i < tudo.length; i = i+3){
            Cidade nova = new Cidade(tudo[i+2], tudo[i+1]);
            lista[tudo[i]].add(nova);
            nova = new Cidade(tudo[i+2], tudo[i]);
            lista[tudo[i+1]].add(nova);
        }
    }

    public int pedagio(int inicio) {
        int pedagio = 0;
        if (rota.contains(inicio)) {
            for (int i = inicio; i < rota.size(); i++) {
                pedagio += lista[i].get(rota.get(i + 1)).pedagio;
            }
        } else {
            int[] ant = new int[tam];
            Arrays.fill(ant, -1);
            boolean[] flag = new boolean[tam];
            Queue<Integer> fila = new LinkedList<>();
            fila.add(inicio);
            flag[inicio] = true;

            int atual;
            while (!(fila.isEmpty())) {
                atual = fila.remove();
                for (int i = 0; i < lista[atual].size(); i++)
                    if (!(flag[lista[atual].get(i).indice])) {
                        flag[lista[atual].get(i).indice] = true;
                        ant[lista[atual].get(i).indice] = atual;
                    }
            }

            pedagio = calcula(ant);
        }
        return pedagio;
    }

    private int calcula (int[] ant){
        int retorno = 0;
        List<Integer> caminho = new ArrayList<>();
        int aux = ant[rota.get(rota.size()-1)];
        if (aux != -1)
            for (int i = 0; i < ant.length; i++){
                System.out.println("entrou");
                caminho.add(aux);
                aux = ant[caminho.get(i)];
                if (aux == -1)
                    break;
            }
        for (int i = 0; i < caminho.size(); i++)
            System.out.print(caminho.get(i) + " ");
        System.out.println();
        loop:
        for(int i = caminho.size() - 1; i >= 0; i--){
            if (!(rota.contains(caminho.get(i))) && ant[caminho.get(i)] != -1) {
                int j = 0;
                while ((j <= lista[ant[caminho.get(i)]].size() &&
                        lista[ant[caminho.get(i)]].get(j).indice != caminho.get(i)))
                    j++;

                retorno += lista[ant[caminho.get(i)]].get(j).pedagio;
            } else {
                for (int j = caminho.get(i); j < rota.size(); j++)
                    retorno += lista[j].get(rota.get(j + 1)).pedagio;
                break loop;
            }
        }
        return retorno;
    }
}



class Cidade {
     int indice;
     int pedagio;

    public Cidade(int pedagio, int indice){
        this.pedagio = pedagio;
        this.indice = indice;
    }
}
