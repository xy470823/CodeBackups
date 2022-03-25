import bean.User;
import bean.User2;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class OptionalTest {

    @Test
    public void LambdaTestMap(){
        Map<String,Object> objectMap = new HashMap<>();
        Map<String,Object> objectMap1 = new HashMap<>();
        Map<String,Object> objectMap2 = new HashMap<>();
        objectMap2.put("objectMap2","Optional");
        objectMap1.put("objectMap1",objectMap2);
        objectMap.put("objectMap",objectMap1);
        System.out.println(JSON.toJSON(Optional.ofNullable(objectMap).map((Optional) -> Optional.get("objectMap1")).map((Object) -> Object.getClass())));
    }

    @Test
    public void LambdaTestBean(){
        User2 user2 = new User2();
        user2.setId(001);
        Map map = new HashMap<>();
        map.put("user2",user2);
        User user = new User();
        user.setUserData(map);
        Optional<Object> object = Optional.ofNullable(user).map(User::getUserData);
    }

}