package main.java;

import java.util.ArrayList;
import java.util.List;

public class Pote {
    /*Pode ser acessado por apenas UM cachorro*/
    //ATRIBUTOS
    /*Quantidade de moedas*/
    /*Cachorro que estão dormindo*/

    private int id;
    private int moedas;
    private List<Cachorro> cachorrosDormindo;

    public Pote(int id) {
        this.id = id;
        this.moedas = 4;
        this.cachorrosDormindo = new ArrayList<>();
    }

    public int pegaMoeda(Cachorro cachorro) {
        if (moedas >= 3) {
            moedas = (moedas - 3);
            return 3;
        } else if (moedas == 2) {
            moedas = (moedas - 2);
            return 2;
        } else if (moedas == 1) {
            moedas = (moedas - 1);
            return 1;
        }

        cachorrosDormindo.add(cachorro);

        return 0;
    }
}
