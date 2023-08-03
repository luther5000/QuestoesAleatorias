import java.util.Scanner;
import java.math.BigInteger;

public class Main
{
    public static void main (String[] args)
    {
        Scanner tc = new Scanner(System.in);
        try {
            while(tc.hasNext()) {
                BigInteger num1 = BigInteger.valueOf(Long.parseLong(tc.next()));
                BigInteger num2 = BigInteger.valueOf(Long.parseLong(tc.next()));

                num1 = Funcoes.fatorial(num1);
                num2 = Funcoes.fatorial(num2);

                System.out.println(num1.add(num2));
            }
            System.exit(0);
        }catch (Exception NumberFormatException) {
            System.exit(1);
        }
    }
}

class Funcoes {
    public static BigInteger fatorial (BigInteger num){
        BigInteger zero = BigInteger.valueOf(0);
            if (num.equals(zero))
                return BigInteger.valueOf(1);
            else
                return (num.multiply(fatorial(num.subtract(BigInteger.valueOf(1)))));
        }
    }
