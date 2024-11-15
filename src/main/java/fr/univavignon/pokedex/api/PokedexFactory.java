package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        if (metadataProvider == null) {
            throw new NullPointerException("metadataProvider cannot be null");
        }
        if (pokemonFactory == null) {
            throw new NullPointerException("pokemonFactory cannot be null");
        }

        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
