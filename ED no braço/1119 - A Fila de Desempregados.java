import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);

        int n = Integer.parseInt(tc.next());
        int k = Integer.parseInt(tc.next());
        int m = Integer.parseInt(tc.next());
        tc.nextLine();

        while (!(n == 0 && k == 0 && m ==0)) {

            Lista lista = new Lista(n);
            int[] vet;


            while (!lista.vazia()) {
                vet = lista.remove(k, m);


                if (vet.length == 1)
                    System.out.print(" " + vet[0] + ",");
                else
                    for (int i = 0; i < vet.length; i++)
                        System.out.print("  " + vet[i]);

                if (!lista.vazia()){
                    System.out.print(",");
                }
            }

            n = Integer.parseInt(tc.next());
            k = Integer.parseInt(tc.next());
            m = Integer.parseInt(tc.next());
            tc.nextLine();
        }
    }
}

class Lista {
    private int[] vet;
    private int tamMax;
    private int tamAtual;


    public Lista (int quant){
        vet = new int[quant];
        tamMax = quant;
        tamAtual = tamMax;
    }

    public int[] remove(int horario, int antiHorario){
        if (this.vet[horario-1] == 0 && this.vet[tamMax - antiHorario] == 0) {
            if (horario - 1 == tamMax - antiHorario) {
                this.vet[horario - 1] = 1;
                int[] vet = {horario - 1};
                --tamAtual;
                return vet;
            } else {
                this.vet[horario - 1] = 1;
                this.vet[tamMax - antiHorario] = 1;
                int[] vet = {horario - 1, tamMax - antiHorario};
                --tamAtual;
                return vet;
            }
        }else if (this.vet[horario - 1] == 0){
            this.vet[horario - 1] = 1;
            int[] vet = {horario - 1};
            --tamAtual;
            return vet;
        } else if (this.vet[tamMax - antiHorario] == 0){
            this.vet[tamMax - antiHorario] = 1;
            int[] vet = {tamMax - antiHorario};
            --tamAtual;
            return vet;
        } else {
            int[] vet = {};
            --tamAtual;
            return vet;
        }
    }

    public boolean vazia(){
        return tamAtual==0;
    }
}
