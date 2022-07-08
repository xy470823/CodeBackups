package cache;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LocalCache<T> implements ApplicationRunner, Serializable {

    private static final long serialVersionUID = 4445556632565335L;

    private static Logger logger = LoggerFactory.getLogger(LocalCache.class);

    private Map<String,Object> container = new ConcurrentHashMap<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("项目启动时加载本地缓存数据");
        container.put("test",1);
        logger.info("项目启动时加载本地缓存完成:{}", JSON.toJSONString(container));
    }

    public LocalCache(Map<String, Object> container) {
        this.container = container;
    }

    public Map<String, Object> getContainer() {
        return container;
    }

    public void setContainer(Map<String, Object> container) {
        this.container = container;
    }
}
