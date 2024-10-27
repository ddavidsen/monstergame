public class MultiAttackMonster implements Monster {
    private String name;
    private int health;
    private Weapon weapon;
    private int numberOfAttacks;

    public MultiAttackMonster(String name,
                              int health,
                              Weapon weapon,
                              int numberOfAttacks) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.numberOfAttacks = numberOfAttacks;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public String attack(Monster target) {
        String output = "";

        for (int i = 0; i < this.numberOfAttacks; i++) {
            int damage = (int)(Math.random() * weapon.getMaxDamage() + 1);

            target.takeDamage(damage);

            output +=
                    String.format("%s attacks %s with %s doing %d damage\n",
                            this.name, target.getName(),
                            this.weapon.getName(), damage);
        }

        return output;
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
    }
}

