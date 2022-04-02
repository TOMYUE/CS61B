/**
 * Deque implemention using Linked list
 * @author TOMYUE
 */
package deque;

public class ArrayDeque<T> {
    private T[] array;

    /** size of the deque, also means the number of elements between head and tail.*/
    private int size;

    /** define the original size of the array in deque. */
    private final int SIZE  = 8;

    /** Refactor constant when resizing the size of the array. */
    private final int REFACTOR = 2;

    /** head index of the array. */
    private int head;

    /** tail index of the array. */
    private int tail;

    /** length of the current array. */
    private int length;


    /** Creates an empty deque. */
    public ArrayDeque(){
        this.array = (T[]) new Object[SIZE];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
        this.length = SIZE;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    /** when the size of array is to be less than the size of the deque elements, resize array. */
    private void resizeUp(){
        T[] resizedArray = (T[]) new Object[array.length * REFACTOR];
        int tempSize = length - head;
        System.arraycopy(array, head, resizedArray, 0, tempSize);
        System.arraycopy(array, 0, resizedArray, tempSize, size - tempSize);
        array = resizedArray;
        head = 0;
        tail = size - 1;
    }

    /** when the size of array is to be more than the size of the deque elements, resize array. */
    private void resizeDown(){
        T[] resizedArray = (T[]) new Object[array.length/2];
        if (tail < head){
            int tempSize = array.length - head;
            System.arraycopy(array, head, resizedArray, 0, tempSize);
            System.arraycopy(array, 0, resizedArray, tempSize, size - tempSize);
        }
        else {
            System.arraycopy(array, head, resizedArray, 0, size);
        }
        array = resizedArray;
        head = 0;
        tail = size - 1;
    }

    public void addFirst(T item){
        // if deque has been full, resize
        if(size + 1 > length){
            resizeUp();
        }
        head = (head - 1 + length) % length;
        array[head] = item;
        size += 1;
    }

    public void addLast(T item){
        // if deque has been full, resize
        if(size + 1 > length){
            resizeUp();
        }
        tail = (tail + 1 + length) % length;
        array[tail] = item;
        size += 1;
    }

    public void printDeque(){
        int ptr = head;
        while (ptr != tail){
            System.out.println(array[ptr]);
            ptr = (ptr + 1 + length) % length;
        }
    }

    public T removeFirst(){
        if (size == 0) {
            return null;
        }

        T firstItem = array[head];
        head = (head + 1 + length) % length;
        size -= 1;

        // resize the array
        if(size < array.length/4){
            resizeDown();
        }

        return firstItem;
    }

    public T removeLast(){
        if (size == 0) {
            return null;
        }

        T lastItem = array[tail];
        tail = (tail - 1 + length) % length;
        size -= 1;

        // resize the array
        if(size < array.length/4){
            resizeDown();
        }

        return lastItem;
    }

    public T get(int index){
        if (index < 0 || index >= size){
            return null;
        }
        int ptr = head;
        while(index > 0){
            ptr = (ptr + 1 + length) % length;
            index--;
        }
        return array[ptr];
    }

}
