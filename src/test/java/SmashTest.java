import characters.CharacterStatus;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import skills.Skill;
import skills.Smash;

public class SmashTest {
    Skill skill = new Smash();
    CharacterStatus status = new CharacterStatus();
    @Test
    public void damageTest(){
        status.attack = 10;
        status.defense = 10;
        assertEquals(60, skill.processData(status));
    }
}
