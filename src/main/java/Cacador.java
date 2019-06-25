package main.java;

import static java.lang.System.exit;

public class Cacador {

    private int totalMoedas;
    private String nome;
    private boolean ganhador;

    public Cacador(String nome) {
        this.totalMoedas = 0;
        this.nome = nome;
        this.ganhador = false;
    }

    public int getTotalMoedas() {
        return totalMoedas;
    }

    public boolean isGanhador() {
        return ganhador;
    }

    public void setTotalMoedas(int moedas) {
        this.totalMoedas += moedas;

        if (this.totalMoedas >= 50) {
            this.ganhador = true;
            Cachorro.running = false;
            System.out.println("Ganhador é " + this.nome);
            exit(0);
        }

        System.out.println("Caçador " + this.nome + " está com " + this.totalMoedas);
    }
}
