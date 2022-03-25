import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.ListUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class UUIdTest4 {

    @Test
    public void getUUid(){
        for (int i = 0; i < 5000; i++) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
            String s = dateFormat.format(new Date()) +System.nanoTime();
            System.out.println("["+s.length()+"]"+s);
        }


    }

    @Test
    public void getList(){
        String str = "ACD,BVC";
        String[] strArray = str.split(",");
        List<String> list = Arrays.asList(strArray);
        System.out.println(list);
    }

    @Test
    public void testList(){
        List<String> stringList = new ArrayList<>();
        stringList.add("贷前监控");
        stringList.add("贷中监控");
        stringList.add("贷后监控");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < stringList.size(); i++) {
             if (i == stringList.size() -1){
                 stringBuffer.append(stringList.get(i));
             }else {
                 stringBuffer.append(stringList.get(i)).append(",");
             }
        }
        System.out.println("数组数据"+stringList.toString());
        System.out.println("Json数组数据"+stringBuffer);
    }

    @Test
    public void testList1(){
        List<String> stringList = new ArrayList<>();
        stringList.add("贷前监控");
        stringList.add("贷中监控");
        stringList.add("贷后监控");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < stringList.size(); i++) {
            if (i == stringList.size() -1){
                stringBuffer.append(stringList.get(i));
            }else {
                stringBuffer.append(stringList.get(i)).append(",");
            }
        }
        System.out.println("数组数据------:"+stringList.toString());
        System.out.println("字符串数据------:"+stringBuffer);
        System.out.println("Json数组数据------:"+JSON.toJSON(stringList).toString());
    }

    @Test
    public void testList2(){
        String appNames = "SX_ZYD_0,SX_ZYD_1,SX_ZYD_2,SX_ZYD_3,SX_ZYD_4,SX_ZYD_5";
        String[] appNameArray = appNames.split(",");
        List<String> list = Arrays.asList(appNameArray);
        System.out.println(list);
    }

}