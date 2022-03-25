package delegate.test;


import delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工作者B
 */
public class WorkerB implements JavaDelegate {

    private final Logger logger = LoggerFactory.getLogger(WorkerB.class);

    @Override
    public void execute(String workName) {
        logger.info("工作者【WorkerB】开始执行["+workName+"]工作");
    }
}
