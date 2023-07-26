import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner tc = new Scanner(System.in);
            int[] dia = new int[2];
            int[] hora = new int[2];
            int[] min = new int[2];
            int[] seg = new int[2];

            tc.next();
            dia[0] = Integer.parseInt(tc.next());
            hora[0] = Integer.parseInt(tc.next());
            tc.next();
            min[0] = Integer.parseInt(tc.next());
            tc.next();
            seg[0] = Integer.parseInt(tc.next());

            tc.next();
            dia[1] = Integer.parseInt(tc.next());
            hora[1] = Integer.parseInt(tc.next());
            tc.next();
            min[1] = Integer.parseInt(tc.next());
            tc.next();
            seg[1] = Integer.parseInt(tc.next());

            int diaf = dia[1]-dia[0];
            int segf, horaf, minf;
            int adiciona=0;
            if (seg[1] >= seg[0])
                segf = seg[1]-seg[0];
            else
                segf = 60 + seg[1] - seg[0];

            if (min[1] >= min[0])
                minf = min[1] - min[0];
            else
                minf = 60 + min[1] - min[0];

            if (hora[1] > hora[0])
                horaf = hora[1] - hora[0];
            else
                horaf = 60 + hora[1] - hora[0];

            System.out.println(diaf + " dia(s)\n" + horaf + " hora(s)\n" +
                    minf + " minuto(s)\n" + segf + "segundo(s)");

        } catch (Exception NumberFormatException) {
            System.exit(1);
        }
        }
    }
