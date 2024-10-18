package fr.univavignon.pokedex.api;

/**
 * Pokemon metadata POJO.
 * 
 * @author fv
 */
public class PokemonMetadata {

	/** Pokemon index. **/
	private final int index;

	/** Pokemon name. **/
	private final String name;

	/** Pokemon attack level. **/
	private final int attack;

	/** Pokemon defense level. **/
	private final int defense;

	/** Pokemon stamina level. **/
	private final int stamina;

	/**
	 * Default constructor.
	 * 
	 * @param index Pokemon index.
	 * @param name Pokemon name.
	 * @param attack Attack level.
	 * @param defense Defense level.
	 * @param stamina Stamina level.
	 */
	public PokemonMetadata(final int index, final String name, final int attack, 
	final int defense, final int stamina) {
		this.index = index;
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.stamina = stamina;
	}

	
	/**
	 * Returns the index of the Pokemon.
	 * @return the index.
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Returns the name of the Pokemon.
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the attack value of the Pokemon.
	 * @return the attack value.
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Returns the defense value of the Pokemon.
	 * @return the defense value.
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Returns the stamina value of the Pokemon.
	 * @return the stamina value.	
	 */
	public int getStamina() {
		return stamina;
	}

}
