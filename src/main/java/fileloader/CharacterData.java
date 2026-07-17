package fileloader;

import characters.CharacterStatus;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.HashMap;

public class CharacterData {
    private static boolean INIT_LOCK = false;
    private static final String dataPath = "CharactersData.json";
    private static final HashMap<String, CharacterStatus> characterData = new HashMap<>();
    private final static ArrayList<String> characterNameList =
            new ArrayList<>();
    /**
     * 初始化CharacterData，读取角色数据。
     */
    public static void init() {
        if(INIT_LOCK) return;
        INIT_LOCK = true;
        JsonNode data = null;
        try {
            data = DataLoader.loadData(dataPath);
        } catch (Exception e) {
            //TODO:处理这个异常。
        }
        if (data != null) {
            JsonNode singleCharacterData, nameList;
            nameList = data.path("name");
            if (nameList.isArray()) {
                for (JsonNode name : nameList) {
                    characterNameList.add(name.asText());
                }
            } else {
                throw new RuntimeException("文件不完整");
            }
            for (String name : characterNameList) {
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
