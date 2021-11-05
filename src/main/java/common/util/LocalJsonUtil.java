package common.util;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * 从本地获取JSON数据的工具类
 */
public class LocalJsonUtil {

    /**
     * 从指定路径获取JSON并转换为List
     *
     * @param path        json文件路径
     * @param elementType List元素类型
     */
    public static <T> List<T> getListFromJson(String path, Class<T> elementType) {
        ClassPathResource resource = new ClassPathResource(path);
        String jsonStr = IoUtil.read(resource.getStream(), StandardCharsets.UTF_8);
        JSONArray jsonArray = new JSONArray(jsonStr);
        return JSONUtil.toList(jsonArray, elementType);
    }

    /**
     * 从指定路径获取JSON并转换为Map
     *
     * @param path json文件路径
     */
    public static <T> Map<Object, Object> getMapFromJson(String path) {
        ClassPathResource resource = new ClassPathResource(path);
        String jsonStr = IoUtil.read(resource.getStream(), StandardCharsets.UTF_8);
        return JSON.parseObject(jsonStr, new TypeReference<Map<Object, Object>>() {
        });
    }

    /**
     * 从指定路径获取JSON并转换为字符串
     *
     * @param path json文件路径
     */
    public static String getStringFromJson(String path) {
        ClassPathResource resource = new ClassPathResource(path);
        return IoUtil.read(resource.getStream(), StandardCharsets.UTF_8);
    }
}
