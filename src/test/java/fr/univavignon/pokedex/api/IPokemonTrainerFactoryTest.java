package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory pokemonTrainerFactory;

    @Mock
    private IPokedexFactory pokedexFactory;

    @Mock
    private IPokedex pokedex;

    private PokemonTrainer ashTrainer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // On mock PokedexFactory pour retourner le Pokedex mocké
        when(pokedexFactory.createPokedex(any(IPokemonMetadataProvider.class), any(IPokemonFactory.class))).thenReturn(pokedex);

        // On crée une instance fictive de PokemonTrainer pour tester la création d'un entraîneur
        ashTrainer = new PokemonTrainer("Ash", Team.VALOR, pokedex);

        // On mock la methode createTrainer pour retourner ashTrainer
        when(pokemonTrainerFactory.createTrainer(eq("Ash"), eq(Team.VALOR), any(IPokedexFactory.class))).thenReturn(ashTrainer);
    }

    @Test
    // On teste la création d'un entraîneur
    public void testCreateTrainer() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertNotNull(trainer.getPokedex());
        assertEquals(pokedex, trainer.getPokedex());
    }

    @Test
    // On teste la création d'un entraîneur avec un nom différent mais la même équipe
    public void testCreateTrainerDifferentTeam() {
        // Préparation d'un autre entraîneur avec une équipe différente
        PokemonTrainer mistyTrainer = new PokemonTrainer("Misty", Team.MYSTIC, pokedex);
        when(pokemonTrainerFactory.createTrainer(eq("Misty"), eq(Team.MYSTIC), any(IPokedexFactory.class))).thenReturn(mistyTrainer);

        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Misty", Team.MYSTIC, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Misty", trainer.getName());
        assertEquals(Team.MYSTIC, trainer.getTeam());
        assertNotNull(trainer.getPokedex());
        assertEquals(pokedex, trainer.getPokedex());
    }

    @Test
    // On teste la création d'un entraîneur avec un nom différent et une équipe différente
    public void testCreateTrainerWithNullName() {
        // Tester le comportement lorsque le nom est null
        when(pokemonTrainerFactory.createTrainer(eq(null), eq(Team.VALOR), any(IPokedexFactory.class)))
                .thenThrow(new IllegalArgumentException("Name cannot be null"));

        try {
            pokemonTrainerFactory.createTrainer(null, Team.VALOR, pokedexFactory);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be null", e.getMessage());
        }
    }

    @Test
    // On teste la création d'un entraîneur avec un nom null et une équipe null
    public void testCreateTrainerWithNullTeam() {
        when(pokemonTrainerFactory.createTrainer(eq("Ash"), eq(null), any(IPokedexFactory.class)))
                .thenThrow(new IllegalArgumentException("Team cannot be null"));

        try {
            pokemonTrainerFactory.createTrainer("Ash", null, pokedexFactory);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Team cannot be null", e.getMessage());
        }
    }

    @Test
    // On teste la création d'un entraîneur lorsque le pokedexFactory est null
    public void testCreateTrainerWithNullPokedexFactory() {
        when(pokemonTrainerFactory.createTrainer(eq("Ash"), eq(Team.VALOR), eq(null)))
                .thenThrow(new IllegalArgumentException("PokedexFactory cannot be null"));

        try {
            pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("PokedexFactory cannot be null", e.getMessage());
        }
    }
}
