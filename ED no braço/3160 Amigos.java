import java.util.Scanner;

class Main{
   public static void main (String[] args){
      Scanner tc = new Scanner(System.in);
      Lista atual = new Lista();
      Lista novo = new Lista();
      String linha;

      for (int i = 0; i < 2; i++){
         if (i == 0) {
            linha = tc.nextLine();
            atual.adicionaString(linha.split(" "));
         }
         else {
            linha = tc.nextLine();
            novo.adicionaString(linha.split(" "));
         }
      }

      linha = tc.nextLine();

      if (linha.equalsIgnoreCase("nao")) {
         atual.printa();
         novo.printa();
      }
      else {
         for (int i = 1; i <= atual.getTam(); i++) {
            if (atual.retorna(i).equals(linha))
               novo.printa();
            if (i != atual.getTam())
               System.out.print(atual.retorna(i) + " ");
            else
               System.out.print(atual.retorna(i));
         }
      }
      System.out.println();
   }
}

class Lista{
   private No cabeca;
   private int tam;
   private No ultimo;

   public Lista(){
      cabeca = null;
      tam = 0;
      ultimo = null;
   }

   public String retorna(int indice){
      No aux = cabeca;
      if (indice > tam || verifica() || indice <= 0)
         return "";
      for (int i = 1; i < indice; i++)
         aux = aux.getProx();

      return aux.getNome();
   }
   public void printa(){
      No aux = cabeca;
      if (verifica())
         return;
      else
         for (int i = 1; i <= tam; i++) {
               System.out.print(aux.getNome() + " ");
               aux = aux.getProx();
         }
   }

   public void adicionaString(String[] nome){
      for (int i = 0; i < nome.length; i++) {
         No novoNo = new No(nome[i]);
         if (verifica()) {
            novoNo.setProx(cabeca);
            cabeca = novoNo;
            ultimo = novoNo;
            //System.out.println(cabeca.getNome());
            tam++;
         } else {
            ultimo.setProx(novoNo);
            ultimo = novoNo;
            //System.out.println(ultimo.getNome());
            tam++;
         }
      }
   }

   public boolean verifica(){
      return (tam==0);
   }

   public int getTam() {
      return tam;
   }
}



class No {
   private String nome;
   private No prox;

   public No (String nome){
      this.nome = nome;
      prox = null;
   }

   public void setProx(No prox){
      this.prox = prox;
   }

   public String getNome(){
      return nome;
   }

   public No getProx() {
      return prox;
   }
}
