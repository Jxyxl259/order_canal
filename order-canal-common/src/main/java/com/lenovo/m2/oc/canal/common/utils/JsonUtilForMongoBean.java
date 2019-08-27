package com.lenovo.m2.oc.canal.common.utils;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by fenglg1 on 2015/5/21.
 */
public class JsonUtilForMongoBean {
    private static Logger logger = LoggerFactory.getLogger(JsonUtilForMongoBean.class);
    public static final ObjectMapper OM = new ObjectMapper();

    static {
        OM.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        OM.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        OM.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
    }

    public static JavaType assignList(Class<? extends Collection> collection, Class<? extends Object> object) {
        return JsonUtilForMongoBean.OM.getTypeFactory().constructParametricType(collection, object);
    }

    public static <T> ArrayList<T> readValuesAsArrayList(String key, Class<T> object) {
        ArrayList<T> list = null;
        try {
            list = OM.readValue(key, assignList(ArrayList.class, object));
        } catch (JsonParseException e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
        } catch (JsonMappingException e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public static String toJson(Object obj) {
        try {
            return OM.writeValueAsString(obj);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return OM.readValue(json, clazz);
        } catch (JsonParseException e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
        } catch (JsonMappingException e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
