import java.util.*;

 public class Main{
    public static void main(String[] args){
        Scanner tc = new Scanner(System.in);
        int tam = Integer.parseInt(tc.next());
        List<Integer> alturas= new ArrayList<>();
        int alturaMax = Integer.parseInt(tc.next());
        tc.nextLine();

        for (int i = 0; i < tam; i++){
            alturas.add(Integer.parseInt(tc.next()));
        }

        alturas.sort(Comparator.naturalOrder());

        int barcos = 0;


        int j = 0;
        while (!(alturas.isEmpty())){
            if (alturas.size() == 1){
                ++barcos;
                break;
            }
            if (alturas.get((alturas.size()-1)/2) + alturas.get(alturas.size()-1) <= alturaMax)
                if (alturas.size() % 2 == 0) {
                    barcos += alturas.size() / 2;
                    break;
                }
                else {
                    barcos += alturas.size() / 2 + 1;
                    break;
                }

            if (alturas.get(j) + alturas.get(alturas.size()-1) <= alturaMax) {
                ++barcos;
                alturas.remove(j);
                alturas.remove(alturas.size()-1);
            }
            else {
                ++barcos;
                alturas.remove(alturas.size()-1);
            }
        }

        System.out.println(barcos);
    }
}
