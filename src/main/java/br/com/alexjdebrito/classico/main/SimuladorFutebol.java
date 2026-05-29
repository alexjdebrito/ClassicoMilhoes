package br.com.alexjdebrito.classico.main;

import br.com.alexjdebrito.classico.model.Partida;
import br.com.alexjdebrito.classico.model.Time;
import br.com.alexjdebrito.classico.observer.EstatisticasObserver;
import br.com.alexjdebrito.classico.observer.NarradorObserver;
import br.com.alexjdebrito.classico.observer.PlacarObserver;
import br.com.alexjdebrito.classico.state.EstadoPreJogo;
import br.com.alexjdebrito.classico.strategy.TaticaContraAtaque;
import br.com.alexjdebrito.classico.strategy.TaticaOfensiva;

import java.util.List;

public class SimuladorFutebol {

    public static void main(String[] args) {

        Time flamengo = new Time(
                "Flamengo",
                "Rossi",
                List.of("Varela", "Léo Ortiz", "Léo Pereira", "Alex Sandro",
                        "Evertton Araújo", "Jorginho", "Arrascaeta", "Plata",
                        "Pedro", "Bruno Henrique"),
                new TaticaOfensiva()
        );

        Time vasco = new Time(
                "Vasco",
                "Léo Jardim",
                List.of("Paulo Henrique", "Carlos Cuesta", "Robert Renan", "Cuiabano",
                        "Hugo Moura", "Thiago Mendes", "Rojas", "Andrés Gómez",
                        "Spinelli", "Adson"),
                new TaticaContraAtaque()
        );

        Partida partida = new Partida(flamengo, vasco, new EstadoPreJogo());

        PlacarObserver placar = new PlacarObserver(
                flamengo.getNome(), vasco.getNome());

        partida.registrarObservador(new NarradorObserver());
        partida.registrarObservador(placar);
        partida.registrarObservador(new EstatisticasObserver());

        partida.simularPartidaCompleta();
        System.out.println("\n─── RESULTADO FINAL ─────────────");
        System.out.println("─── " + placar.getPlacarAtual());

    }
}
