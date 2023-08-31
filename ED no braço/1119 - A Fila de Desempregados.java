import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);

        int n = Integer.parseInt(tc.next());
        int k = Integer.parseInt(tc.next());
        int m = Integer.parseInt(tc.nextLine().substring(1));

        while (!(n == 0 && k == 0 && m ==0)) {

            Lista lista = new Lista(n);



            while (!lista.vazia()) {
                int[] vet = lista.remove(k, m);
                /*lista.printa();*/
                if (vet.length == 1)
                    System.out.print(" " + vet[0] + ",");
                else
                    for (int i = 0; i < vet.length; i++)
                        System.out.print("  " + vet[i]);

                if (!lista.vazia()){
                    System.out.print(",");
                }
            }

            n = Integer.parseInt(tc.next());
            k = Integer.parseInt(tc.next());
            m = Integer.parseInt(tc.nextLine().substring(1));
        }
    }
}

class Lista {
    private int tamAtual;
    private No inicio;
    private No fim;
    private int pessoaHorarioAtual;
    private int pessoaAntiHorarioAtual;
    private No atualH;
    private No atualA;


    public Lista (int quant){
        tamAtual = quant;
        pessoaHorarioAtual = 0;
        pessoaAntiHorarioAtual = 0;
        adiciona(quant);
        atualA = inicio;
        atualH = inicio;
    }

    public void adiciona(int quant){
        int cont = 1;
        while (cont <= quant){
            No novoNo = new No(cont);
            if (cont == 1){
                inicio = novoNo;
                fim = novoNo;
            } else {
                fim.setProx(novoNo);
                novoNo.setAnt(fim);
                fim = novoNo;
                novoNo.setProx(inicio);
                inicio.setAnt(novoNo);
            }
            ++cont;
        }
    }

    public int[] remove(int horario, int antiHorario){
        No aux1 = atualH;
        if (tamAtual > 1) {
            for (int i = 1; i < horario; i++) {
                aux1 = aux1.getProx();
            }

            No aux2 = atualA;
            for (int i = 0; i < antiHorario; i++)
                aux2 = aux2.getAnt();

            pessoaHorarioAtual = aux1.getNum();
            atualH = aux1.getProx();
            pessoaAntiHorarioAtual = aux2.getNum();
            atualA = aux2.getProx();

            if (pessoaHorarioAtual == pessoaAntiHorarioAtual) {
                int[] vet = {pessoaHorarioAtual};
                aux1.getAnt().setProx(aux1.getProx());
                aux1.getProx().setAnt(aux1.getAnt());
                --tamAtual;
                return vet;
            } else {
                aux1.getAnt().setProx(aux1.getProx());
                aux1.getProx().setAnt(aux1.getAnt());
                aux2.getAnt().setProx(aux2.getProx());
                aux2.getProx().setAnt(aux2.getAnt());
                int[] vet = {pessoaHorarioAtual, pessoaAntiHorarioAtual};
                tamAtual -= 2;
                return vet;
            }
        } else{
            int[] vet = {aux1.getNum()};
            --tamAtual;
            return vet;
        }
    }

    public void printa(){
        No aux = inicio;
        for (int i = 0; i < tamAtual; i++) {
            System.out.print(aux.getNum() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }

    public boolean vazia(){
        return tamAtual==0;
    }
}

class No{
    private int num;
    private No prox;
    private No ant;

    public No(int num){
        this.num = num;
        prox = null;
        ant = null;
    }

    public int getNum() {
        return num;
    }

    public No getAnt() {
        return ant;
    }

    public No getProx() {
        return prox;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}
