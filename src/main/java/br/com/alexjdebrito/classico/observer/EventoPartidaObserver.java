package br.com.alexjdebrito.classico.observer;

import br.com.alexjdebrito.classico.model.EventoPartida;

public interface EventoPartidaObserver {
    void onEvento(EventoPartida evento);
}