public class CrazyMonster implements Monster {
    private int health;
    private int damageCount = 0;
    private int attackStrength = 1;

    public CrazyMonster(int health) {
        this.health = health;
    }

    @Override
    public String getName() {
        String name = "";
        char[] parts = "!@#$%^&*?".toCharArray();
        for (int i = 0; i < 5; i++)
            name += parts[(int)(Math.random() * parts.length)];

        return name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public String attack(Monster target) {
        String output = "";

        int damage = (int)(Math.random() * attackStrength + 1);

        target.takeDamage(damage);

        return String.format("%s attacks %s doing %d damage\n",
                this.getName(), target.getName(),
                damage);
    }

    @Override
    public void takeDamage(int damage) {
        damageCount++;

        if (damageCount % 2 == 0)
            this.attackStrength += damage;

        this.health -= damage;
    }
}
