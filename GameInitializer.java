// public class GameInitializer {
//     public static GameContext init() {
//         Room forest = new Room("森林入口", "你站在茂密森林的邊緣", new Monster("哥布林", 30, 8), true);
//         Room temple = new Room("神殿大廳", "光線從破碎的石窗灑落", new Monster("亡靈戰士", 50, 12), false);
//         forest.setExit("north", temple);
//         temple.setExit("south", forest);
//         Player player = new Player("勇者", 100, 15);
//         player.addSkill(new FireballSkill());
//         return new GameContext(player, forest);
//     }
// }
public class GameInitializer {
    public static GameContext init() {
        Room forest = new Room("森林入口", "你站在茂密森林的邊緣", new Monster("哥布林", 30, 8), true);
        Room temple = new Room("神殿大廳", "光線從破碎的石窗灑落", new Monster("亡靈戰士", 50, 12), false);
        Room cave = new Room("黑石洞窟", "一個陰暗的洞穴，牆上佈滿黏液", new Monster("暗影蜘蛛", 70, 14), true);
        Room tower = new Room("法師之塔", "充滿魔力波動的空間，空氣中飄著火花", new Monster("黑袍法師", 90, 18), false);
        Room throne = new Room("王座大廳", "華麗的大廳，中央坐著一位強大的魔王", new Monster("魔王川普", 1000, 25), false);

        forest.setExit("north", temple);
        temple.setExit("south", forest);
        temple.setExit("east", cave);
        cave.setExit("west", temple);
        cave.setExit("north", tower);
        tower.setExit("south", cave);
        tower.setExit("north", throne);
        throne.setExit("south", tower);

        Player player = new Player("勇者", 100, 15);
        player.addSkill(new FireballSkill());
        player.addSkill(new Tariff());

        return new GameContext(player, forest);
    }
}
