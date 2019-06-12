package lock.handler.lock;

import org.aspectj.lang.JoinPoint;
import lock.lock.Lock;
import lock.model.LockInfo;


/**
 * @description: 获取锁超时的处理逻辑接口
 * @author: huangtao
 * @date: 2019/6/12
 */
public interface LockTimeoutHandler {

    void handle(LockInfo lockInfo, Lock lock, JoinPoint joinPoint);
}
