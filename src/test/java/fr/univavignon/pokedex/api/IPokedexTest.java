package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class IPokedexTest {

    @Mock
    private IPokedex pokedex;

    @Mock
    private IPokemonMetadataProvider metadataProvider;

    @Mock
    private IPokemonFactory pokemonFactory;

    private Pokemon bulbasaur;
    private Pokemon charmander;

    @Before
    public void setUp() throws PokedexException {
        MockitoAnnotations.initMocks(this);

        // Création des mocks de Pokémon
        bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        charmander = new Pokemon(4, "Charmander", 128, 108, 78, 600, 60, 3000, 3, 67);

        // Mock des appels au pokedex
        when(pokedex.size()).thenReturn(2);
        when(pokedex.getPokemon(0)).thenReturn(bulbasaur);
        when(pokedex.getPokemon(4)).thenReturn(charmander);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(bulbasaur);
        pokemons.add(charmander);

        when(pokedex.getPokemons()).thenReturn(pokemons);
        when(pokedex.getPokemons(PokemonComparators.NAME)).thenReturn(pokemons);
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0);
        when(pokedex.addPokemon(charmander)).thenReturn(1);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = pokedex.getPokemon(0);
        assertNotNull(pokemon);
        assertEquals("Bulbasaur", pokemon.getName());

        pokemon = pokedex.getPokemon(4);
        assertNotNull(pokemon);
        assertEquals("Charmander", pokemon.getName());
    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        int index = pokedex.addPokemon(bulbasaur);
        assertEquals(0, index);

        index = pokedex.addPokemon(charmander);
        assertEquals(1, index);
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("Charmander", pokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonsSortedByName() {
        List<Pokemon> pokemons = pokedex.getPokemons(PokemonComparators.NAME);
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("Charmander", pokemons.get(1).getName());
    }
}
