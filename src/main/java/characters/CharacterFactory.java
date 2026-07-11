package characters;

public class CharacterFactory {

    /**
     *
     * @param characterIndex 要获取的角色的名字
     * @return 要获取的角色实例
     * @throws IllegalArgumentException 如果传入的characterIndex为null或者在已有角色中找不到。
     */
    public static Character getCharacter(String characterIndex) {
        if (characterIndex == null) {
            throw new IllegalArgumentException("这里禁止输入null，谢谢。");
        } else if (characterIndex.equals("Involver")) {
            return new Involver();
        } else if (characterIndex.equals("Napoleon")){
            return new Napoleon();
        }
        throw new IllegalArgumentException("查无此人");
    }
}
