package br.com.alexjdebrito.classico.observer;

import br.com.alexjdebrito.classico.model.EventoPartida;
import br.com.alexjdebrito.classico.model.TipoEvento;

import java.util.ArrayList;
import java.util.List;

public class PlacarObserver implements EventoPartidaObserver {

    private int golsTimeCasa = 0;
    private int golsTimeVisitante = 0;
    private final String nomeTimeCasa;
    private final String nomeTimeVisitante;

    private final List<String> artilheiros = new ArrayList<>();

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
            artilheiros.add(String.format("%s %d'", evento.getJogador(), evento.getMinuto()));
            exibirPlacar(evento.getMinuto());
        }
    }

    private void exibirPlacar(int minuto) {
        System.out.printf("├─── PLACAR [%d'] ───┤ %s %d x %d %s %n",
                minuto, nomeTimeCasa, golsTimeCasa, golsTimeVisitante, nomeTimeVisitante);
    }

    public String getPlacarAtual() {
        String placar = String.format("%s %d x %d %s", nomeTimeCasa, golsTimeCasa, golsTimeVisitante, nomeTimeVisitante);
        if (artilheiros.isEmpty()) {
            return placar;
        }
        return placar + "\n   ⚽ " + String.join(", ", artilheiros);
    }
}