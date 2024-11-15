package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PokedexTest {

    private Pokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    private Pokemon bulbasaur;
    private Pokemon charmander;

    @Before
    public void setUp() throws PokedexException {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        bulbasaur = new Pokemon(0, "Bulbizarre", 126, 126, 90,
                613, 64, 4000, 4, 56);
        charmander = new Pokemon(4, "Salameche", 128, 108, 78,
                600, 60, 3000, 3, 67);

        pokedex.addPokemon(bulbasaur);
        pokedex.addPokemon(charmander);
    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        Pokemon pikachu = new Pokemon(25, "Pikachu", 112, 101, 70,
                500, 55, 2000, 2, 50);
        int index = pokedex.addPokemon(pikachu);
        assertEquals(2, index);
        assertEquals(3, pokedex.size());
        assertEquals(pikachu, pokedex.getPokemon(index));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = pokedex.getPokemon(0);
        assertEquals(bulbasaur, pokemon);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonWithInvalidIndex() throws PokedexException {
        pokedex.getPokemon(-1);
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals(bulbasaur, pokemons.get(0));
        assertEquals(charmander, pokemons.get(1));
    }

    @Test
    public void testGetPokemonsOrderedByName() {
        List<Pokemon> pokemons = pokedex.getPokemons(PokemonComparators.NAME);
        assertEquals(2, pokemons.size());
        assertEquals(bulbasaur, pokemons.get(0));
        assertEquals(charmander, pokemons.get(1));
    }

    @Test
    public void testGetPokemonsOrderedByIndex() {
        List<Pokemon> pokemons = pokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(2, pokemons.size());
        assertEquals(bulbasaur, pokemons.get(0));
        assertEquals(charmander, pokemons.get(1));
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = pokedex.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("GeneratedPokemon", pokemon.getName());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        pokedex.getPokemonMetadata(999);
    }
}