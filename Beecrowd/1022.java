import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        
        try {
            
            Scanner tc = new Scanner (System.in);
            int quant = Integer.valueOf(tc.next());
            int cont = 0;
            int[] num = new int[2];
            int[] den = new int[2];
            char operacao;
            do {
                num[0] = Integer.valueOf(tc.next()); tc.next();
                den[0] = Integer.valueOf(tc.next()); 
                operacao = tc.next().charAt(0);
                num[1] = Integer.valueOf(tc.next()); tc.next();
                den[1] = Integer.valueOf(tc.next());
                
                int[] res = new int[2];
                switch(operacao){
                 
                 case '+': 
                    res[0] = num[0]*den[1] + num[1]*den[0]; 
                    res[1] = den[0]*den[1];
                    break;
                 case '-': 
                    res[0] = num[0]*den[1] - num[1]*den[0]; 
                    res[1] = den[0]*den[1];
                    break;  
                }
                
        
                int[] vet = funcoes.simplifica(num, den);
                System.out.println(vet[0]);
                System.out.println(vet[1]);
                cont++;
            
                
            } while(cont<quant);
            
        }catch (Exception NumberFormatException){
            System.exit(1);
        }catch (ArrayIndexOutOfBoundsException e){
            System.exit(1);
        }
    }
 
}

class funcoes {
    
    public static int[] simplifica (int num, int den){
        int i=2;
        while (true){
            if (num >= i & den >= i) {
                if ((num % i == 0) & (den % i == 0)){
                    num = num/i;
                    den = den/i;
                } else
                    i++;
            }else{
                return new int[] {num, den};
            }
        }
    }
}
