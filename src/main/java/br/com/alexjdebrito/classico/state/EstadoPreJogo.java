package br.com.alexjdebrito.classico.state;

import br.com.alexjdebrito.classico.model.EventoPartida;
import br.com.alexjdebrito.classico.model.Partida;
import br.com.alexjdebrito.classico.model.TipoEvento;

import java.util.ArrayList;
import java.util.List;

public class EstadoPreJogo implements EstadoPartida {

    @Override
    public void simular(Partida partida) {

        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("╟──────────────────── CLÁSSICO DOS MILHÕES ────────────────────╢");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");

        System.out.println("\n─── PRÉ-JOGO ────────────────────");
        System.out.printf("  %s  X  %s%n",
                partida.getTimeCasa().getNome(),
                partida.getTimeVisitante().getNome());

        System.out.println("\n─── ESCALAÇÕES ──────────────────");

        System.out.printf("\n O %s vai a campo em uma formação %s",
                partida.getTimeCasa().getNome(),
                partida.getTimeCasa().getTatica().getNomeTatica());
        System.out.println();
        exibirEscalacao(partida.getTimeCasa());

        System.out.printf("\n O %s vai a campo em uma formação %s",
                partida.getTimeVisitante().getNome(),
                partida.getTimeVisitante().getTatica().getNomeTatica());
        System.out.println();
        exibirEscalacao(partida.getTimeVisitante());

        System.out.println("\n─────────────────────────────────\n");

        partida.notificarObservadores(
                new EventoPartida(TipoEvento.INICIO_PARTIDA,
                        partida.getTimeCasa().getNome(), "", 0));

        partida.setEstado(new EstadoPrimeiroTempo());
    }

    private void exibirEscalacao(br.com.alexjdebrito.classico.model.Time time) {
        List<String> todos = new ArrayList<>();
        todos.add(time.getGoleiro());
        todos.addAll(time.getJogadores());
        System.out.println("  " + time.getNome().toUpperCase());
        System.out.println("  " + String.join(", ", todos));
    }

    @Override
    public String getNomeEstado() {
        return "Pré-Jogo";
    }
}
