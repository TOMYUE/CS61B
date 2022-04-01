/**
 * Deque implemention using Linked list
 * @author TOMYUE
 */
package deque;

public class LinkedListDeque<T> {
    /** nested class TNode */
    private class TNode{
        private T item;
        private TNode prev;
        private TNode next;

        /** constructor of a sentinel node. */
        public TNode(TNode prev, TNode next){
            this.prev = null;
            this.next = null;
        }

        /** constructor of a node with item, and pointers. */
        public TNode(T item, TNode prev, TNode next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private TNode sentinel;
    private int size;

    /** Creates an empty deque */
    public LinkedListDeque(){
            sentinel = new TNode(null, null);
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = 0;
    }

    /** Returns true if the deque is empty. */
    public boolean isEmpty(){
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size(){
        return size;
    }

    /** Adds item to the front of the deque. */
    public void addFirst(T item){
        TNode newNode = new TNode(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    /** Adds item to the last of the deque. */
    public void addLast(T item){
        TNode newNode = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    /** Removes first item in the deque. */
    public T removeFirst(){
        if(size == 0){
            return null;
        }

        T firstItem = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return firstItem;
    }

    /** Removes last item in the deque. */
    public T removeLast(){
        if(size == 0){
            return null;
        }

        T lastItem = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return lastItem;
    }

    /** Gets the item at the given index. */
    public T get(int index){
        if(index +1 > size){
            return null;
        }
        TNode p = sentinel.next;
        while(index > 0){
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    /** Prints all the items in the deque. */
    public void printDeque(){
        TNode p = sentinel.next;
        while (p.next.next != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }
}
