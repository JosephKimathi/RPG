
public class StoneWarrior_24032220 extends Warrior_24032220 implements WarriorTypeInterface_24032220 {
	// private final int initial;
	private static double initialDef;

	public StoneWarrior_24032220(int x, int y, int age, String type, double health, double offense, double defense,
			int InventorySize, String moves, int id) {
		super(x, y, age, type, health, offense, defense, InventorySize, moves, id);

		// TODO Auto-generated constructor stub
	}

	/*
	 * Stone Warrior - The stone warrior generates an earthquake which creates an
	 * effective defence against its enemies. The warrior's defence strength becomes
	 * set to the maximum of its current defence strength or 95% for 4 iterations.
	 * After which the warrior's defence strength is set to the value it held before
	 * the ability was activated (subject to the rules of 3.7); any increase in
	 * defence strength gained by warrior alliances (Section 3.6 paragraph 2) during
	 * the time in which the special ability was activated are lost. Unfortunately,
	 * due to the energy needed to create an earthquake, the warrior's health
	 * decreases by 3%. Your program should immediately print
	 * "Special ability performed by stone warrior!".
	 */
	public static void performSpecialAbility(Warrior_24032220 w) {
		if (w.abilityCounter() == -1) {
			initialDef = w.getDefense();
			System.out.println("Special abillity performed by stone warrior!");
			if (w.getDefense() < 95)
				w.setdefense(95);
			w.sethealth(-3);
		}
		arr[w.getID() - 1] = w;
	}

	public static void specialAbilityCompleted(Warrior_24032220 w) {
		w.setdefense(initialDef);
		w.capDefense();
	}
}