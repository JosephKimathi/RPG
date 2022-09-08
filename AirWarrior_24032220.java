
public abstract class AirWarrior_24032220 extends Warrior_24032220 implements WarriorTypeInterface_24032220 {
	public AirWarrior_24032220(int x, int y, int age, String type, double health, double offense, double defense,
			int InventorySize, String moves, int id) {
		super(x, y, age, type, health, offense, defense, InventorySize, moves, id);
		// TODO Auto-generated constructor stub
	}

	private static double initialOff;

	public static void performSpecialAbility(Warrior_24032220 w) {
		if (w.abilityCounter() == -1) {
			initialOff = w.getOffense();
			w.setoff(initialOff + 30);
			System.out.println("Special abillity performed by air warrior!");
		}
		arr[w.getID()-1]=w;
	}

	public static void specialAbilityCompleted(Warrior_24032220 w) {
		if (initialOff <= 70)
			w.setoff(initialOff);
		else
			w.setoff(70);
	}

}