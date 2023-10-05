import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);

        while (tc.hasNext()) {
            int casos = Integer.parseInt(tc.nextLine());
            Queue<Paciente> fila = new LinkedList<>();

            for (int i = 0; i < casos; i ++) {
                int hora = Integer.parseInt(tc.next())*60 + Integer.parseInt(tc.next());
                if (hora < i) {
                    Paciente novo = new Paciente(hora, Integer.parseInt(tc.next()));
                    fila.add(novo);
                }
                tc.nextLine();
            }

            int criticos = 0;
            int horaAtual = 7*60;
            
            while (!(fila.isEmpty()) && horaAtual <= 19*60) {
                if (horaAtual - fila.peek().hora < 0) {
                    horaAtual += 30;
                    continue;
                }

                if (horaAtual - fila.peek().hora > fila.peek().tempo) 
                    ++criticos;

                horaAtual += 30;
                fila.remove();
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
