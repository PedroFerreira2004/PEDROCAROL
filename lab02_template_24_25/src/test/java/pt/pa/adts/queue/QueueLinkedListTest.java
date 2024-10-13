package pt.pa.adts.queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {
    QueueLinkedList queue = new QueueLinkedList();

    @org.junit.jupiter.api.Test
    void enqueue() {
        queue.enqueue(1);
        assertEquals(1, queue.front());
    }

    @org.junit.jupiter.api.Test
    void dequeue() {
        int a = queue.size();
        assertEquals(false, queue.isEmpty());
        queue.dequeue();
        assertEquals(a-1, queue.size());

    }

    @org.junit.jupiter.api.Test
    void front() {
        assertEquals(false, queue.isEmpty());
        queue.enqueue(1);
        assertEquals(1, queue.front());
        queue.enqueue(2);
        assertEquals(1, queue.front());


    }

    @org.junit.jupiter.api.Test
    void size() {
        int a = queue.size();
        assertEquals(false, queue.isEmpty());
        queue.enqueue(1);
        assertEquals(a+1, queue.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertEquals(true, queue.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        assertEquals(false, queue.isEmpty());
        queue.enqueue(1);
        queue.clear();
        assertEquals(true, queue.isEmpty());
    }
}