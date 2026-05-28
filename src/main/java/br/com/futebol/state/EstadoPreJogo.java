package br.com.futebol.state;

import br.com.futebol.model.EventoPartida;
import br.com.futebol.model.Partida;
import br.com.futebol.model.TipoEvento;

public class EstadoPreJogo implements EstadoPartida {

    @Override
    public void simular(Partida partida) {



        System.out.println("PRÉ-JOGO");
        System.out.printf("  %s  X  %s%n",
                partida.getTimeCasa().getNome(),
                partida.getTimeVisitante().getNome());
        System.out.printf("  Tática casa: %s%n",
                partida.getTimeCasa().getTatica().getNomeTatica());
        System.out.printf("  Tática visitante: %s%n",
                partida.getTimeVisitante().getTatica().getNomeTatica());
        System.out.println("|||\n");

        partida.notificarObservadores(
                new EventoPartida(TipoEvento.INICIO_PARTIDA,
                        partida.getTimeCasa().getNome(), "", 0));

        partida.setEstado(new EstadoPrimeiroTempo());
    }

    @Override
    public String getNomeEstado() {
        return "Pré-Jogo";
    }
}
