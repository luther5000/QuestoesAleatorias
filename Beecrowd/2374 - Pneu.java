import java.util.Scanner;

class Main {
    public static void main (String[] args){
        Scanner tc = new Scanner(System.in);
        int pDesejada = Integer.parseInt(tc.next());
        int pAtual = Integer.parseInt(tc.next());
        System.out.println(pDesejada-pAtual);
        System.exit(0);
    }
}
