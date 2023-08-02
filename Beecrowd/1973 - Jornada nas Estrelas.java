import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner tc = new Scanner(System.in);
        int quantEstrelas = 0;
        int quant = Integer.parseInt(tc.nextLine());
        long[] estrelas = new long[quant];
        try {
            for (int i = 0; i < quant; i++)
                estrelas[i] = Integer.parseInt(tc.next());
            int atual = 0;
            do {
                long antigo = estrelas[atual];

                if (quantEstrelas <= atual)
                    quantEstrelas++;

                if (estrelas[atual] > 0) {
                    estrelas[atual]--;
                }

                if (antigo % 2 == 0)
                    atual--;
                else
                    atual++;

            } while (true);

        }catch (Exception ArrayOutOfBoudsException) {
            long total = 0;
                for (int i = 0; i < quant; i++)
                    total += estrelas[i];
            System.out.println(quantEstrelas + " " + total);
            System.exit(0);
        }
    }
}
