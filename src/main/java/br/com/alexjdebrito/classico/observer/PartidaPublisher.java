package br.com.alexjdebrito.classico.observer;

import br.com.alexjdebrito.classico.model.EventoPartida;

public interface PartidaPublisher {
    void registrarObservador(EventoPartidaObserver observer);
    void removerObservador(EventoPartidaObserver observer);
    void notificarObservadores(EventoPartida evento);
}
