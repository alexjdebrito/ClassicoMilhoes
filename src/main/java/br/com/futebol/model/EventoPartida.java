package br.com.futebol.model;

public class EventoPartida {

    private final TipoEvento tipo;
    private final String timeResponsavel;
    private final String jogador;
    private final int minuto;

    public EventoPartida(TipoEvento tipo, String timeResponsavel, String jogador, int minuto) {
        this.tipo = tipo;
        this.timeResponsavel = timeResponsavel;
        this.jogador = jogador;
        this.minuto = minuto;
    }

    public TipoEvento getTipo() { return tipo; }
    public String getTimeResponsavel() { return timeResponsavel; }
    public String getJogador() { return jogador; }
    public int getMinuto() { return minuto; }
}
