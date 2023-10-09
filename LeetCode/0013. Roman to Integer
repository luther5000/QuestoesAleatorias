import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Mapa mapa = new Mapa();

        int total = 0;
        for (int i = 0; i < s.length(); i++){
            if (i < s.length() - 1 && mapa.returnValue(s.charAt(i)) < mapa.returnValue(s.charAt(i+1)))
                total -= mapa.returnValue(s.charAt(i));
            else
                total += mapa.returnValue(s.charAt(i));
        }

        return total;
    }
}

class Mapa {
    List<Estilo>[] lista = new List[7];

    public Mapa () {
        for (int i = 0; i < 7; i++)
            lista[i] = new ArrayList<>();


        Estilo novo = new Estilo ('I', 1);
        lista[0].add(novo);

        novo = new Estilo ('V', 5);
        lista[1].add(novo);

        novo = new Estilo ('X', 10);
        lista[2].add(novo);

        novo = new Estilo ('L', 50);
        lista[3].add(novo);

        novo = new Estilo ('C', 100);
        lista[4].add(novo);

        novo = new Estilo ('D', 500);
        lista[5].add(novo);

        novo = new Estilo ('M', 1000);
        lista[6].add(novo);
    }

    public int returnValue(char compara) {
        for (int i = 0; i < lista.length; i++){
            if (lista[i].get(0).rom == compara)
                return lista[i].get(0).rom;
        }

        return -1;
    }
}

class Estilo{
    int val;
    char rom;

    public Estilo (char rom, int val) {
        this.val = val;
        this.rom = rom;
    }
}
