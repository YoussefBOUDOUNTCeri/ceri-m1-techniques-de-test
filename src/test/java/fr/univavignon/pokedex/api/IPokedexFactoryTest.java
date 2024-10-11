package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class IPokedexFactoryTest {

    @Mock
    private IPokedexFactory pokedexFactory;

    @Mock
    private IPokemonMetadataProvider metadataProvider;

    @Mock
    private IPokemonFactory pokemonFactory;

    private IPokedex pokedex;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock la création du pokedex
        pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex result = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(result);
        assertEquals(pokedex, result);
    }
}
