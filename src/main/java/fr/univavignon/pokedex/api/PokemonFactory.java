package fr.univavignon.pokedex.api;


public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Mock data for Pokemon metadata (replace it with real metadata provider)
        final int baseAttack = 100;
        final int baseDefense = 100;
        final int baseStamina = 100;

        // Calculate IV perfection (this is just an example, you can change the calculation)
        final double iv = (baseAttack + baseDefense + baseStamina) / 45.0 * 100.0;

        // Create and return a new Pokemon instance
        return new Pokemon(index, "GeneratedPokemon", baseAttack, baseDefense, baseStamina, cp, hp, dust, candy, iv);
    }
}
