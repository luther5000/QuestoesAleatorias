import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner tc = new Scanner(System.in);
        int tam = Integer.parseInt(tc.next());
        int[] alturas = new int[tam];
        int alturaMax = Integer.parseInt(tc.next());
        tc.nextLine();

        for (int i = 0; i < tam; i++){
            alturas[i] = Integer.parseInt(tc.next());
        }

        Arrays.sort(alturas);

        int barcos = 0;


        int j = alturas.length;
        int i = 0;
        while (true){
            if (i == j ) {
                ++barcos;
                break;
            }
            if (i > j)
                break;

            if (alturas[i] + alturas[j] <= alturaMax) {
                ++barcos;
                --j;
                ++i;
            }
            else {
                ++barcos;
                --j;
            }
        }

        System.out.println(barcos);
    }
}
