/**
 * Deque implemention using Linked list
 * @author TOMYUE
 */
package deque;

public class ArrayDeque<T> {
    private T[] array;
    private int size;

    /** Refactor constant when resizing the size of the array. */
    private int REFACTOR = 3;

    /** head index of the array in the circl. */
    private int head;

    /** tail index of the array. */
    private int tail;

    /** Creates an empty deque. */
    public ArrayDeque(){
        this.array = (T[]) new Object[34];
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

//    public void addFirst(T item)

//    public void addLast(T item)

//    public void printDeque()

//    public T removeFirst()

//    public T removeLast()

    public T get(int index){
        return array[index-1];
    }

}
