package model;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int N;
	private int operates;
	
	public class Node{
		Item item;
		Node next;
        
		Node(Node x) {//copy all the nodes connect next this node
			item = x.item;
			if (x.next != null) {
				next = new Node(x.next);
			}
			N++;
		}

		public Node() {
			
		}
	
}
	public Stack() {
		
		first = null;
		N = 0;
		operates = 0;
	}
	
	public Stack(Stack<Item> stack) {
		first = new Node(stack.first);
		
	}
	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}
	public void push(Item item) {
		Node oldnode = first;
		first = new Node();
		first.item = item;
		first.next = oldnode;
		N++;
		operates++;
		
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		operates--;
		return item;
	}
	
	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		return first.item;
	}
	
	public void catenation(Stack<Item> stack) {//make bottom of parameter 'stack' point to top of this object
		if (!stack.isEmpty()) {
			Stack<Item> s = new Stack<>(stack);
			Node last = s.first;
			while(last.next != null) {           
				last = last.next;
			}
			last.next = first;
			first = s.first;
			
		}
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		private int count = operates;

		@Override
		public boolean hasNext() {
			if (count != operates) {
				throw new ConcurrentModificationException();
			}
			return current != null;
		}

		@Override
		public Item next() {
			if (count != operates) {
				throw new ConcurrentModificationException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
		}
	}
  
	

	
	
}
