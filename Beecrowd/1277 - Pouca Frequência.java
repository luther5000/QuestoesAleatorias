import java.util.Scanner;

class Main {


    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int quant = Integer.parseInt(tc.nextLine());

        while (quant > 0){
            int alunos = Integer.parseInt(tc.nextLine());

            String all = tc.nextLine();
            String[] nomes = all.split(" ");

            all = tc.nextLine();
            String[] presenca = all.split(" ");

            int[] total = new int[presenca.length];
            int[] faltas = new int[presenca.length];

            for (int i = 0; i < presenca.length; i++){
                for (int j = 0; j < presenca[i].length(); j++){
                    if (presenca[i].charAt(j) != 'M')
                        ++total[i];
                    if (presenca[i].charAt(j) == 'A')
                        ++faltas[i];
                }
            }

            String printa = "";
            for (int i = 0; i < nomes.length; i++){
                if (((double)faltas[i]/total[i])*100 > 25)
                    if (printa.isEmpty())
                        printa = nomes[i];
                    else
                        printa = printa + " " + nomes[i];
            }

            System.out.println(printa);

            --quant;
        }

    }
}
