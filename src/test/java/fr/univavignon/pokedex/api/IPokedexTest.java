package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp() throws PokedexException {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);

        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        bulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(bulbizarre);
        assertEquals(1, pokedex.size());
        pokedex.addPokemon(aquali);
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        int index1 = pokedex.addPokemon(bulbizarre);
        int index2 = pokedex.addPokemon(aquali);

        assertEquals(0, index1);
        assertEquals(1, index2);

        Pokemon retrieved1 = pokedex.getPokemon(index1);
        Pokemon retrieved2 = pokedex.getPokemon(index2);

        assertEquals(bulbizarre.getIndex(), retrieved1.getIndex());
        assertEquals(aquali.getIndex(), retrieved2.getIndex());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        Pokemon pokemon0 = pokedex.getPokemon(0);
        assertEquals(bulbizarre.getName(), pokemon0.getName());

        Pokemon pokemon1 = pokedex.getPokemon(1);
        assertEquals(aquali.getName(), pokemon1.getName());

        try {
            pokedex.getPokemon(2);
            fail("Expected PokedexException");
        } catch (PokedexException e) {
            // Expected exception
        }
    }

    @Test
    public void testGetPokemons() {
        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbizarre);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals(aquali, pokemons.get(0));
        assertEquals(bulbizarre, pokemons.get(1));
    }

    @Test
    public void testGetPokemonsWithOrder() {
        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbizarre);

        List<Pokemon> pokemonsByName = pokedex.getPokemons(PokemonComparators.NAME);
        assertEquals(2, pokemonsByName.size());
        assertEquals(bulbizarre, pokemonsByName.get(0));
        assertEquals(aquali, pokemonsByName.get(1));

        List<Pokemon> pokemonsByIndex = pokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(2, pokemonsByIndex.size());
        assertEquals(bulbizarre, pokemonsByIndex.get(0));
        assertEquals(aquali, pokemonsByIndex.get(1));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = pokedex.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("Bulbizarre", pokemon.getName());
    }
}