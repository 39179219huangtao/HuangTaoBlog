package lock.model;


/**
 * @description: 锁类型
 * @author: huangtao
 * @date: 2019/6/12
 */
public enum LockType {
    /**
     * 可重入锁
     */
    Reentrant,
    /**
     * 公平锁
     */
    Fair,
    /**
     * 读锁
     */
    Read,
    /**
     * 写锁
     */
    Write;

    LockType() {
    }

}
