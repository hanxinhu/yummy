package edu.nju.hxh.yummy.util;

import java.util.UUID;

/**
 * @author hxh
 * @date 2019-02-16 08:23
 */
public class UUIDUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
