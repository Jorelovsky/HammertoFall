package fileloader;

import characters.CharacterStatus;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.HashMap;

public class SkillData {
    private static boolean INIT_LOCK = false;
    private static final String dataPath = "SkillsData.json";
    private static final HashMap<String, Double> skillData = new HashMap<>();
    private final static ArrayList<String> skillNameList =
            new ArrayList<>();

    public static void init(){
        if(INIT_LOCK) return;
        INIT_LOCK = true;
        JsonNode data = null;
        try {
            data = DataLoader.loadData(dataPath);
        } catch (Exception e) {
            //TODO:处理这个异常。
        }
        if (data != null) {
            JsonNode nameList;
            nameList = data.path("name");
            if(nameList.isArray()){
                for(JsonNode name: nameList){
                    skillNameList.add(name.asText());
                }
            }else {
                throw new RuntimeException("文件不完整");
            }
            for (String name:skillNameList){
                Double multiplier = data.path(name).path("Multiplier").asDouble();
                skillData.put(name, multiplier);
            }
        }
    }
    public static Double getSkillData(String name){
        return skillData.get(name);
    }
}
