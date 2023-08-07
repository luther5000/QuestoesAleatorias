import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int quant = Integer.parseInt(tc.nextLine());
        int contador = 0;
        while (contador < quant){
            char[] string = tc.nextLine().toCharArray();

            for (int i = 0; i< string.length; i++)
                if (string[i] > 96 && string[i] < 123 || string[i] > 64 && string[i] < 91) {
                    int aleatorio = ((int) string[i]) + 3;
                    string[i] = (char) aleatorio;
                }


            char[] stringInvertida = new char[string.length];
            int j = string.length - 1;

            for (int i = 0; i < string.length; i++){
                stringInvertida[i] = string[j];
                j--;
            }

            for (int i = stringInvertida.length/2; i < stringInvertida.length; i++){

                    int aleatorio = ((int)stringInvertida[i]) - 1;
                    stringInvertida[i] = (char) aleatorio;
                }

            for (int i = 0; i < stringInvertida.length; i++)
                System.out.print(stringInvertida[i]);
            System.out.println();
            contador++;
        }
    }
}
