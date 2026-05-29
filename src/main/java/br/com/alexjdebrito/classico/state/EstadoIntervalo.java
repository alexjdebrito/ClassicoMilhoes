package br.com.alexjdebrito.classico.state;

import br.com.alexjdebrito.classico.model.EventoPartida;
import br.com.alexjdebrito.classico.model.Partida;
import br.com.alexjdebrito.classico.model.TipoEvento;
import br.com.alexjdebrito.classico.strategy.TaticaContraAtaque;
import br.com.alexjdebrito.classico.strategy.TaticaDefensiva;
import br.com.alexjdebrito.classico.strategy.TaticaOfensiva;
import br.com.alexjdebrito.classico.strategy.TaticaStrategy;

import java.util.Random;

public class EstadoIntervalo implements EstadoPartida {

    private final Random random = new Random();

    @Override
    public void simular(Partida partida) {
        System.out.println("\n─── INTERVALO ───────────────────");
        System.out.println("Um grande primeiro tempo de jogo!");
        pausar(1000);

        ajustarTaticas(partida);

        partida.notificarObservadores(
                new EventoPartida(TipoEvento.INICIO_SEGUNDO_TEMPO,
                        partida.getTimeCasa().getNome(), "", 45));

        partida.setEstado(new EstadoSegundoTempo());
    }

    private void ajustarTaticas(Partida partida) {
        TaticaStrategy[] taticas = {
                new TaticaOfensiva(),
                new TaticaDefensiva(),
                new TaticaContraAtaque()
        };

        TaticaStrategy novaTaticaCasa = taticas[random.nextInt(taticas.length)];
        TaticaStrategy novaTaticaVisitante = taticas[random.nextInt(taticas.length)];

        System.out.printf("\nO %s volta a campo com uma formação %s%n",
                partida.getTimeCasa().getNome(), novaTaticaCasa.getNomeTatica());
        System.out.printf("E o %s volta a campo com uma formação %s%n\n",
                partida.getTimeVisitante().getNome(), novaTaticaVisitante.getNomeTatica());

        partida.getTimeCasa().setTatica(novaTaticaCasa);
        partida.getTimeVisitante().setTatica(novaTaticaVisitante);
    }

    private void pausar(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    @Override
    public String getNomeEstado() {
        return "Intervalo";
    }
}