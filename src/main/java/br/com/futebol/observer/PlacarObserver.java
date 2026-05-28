package br.com.futebol.observer;

import br.com.futebol.model.EventoPartida;
import br.com.futebol.model.TipoEvento;

public class PlacarObserver implements EventoPartidaObserver {

    private int golsTimeCasa = 0;
    private int golsTimeVisitante = 0;
    private String nomeTimeCasa;
    private String nomeTimeVisitante;

    public PlacarObserver(String nomeTimeCasa, String nomeTimeVisitante) {
        this.nomeTimeCasa = nomeTimeCasa;
        this.nomeTimeVisitante = nomeTimeVisitante;
    }

    @Override
    public void onEvento(EventoPartida evento) {
        if (evento.getTipo() == TipoEvento.GOL) {
            if (evento.getTimeResponsavel().equals(nomeTimeCasa)) {
                golsTimeCasa++;
            } else {
                golsTimeVisitante++;
            }
            exibirPlacar(evento.getMinuto());
        }
    }

    private void exibirPlacar(int minuto) {
        System.out.printf("│  PLACAR [%d']  %-10s %d x %d %-10s │%n",
                minuto, nomeTimeCasa, golsTimeCasa, golsTimeVisitante, nomeTimeVisitante);
    }

    public String getPlacarAtual() {
        return String.format("%s %d x %d %s", nomeTimeCasa, golsTimeCasa, golsTimeVisitante, nomeTimeVisitante);
    }
}
