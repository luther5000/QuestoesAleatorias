import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            Scanner tc = new Scanner (System.in);
            int quant = Integer.parseInt(tc.next());
            int[] num = new int[2];
            int[] den = new int[2];
            char operacao;
            for (int k=0; k<quant; k++) {
                num[0] = Integer.parseInt(tc.next());
                tc.next();
                den[0] = Integer.parseInt(tc.next());
                operacao = tc.next().charAt(0);
                num[1] = Integer.parseInt(tc.next());
                tc.next();
                den[1] = Integer.parseInt(tc.next());

                int[] res = new int[2];
                switch (operacao) {

                    case '+' -> {
                        res[0] = num[0] * den[1] + num[1] * den[0];
                        res[1] = den[0] * den[1];
                    }

                    case '-' -> {
                        res[0] = num[0] * den[1] - num[1] * den[0];
                        res[1] = den[0] * den[1];
                    }

                    case '*' -> {
                        res[0] = num[0] * num[1];
                        res[1] = den[0] * den[1];
                    }

                    case '/' -> {
                        res[0] = num[0] * den[1];
                        res[1] = num[1] * den[0];
                    }
                }

                int i = 2;
                int[] antigo = {res[0], res[1]};
                if (res[0] < 0) {
                    res[0] = -res[0];
                    while (res[0] >= i & res[1] >= i) {
                        if ((res[0] % i == 0) & (res[1] % i == 0)) {
                            res[0] = res[0] / i;
                            res[1] = res[1] / i;
                        } else
                            i++;
                    }
                    res[0] = -res[0];
                }else
                    while (res[0] >= i & res[1] >= i) {
                        if ((res[0] % i == 0) & (res[1] % i == 0)) {
                            res[0] = res[0] / i;
                            res[1] = res[1] / i;
                        } else
                            i++;
                    }
                System.out.printf("%d/%d = %d/%d\n", antigo[0], antigo[1], res[0], res[1]);
            }
            System.exit(0);
        }catch (Exception NumberFormatException){
            System.exit(1);
        }
    }
}
