package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    private IPokemonMetadataProvider metadataProvider;

    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
            final double iv = 100.0;

            return new Pokemon(
                index,
                metadata.getName(),
                metadata.getAttack(),
                metadata.getDefense(),
                metadata.getStamina(),
                cp,
                hp,
                dust,
                candy,
                iv
            );
        } catch (PokedexException e) {
            e.printStackTrace();
            return null;
        }
    }
}
