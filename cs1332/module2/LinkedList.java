package cs1332.module2;
import java.util.Iterator;

import org.w3c.dom.Node;

public class LinkedList<T> implements Iterable<T>{
	Node<T> curr;
	int data;
	public Iterator<T> iterator(){
		return new LLIterator<>();
	}
	
	private class LLIterator implements Iterator<T>{
		private Node<> curr;
		LLIterator(){
			curr = head;
		}
		public boolean hasNext() {
			return curr != null;
		}
		public T next() {
			if(hasNext()) {
				T temp = curr.data;
				curr = curr.next;
				return temp;
			}
			return null;
		}

	}
	public void removeDuplicates() {
		head = rRemove(head);
	}
	public Node<T> rRemove(Node<T> curr){
		if(curr==null) {
			return null;
		}
		curr.next=rRemove(curr.next);
		if(curr.next!=null && curr.data.equals(curr.next.data)) {
			return curr.next;
		}
		return curr;
	}
}
