import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        try {
            Scanner tc = new Scanner(System.in);
            int quant = Integer.parseInt(tc.nextLine());
            for (int i = 0; i < quant; i++) {
                int popA = Integer.parseInt(tc.next());
                int popB = Integer.parseInt(tc.next());
                double cresA = Double.parseDouble(tc.next());
                double cresB = Double.parseDouble(tc.next());
                int anos=0;

                while (popA <= popB)
                {
                    popA = (int)Math.floor(popA + popA * cresA/100);
                    popB = (int)Math.floor(popB + popB * cresB/100);
                    anos++;
                    if (anos>100)
                    {
                        System.out.println("Mais de 1 seculo.");
                        break;
                    }
                }
                if (anos<101)
                    System.out.println(anos + " anos.");

            }
            System.exit(0);
        } catch (Exception NumberFormatException){
            System.exit(1);
        }
    }
}
