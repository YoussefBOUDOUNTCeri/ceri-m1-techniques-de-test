package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        IPokemonFactory pokemonFactory = new PokemonFactory();
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("GeneratedPokemon", pokemon.getName());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals(100.0, pokemon.getIv(), 0.0);
    }
}
