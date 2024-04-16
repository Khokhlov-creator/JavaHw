package cz.cvut.fel.pjv;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue {
    private String[] array;
    private int head;
    private int tail;
    private int size;
    private int capacity;
    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueue() {
        this(5);
    }


    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     * @param capacity of the queue
     */
    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        this.array = new String[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public boolean enqueue(String obj) {
        if (isFull()){
            return false;
        }
        array[tail] = obj;
        tail = (tail +1) % capacity;
        size++;
        return true;
    }

    @Override
    public String dequeue() {
        if (isEmpty()){
            return null;
        }
        String removed = array[head];
        head = (head + 1) % capacity;
        size--;
        return  removed;
    }

    @Override
    public void printAllElements() {
        int count = size;
        while (count > 0) {
            System.out.println(array[head]);
            head = (head + 1) % capacity;
            count--;
        }
    }
}
