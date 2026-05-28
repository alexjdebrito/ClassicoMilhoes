package br.com.futebol.state;

import br.com.futebol.model.EventoPartida;
import br.com.futebol.model.Partida;
import br.com.futebol.model.TipoEvento;
import br.com.futebol.strategy.TaticaContraAtaque;
import br.com.futebol.strategy.TaticaDefensiva;
import br.com.futebol.strategy.TaticaOfensiva;
import br.com.futebol.strategy.TaticaStrategy;

import java.util.Random;

public class EstadoIntervalo implements EstadoPartida {

    private final Random random = new Random();

    @Override
    public void simular(Partida partida) {
        System.out.println("\n--- INTERVALO ---");
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

        System.out.printf("%s muda para tática: %s%n",
                partida.getTimeCasa().getNome(), novaTaticaCasa.getNomeTatica());
        System.out.printf("%s muda para tática: %s%n",
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