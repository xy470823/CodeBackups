package delegate.test;

import delegate.JavaDelegate;

import java.util.HashMap;
import java.util.Map;

/**
 * 领导
 */
public class Leader implements JavaDelegate {

    private Map<String,JavaDelegate> targets = new HashMap();

    public Leader() {
        targets.put("登录开发工作",new WorkerA());
        targets.put("注册开发工作",new WorkerB());
    }

    @Override
    public void execute(String workName) {
        targets.get(workName).execute(workName);
    }
}
