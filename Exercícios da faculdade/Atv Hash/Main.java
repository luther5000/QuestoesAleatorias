import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);

        System.out.println("Qual o tamanho do hash?");
        Hash hash = new Hash(Integer.parseInt(tc.nextLine()));

        while (true){
            System.out.println("O que deseja fazer? \n1. Inserir nova pessoa; \n2. Consultar pessoa;" +
                    "\n3. Remover pessoa; \n4. Sair.");
            int escolha = Integer.parseInt(tc.nextLine());
             switch (escolha) {
                 case 1 -> {
                     System.out.println("\nQual o nome da pessoa?");
                     String nome = tc.nextLine();

                     System.out.println("Qual o CPF da pessoa?");
                     int cpf = Integer.parseInt(tc.nextLine());

                     Pessoa pessoa = new Pessoa(cpf, nome);
                     hash.adiciona(pessoa);
                 }
                 case 2 -> {
                     System.out.println("\nQual o CPF da pessoa que deseja procurar?");
                     int cpf = Integer.parseInt(tc.nextLine());

                     Pessoa procura = hash.retorna(cpf);

                     if (procura == null)
                         System.out.println("A pessoa com CPF " + cpf + "não existe no banco de dados atual.");
                     else {
                         System.out.println("Nome: " + procura.nome + ".\nCPF: " + procura.cpf + ".");
                     }
                 }
                 case 3 -> {
                     System.out.println("\nQual o CPF da pessoa que deseja remover?");
                     int cpf = Integer.parseInt(tc.nextLine());

                     Pessoa procura = hash.remove(cpf);

                     if (procura == null)
                         System.out.println("A pessoa com CPF " + cpf + "não existe no banco de dados atual.");
                     else {
                         System.out.println("A seguinte pessoa foi removida:\n" + procura.nome + ".\nCPF: " + procura.cpf + ".");
                     }
                 }
                 case 4 -> System.exit(0);
             }
             System.out.println("-----------------------------------------------------------------------------------");
        }
    }
}
