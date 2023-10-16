import java.util.*;

public class Hash {

    private List<List<Pessoa>>[] vet;
    int tam;

    public Hash(int tam){
        if (tam % 2 == 0)
            this.tam = tam + 1;
        else
            this.tam = tam;

        vet = new ArrayList[11];

        for (int i = 0; i < 11; i++){
            vet[i] = new ArrayList<>(tam/10);
        }
    }

    private int firstHash(int valor){
        return valor % 11;
    }

    private int secondHash(int valor){
        return valor % tam;
    }

    public void adiciona(Pessoa pessoa){
        int first = firstHash(pessoa.cpf);
        int second = secondHash(pessoa.cpf);

        Pessoa nova = new Pessoa(pessoa.cpf, pessoa.nome);
        vet[first].get(second).add(nova);
    }

    public Pessoa retorna(int cpf){
        int first = firstHash(cpf);
        int second = secondHash(cpf);

        for (int i = 0; i < vet[first].get(second).size(); i++)
            if (vet[first].get(second).get(i).cpf == cpf)
                return vet[first].get(second).get(i);

        return null;
    }
}
