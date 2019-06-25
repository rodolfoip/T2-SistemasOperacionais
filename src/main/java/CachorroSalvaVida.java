package main.java;

public class CachorroSalvaVida extends Thread {

    private Pote pote;
    private Bosque bosque;

    public CachorroSalvaVida(Bosque bosque) {
        this.bosque = bosque;
    }

    @Override
    public void run() {
        while (Cachorro.running) {
            for (int i = 1; i <= 20; i++) {
                this.pote = bosque.getPote(i);

                if (this.pote.estaVazio()) {
                    this.colocaMoeda();
                }
            }
        }

        System.out.println(getName() + " acabou");
    }

    public synchronized void colocaMoeda() {
        this.pote.adicionaMoedas();
        System.out.println("Cachorro salva vidas adicionou 1 moeda no pote " + this.pote.getId());
        notifyAll();
    }
}
