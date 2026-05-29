package br.com.alexjdebrito.classico.strategy;

import br.com.alexjdebrito.classico.model.EventoPartida;
import br.com.alexjdebrito.classico.model.Time;

public interface TaticaStrategy {
    EventoPartida executarJogada(Time time, Time adversario, int minuto);
    String getNomeTatica();
}
