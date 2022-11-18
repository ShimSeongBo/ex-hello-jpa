package classUser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserApp {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<?> userClass = Class.forName("classUser.User");

        System.out.println("Field List");
        for (Field field : userClass.getFields()) {
            System.out.println(field.getName());
        }

//        System.out.println("Constructor List");
//        for (Constructor constructor : userClass.getConstructors()) {
//            System.out.println(constructor.getName());
//        }

        System.out.println("Method List");
        for (Method method : userClass.getMethods()) {
            System.out.println(method.getName());
        }


        Class<User> userClass1 = User.class;
        Constructor<?> constructor = userClass1.getConstructor(null);
        User user = (User) constructor.newInstance();
        System.out.println(user); //expect -> constructor 2개인데? 무엇이 나오지? 아니면 둘 다 나오나? 아니면 에러? 4개짜리(모두 포함) 생성자 value=null로 출력

        Field userPwd = User.class.getDeclaredField("pwd");
        userPwd.setAccessible(true);
        System.out.println(userPwd.get(user)); //expect ->
        // 필드의 생성자.newInstance() ? 이게 뭐야? -> null
        userPwd.set(user, "anythins?");
        System.out.println(userPwd.get(user)); //expect ->
        // name 출력

    }
}
