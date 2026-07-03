public class GameTest {
    public static void main(String[] args){
        Game game = Game.getInstance();
        game.init();
        game.start();
        game.end();
    }
}
