// public class SkillCommand implements Command { public SkillCommand(String name) {} public void execute(Player p, GameContext c) {} }
// SkillCommand.java
public class SkillCommand implements Command {
    private String skillName;

    public SkillCommand(String skillName) {
        this.skillName = skillName.toLowerCase();
    }

    @Override
    public void execute(Player player, GameContext context) {
        Skill skill = player.getSkill(skillName);
        Room room = context.getCurrentRoom();
        Monster monster = room.getMonster();

        if (skill == null) {
            System.out.println("技能無效！");
            return;
        }

        if (monster == null || !monster.isAlive()) {
            System.out.println("這裡沒有可以施放技能的目標。");
            return;
        }
        if (!monster.isAlive() && monster.getName().contains("魔王")) {
            System.out.println("👑 你擊敗了魔王！世界得救了！");
            System.out.println("🎉 恭喜通關！遊戲結束。");
            System.exit(0);
        }
        skill.use(player, monster);

        // System.out.println("\n=== 狀態更新 ===");
        // System.out.println("你的 HP：" + player.getHp());
        // System.out.println(monster.getName() + " HP：" + monster.getHp());
        // System.out.println("總傷害：" + player.getTotalDamage() + "，擊殺數：" + player.getKillCount());
    }
}
