import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int numOps = Integer.parseInt(tc.nextLine());

        while (numOps != 0){
            Queue<Integer> fila = new LinkedList<>();
            String s = tc.nextLine();
            char[] ops = new char[numOps];
            int j = 0;
            int num = 0;

            System.out.println(s.length());
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    fila.add(Integer.parseInt(s.substring(0, i)));
                    ops[j++] = s.charAt(i);

                    s = s.substring(0, i);
                    i = 0;
                    System.out.println("entrou");
                }
            }

            int total = fila.remove();
            for (int i = 0; i < ops.length; i++)
                if (ops[i] == '+')
                    total += fila.remove();
                else
                    total -= fila.remove();

            numOps = Integer.parseInt(tc.nextLine());
        }
    }
}
