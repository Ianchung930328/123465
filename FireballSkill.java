public class FireballSkill implements Skill {
    public String getName() {
        return "fireball";
    }

    public void use(Player p, Monster m) {
        int damage = 40;
        System.out.println("🔥 你施放了【火球術】！");
        System.out.println("對 " + m.getName() + " 造成 " + damage + " 傷害！");
        m.takeDamage(damage);
        p.addDamage(damage);

        if (!m.isAlive()) {
            System.out.println(m.getName() + " 被燒到襙灰搭！");
            p.addKill();
        } 
        else {
            int counter = m.getAttack();
            System.out.println(m.getName() + " 還活著！");
            System.out.println(m.getName() + " 反擊你，造成 " + counter + " 傷害！");
            p.takeDamage(counter);
        }
        System.out.println("=== 狀態更新 ===");
        System.out.println("你的 HP：" + p.getHp());
        System.out.println(m.getName() + " HP：" + m.getHp());
        System.out.println("總傷害：" + p.getTotalDamage() + "，擊殺數：" + p.getKillCount());
    }
}
