package com.lairun.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author x_holic@outlook.com
 * @date 2019-12-12
 */
public final class ResultUtil {

    private ResultUtil() {}

    public static Map<String, Object> success(String msg, Object data) {
        return success(msg, null, data);
    }

    public static Map<String, Object> success(Object data) {
        return success(null, null, data);
    }
    public static Map<String, Object> success() {
        return success(null, null, null);
    }

    public static Map<String, Object> success(String msg, String dataName, Object data){
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("code", "200");
        result.put("msg", StringUtils.isNotBlank(msg) ? msg : "操作成功");

        if (data != null) {
            if (StringUtils.isNotBlank(dataName)) {
                result.put(dataName, data);
            } else {
                result.put("data", data);
            }
        }
        return result;
    }

    public static Map<String, Object> failure() {
        return failure(null, null);
    }

    public static Map<String, Object> failure(String msg) {
        return failure(null, msg);
    }

    public static Map<String, Object> failure(String code, String msg) {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("code", StringUtils.isNotBlank(code) ? code : "500");
        result.put("msg", StringUtils.isNotBlank(msg) ? msg : "操作失败，请联系管理员");
        return result;
    }

}
