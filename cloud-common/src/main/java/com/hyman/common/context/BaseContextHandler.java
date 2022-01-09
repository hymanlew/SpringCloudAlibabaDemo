package com.hyman.common.context;

import com.hyman.common.constant.CommonConstants;
import io.jsonwebtoken.lang.Objects;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hyman
 * @Date: 2018/3.4/28 16:19
 * @Description: 增加子线程传递功能，线程池中禁用
 */
public class BaseContextHandler {

    public static ThreadLocal<Map<String, Object>> threadLocal = new InheritableThreadLocal<>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static Integer getUserID() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
        if (value == null) {
            value = "0";
        }
        return Integer.valueOf(value.toString());
    }

    public static String getUsername() {
        Object value = get(CommonConstants.CONTEXT_KEY_USERNAME);
        return returnObjectValue(value);
    }


    public static String getName() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_NAME);
        return Objects.getDisplayString(value);
    }

    public static String getToken() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_TOKEN);
        return Objects.getDisplayString(value);
    }

    public static void setToken(String token) {
        set(CommonConstants.CONTEXT_KEY_USER_TOKEN, token);
    }

    public static String getTokenType() {
        Object value = get(CommonConstants.JWT_KEY_TYPE);
        return Objects.getDisplayString(value);
    }

    public static void setTokenType(String tokenType) {
        set(CommonConstants.JWT_KEY_TYPE, tokenType);
    }

    public static void setName(String name) {
        set(CommonConstants.CONTEXT_KEY_USER_NAME, name);
    }

    public static void setUserID(int userID) {
        set(CommonConstants.CONTEXT_KEY_USER_ID, userID);
    }

    public static void setUsername(String username) {
        set(CommonConstants.CONTEXT_KEY_USERNAME, username);
    }

    private static String returnObjectValue(Object value) {
        return value == null ? null : value.toString();
    }

    public static void remove() {
        threadLocal.remove();
    }

//    @RunWith(SpringRunner.class)
//    public static class UnitTest {
//        private Logger logger = LoggerFactory.getLogger(UnitTest.class);
//
//        @Test
//        public void testSetContextVariable() throws InterruptedException {
//            BaseContextHandler.set("test", "main");
//            new Thread(()->{
//                BaseContextHandler.set("test", "moo");
//
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                assertEquals(BaseContextHandler.get("test"), "moo");
//                logger.info("thread one done!");
//            }).start();
//            new Thread(()->{
//                BaseContextHandler.set("test", "moo2");
//                assertEquals(BaseContextHandler.get("test"), "moo2");
//                logger.info("thread two done!");
//            }).start();
//
//            Thread.sleep(5000);
//            assertEquals(BaseContextHandler.get("test"), "main");
//            logger.info("main one done!");
//        }
//
//        @Test
//        public void testSetUserInfo(){
//            BaseContextHandler.setUserID(123);
//            assertEquals(BaseContextHandler.getUserID(), "test");
//            BaseContextHandler.setUsername("test2");
//            assertEquals(BaseContextHandler.getUsername(), "test2");
//        }
//    }
}
