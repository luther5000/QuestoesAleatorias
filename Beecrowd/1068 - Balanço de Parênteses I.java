import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        Pilha pilha = new Pilha();
        while (tc.hasNext()) {
            pilha.limpaPilha();
            String s = tc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(')
                    pilha.push(s.charAt(i));
                else if (s.charAt(i) == ')') {
                    if (pilha.getTop() == 'e') {
                        pilha.push('e');
                        break;
                    }
                    else
                        pilha.pop();
                }
            }
            if (pilha.vazia())
                System.out.println("correct");
            else
                System.out.println("incorrect");
        }
    }
}


class Pilha{
    private char[] vet;
    private int tam;

    public Pilha(){
        vet = new char[1000];
        tam = 0;
    }

    public void push(char c){
        vet[tam] = c;
        ++tam;
    }

    public void pop(){
        if (tam>0)
            --tam;
    }

    public char getTop(){
        if (tam>0)
            return vet[tam];
        else
            return 'e';
    }

    public boolean vazia(){
        return (tam==0);
    }
    
    public void limpaPilha(){
        while (tam>0){
            --tam;
        }
    }
}
