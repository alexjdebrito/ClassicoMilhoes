package br.com.alexjdebrito.classico.state;

import br.com.alexjdebrito.classico.model.Partida;

public interface EstadoPartida {
    void simular(Partida partida);
    String getNomeEstado();
}