package br.com.futebol.state;

public interface EstadoPartida {
    void simular(br.com.futebol.model.Partida partida);
    String getNomeEstado();
}