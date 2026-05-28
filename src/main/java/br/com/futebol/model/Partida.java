package br.com.futebol.model;

import br.com.futebol.observer.EventoPartidaObserver;
import br.com.futebol.observer.PartidaPublisher;
import br.com.futebol.state.EstadoPartida;

import java.util.ArrayList;
import java.util.List;

public class Partida implements PartidaPublisher {

    private final List<EventoPartidaObserver> observadores = new ArrayList<>();

    private EstadoPartida estadoAtual;

    private final Time timeCasa;
    private final Time timeVisitante;

    public Partida(Time timeCasa, Time timeVisitante, EstadoPartida estadoInicial) {
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.estadoAtual = estadoInicial;
    }

    public void avancarFase() {
        System.out.printf("%n %s%n", estadoAtual.getNomeEstado());
        estadoAtual.simular(this);
    }

    public void simularPartidaCompleta() {
        while (!(estadoAtual instanceof br.com.futebol.state.EstadoEncerrado)) {
            avancarFase();
        }
    }

    @Override
    public void registrarObservador(EventoPartidaObserver observer) {
        observadores.add(observer);
    }

    @Override
    public void removerObservador(EventoPartidaObserver observer) {
        observadores.remove(observer);
    }

    @Override
    public void notificarObservadores(EventoPartida evento) {
        for (EventoPartidaObserver obs : observadores) {
            obs.onEvento(evento);
        }
    }

    public void setEstado(EstadoPartida novoEstado) {
        this.estadoAtual = novoEstado;
    }

    public Time getTimeCasa() { return timeCasa; }
    public Time getTimeVisitante() { return timeVisitante; }
    public EstadoPartida getEstado() { return estadoAtual; }
}