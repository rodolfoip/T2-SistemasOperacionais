package main.java;

public class Cachorro extends Thread {
    /*Quando encontra um pote consegue levar até TRÊS moedas,
    após isso, ele vai procurar no proximo pode escolhido aleatoriamente, dentre as opções disponiveis podendo inclusive voltar para o anterior*/
    /*Se encontrar um pote vazio, deve dormir por 60 unidades de tempo ou até que o Cachorro salva-vida coloque UMA moeda no pote*/
    /*Cachorro salva-vida visita todos os podes de acordo com a ordem numérica para determinar os que estão vazios, nos vazios ele coloca UMA moeda*/
    /*Quando tiver 20 moedas deve voltar imediatamente para o cacador, deixar as moedas e voltar para a fila de entrada do bosque*/
    /*Quando o total de moedas do cacador + o número de moedas com o cachorro totalizarem 50, o cachorro pode voltar para o caçador*/
    /*Demora UMA unidade de tempo para sair de um pote para outro*/
    /*Demora UMA unidade de tempo para pegar as moedas de um pote, caso haja*/
    /*Pode acessar um pote com cachorros que estejam dormindo nesse pote*/
    /*Cachorro salva-vida passa a cada 2 unidades de tempo verificando quais potes estão vazios e colocar uma moeda,
    também irá verificar se há cachorros dormindo, se houver deve acorda-los para que tentem pegar a unica moeda recem colocada, os que não conseguirem devem voltar a dormir por mais 3 unidades de tempo*/

    private Thread t;
    private int qtdMoedas;
    private String cor;

    public Cachorro(String cor) {
        this.cor = cor;
        this.qtdMoedas = 0;
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

    public int getQtdMoedas() {
        return qtdMoedas;
    }

    public void setQtdMoedas(int qtdMoedas) {
        this.qtdMoedas = qtdMoedas;
    }

    public String getCor() {
        return cor;
    }
}
