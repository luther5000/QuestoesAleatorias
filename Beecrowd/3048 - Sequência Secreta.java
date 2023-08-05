import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner tc = new Scanner(System.in);
        int quant = Integer.parseInt(tc.nextLine());
        byte[] vet = new byte[quant];
        for (int i = 0; i < quant; i++)
            vet[i] = Byte.parseByte(tc.nextLine());
        
        int sequencia = 1;
        byte ultimo = 1;
        for (int i = 1; i < quant; i++)
            if (vet[i] != ultimo){
                ultimo = vet[i];
                sequencia++;
            }
        
        System.out.println(sequencia);
    }
}
