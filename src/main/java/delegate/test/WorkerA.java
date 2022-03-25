package delegate.test;


import delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工作者A
 */
public class WorkerA implements JavaDelegate {

    private final Logger logger = LoggerFactory.getLogger(WorkerA.class);

    @Override
    public void execute(String workName) {
        logger.info("工作者【WorkerA】开始执行["+workName+"]工作");
    }
}
