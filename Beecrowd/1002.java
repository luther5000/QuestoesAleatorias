import java.util.Scanner;

class Main {
    public static void main (String[] args) {
        try {
            Scanner tc = new Scanner(System.in);
            double raio = Double.parseDouble(tc.next());

            System.out.printf("A=%.4f\n", (3.14159*raio*raio));

            System.exit(0);
        } catch (Exception NumberFormatException){
            System.exit(1);
        }
    }
}
