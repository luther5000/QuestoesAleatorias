import java.util.*;

public class Hash {

    private List<Pessoa>[][] vet;
    int tam;

    public Hash(int tam){
        if ((int)(1.25 * tam) % 2 == 0)
            this.tam = (int)(1.25 * tam) + 1;
        else
            this.tam = (int)(1.25 * tam);

        vet = new List[11][this.tam/10];

        for (int i = 0; i < 11; i ++)
            for (int j = 0; j < this.tam/10; j++){
                vet[i][j] = new LinkedList<>();
            }
    }

    private int firstHash(long valor){
        return (int)(valor % 11);
    }

    private int secondHash(long valor){
        return (int)(valor % tam/10);
    }

    public void adiciona(Pessoa pessoa){
        int first = firstHash(pessoa.cpf);
        int second = secondHash(pessoa.cpf);

        Pessoa nova = new Pessoa(pessoa.cpf, pessoa.nome);
        vet[first][second].add(nova);
    }

    public Pessoa retorna(int cpf){
        int first = firstHash(cpf);
        int second = secondHash(cpf);

        for (int i = 0; i < vet[first][second].size(); i++)
            if (vet[first][second].get(i).cpf == cpf)
                return vet[first][second].get(i);

        return null;
    }

    public Pessoa remove(int cpf){
        int first = firstHash(cpf);
        int second = secondHash(cpf);

        for (int i = 0; i < vet[first][second].size(); i++)
            if (vet[first][second].get(i).cpf == cpf) {
                Pessoa armazena = vet[first][second].get(i);
                vet[first][second].remove(i);

                return armazena;
            }

        return null;
    }
}
