import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner tc = new Scanner(System.in);
        int quantEstrelas = 0;
        long carneiros = 0;
        int quant = Integer.parseInt(tc.nextLine());
        long[] estrelas = new long[quant];
        try {
            for (int i = 0; i < quant; i++)
                estrelas[i] = Integer.parseInt(tc.next());
            int atual = 0;
            do {
                System.out.println(atual);
                for (int i = 0; i<quant; i++)
                    System.out.print(" " + estrelas[i]);
                System.out.println();

                long antigo = estrelas[atual];

                if (quantEstrelas <= atual)
                    quantEstrelas++;

                if (estrelas[atual] > 0) {
                    estrelas[atual]--;
                    if (atual >= quantEstrelas) {
                        carneiros = carneiros + estrelas[atual];
                    } else
                        carneiros--;
                }

                if (antigo % 2 == 0)
                    atual--;
                else
                    atual++;

            } while (true);

        }catch (Exception ArrayOutOfBoudsException) {
            if (quant > quantEstrelas)
                for (int i = quantEstrelas+1; i <= quant; i++)
                    carneiros += estrelas[i];
            System.out.println(quantEstrelas + " " + carneiros);
            System.exit(0);
        }
    }
}
