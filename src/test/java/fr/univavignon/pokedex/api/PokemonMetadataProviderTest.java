package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();

        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());

        metadata = metadataProvider.getPokemonMetadata(133);
        assertNotNull(metadata);
        assertEquals(133, metadata.getIndex());
        assertEquals("Aquali", metadata.getName());
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
        assertEquals(260, metadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        metadataProvider.getPokemonMetadata(-1);
    }
}
