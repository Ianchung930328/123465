// public class UsePotionCommand implements Command { public void execute(Player p, GameContext c) {} }
// UsePotionCommand.java
public class UsePotionCommand implements Command {
    @Override
    public void execute(Player player, GameContext context) {
        Room room = context.getCurrentRoom();

        if (room.hasPotion()) {
            player.heal(30);
            room.removePotion();
            System.out.println("你喝下治療藥水，回復 30 HP！");
            System.out.println("你的 HP：" + player.getHp());
        } else {
            System.out.println("這個房間沒有治療藥水！");
        }
    }
}