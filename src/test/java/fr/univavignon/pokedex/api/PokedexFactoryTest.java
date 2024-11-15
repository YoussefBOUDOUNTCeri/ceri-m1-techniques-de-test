package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokedexFactoryTest {

    @Test
    public void testCreatePokedex() {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();

        IPokedexFactory pokedexFactory = new PokedexFactory();

        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        assertEquals(0, pokedex.size());
    }

    @Test(expected = NullPointerException.class)
    public void testCreatePokedexWithNullMetadataProvider() {
        IPokemonFactory pokemonFactory = new PokemonFactory();
        IPokedexFactory pokedexFactory = new PokedexFactory();

        pokedexFactory.createPokedex(null, pokemonFactory);
    }

    @Test(expected = NullPointerException.class)
    public void testCreatePokedexWithNullPokemonFactory() {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokedexFactory pokedexFactory = new PokedexFactory();

        pokedexFactory.createPokedex(metadataProvider, null);
    }
}