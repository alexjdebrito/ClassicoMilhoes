package br.com.alexjdebrito.classico.observer;

import br.com.alexjdebrito.classico.model.EventoPartida;

public class NarradorObserver implements EventoPartidaObserver {

    @Override
    public void onEvento(EventoPartida evento) {
        String narrativa = gerarNarrativa(evento);
        if (narrativa != null) {
            System.out.println("[NARRADOR] " + narrativa);
        }
    }

    private String gerarNarrativa(EventoPartida evento) {
        int minuto = evento.getMinuto();
        String time = evento.getTimeResponsavel();
        String jogador = evento.getJogador();

        return switch (evento.getTipo()) {
            case INICIO_PARTIDA   -> "As equipes estão prontas para a partida!";
            case INICIO_SEGUNDO_TEMPO -> "Começa o segundo tempo!";
            case INTERVALO        -> "⌚ Fim do primeiro tempo! As equipes vão para o intervalo.";
            case GOL              -> String.format("⚽ GOOOOOL! [%d'] %s marca para o %s!", minuto, jogador, time);
            case GRANDE_CHANCE    -> String.format("💥 [%d'] Pelas barbas do Profeta! %s acerta a trave!", minuto, jogador);
            case FALTA -> null;
            case CARTAO_AMARELO   -> String.format("⚠️ [%d'] %s do %s recebe cartão amarelo!", minuto, jogador, time);
            case CARTAO_VERMELHO  -> String.format("❌ [%d'] %s do %s é EXPULSO!", minuto, jogador, time);
            case FIM_PARTIDA      -> "⌚ FIM DE JOGO! A partida está encerrada!";
            case DEFESA_GOLEIRO   -> String.format("🧱 [%d'] %s! O goleiro do %s faz grande defesa!", minuto, jogador, time);
        };
    }
}