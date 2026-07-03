import org.junit.Before;
import org.junit.Test;
import accounts.Player;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void initiateTest(){
        Player player = Player.getInstance();
        assertNotNull(player);
    }
    public void inputTest(){
        Player player = Player.getInstance();
        String actual = player.getPlayerInput();
        System.out.println(actual);
    }
    @Before
    public void introduction()
    {
        System.out.println("现在开始测试Player!");
    }
}
