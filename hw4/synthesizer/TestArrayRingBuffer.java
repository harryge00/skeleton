package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(6);
        arb.enqueue(9.0);
        assertEquals(arb.peek(),9.0,0.005);
        arb.enqueue(8.0);
        arb.enqueue(7.0);
        arb.enqueue(6.0);
        assertEquals(9.0,arb.dequeue(),0.005);
        arb.enqueue(5.0);
        arb.enqueue(1.0);
        assertEquals(arb.fillCount(),5);
        assertEquals(arb.isFull(),false);
        assertEquals(arb.peek(),8.0,0.005);
        arb.enqueue(4.0);
        assertEquals(arb.isFull(),true);
       // arb.enqueue(9.0);//throw exception
        assertEquals(8.0,arb.dequeue(),0.005);
        assertEquals(7.0,arb.dequeue(),0.005);
        assertEquals(6.0,arb.dequeue(),0.005);
        assertEquals(5.0,arb.dequeue(),0.005);
        assertEquals(1.0,arb.dequeue(),0.005);
        assertEquals(4.0,arb.dequeue(),0.005);
        assertEquals(arb.isEmpty(),true);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}
