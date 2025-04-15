public class Tariff implements Skill {
    @Override
    public String getName() {
        return "tariff";
    }

    @Override
    public void use(Player p, Monster m) {
        int damage = 999;
        System.out.println("你施放了【蜜月期偷偷】！");
        System.out.println("對 " + m.getName() + " 造成 " + damage + " 傷害！");
        m.takeDamage(damage);
        p.addDamage(damage);

        if (!m.isAlive()) {
            System.out.println(m.getName() + " 沒錢生存而亡！");
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