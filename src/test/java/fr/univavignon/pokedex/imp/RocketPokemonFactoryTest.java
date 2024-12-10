package fr.univavignon.pokedex.imp;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import fr.univavignon.pokedex.api.Pokemon;

public class RocketPokemonFactoryTest {

    private RocketPokemonFactory rocketPokemonFactory;

    @Before
    public void setUp() {
        rocketPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemonWithValidIndex() {
        Pokemon pokemon = rocketPokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        assertNotNull(pokemon);
        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() {
        Pokemon pokemon = rocketPokemonFactory.createPokemon(-1, 613, 64, 4000, 4);
        assertNotNull(pokemon);
        assertEquals(-1, pokemon.getIndex());
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
    }

    @Test
    public void testCreatePokemonWithRandomStats() {
        Pokemon pokemon = rocketPokemonFactory.createPokemon(0, 500, 55, 2000, 2);
        assertNotNull(pokemon);
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 15);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 15);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 15);
    }
    
}
