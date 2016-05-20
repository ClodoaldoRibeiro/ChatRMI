package br.com.chat.server;

public enum SituationServer {
    START(1), STOP(2);

    private final int valor;

    private SituationServer(int valor) {
        this.valor = valor;
    }

    public static SituationServer getSTART() {
        return START;
    }

    public static SituationServer getSTOP() {
        return STOP;
    }

    public int getValor() {
        return valor;
    }
}
