import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        int quantEstrelas = 0;
        int carneiros = 0;
        try {
            Scanner tc = new Scanner(System.in);
            int quant = Integer.parseInt(tc.nextLine());
            int[] estrelas = new int[quant];
            for (int i = 0; i < quant; i++)
                estrelas[i] = Integer.parseInt(tc.next());
            int a = quant;
            do {
                    if (estrelas[quant - 1] % 2 == 0) {
                        if (estrelas[quant - 1] > 0) {
                            carneiros = carneiros + estrelas[quant - 1] - 1;
                            quantEstrelas++;
                            quant = quant + 1;
                        } else {
                            quantEstrelas++;
                            quant = quant + 1;
                        }
                    } else {
                            carneiros = carneiros + estrelas[quant - 1] - 1;
                            quantEstrelas++;
                            quant = quant - 1;

                    }
            } while (true);
        }catch (Exception ArrayOutOfBoudsException) {
            System.out.println(quantEstrelas + " " + carneiros);
            System.exit(0);
        }
    }
}
