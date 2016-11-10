package com.slut.alumni.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 七月在线科技 on 2016/11/8.
 */

public class BodyUtils {

    public static Map<String, String> getLoginBody(String account, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("account", account);
        map.put("password", password);
        return map;
    }

    public static Map<String, String> getRegBody(String nickname, String account, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("nickname", nickname);
        map.put("account", account);
        map.put("password", password);
        return map;
    }

}
