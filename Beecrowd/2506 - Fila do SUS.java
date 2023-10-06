import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int cont = 0;
        while (tc.hasNext()) {
            if (cont != 0){
                tc.nextLine();
            }
            int casos = Integer.parseInt(tc.nextLine());
            Queue<Paciente> fila = new LinkedList<>();

            for (int i = 0; i < casos; i ++) {
                Paciente novo = new Paciente(Integer.parseInt(tc.next())*60 + Integer.parseInt(tc.next()),
                        Integer.parseInt(tc.next()));
                fila.add(novo);
                if (casos -1 != i)
                    tc.nextLine();
            }

            int criticos = 0;
            int horaAtual = 7*60;
            cont = 1;
            while (!(fila.isEmpty())) {
                if (horaAtual - fila.peek().hora < 0) {
                    horaAtual += 30;
                    continue;
                }

                Paciente atual = fila.remove();

                if (horaAtual - atual.hora > atual.tempo) {
                    ++criticos;
                }

                horaAtual += 30;
            }
            System.out.println(criticos);

        }
    }
}
class Paciente{
    int hora;
    int tempo;
    public Paciente(int hora, int tempo) {
        this.hora = hora;
        this.tempo = tempo;
    }
}
