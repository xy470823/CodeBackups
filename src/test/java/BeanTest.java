
import bean.UserTest;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import utils.CopyUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanTest {

    @Test
    public void copyBeanTest(){
        UserTest userTest1 = new UserTest();
        userTest1.setUserName("nameA");
        userTest1.setUserNo(001);
        userTest1.setId("id-A-001");
        UserTest userTest2 = new UserTest();
        try {
            BeanUtils.copyProperties(userTest2,userTest1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(userTest2));
    }

    @Test
    public void copyBeanTest2(){
        UserTest userTest1 = new UserTest();
        userTest1.setUserName("nameA");
        userTest1.setUserNo(001);
        userTest1.setId("id-A-001");
        UserTest userTest2 = new UserTest();
        org.springframework.beans.BeanUtils.copyProperties(null,userTest2);
        userTest2.setUserName("nameB");
        System.out.println(JSON.toJSONString(userTest1));
        System.out.println(JSON.toJSONString(userTest2));
    }

    @Test
    public void copyBeanTest3(){
        UserTest userTest1 = new UserTest();
        userTest1.setUserName("nameA");
        userTest1.setUserNo(001);
        userTest1.setId("id-A-001");

    }
}
