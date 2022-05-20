import bean.User;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StringJunitTest4 {

    @Test
    public void getMsg(){
        String url = "http://4a.fat001:qa.pad.com.cn/admin?appId=90189";
        if (url.indexOf("?") == -1){
            System.out.println(url.indexOf("appId=90188"));
        }else {
            System.out.println(url.indexOf("?"));
        }
    }


}