package cs203;

import java.util.List;
import java.util.Random;

public class Character {
    private CharacterClass cc;
    private Race race;
    private Treasure treasure;
    private Equipment equipment;
    private List<Integer> abilityScores;

    public String name;

    /**
     * Takes in the class of the character and their race. These are immutable once the character is created
     * @param characterClass Class of the character. Not null.
     * @param race Race of the character. Not null.
     * @param name Name of the character. Not null, not empty
     */
    public Character(CharacterClass characterClass, Race race, String name) {
        this.cc = characterClass;
        this.race = race;
        this.name = name;
    }

    /**
     * Returns the amount of damage done to an enemy with a weapon attack
     * @return integer greater than or equal to 0
     */
    public int attqackEnemyWithWeapon() {
        int d = equipment.getWeaponDamage();
        int result = diceRoll(d);
        int mod = cc.getWDM();
        return result + mod;
    }

    /**
     * Takes in an integer number of sides and returns a random integer between 1 and the passed in number
     * @param numSides Positive integer
     * @return Integer from 1 through numSides
     */
    private int diceRoll(int numSides) {
        Random random = new Random();
        return random.nextInt(numSides) + 1;
    }

    /**
     * Returns the amount of damage done to an enemy with a weapon attack
     * @return integer greater than or equal to 0
     */
    public int castSpell() {
        int damageDie = cc.getSpellDamageDie();
        int modifier = cc.getSpellDamageModifier();
        int rollResult = diceRoll(damageDie);
        return rollResult + modifier;
    }

    public CharacterClass getCharacterClass() {
        return cc;
    }

    public Race getRace() {
        return race;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public List<Integer> getAbilityScores() {
        return abilityScores;
    }

    public String getName() {
        return name;
    }
}
