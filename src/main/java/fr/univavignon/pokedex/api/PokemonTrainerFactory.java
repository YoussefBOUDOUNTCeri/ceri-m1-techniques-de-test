package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        if (team == null) {
            throw new IllegalArgumentException("Team cannot be null");
        }

        if (pokedexFactory == null) {
            throw new IllegalArgumentException("PokedexFactory cannot be null");
        }

        final IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());

        return new PokemonTrainer(name, team, pokedex);
    }
}
