package accounts;

import java.util.ArrayList;

public class PlayerCommandDecoder {
    /**
     * 最简单的拆解用户指令的方法，即将字符串中的数字转化为ArrayList，忽略其他字符
     *
     * @param command 用户输入的指令
     * @return 指令中数字构成的ArrayList
     */
    public static ArrayList<Integer> CommandDecoder(String command) {
        int integerHead = -1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < command.length(); i++) {
            if (integerHead == -1 && Character.isDigit(command.charAt(i))) {
                integerHead = i;
            }
            if (integerHead != -1 && !Character.isDigit(command.charAt(i))) {
                result.add(Integer.parseInt(command.substring(integerHead, i)));
                integerHead = -1;
            }
        }
        if (integerHead != -1) {
            result.add(Integer.parseInt(command.substring(integerHead)));
        }
        return result;
    }
}
