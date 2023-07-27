import java.util.Scanner;

class Main {
    public static void main (String[] args) {
        try {
            Scanner tc = new Scanner(System.in);
            int n = Integer.parseInt(tc.next());
            int n1 = Integer.parseInt(tc.next());
            int PROD = n * n1;

            System.out.println("PROD = " + PROD);

            System.exit(0);
        } catch (Exception NumberFormatException){
            System.exit(1);
        }
    }
}
