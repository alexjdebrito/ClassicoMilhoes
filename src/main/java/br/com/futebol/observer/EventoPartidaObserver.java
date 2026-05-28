package br.com.futebol.observer;

import br.com.futebol.model.EventoPartida;

public interface EventoPartidaObserver {
    void onEvento(EventoPartida evento);
}