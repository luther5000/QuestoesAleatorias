import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner tc = new Scanner (System.in);
		int valor = Integer.parseInt(tc.nextLine());
		
	}
}

class Funcoesn{
    public static int binaria (int[] vet, int valor){
        
        
        if (length(vet) != 1) {
            
            int i = length(vet)/2;
            
            if (vet[i] == valor)
                return i;
            
            if (vet[i] != valor){
                int newVet = new int[i];
                for (int j = 0; j<length(vet); j++) {
                    newVet[j] = vet[i];
                    if (vet[i] > valor)
                        i++;
                    else
                    i--;
                }
                binaria(newVet, valor);
            }
        } else
            
            return -1;
    }
    
    public static int normal (int[] vet, int valor){
        for (int i = 0; i<length(vet); i++)
            if (vet[i] == valor)
                return i;
        
        return -1;        
    }
}














