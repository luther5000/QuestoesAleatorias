import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while (tc.hasNext()){
            int i = 0;
            list.add(i, 1);
            int num1 = Integer.parseInt(tc.next());
            int num2 = Integer.parseInt(tc.next());

            mdc (list, num1, num2, 2, i);

            ++i;
        }

        for (int i = list.size()-1; i >= 0; i--){
            if (list.get(i) > 5)
                System.out.println("Noel");
            else
                System.out.println("Gnomos");
        }

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    public static void mdc(List list, int num, int num2, int divisor, int i) {
        if (divisor > (num+1)/2 && divisor > (num2 + 1)/2)
            return;
        if (divisor > num || divisor > num2)
            return;
        if (num % divisor == 0 && num2 % divisor == 0)
            list.set(i, divisor);

            mdc(list, num, num2, ++divisor, i);
    }
}
