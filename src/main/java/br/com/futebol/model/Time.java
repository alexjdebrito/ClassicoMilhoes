package br.com.futebol.model;

import br.com.futebol.strategy.TaticaStrategy;

import java.util.List;
import java.util.Random;

public class Time {

    private final String nome;
    private final String goleiro;
    private final List<String> jogadores;
    private TaticaStrategy tatica;

    private final Random random = new Random();

    public Time(String nome, String goleiro, List<String> jogadores, TaticaStrategy tatica) {
        this.nome = nome;
        this.goleiro = goleiro;
        this.jogadores = jogadores;
        this.tatica = tatica;
    }

    public String escolherJogadorAleatorio() {
        return jogadores.get(random.nextInt(jogadores.size()));
    }

    public String getNome() { return nome; }
    public String getGoleiro() { return goleiro; }
    public TaticaStrategy getTatica() { return tatica; }
    public void setTatica(TaticaStrategy tatica) { this.tatica = tatica; }
}
