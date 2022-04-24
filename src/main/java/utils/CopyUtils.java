package utils;

import bean.UserTest;

public class CopyUtils {

    public static Object copyBean(Object classA, Object classB) {
        try {
            if (null == classA) {
                return null;
            }
        }finally {
            System.out.println(133);
        }
        org.springframework.beans.BeanUtils.copyProperties(classA, classB);
        classA.getClass();
        return classB;
    }



}
