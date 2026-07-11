package characters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CharacterData {
    static final String dataPath = "CharactersData.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final HashMap<String, CharacterStatus> characterData = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(CharacterData.class);
    private final static ArrayList<String> CharacterNameList =
            new ArrayList<>();

    public ArrayList<String> getCharacterNameList() {
        return CharacterNameList;
    }

    public static void init() {
        JsonNode data = null;
        try {
            data = loadData();
        } catch (Exception e) {
            //TODO:处理这个异常。
        }
        if (data != null) {
            JsonNode singleCharacterData, nameList;
            nameList = data.path("name");
            if(nameList.isArray()){
                for(JsonNode name:nameList){
                    CharacterNameList.add(name.asText());
                }
            }
            else{
                throw new RuntimeException("文件不完整");
            }
            for (String name : CharacterNameList) {
                singleCharacterData = data.path(name);
                CharacterStatus status = new CharacterStatus();
                status.maxHealth = singleCharacterData.get("maxHealth").asInt();
                status.attack = singleCharacterData.get("attack").asInt();
                status.defense = singleCharacterData.get("defense").asInt();
                status.fortune = singleCharacterData.get("fortune").asInt();
                status.defenseMultiplier = singleCharacterData.get("defenseMultiplier").asDouble();
                status.health = 0;
                characterData.put(name, status);
            }
        }
    }

    private static JsonNode loadData() throws Exception {
        InputStream inputStream = Thread.currentThread().
                getContextClassLoader().getResourceAsStream(dataPath);
        return mapper.readTree(inputStream);
    }

    public static CharacterStatus characterStatusFactory(String name) {
        CharacterStatus result = null;
        result = characterData.get(name);
        return result;
    }
}
