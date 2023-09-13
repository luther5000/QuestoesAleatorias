import java.util.Scanner;

class Main {


    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        String s = tc.nextLine();
        while (!(s.equals("0 0"))){
            String[] tudo = s.split(" ");

            tudo[1] = tudo[1].replaceAll(tudo[0], "");

            if (tudo[1].isEmpty() || tudo[1].replaceAll("0", "").isEmpty())
                System.out.println("0");
            else
                System.out.println(tudo[1]);

            s = tc.nextLine();
        }
    }
}
