package br.com.futebol.observer;

import br.com.futebol.model.EventoPartida;
import br.com.futebol.model.TipoEvento;

import java.util.HashMap;
import java.util.Map;

public class EstatisticasObserver implements EventoPartidaObserver {

    private final Map<String, Integer> gols = new HashMap<>();
    private final Map<String, Integer> faltas = new HashMap<>();
    private final Map<String, Integer> cartõesAmarelos = new HashMap<>();
    private final Map<String, Integer> cartõesVermelhos = new HashMap<>();

    @Override
    public void onEvento(EventoPartida evento) {
        String time = evento.getTimeResponsavel();

        switch (evento.getTipo()) {
            case GOL -> gols.merge(time, 1, Integer::sum);
            case FALTA -> faltas.merge(time, 1, Integer::sum);
            case CARTAO_AMARELO -> cartõesAmarelos.merge(time, 1, Integer::sum);
            case CARTAO_VERMELHO -> cartõesVermelhos.merge(time, 1, Integer::sum);
            case FIM_PARTIDA -> exibirResumo();
            default -> {}
        }
    }

    private void exibirResumo() {
        System.out.println("\nESTATÍSTICAS DA PARTIDA \n");
        System.out.printf("%-22s %-6s%n", "Times", "Resultados", "\n");

        for (String time : gols.keySet()) {
            System.out.printf("%-22s %d gols, %d faltas, %d c. amar., %d c. verm. %n",
                    time,
                    gols.getOrDefault(time, 0),
                    faltas.getOrDefault(time, 0),
                    cartõesAmarelos.getOrDefault(time, 0),
                    cartõesVermelhos.getOrDefault(time, 0));
        }
        System.out.println("|||\n");
    }
}
