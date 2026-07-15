import fileloader.CharacterData;
import characters.CharacterStatus;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CharacterDataLoaderTest {
    private static final Logger logger = LoggerFactory.getLogger(CharacterDataLoaderTest.class);

    @Test
    public void testLoadData() {
        CharacterData.init();
        CharacterStatus status = CharacterData.getcharacterStatus("Involver");
        assertNotNull(status);
        assertEquals(1000, status.maxHealth);
    }
}
