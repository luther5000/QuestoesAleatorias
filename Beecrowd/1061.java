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

                long[] segundosTotal = new long[2];
                segundosTotal[0] = (dia[0]*24*60*60)+(hora[0]*60*60)+(min[0]*60)+seg[0];
                segundosTotal[1] = (dia[1]*24*60*60)+(hora[1]*60*60)+(min[1]*60)+seg[1];;

                segundosTotal[0] = segundosTotal[1] - segundosTotal[0];
                min[0] = (int)segundosTotal[0]/60;
                seg[0] = (int)segundosTotal[0]%60;

                hora[0] = min[0]/60;
                min[0] = min[0]%60;

                dia[0] = hora[0]/24;
                hora[0] = hora[0]%24;


                System.out.println(dia[0] + " dia (s)\n" + hora[0] + " hora (s)\n" +
                        min[0] + " minuto (s)\n" + seg[0] + " segundo (s)");

            } catch (Exception NumberFormatException) {
                System.exit(1);
            }
        }
    }
