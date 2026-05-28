package br.com.futebol.state;

import br.com.futebol.model.EventoPartida;
import br.com.futebol.model.Partida;
import br.com.futebol.model.TipoEvento;

import java.util.Scanner;

public class EstadoSegundoTempo implements EstadoPartida {

    private static final int INICIO_MINUTO   = 46;
    private static final int FIM_MINUTO      = 91;
    private static final int PASSO_SIMULACAO = 9;

    @Override
    public void simular(Partida partida) {
        System.out.println("\nPressione Enter para iniciar o 2º tempo...");
        new Scanner(System.in).nextLine();

        System.out.println("\n--- 2º TEMPO ---");

        for (int minuto = INICIO_MINUTO; minuto <= FIM_MINUTO; minuto += PASSO_SIMULACAO) {
            simularMinuto(partida, minuto);
            pausar(400);
        }

        partida.notificarObservadores(
                new EventoPartida(TipoEvento.FIM_PARTIDA,
                        partida.getTimeCasa().getNome(), "", 90));

        partida.setEstado(new EstadoEncerrado());
    }

    private void simularMinuto(Partida partida, int minuto) {
        EventoPartida eventoCasa = partida.getTimeCasa().getTatica()
                .executarJogada(partida.getTimeCasa(), partida.getTimeVisitante(), minuto);
        if (eventoCasa != null) partida.notificarObservadores(eventoCasa);

        EventoPartida eventoVisitante = partida.getTimeVisitante().getTatica()
                .executarJogada(partida.getTimeVisitante(), partida.getTimeCasa(), minuto);
        if (eventoVisitante != null) partida.notificarObservadores(eventoVisitante);
    }

    private void pausar(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    @Override
    public String getNomeEstado() {
        return "Segundo Tempo";
    }
}