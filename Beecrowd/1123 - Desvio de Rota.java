import java.util.*;

class Main {


    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
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
        int aux = ant[rota.get(tam-1)];
        for (int i = 0; i < ant.length; i++){
            caminho.add(aux);
            aux = ant[caminho.get(i)];
            if (aux == -1)
                break;
        }
        loop:
        for(int i = caminho.size() - 1; i >= 0; i--){
            if (!(rota.contains(caminho.get(i)))) {
                int j = 0;
                while ( j <= lista[ant[caminho.get(i)]].size() &&
                        lista[ant[caminho.get(i)]].get(j).indice != caminho.get(i))
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
