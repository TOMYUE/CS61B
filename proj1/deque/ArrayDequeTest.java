package deque;

import edu.princeton.cs.algs4.In;
import org.junit.After;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/** Performs some basic array deque list tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty and size() are corrext,
     * finally printing the results
     *
     * */
    public void addIsEmptySizeTest(){
        ArrayDeque<String> ad1 = new ArrayDeque<>();
        assertTrue("A newly initialized ADeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");

        assertEquals(1, ad1.size());
        assertFalse(ad1.isEmpty());

        ad1.addFirst("middle");
        assertFalse(ad1.isEmpty());

        ad1.addLast("last");
        assertFalse(ad1.isEmpty());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    /** Adds continue items to see the results. */
    public void addContinueItem(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 10; ++i){
            ad1.addFirst(i);
        }

        ad1.printDeque();

        for (int i = 9; i >= 0; --i){
            int temp = ad1.removeFirst();
            assertEquals("each element squence", i, temp);
        }
    }
    @Test
    /** Adds an item, then removes an item, and ensures that ad2 is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        assertTrue("ad2 should contain no item",ad2.isEmpty());

        ad2.addFirst(10);
        assertFalse("ad2 should contain 1 item",ad2.isEmpty());

        ad2.removeFirst();
        assertTrue("ad2 should contain no item", ad2.isEmpty());
    }

    @Test
    /** Tests removing from an empty deque. */
    public void removeEmptyTest(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(10);

        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeLast();

        assertTrue("Deque should be empty", ad1.isEmpty());
    }

    @Test
    /** Check if you can create ArrayDeques with different parameterized types. */
    public void multiParameters(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ArrayDeque<String>  ad2 = new ArrayDeque<>();
        ArrayDeque<Double> ad3 = new ArrayDeque<>();

        ad1.addFirst(10);
        ad2.addFirst("One");
        ad3.addFirst(10.0);

        Integer x = ad1.removeFirst();
        String y = ad2.removeFirst();
        Double z = ad3.removeFirst();

    }

    @Test
    /** Check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturn(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        assertEquals("Remove from the front of the deque should be null", null, ad1.removeFirst());
        assertEquals("Remove from the last of the deque should be null", null, ad1.removeLast());
    }

    @Test
    /** Add large number of elements to deque; check if order is correct.*/
    public void checkLargeNumberOrders() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        for(int i = 0; i < 100000; ++i){
            ad1.addFirst(i);
        }

        for(double i = 0; i < 50000; ++i){
            assertEquals(i, (double) ad1.removeFirst(), 0.0);
        }

        for(double i = 99999; i > 50000; --i){
            assertEquals(i, (double) ad1.removeLast(), 0.0);
        }
    }

}
