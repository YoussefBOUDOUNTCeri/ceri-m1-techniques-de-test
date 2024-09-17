package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class IPokemonFactoryTest {

    @Mock
    private IPokemonFactory pokemonFactory;

    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Données fictives pour Bulbizarre (index 0) et Aquali (index 133)
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        // Mocking des appels à pokemonFactory pour renvoyer ces Pokémon
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);
    }

    @Test
    public void testCreatePokemonBulbizarre() {
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(bulbizarre.getIndex(), result.getIndex());
        assertEquals(bulbizarre.getName(), result.getName());
        assertEquals(bulbizarre.getAttack(), result.getAttack());
        assertEquals(bulbizarre.getDefense(), result.getDefense());
        assertEquals(bulbizarre.getStamina(), result.getStamina());
        assertEquals(bulbizarre.getCp(), result.getCp());
        assertEquals(bulbizarre.getHp(), result.getHp());
        assertEquals(bulbizarre.getDust(), result.getDust());
        assertEquals(bulbizarre.getCandy(), result.getCandy());
        assertEquals(bulbizarre.getIv(), result.getIv(), 0.0);
    }

    @Test
    public void testCreatePokemonAquali() {
        Pokemon result = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertNotNull(result);
        assertEquals(aquali.getIndex(), result.getIndex());
        assertEquals(aquali.getName(), result.getName());
        assertEquals(aquali.getAttack(), result.getAttack());
        assertEquals(aquali.getDefense(), result.getDefense());
        assertEquals(aquali.getStamina(), result.getStamina());
        assertEquals(aquali.getCp(), result.getCp());
        assertEquals(aquali.getHp(), result.getHp());
        assertEquals(aquali.getDust(), result.getDust());
        assertEquals(aquali.getCandy(), result.getCandy());
        assertEquals(aquali.getIv(), result.getIv(), 0.0);
    }
}
