package characters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class CharacterDataLoader {
    static final String dataPath = "CharactersData.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(CharacterDataLoader.class);
    public static void init() {
        JsonNode data = null;
        try {
            data = loadData();
        }catch (Exception e){
            //TODO:处理这个异常。
        }
        if(data != null){
            JsonNode involver = data.path("Involver");
            logger.info(involver.get("name").asText());
            logger.info(involver.get("maxHealth").asText());
            logger.info(involver.get("attack").asText());
            logger.info(involver.get("defense").asText());
            logger.info(involver.get("fortune").asText());
        }
    }

    private static JsonNode loadData() throws Exception {
        InputStream inputStream = Thread.currentThread().
                getContextClassLoader().getResourceAsStream(dataPath);
        return mapper.readTree(inputStream);
    }
}
