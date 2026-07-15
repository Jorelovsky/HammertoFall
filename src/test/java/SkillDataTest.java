import fileloader.SkillData;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SkillDataTest {
    private static final Logger logger = LoggerFactory.getLogger(SkillDataTest.class);
    @Test
    public void testLoader(){
        SkillData.init();
        assertEquals(3.0, SkillData.getSkillData("Smash"), 0.01);
    }
}
