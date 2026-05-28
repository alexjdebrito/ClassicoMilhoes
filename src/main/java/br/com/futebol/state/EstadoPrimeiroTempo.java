package br.com.futebol.state;

import br.com.futebol.model.EventoPartida;
import br.com.futebol.model.Partida;
import br.com.futebol.model.TipoEvento;

import java.util.Scanner;

public class EstadoPrimeiroTempo implements EstadoPartida {

    private static final int DURACAO_MINUTOS = 45;
    private static final int PASSO_SIMULACAO = 9;

    @Override
    public void simular(Partida partida) {
        System.out.println("\nPressione Enter para iniciar o 1º tempo...");
        new Scanner(System.in).nextLine();

        System.out.println("\n--- 1º TEMPO ---");

        for (int minuto = PASSO_SIMULACAO; minuto <= DURACAO_MINUTOS; minuto += PASSO_SIMULACAO) {
            simularMinuto(partida, minuto);
            pausar(400);
        }

        partida.notificarObservadores(
                new EventoPartida(TipoEvento.INTERVALO,
                        partida.getTimeCasa().getNome(), "", 45));

        partida.setEstado(new EstadoIntervalo());
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
        return "Primeiro Tempo";
    }
}