package br.com.alexjdebrito.classico.strategy;

import br.com.alexjdebrito.classico.model.EventoPartida;
import br.com.alexjdebrito.classico.model.Time;
import br.com.alexjdebrito.classico.model.TipoEvento;

import java.util.Random;

public class TaticaContraAtaque implements TaticaStrategy {

    private final Random random = new Random();

    @Override
    public EventoPartida executarJogada(Time time, Time adversario, int minuto) {
        int chance = random.nextInt(100);
        String jogador = time.escolherJogadorAleatorio();

        if (chance < 10) {
            return new EventoPartida(TipoEvento.GOL, time.getNome(), jogador, minuto);
        } else if (chance < 11) {
            return new EventoPartida(TipoEvento.GRANDE_CHANCE, time.getNome(), jogador, minuto);
        } else if (chance < 25) {
            return new EventoPartida(TipoEvento.DEFESA_GOLEIRO, adversario.getNome(),
                    adversario.getGoleiro(), minuto);
        } else if (chance < 55) {
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
        return "de Transição";
    }
}
