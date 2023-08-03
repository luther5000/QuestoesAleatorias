import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner tc = new Scanner(System.in);
        try {
            int j = 1;
            int[] salva = new int[200];
            salva[0] = 1;
            salva[1] = 2;
            int numMax = 0;
            while(tc.hasNext())
            {
                int num = Integer.parseInt(tc.nextLine());
                System.out.println(num);

                if (num > numMax) {
                    for (int i = numMax; i < num; i++) {
                        if (i > 0)
                            salva[i+1] = salva[i] + i+1;
                    }
                    numMax = num;
                }

                if (salva[num] == 1)
                {
                    System.out.println("Caso " + j + ": " + salva[num] + " numero" + "\n0");
                    j++;
                } else
                {
                    System.out.print("Caso " + j + ": " + salva[num] + " numeros" + "\n0 ");
                    int k = 1;
                    int l=0;
                    while (k<=num){
                        if (l<k) {
                            System.out.print(k + " ");
                            l++;
                        } else {
                            l = 0;
                            k++;
                        }
                    }

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
