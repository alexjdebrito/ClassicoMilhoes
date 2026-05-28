package br.com.futebol.strategy;

import br.com.futebol.model.EventoPartida;
import br.com.futebol.model.Time;
import br.com.futebol.model.TipoEvento;

import java.util.Random;

public class TaticaOfensiva implements TaticaStrategy {

    private final Random random = new Random();

    @Override
    public EventoPartida executarJogada(Time time, Time adversario, int minuto) {
        int chance = random.nextInt(100);
        String jogador = time.escolherJogadorAleatorio();

        if (chance < 15) {
            return new EventoPartida(TipoEvento.GOL, time.getNome(), jogador, minuto);
        } else if (chance < 35) {
            return new EventoPartida(TipoEvento.DEFESA_GOLEIRO, adversario.getNome(),
                    adversario.getGoleiro(), minuto);
        } else if (chance < 60) {
            return new EventoPartida(TipoEvento.FALTA, adversario.getNome(),
                    adversario.escolherJogadorAleatorio(), minuto);
        } else if (chance < 70) {
            return new EventoPartida(TipoEvento.CARTAO_AMARELO, adversario.getNome(),
                    adversario.escolherJogadorAleatorio(), minuto);
        }

        return null;
    }

    @Override
    public String getNomeTatica() {
        return "Ofensiva";
    }
}
