import java.util.Scanner;

class Main{
    public static void main (String[] args){
        Scanner tc = new Scanner(System.in);
        String pegaTudo = tc.nextLine();
        Lista atual = new Lista();
        String compara = pegaTudo;

        int i = 0;
        while (true) {
            if (compara.length() < i)
                i = 0;
            else if (compara.length() == 1)
                break;
            if (compara.charAt(i) == ' ') {
                atual.adiciona(compara.substring(0, i));
                compara = compara.substring(i);
                System.out.println(compara);
            }
            i++;
        }
        pegaTudo = tc.nextLine();
        Lista nova = new Lista();
        compara = pegaTudo;

//        while (true) {
//            if (compara.length() <= i)
//                i = 0;
//            else if (compara.length() == 1)
//                break;
//            if (compara.charAt(i) == ' ') {
//                atual.adiciona(compara.substring(0, i));
//                compara = compara.substring(i);
//                System.out.println(compara);
//            }
//            i++;
//        }
//
//        pegaTudo = tc.nextLine();
//            atual.printa(); System.out.println();
//            nova.printa();

    }
}

class Lista{
    private No cabeca;
    private int tam;
    private No ultimo;

    public Lista(){
        cabeca = null;
        tam = 0;
        ultimo = null;
    }

    public String retorna(){
        return cabeca.getNome();
    }
    public void printa(){
        No aux = cabeca;
        if (verifica())
            return;
        else
            for (int i = 1; i <= tam; i++) {
                System.out.print(aux.getNome() + " ");
                aux = aux.getProx();
            }
    }

    public void adiciona(String nome){
        No novoNo = new No(nome);
        if (verifica()){
            novoNo.setProx(cabeca);
            cabeca = novoNo;
            ultimo = novoNo;
            //System.out.println(cabeca.getNome());
            tam++;
        } else {
            ultimo.setProx(novoNo);
            ultimo = novoNo;
            //System.out.println(ultimo.getNome());
            tam++;
        }

    }

    public boolean verifica(){
        return (tam==0);
    }
}



class No {
    private String nome;
    private No prox;

    public No (String nome){
        this.nome = nome;
        prox = null;
    }

    public void setProx(No prox){
        this.prox = prox;
    }

    public String getNome(){
        return nome;
    }

    public No getProx() {
        return prox;
    }
}
