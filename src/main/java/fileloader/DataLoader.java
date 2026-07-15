package fileloader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class DataLoader {
    protected static final ObjectMapper mapper = new ObjectMapper();
    /**
     * 从Json文件中读取角色数据
     *
     * @return 读取到的Json文件
     * @throws Exception
     */
    public static JsonNode loadData(String path) throws Exception {
        InputStream inputStream = Thread.currentThread().
                getContextClassLoader().getResourceAsStream(path);
        return mapper.readTree(inputStream);
    }
}
