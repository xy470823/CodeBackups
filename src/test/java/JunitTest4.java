import bean.User;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;


public class JunitTest4 {

    @Test
    public void getMsg(){
        List<User> list = new ArrayList<>();
        User user01 = new User("map01","555");
        User user02 = new User("map02","555");
        User user03 = new User("map03","555");
        User user04 = new User("map04","555");
        User user05 = new User("map05","666");
        User user06 = new User("map06","666");
        User user07 = new User("map07","666");
        User user08 = new User("map08","666");
        User user09 = new User("map09","777");
        User user10 = new User("map10","777");
        User user11 = new User("map11","777");
        User user12 = new User("map12","888");
        User user13 = new User("map13","888");
        User user14 = new User("map14","888");
        User user15 = new User("map15","888");
        User user16 = new User("map16","999");
        User user17 = new User("map17","999");
        User user18 = new User("map18","999");
        User user19 = new User("map19","999");
        User user20 = new User("map20","999");
        list.add(user01);
        list.add(user02);
        list.add(user03);
        list.add(user04);
        list.add(user05);
        list.add(user06);
        list.add(user07);
        list.add(user08);
        list.add(user09);
        list.add(user10);
        list.add(user11);
        list.add(user12);
        list.add(user13);
        list.add(user14);
        list.add(user15);
        list.add(user16);
        list.add(user17);
        list.add(user18);
        list.add(user19);
        list.add(user20);
        List<String> strList = new ArrayList<>();
        strList.add("666");
        strList.add("999");
        for (String str : strList) {
            int count = 0;
            for (User user : list) {
                if (str.equals(user.getUserPwd())){
                    count = 1;
                }else {
                    if (count == 1) {
                        break;
                    }
                }
            }
        }
    }

    @Test
    public void setUser(){
        User user = new User();
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        System.out.println("bf:{}"+user.getUserName());
        setUserName(map);
        System.out.println("af:{}"+user.getUserName());
    }

    public void setUserName (Map<String,Object> map ){
        User user = (User) map.get("user");
        user.setUserName("123456-Name");
    }

    @Test
    public void StringUtils(){
        String str = "(-999.99999.999,50000)";
        boolean b = str.indexOf("(") != -1;
        System.out.println(b);
    }

    @Test
    public void testException(){
        BigDecimal big = new BigDecimal("12");
        try {
            big = new BigDecimal("AAA");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("111111-"+big);
    }

    @Test
    public void testException1(){
        String values = "SSSSSAAAA;eee";
        String[] value = values.split(";");
        System.out.println(value.length);
    }

    @Test
    public void testException2() throws ParseException {
        String dateS = "2022-03-17 23:59:59";
        //Date date = DateUtils.parseDate(dateS,null);
        System.out.println(this.getClass().getName());
    }
}