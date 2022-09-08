
public class WaterWarrior_24032220 extends Warrior_24032220 implements WarriorTypeInterface_24032220 {

	public WaterWarrior_24032220(int x, int y, int age, String type, double health, double offense, double defense,
			int InventorySize, String moves, int id) {
		super(x, y, age, type, health, offense, defense, InventorySize, moves, id);
		// TODO Auto-generated constructor stub
	}

	public static void performSpecialAbility(Warrior_24032220 w) {
		if (w.abilityCounter() == -1) {
			w.sethealth(20);
			System.out.println("Special abillity performed by water warrior!");
			arr[w.getID() - 1] = w;
		}
	}
}