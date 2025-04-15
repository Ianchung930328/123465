// public class AttackCommand implements Command { public void execute(Player p, GameContext c) {} }
// AttackCommand.java
public class AttackCommand implements Command {
    @Override
    public void execute(Player player, GameContext context) {
        Monster monster = context.getCurrentRoom().getMonster();

        if (monster != null && monster.isAlive()) {
            int damage = player.getAttack();
            System.out.println("你對 " + monster.getName() + " 造成了 " + damage + " 傷害！");
            monster.takeDamage(damage);
            player.addDamage(damage);

            if (!monster.isAlive()) {
                System.out.println(monster.getName() + " 被擊倒！");
                player.addKill();
            } else {
                int counterDamage = monster.getAttack();
                System.out.println(monster.getName() + " 反擊你，造成 " + counterDamage + " 傷害！");
                player.takeDamage(counterDamage);
            }
            if (!monster.isAlive() && monster.getName().contains("魔王")) {
                System.out.println("👑 你擊敗了魔王！世界得救了！");
                System.out.println("🎉 恭喜通關！遊戲結束。");
                System.exit(0);
            }
            System.out.println("=== 狀態欄列表更新 ===");
            System.out.println("你的 HP：" + player.getHp());
            System.out.println(monster.getName() + " HP：" + monster.getHp());
            System.out.println("總傷害：" + player.getTotalDamage() + "，擊殺數：" + player.getKillCount());
        } else {
            System.out.println("此房間沒有怪物，或怪物已被擊倒！");
        }
    }
}