package br.com.futebol.state;

import br.com.futebol.model.Partida;

public class EstadoEncerrado implements EstadoPartida {

    @Override
    public void simular(Partida partida) {
        System.out.println("A partida já foi encerrada. Não há mais ações possíveis.");
    }

    @Override
    public String getNomeEstado() {
        return "Encerrada";
    }
}
