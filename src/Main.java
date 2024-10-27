import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Weapon atomicFireBreath = new Weapon("Atomic Fire Breath", 40);
        Weapon thunderbolt = new Weapon("Thunderbolt", 25);

        Monster godzilla = new BasicMonster("Godzilla", 150, atomicFireBreath);
        Monster pikachu = new MultiAttackMonster("Pikachu", 50, thunderbolt, 3);
        Monster gazorp = new CrazyMonster(125);

        ArrayList<Monster> monsters = new ArrayList<Monster>();
        monsters.add(godzilla);
        monsters.add(pikachu);
        monsters.add(gazorp);

        while (monsters.size() > 1) {
            ArrayList<Monster> deadMonsters = new ArrayList<Monster>();

            Collections.shuffle(monsters);

            for (Monster monster : monsters) {
                Monster enemy = pickAnEnemy(monster, monsters);

                String description = monster.attack(enemy);
                System.out.println(description);

                // add dead monsters to the deadMonster list
                if (enemy.getHealth() <= 0)
                    deadMonsters.add(enemy);
            }

            // remove dead monsters from monsters list
            for (Monster m : deadMonsters)
                monsters.remove(m);
        }

        // announce winner
        announceWinner(monsters);
    }

    static Monster pickAnEnemy(Monster m, ArrayList<Monster> monsters) {
        Monster enemy = m;

        while (enemy == m)
            enemy = monsters.get((int)(Math.random() * monsters.size()));

        return enemy;
    }

    static void announceWinner(ArrayList<Monster> monsters) {
        if (monsters.size() == 0)
            System.out.println("All monsters are dead. There is no winner.");
        else
            System.out.printf("The winner is %s.", monsters.get(0).getName());
    }
}
