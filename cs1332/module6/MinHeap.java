package cs1332.module6;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if(Objects.equals(data, null)) {
    		throw new IllegalArgumentException();
    	}else {
    		if(size==backingArray.length-1) {
    			T[] tmp = (T[])new Comparable[2*backingArray.length];
    			for(int i=0;i<backingArray.length;i++) {
    				tmp[i]=backingArray[i];
    			}
    			backingArray = tmp;
    		}
    		backingArray[size+1] = data;
    		size++;
    		int parent=size/2;
    		int current=size;
    		while(parent>0) {
    			if(backingArray[current].compareTo(backingArray[parent])==1) {
    				parent=-1;;
    			}else {
    				T tmp = backingArray[current];
    				backingArray[current]=backingArray[parent];
    				backingArray[parent]=tmp;
    				tmp=null;
    				current=parent;
    				parent=current/2;
    			}
    		}
    		
    	}
    }
 
    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if(backingArray.length<=1) {
    		throw new NoSuchElementException();
    	}else {
    		T res = backingArray[1];
        	backingArray[1]=backingArray[size];
        	backingArray[size]=null;
        	size--;
        	int parent = 1;
        	int left = 2*parent;
        	int right = 2*parent+1;
        	while(left<=size) {
        		if(left==size) {
        			if(backingArray[parent].compareTo(backingArray[left])==1) {
        				T tmp = backingArray[parent];
        				backingArray[parent]=backingArray[left];
        				backingArray[left]=tmp;
        			}
        			break;
        		}else {
        			if(backingArray[parent].compareTo(backingArray[left])==-1 && 
        					backingArray[parent].compareTo(backingArray[right])==-1){
        				
        				break;
        				
        			}else if(backingArray[left].compareTo(backingArray[right])==-1){
        				T tmp = backingArray[parent];
        				backingArray[parent]=backingArray[left];
        				backingArray[left]=tmp;
        				tmp=null;
        				parent = left;
        				left = 2*parent;
        				right=2*parent+1;
        				
        			}else {
        				T tmp = backingArray[parent];
        				backingArray[parent]=backingArray[right];
        				backingArray[right]=tmp;
        				tmp=null;
        				parent = right;
        				left = 2*parent;
        				right=2*parent+1;
        			}
        		}
        		
        	}
        	return res;
    		
    	}
    	
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}