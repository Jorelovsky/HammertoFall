package characters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class CharacterData {
    static final String dataPath = "CharactersData.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final HashMap<String, CharacterStatus> characterData = new HashMap<>();
    private final static ArrayList<String> CharacterNameList =
            new ArrayList<>();

    /**
     * 初始化CharacterData，读取角色数据。
     */
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
            if (nameList.isArray()) {
                for (JsonNode name : nameList) {
                    CharacterNameList.add(name.asText());
                }
            } else {
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

    /**
     * 从Json文件中读取角色数据
     *
     * @return 读取到的Json文件
     * @throws Exception
     */
    private static JsonNode loadData() throws Exception {
        InputStream inputStream = Thread.currentThread().
                getContextClassLoader().getResourceAsStream(dataPath);
        return mapper.readTree(inputStream);
    }

    /**
     * 获得对应角色的基础面板
     *
     * @param name 角色名称
     * @return 基础面板
     */
    public static CharacterStatus getcharacterStatus(String name) {
        CharacterStatus result = null;
        result = characterData.get(name);
        return result;
    }
}
