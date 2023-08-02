import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner tc = new Scanner(System.in);

        try {
            int j = 1;
            while(tc.hasNext())
            {
                int num = Integer.parseInt(tc.nextLine());
                int quant = 1;

                for (int i=0; i<num; i++)
                    quant += i+1;

                if (quant == 1)
                {
                    System.out.println("Caso " + j + ": " + quant + " numero" + "\n0");
                    j++;
                } else
                {
                    System.out.print("Caso " + j + ": " + quant + " numeros" + "\n0 ");
                    for (int i = 1; i <= num; i++)
                        for (int k = 0; k < i; k++)
                            System.out.print(i + " ");
                    System.out.println();
                    j++;
                }
            }
            System.exit(0);
        }catch (Exception NumberFormatException) {
            System.exit(1);
        }
    }
}
