package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    private IPokemonMetadataProvider metadataProvider;

    /**
     * Constructor that accepts an IPokemonMetadataProvider.
     *
     * @param metadataProvider The metadata provider to use.
     */
    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

            double iv = ((metadata.getAttack() + metadata.getDefense() + metadata.getStamina()) / 45.0) * 100.0;

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
            throw new RuntimeException("Error creating Pokemon", e);
        }
    }
}
