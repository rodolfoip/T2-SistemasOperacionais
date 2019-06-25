package main.java;

public class Cachorro extends Thread {

    private int qtdMoedas;
    private Pote pote;
    private Bosque bosque;
    private Cacador cacador;
    public static boolean running = true;

    public Cachorro(String nome, Cacador cacador, Bosque bosque, Pote pote) {
        this.setName(nome);
        this.qtdMoedas = 0;
        this.pote = pote;
        this.cacador = cacador;
        this.bosque = bosque;
    }

    @Override
    public void run() {
        while (this.qtdMoedas < 20 && this.cacador.getTotalMoedas() + this.qtdMoedas < 50 && running) {
            try {
                int coletadas = this.pegaMoeda(this.qtdMoedas);
                this.qtdMoedas += coletadas;

                System.out.println(getName() + " está com " + this.qtdMoedas + " moedas");

                int caminho = this.pote.encontraCaminho();
                this.pote = this.bosque.getPote(caminho);

                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Erro: " + e);
            }
        }

        if (!this.cacador.isGanhador()) {
            System.out.println(getName() + " já conseguiu as " + this.qtdMoedas + " esta indo levar ao seu dono");
            cacador.setTotalMoedas(this.qtdMoedas);
            this.qtdMoedas = 0;
        }

        System.out.println(getName() + " acabou");
    }

    public synchronized int pegaMoeda(int moedas) throws InterruptedException {
        int coletadas = 0;
        int moedasAtual = moedas;

        while (this.pote.estaVazio()) {
            System.out.println(getName() + " achou o pote " + this.pote.getId() + " vazio e DORMIU");
            sleep(6000);
        }

        while (coletadas < 3 && moedasAtual < 20 && !this.pote.estaVazio()) {
            System.out.println(getName() + " está pegando moedas no pote: " + this.pote.toString());
            this.pote.removeMoedas();
            coletadas++;
            moedasAtual++;
            sleep(100);
        }

        return coletadas;
    }
}
