// public class LookCommand implements Command { public void execute(Player p, GameContext c) {} }
// LookCommand.java
public class LookCommand implements Command {
    @Override
    public void execute(Player player, GameContext context) {
        Room room = context.getCurrentRoom();
        Monster monster = room.getMonster();

        System.out.println("【房間】：" + room.getName());
        System.out.println("【描述】：" + room.getDescription());
        System.out.println("【怪物】：" + (monster != null ? monster.getName() + "（HP: " + monster.getHp() + ")" : "無"));
        System.out.println("【可用方向】：" + room.getExitString());

        if (room.hasPotion()) {
            System.out.println("【道具】：" + "治療藥水");
        }
    }
}