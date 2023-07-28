import java.util.Scanner;

class Main {
    public static void main (String[] args) {
        try {
            Scanner tc = new Scanner(System.in);
            int[] horario = new int[4];
            for (int i=0; i<4; i++)
                horario[i] = Integer.parseInt(tc.next());

            long[] segundosTotal = new long[2];


            segundosTotal[0] = (horario[0] * 60 * 60) + (horario[1] * 60);
            segundosTotal[1] = (horario[2] * 60 * 60) + (horario[3] * 60);

            if (horario[0] > horario[2] || horario[0] == horario[2] & horario[1] > horario[3])
                segundosTotal[0] = (60*60*24 - segundosTotal[0]) + (segundosTotal[1]);

            else
                segundosTotal[0] = segundosTotal[1]-segundosTotal[0];

            horario[0] = (int)segundosTotal[0]/60;
            horario[1] = horario[0]/60;
            horario[0] = horario[0]%60;

            if (horario[0] < 0)
                horario[0] = -horario[0];

            if (horario[1] < 0)
                horario[1] = -horario[1];

            if (horario[1]>24)
                System.exit(1);

            if (horario[0] == 0 & horario[1] == 0)
                horario[1] = 24;

            System.out.println("O JOGO DUROU " + horario[1] + " HORA(S) E " +
                    horario[0] + " MINUTO(S)");

            System.exit(0);
        } catch (Exception NumberFormatException){
            System.exit(1);
        }
    }
}
