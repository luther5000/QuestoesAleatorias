import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        List<String> texto = Files.readAllLines(Path.of("/home/aluno/Downloads/pcv4.txt"),
                StandardCharsets.UTF_8);
        int tam = Integer.parseInt(texto.get(0));
        texto.remove(0);

        Grafo grafo = new Grafo(tam);
        grafo.adicionar(trata(texto, tam));

        while (true) {
            System.out.println("Número de componentes conexas: " + grafo.numCompConexa());

            grafo.printaMatriz();
            System.out.println();

            Scanner tc = new Scanner(System.in);

            System.out.println("Qual o vértice de origem?");
            int origem = Integer.parseInt(tc.nextLine())-1;

            System.out.println("Qual o vértice de destino?");
            int destino = Integer.parseInt(tc.nextLine())-1;


            int[] caminho = grafo.caminho(origem, destino);
            if (caminho[caminho.length-1] == 0)
                System.out.println("Não há caminho entre os vértices");
            else {
                System.out.print("O caminho entre os vérties é: ");

                for (int i = 0; i < caminho.length; i++)
                    if (i != caminho.length - 1)
                        System.out.print(caminho[i] + " ");
                    else
                        System.out.println(caminho[i] + " " + (destino+1));
            }

            System.out.println("\nDeseja sair?\n1. Sim\n2. Não");
            origem = Integer.parseInt(tc.nextLine());
            if (origem == 1)
                System.exit(0);
        }
    }

    public static int[][] trata(List<String> entrada, int tam){
        int[][] matriz = new int[tam][tam];

        for (int i = 0; i < tam; i++) {
            String[] nums = entrada.get(i).split("\t");

            for (int j = 0; j < tam; j++) {
                matriz[i][j] = Integer.parseInt(nums[j]);
            }
        }
        return matriz;
    }
}
