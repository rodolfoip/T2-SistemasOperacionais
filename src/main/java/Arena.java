package main.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Arena {

    protected static ScheduledExecutorService salvaVidas;

    public static void main(String args[]) {
        Bosque bosque = new Bosque();

        Cacador amarelo = new Cacador("Amarelo");
        Cacador verde = new Cacador("Verde");
        Cacador azul = new Cacador("Azul");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        salvaVidas = Executors.newSingleThreadScheduledExecutor();
        salvaVidas.scheduleAtFixedRate(new CachorroSalvaVida(bosque), 0, 4, TimeUnit.SECONDS);

        Cachorro amarelo1 = new Cachorro("Cachorro Amarelo 1", amarelo, bosque, bosque.getPote(1));
        Cachorro amarelo2 = new Cachorro("Cachorro Amarelo 2", amarelo, bosque, bosque.getPote(1));

        Cachorro verde1 = new Cachorro("Cachorro Verde 1", verde, bosque, bosque.getPote(1));
        Cachorro verde2 = new Cachorro("Cachorro Verde 2", verde, bosque, bosque.getPote(1));

        Cachorro azul1 = new Cachorro("Cachorro Azul 1", azul, bosque, bosque.getPote(1));
        Cachorro azul2 = new Cachorro("Cachorro Azul 2", azul, bosque, bosque.getPote(1));

        executor.execute(amarelo1);
        executor.execute(verde1);
        executor.execute(azul1);

        executor.submit(amarelo2);
        executor.submit(verde2);
        executor.submit(azul2);

        salvaVidas.shutdown();
    }
}
