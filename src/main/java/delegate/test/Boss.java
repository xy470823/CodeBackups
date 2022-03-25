package delegate.test;

import org.testng.annotations.Test;


public class Boss {

    @Test
    public void BossOrderWorkLeader(){
        new Leader().execute("登录开发工作");
    }

}