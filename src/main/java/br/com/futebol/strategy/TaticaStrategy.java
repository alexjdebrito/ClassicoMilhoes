package br.com.futebol.strategy;

import br.com.futebol.model.EventoPartida;
import br.com.futebol.model.Time;

public interface TaticaStrategy {
    EventoPartida executarJogada(Time time, Time adversario, int minuto);
    String getNomeTatica();
}
