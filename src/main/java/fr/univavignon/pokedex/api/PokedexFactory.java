package fr.univavignon.pokedex.api;


public class PokedexFactory implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        // Return a new Pokedex instance with the provided metadataProvider and pokemonFactory
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
