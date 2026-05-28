package br.com.futebol.strategy;

import br.com.futebol.model.EventoPartida;
import br.com.futebol.model.Time;
import br.com.futebol.model.TipoEvento;

import java.util.Random;

public class TaticaDefensiva implements TaticaStrategy {

    private final Random random = new Random();

    @Override
    public EventoPartida executarJogada(Time time, Time adversario, int minuto) {
        int chance = random.nextInt(100);
        String jogador = time.escolherJogadorAleatorio();

        if (chance < 5) {
            return new EventoPartida(TipoEvento.GOL, time.getNome(), jogador, minuto);
        } else if (chance < 30) {
            return new EventoPartida(TipoEvento.DEFESA_GOLEIRO, time.getNome(),
                    time.getGoleiro(), minuto);
        } else if (chance < 45) {
            return new EventoPartida(TipoEvento.FALTA, time.getNome(), jogador, minuto);
        } else if (chance < 55) {
            return new EventoPartida(TipoEvento.CARTAO_AMARELO, time.getNome(),
                    jogador, minuto);
        } else if (chance < 60) {
            return new EventoPartida(TipoEvento.CARTAO_VERMELHO, time.getNome(),
                    jogador, minuto);
        }

        return null;
    }

    @Override
    public String getNomeTatica() {
        return "Defensiva";
    }
}
