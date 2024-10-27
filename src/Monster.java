public interface Monster {
    public String getName();
    public int getHealth();
    public String attack(Monster other);
    public void takeDamage(int damage);
}

class BasicMonster implements Monster {
    private String name;
    private int health;
    private Weapon weapon;

    public BasicMonster(String name,
                        int health,
                        Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
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
        int damage = (int)(Math.random() * weapon.getMaxDamage() + 1);

        target.takeDamage(damage);

        return String.format("%s attacks %s with %s doing %d damage\n",
                this.name, target.getName(),
                this.weapon.getName(), damage);
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
    }
}
