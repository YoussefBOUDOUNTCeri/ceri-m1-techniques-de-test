package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() throws PokedexException {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        Pokemon bulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        Pokemon aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);
    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        Pokemon pikachu = pokemonFactory.createPokemon(25, 500, 60, 3000, 3);
        int index = pokedex.addPokemon(pikachu);
        assertEquals(2, index);
        assertEquals(3, pokedex.size());
        assertEquals(pikachu, pokedex.getPokemon(2));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = pokedex.getPokemon(0);
        assertNotNull(pokemon);
        assertEquals("Bulbizarre", pokemon.getName());

        pokemon = pokedex.getPokemon(1);
        assertNotNull(pokemon);
        assertEquals("Aquali", pokemon.getName());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonInvalidIndex() throws PokedexException {
        pokedex.getPokemon(10);
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonsSortedByName() {
        List<Pokemon> pokemons = pokedex.getPokemons(PokemonComparators.NAME);
        assertEquals("Aquali", pokemons.get(0).getName());
        assertEquals("Bulbizarre", pokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals("Bulbizarre", metadata.getName());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        pokedex.getPokemonMetadata(999);
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pikachu = pokedex.createPokemon(25, 500, 60, 3000, 3);
        assertNotNull(pikachu);
        assertEquals(25, pikachu.getIndex());
        assertEquals("Pikachu", pikachu.getName());
    }
}