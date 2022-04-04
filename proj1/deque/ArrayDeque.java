/**
 * Deque implemention using Linked list
 * @author TOMYUE
 */
package deque;

public class ArrayDeque<T> implements Deque<T> {
    private T[] array;

    /** size of the deque, also means the number of elements between head and tail.*/
    private int size;

    /** define the original size of the array in deque. */
    private final int SIZE = 8;

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
        /* Create new copy array. */
        T[] temp = (T[]) new Object[array.length*REFACTOR];

        /* Copy the ArrayDeque elements to the temp array. */
        int ptr = head;
        int cnt = 0;
        while (ptr != tail){
            temp[cnt] = array[ptr];
            ptr = (ptr + 1 + length) % length;
            cnt += 1;
        }
        temp[cnt] = array[ptr];

        /* Copy back to array. */
        array = temp;

        /* Update head, tail and length. */
        head = 0;
        tail = size - 1;
        length = length*REFACTOR;
    }

    /** when the size of array is to be more than the size of the deque elements, resize array. */
    private void resizeDown(){
        /* Create new copy array. */
       T[] temp = (T[]) new Object[array.length/REFACTOR];

       /* Copy the ArrayDeque elements to the temp array. */
       int ptr = head;
       int cnt = 0;
       while (ptr != tail){
           temp[cnt] = array[ptr];
           ptr = (ptr + 1 + length) % length;
           cnt += 1;
       }
       temp[cnt] = array[ptr];

       /* Copy back to array. */
       array = temp;

       /* Update head, tail and length. */
        head = 0;
        tail = size - 1;
        length = length/REFACTOR;
    }


    public void addFirst(T item){
        if(size == 0){
            array[0] = item;
            size += 1;
            head = 0;
            tail = 0;
            return;
        }
        // if deque has been full, resize
        if(size + 1 > length){
            resizeUp();
        }

        head = (head - 1 + length) % length;
        array[head] = item;
        size += 1;
    }

    public void addLast(T item){
        if(size == 0){
            array[0] = item;
            size += 1;
            head = 0;
            tail = 0;
            return;
        }
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
            System.out.print(array[ptr] + " ");
            ptr = (ptr + 1 + length) % length;
        }
        System.out.println(array[ptr]);
    }

    public T removeFirst(){
        if (size == 0) {
            return null;
        }

        T firstItem = array[head];
        head = (head + 1 + length) % length;
        size -= 1;

        /* resize the array */
        if(size < array.length/4 && !(size >=0 && size <=8)){
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
