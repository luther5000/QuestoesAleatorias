import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner tc = new Scanner(System.in);
        int num = Integer.parseInt(tc.nextLine());
        num = fatorial (num);
        System.out.println(num);
    }
    
    public static int fatorial (int num){
        if (num <= 1)
            return 1;
        else 
            return (num * fatorial(num-1));
    }
}
