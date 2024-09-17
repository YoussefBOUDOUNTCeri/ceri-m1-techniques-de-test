package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    private PokemonMetadata bulbizarreMetadata;
    private PokemonMetadata aqualiMetadata;

    @Before
    public void setUp() throws PokedexException {
        MockitoAnnotations.initMocks(this);

        // Données fictives pour Bulbizarre (index 0) et Aquali (index 133)
        bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);

        // Mocking des appels à pokemonMetadataProvider pour renvoyer ces métadonnées
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetadata);
    }

    @Test
    public void testGetPokemonMetadataBulbizarre() throws PokedexException {
        PokemonMetadata result = pokemonMetadataProvider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(bulbizarreMetadata.getIndex(), result.getIndex());
        assertEquals(bulbizarreMetadata.getName(), result.getName());
        assertEquals(bulbizarreMetadata.getAttack(), result.getAttack());
        assertEquals(bulbizarreMetadata.getDefense(), result.getDefense());
        assertEquals(bulbizarreMetadata.getStamina(), result.getStamina());
    }

    @Test
    public void testGetPokemonMetadataAquali() throws PokedexException {
        PokemonMetadata result = pokemonMetadataProvider.getPokemonMetadata(133);
        assertNotNull(result);
        assertEquals(aqualiMetadata.getIndex(), result.getIndex());
        assertEquals(aqualiMetadata.getName(), result.getName());
        assertEquals(aqualiMetadata.getAttack(), result.getAttack());
        assertEquals(aqualiMetadata.getDefense(), result.getDefense());
        assertEquals(aqualiMetadata.getStamina(), result.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        // Configurer le mock pour qu'il lance une PokedexException pour l'index 999
        doThrow(new PokedexException("Invalid index")).when(pokemonMetadataProvider).getPokemonMetadata(999);

        // Tester avec un index invalide, cela devrait lancer une exception
        pokemonMetadataProvider.getPokemonMetadata(999);
    }

}
