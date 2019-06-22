package main.java;

public class Cacador extends Thread {
    /*Tem 2 cachorros*/
    /*Vence quando tiver 50 moedas antes dos oponentes*/

    private Thread t;
    private int totalMoedas;
    private String cor;
    private Cachorro cachorro1;
    private Cachorro cachorro2;

    public Cacador(String cor) {
        this.totalMoedas = 0;
        this.cor = cor;
        this.cachorro1 = new Cachorro(this.cor, 1);
        this.cachorro2 = new Cachorro(this.cor, 2);
    }

    @Override
    public void run() {
    }

    @Override
    public void start() {
        if (t == null) {
            t = new Thread(this, cor);
            t.start();
        }
    }


    public int getTotalMoedas() {
        return totalMoedas;
    }

    public void setTotalMoedas(int totalMoedas) {
        this.totalMoedas = totalMoedas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Cachorro getCachorro1() {
        return cachorro1;
    }

    public Cachorro getCachorro2() {
        return cachorro2;
    }
}
