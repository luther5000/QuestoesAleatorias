import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int numOps = Integer.parseInt(tc.nextLine());
        int teste = 1;

        while (numOps != 0){
            Queue<Integer> fila = new LinkedList<>();
            String s = tc.nextLine();
            int num = 0;
            System.out.println(s.length());
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    fila.add(Integer.parseInt(s.substring(0, i)));

                    s = s.substring(i);
                    i = 0;
                    ++num;
                    if (num+1 == numOps){
                        fila.add(Integer.parseInt(s));
                        break;
                    }
                }
            }
            
            if (fila.isEmpty()){
                numOps = Integer.parseInt(tc.nextLine());
                continue;
            }

            int total = fila.remove();
            while (!(fila.isEmpty())) {
                total += fila.remove();
            }

            System.out.println("Teste " + teste + "\n" + total);
            numOps = Integer.parseInt(tc.nextLine());
            ++teste;
        }
    }
}
