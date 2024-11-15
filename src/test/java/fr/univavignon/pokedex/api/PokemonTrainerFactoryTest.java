public class PokemonTrainerFactoryTest {
    
}
package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokemonTrainerFactoryTest {

    @Test
    public void testCreateTrainer() {
        IPokedexFactory pokedexFactory = new PokedexFactory();
        IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertNotNull(trainer.getPokedex());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerWithNullName() {
        IPokedexFactory pokedexFactory = new PokedexFactory();
        IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

        trainerFactory.createTrainer(null, Team.VALOR, pokedexFactory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerWithNullTeam() {
        IPokedexFactory pokedexFactory = new PokedexFactory();
        IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

        trainerFactory.createTrainer("Ash", null, pokedexFactory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerWithNullPokedexFactory() {
        IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

        trainerFactory.createTrainer("Ash", Team.VALOR, null);
    }
}
