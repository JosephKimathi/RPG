
public abstract class FlameWarrior_24032220 extends Warrior_24032220 implements WarriorTypeInterface_24032220 {
	private static double initialDef;

	public FlameWarrior_24032220(int x, int y, int age, String type, double health, double offense, double defense,
			int InventorySize, String moves, int id) {
		super(x, y, age, type, health, offense, defense, InventorySize, moves, id);
//		initialDef = getDefense();
	}

	public static void performSpecialAbility(Warrior_24032220 w) {
		if (w.abilityCounter() == -1) {
			initialDef = w.getDefense();
			System.out.println("Special abillity performed by flame warrior!");
			w.setdefense(100);
		}
		arr[w.getID() - 1] = w;
	}

	public static void specialAbilityCompleted(Warrior_24032220 w) {
		if (initialDef > 70)
			w.setdefense(70);
		else if (initialDef <= 70)
			w.setdefense(initialDef);
		w.capDefense();
	}
}