package prja.leetcode.challange.general;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueWithLock<T> {
	private Queue<T> queue = new LinkedList<T>();
	private int capacity;
	private Lock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();

	public BlockingQueueWithLock(int capacity) {
		this.capacity = capacity;
	}

	public void put(T element) throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == capacity) {
				notFull.await();
			}
			queue.add(element);
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public T take() throws InterruptedException {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				notEmpty.await();
			}
			T item = queue.remove();
			notFull.signal();
			return item;
		} finally {
			lock.unlock();
		}
	}
}