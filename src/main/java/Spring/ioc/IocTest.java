package Spring.ioc;

public class IocTest {

    static class TocTest_A {
        private String id;
        private String name;
        public static void testA(TocTest_B b){
            return ;
        }
    }

    static class TocTest_B {
        private String id;
        private String name;
        public static void testA(TocTest_C c){
            TocTest_C.execute();
        }
    }

    static class TocTest_C {
        private static String id;
        private static String name;
        public static void execute(){
            System.out.println("id:"+id+"name"+name); ;
        }
    }


}
