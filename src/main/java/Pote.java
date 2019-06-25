package main.java;

import java.util.Random;

public class Pote {

    private int id;
    private int moedas;
    private int[] caminhos;

    public Pote(int id, int[] array) {
        this.id = id;
        this.moedas = 4;
        this.caminhos = array;
    }

    public int getId() {
        return id;
    }

    public void adicionaMoedas() {
        this.moedas++;
    }

    public void removeMoedas() {
        this.moedas--;
    }

    public boolean estaVazio() {
        return moedas == 0;
    }

    public int encontraCaminho() {
        Random rand = new Random();
        return caminhos[rand.nextInt(caminhos.length)];
    }

    @Override
    public String toString() {
        return "Pote{" +
                "id=" + id +
                ", moedas=" + moedas +
                '}';
    }
}
