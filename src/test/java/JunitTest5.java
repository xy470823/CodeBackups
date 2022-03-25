import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class JunitTest5 {

    @Test
    public void getMeg(){
        System.out.println("JunitTest5");
    }

    @Test
    public void getJson(){
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        jsonMap.put("StringType","String");
        jsonMap.put("int",0);
        jsonMap.put("Boolean",false);
        System.out.println(JSON.toJSON(jsonMap));
    }

    @Test
    public void byteTest(){
       Byte test1 = 0;
        System.out.println(
                test1
        );
    }


    @Test
    public void testResb(){
       String riskCost = "1";
       String resultCode = "100007";
       if ("1".equals(riskCost) && !"100000".equals(resultCode)){
           System.out.println("A+1");
           if ("1".equals(riskCost) && !("100000".equals(resultCode)|| "199999".equals(resultCode))){
               System.out.println("A+2");
           }
       }
        if (!"100000".equals(resultCode)){
            System.out.println("B+1");
            if (!"100000".equals(resultCode)|| "199999".equals(resultCode)){
                System.out.println("B+2");
            }
        }
    }

    @Test
    public void testArray(){
        List<Map<String,Object>> arrayList = new ArrayList<>();
        Map<String,Object> test1Map = new HashMap<>();
        test1Map.put("key","test1");
        arrayList.add(test1Map);
        Map<String,Object> test2Map = new HashMap<>();
        test2Map.put("key",null);
        arrayList.add(test2Map);
        Map<String,Object> test3Map = new HashMap<>();
        test3Map.put("key","test3");
        arrayList.add(test3Map);
        for (Map<String, Object> objectMap : arrayList) {
            if (MapUtils.getObject(objectMap,"key") == null) continue;
            System.out.println(MapUtils.getObject(objectMap,"key"));
        }
    }

    @Test
    public void testBool(){
        String testFileCode = null;
        String testFileName = "Name";
        if (StringUtils.isNotBlank(testFileCode) && StringUtils.isNotBlank(testFileName) && "Code".equals(testFileCode) || "Code1".equals(testFileCode)){
            System.out.println("1");
        }
    }

    @Test
    public void testBoolSub(){
        String xmlString = "acbdfrg:44,jgjg:89,";
        String[] xmlStringArray = xmlString.split("jgjg:");
        System.out.println(xmlStringArray[1].split(",")[0]);
    }
}