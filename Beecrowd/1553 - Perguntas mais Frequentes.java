import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {


    public static void main (String[] args) {
        Scanner tc = new Scanner(System.in);
        int tamString = Integer.parseInt(tc.next());
        int repeticoes = Integer.parseInt(tc.next());
        tc.nextLine();

        while (repeticoes != 0 && tamString != 0){
            int[] vet = new int[tamString];
            for (int i = 0; i < tamString; i++)
                vet[i] = Integer.parseInt(tc.next());
            tc.nextLine();

            System.out.println(numeros(vet, repeticoes));

            tamString = Integer.parseInt(tc.next());
            repeticoes = Integer.parseInt(tc.next());
            tc.nextLine();
        }
    }

    public static int numeros(int[] vet, int quantos){
        int[] verifica = new int[vet.length];
        int retorno = 0;
        List list = new ArrayList();

        for (int i = 0; i < vet.length; i++) {
            if (verifica[vet[i]] == 0){
                if (repeticoes(vet, vet[i], quantos, list))
                    ++retorno;
            }
        }
        return retorno;
    }

    public static boolean repeticoes(int[] vet, int num, int quantos, List list) {
        int verifica = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(num))
                return false;
        }

        list.add(num);
        for (int i = 0; i < vet.length; i++){
            if (vet[i] == num)
                ++verifica;
            if (verifica == quantos)
                return true;
        }
        return false;
    }
}
