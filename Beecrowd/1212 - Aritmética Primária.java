import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tc = new Scanner (System.in);
        while (true){
            String s = tc.next();
            String s2 = tc.nextLine();


            s = s.replaceAll(" ", "");
            s2 = s2.replaceAll(" ", "");

            if (s.equals("0") && s2.equals("0"))
                System.exit(0);

            Lista primeiro = converte(s);
            Lista segundo = converte(s2);

            /*for (int i = 1; i <= primeiro.getTam(); i++)
                System.out.println(primeiro.getElemento(i));

            for (int i = 1; i <= segundo.getTam(); i++)
                System.out.println(segundo.getElemento(i));*/

            int[] soma = primeiro.somaListas(segundo);
            int cont = 0;

            for (int i = 0; i < soma.length; i++) {
                //System.out.println(soma[i]);
                if (soma[i] >= 10) {
                    cont++;
                    if (!(i+1 >= soma.length))
                        soma[i+1]++;
                }

            }
            if (cont == 0)
                System.out.println("No carry operation.");
            else if (cont == 1)
                System.out.println(cont + " carry operation.");
            else 
                System.out.println(cont + " carry operations.");
        }
    }

    public static Lista converte(String s){
        Lista novo = new Lista();
        for (int i = 0; i<s.length(); i++) {
            novo.adicionaNo(Integer.parseInt(s.substring(i, i+1)));
        }
        return novo;
    }

}

class Lista {
    private No cabeca;
    private int tam;

    public Lista (){
        this.cabeca = null;
        this.tam = 0;
    }

    public void adicionaNo (int numero){
        No novo = new No();
        novo.setNumero(numero);
        novo.prox = cabeca;
        cabeca = novo;
        tam++;
    }

    public int[] somaListas(Lista segundo)
    {
        if (this.tam >= segundo.getTam())
        {
            int[] vet = new int[tam];
            for (int i = 1; i <= tam; i++)
            {
                if (i <= segundo.getTam())
                    vet[i-1] = getElemento(i) + segundo.getElemento(i);
                else
                    vet[i-1] = getElemento(i);
            }

            return vet;
        } else
        {
            int[] vet = new int[segundo.getTam()];
            for (int i = 1; i <= segundo.getTam(); i++)
            {
                if (i <= tam)
                    vet[i - 1] = getElemento(i) + segundo.getElemento(i);
                else
                    vet[i - 1] = segundo.getElemento(i);
        }

            return vet;
        }
    }

    public int getTam(){
        return tam;
    }

    public boolean verificaVazia(){
        if (tam == 0)
            return true;
        else
            return false;
    }

    public int getElemento(int indice){
        No aux = cabeca;

        if (verificaVazia() && indice > tam && indice < 0)
            return -1;

        for (int i = 1; i < indice; i++)
            aux = aux.prox;

        return aux.getNumero();
    }
}

class No {
    private int numero;
    No prox;

    public No () {
        prox = null;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
