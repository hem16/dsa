package org.example.dsaquestions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue queue = null;

@BeforeEach
public void setup(){
    queue = new Queue(2);
}


@Test
public void testLength() {

    int len = queue.getLength();
    assertEquals(len,1);

}

}