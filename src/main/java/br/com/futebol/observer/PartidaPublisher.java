package br.com.futebol.observer;

import br.com.futebol.model.EventoPartida;

public interface PartidaPublisher {
    void registrarObservador(EventoPartidaObserver observer);
    void removerObservador(EventoPartidaObserver observer);
    void notificarObservadores(EventoPartida evento);
}
