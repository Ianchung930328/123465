// public class MoveCommand implements Command { public void execute(Player p, GameContext c) {} }
public class MoveCommand implements Command {
    private String direction;

    public MoveCommand(String direction) {
        this.direction = direction.toLowerCase();
    }

    @Override
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom != null) {
            context.setCurrentRoom(nextRoom);
            System.out.println("你移動到了：" + nextRoom.getName());
        } else {
            System.out.println("這個方向沒有出口！");
        }
    }
}
