import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
    Scanner tc = new Scanner(System.in);

    Arvore arvore = new Arvore();
    while (tc.hasNext()){
        String s = tc.next();

        switch (s){
            case "I" -> arvore.adiciona(tc.nextLine().toCharArray()[1]);
            case "INFIXA" ->{
                arvore.infixo(arvore.raiz);
                System.out.println();
            }
            case "PREFIXA" ->{
                arvore.prefixo(arvore.raiz);
                System.out.println();
            }
            case "POSFIXA" ->{
                arvore.posfixo(arvore.raiz);
                System.out.println();
            }
            case "P" -> {
                arvore.pesquisa(tc.nextLine().toCharArray()[1]);
                System.out.println();
            }
        }
        arvore.limpaPrintou();
    }
    }
}

class Arvore{
    No raiz;
    boolean printou = false;

    public Arvore(){
        raiz = null;
    }

    public void adiciona(char a){
        if (raiz == null) {
            raiz = new No(a);
            return;
        }

        No aux = raiz;
        while (true) {
            if (a > aux.content) {
                if (aux.direita == null)
                    break;
                aux = aux.direita;
            }
            else {
                if (aux.esquerda == null)
                    break;
                aux = aux.esquerda;
            }
        }

        if (aux.content > a)
            aux.esquerda = new No(a);
        else
            aux.direita = new No(a);
    }

    public void pesquisa(char a){
        if (raiz.content == a) {
            System.out.print(a + " existe");
            return;
        }

        No aux = raiz;
        while (true) {
            if (a > aux.content) {
                if (aux.direita == null)
                    break;
                aux = aux.direita;
            }
            else {
                if (aux.esquerda == null)
                    break;
                aux = aux.esquerda;
            }

            if (aux.content == a){
                System.out.print(a + " existe");
                return;
            }
        }

        System.out.print(a + " nao existe");
    }
    public void prefixo(No atual){
        if (atual == null)
            return;

        if (printou) {
            System.out.print(" ");
            printou = false;
        }

        System.out.print(atual.content);
        printou = true;

        if (atual.esquerda != null) {
            prefixo(atual.esquerda);
        }

        if (atual.direita != null) {
            prefixo(atual.direita);
        }
    }

    public void infixo(No atual){
        if (atual == null)
            return;

        if (printou) {
            System.out.print(" ");
            printou = false;
        }

        if (atual.esquerda != null) {
            infixo(atual.esquerda);
        }

        if (printou) {
            System.out.print(" ");
            printou = false;
        }

        System.out.print(atual.content);
        printou = true;

        if (atual.direita != null){
            infixo(atual.direita);
        }
    }

    public void posfixo(No atual) {
        if (atual == null)
            return;

        if (printou) {
            System.out.print(" ");
            printou = false;
        }

        if (atual.esquerda != null) {
            posfixo(atual.esquerda);
        }

        if (printou) {
            System.out.print(" ");
            printou = false;
        }

        if (atual.direita != null) {
            posfixo(atual.direita);
        }

        if (printou) {
            System.out.print(" ");
            printou = false;
        }

        System.out.print(atual.content);
        printou = true;
    }

    public void limpaPrintou(){printou = false;}
}
class No{
    No direita;
    No esquerda;
    char content;

    public No(char content){
        direita = null;
        esquerda = null;
        this.content = content;
    }
}
