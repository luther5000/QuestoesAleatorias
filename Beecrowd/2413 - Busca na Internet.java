import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner tc = new Scanner(System.in);
        int tipo = Integer.parseInt(tc.nextLine());
        int quant = tipo*4;
        System.out.println(quant);
        System.exit(0);
    }
}
