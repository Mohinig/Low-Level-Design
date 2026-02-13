package HashMap.src;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class LockManager {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    void read(Runnable r) {
        lock.readLock().lock();
        try { r.run(); }
        finally { lock.readLock().unlock(); }
    }

    void write(Runnable r) {
        lock.writeLock().lock();
        try { r.run(); }
        finally { lock.writeLock().unlock(); }
    }
}

