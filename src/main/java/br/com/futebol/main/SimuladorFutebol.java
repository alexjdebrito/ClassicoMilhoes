package br.com.futebol.main;

import br.com.futebol.model.Partida;
import br.com.futebol.model.Time;
import br.com.futebol.observer.EstatisticasObserver;
import br.com.futebol.observer.NarradorObserver;
import br.com.futebol.observer.PlacarObserver;
import br.com.futebol.state.EstadoPreJogo;
import br.com.futebol.strategy.TaticaContraAtaque;
import br.com.futebol.strategy.TaticaDefensiva;
import br.com.futebol.strategy.TaticaOfensiva;

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

        System.out.println("\n🏆 Resultado final: " + placar.getPlacarAtual());
    }
}
