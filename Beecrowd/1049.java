import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            Scanner tc = new Scanner(System.in);
            /*String[] classificacao = new String[3];*/
       /* for (int i = 0; i < 3; i++)
            classificacao[i] = tc.next();*/
        /*for (int i=0; i<3; i++)
            System.out.println(classificacao[i]);*/

            String tipo1 = tc.next();
            String tipo2 = tc.next();
            String tipo3 = tc.next();

            if (tipo2.equals("ave")) {
                if (tipo3.equals("carnivoro")) {
                    System.out.println("aguia");
                    System.exit(0);
                } else if (tipo3.equals("onivoro")) {
                    System.out.println("pomba");
                    System.exit(0);
                }

            } else if (tipo2.equals("mamifero")) {
                if (tipo3.equals("onivoro")) {
                    System.out.println("homem");
                    System.exit(0);
                } else if (tipo3.equals("herbivoro")) {
                    System.out.println("vaca");
                    System.exit(0);
                }

            } else if (tipo2.equals("inseto")) {
                if (tipo3.equals("hematofago")) {
                    System.out.println("pulga");
                    System.exit(0);
                } else if (tipo3.equals("herbivoro")) {
                    System.out.println("lagarta");
                    System.exit(0);
                }

            } else {
                if (tipo3.equals("hematofago")) {
                    System.out.println("sanguessuga");
                    System.exit(0);
                } else if (tipo3.equals("onivoro")) {
                    System.out.println("minhoca");
                    System.exit(0);
                }
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            System.exit(1);
        }
    }
}
