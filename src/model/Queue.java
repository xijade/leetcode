package model;

import java.util.Iterator;


public class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		N++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
		}
	}

	/**
	 * Exercise 1.3.47
	 * 
	 * @param queue
	 */
	public void catenation(Queue<Item> queue) {
		Queue<Item> temp = new Queue<>();
		Iterator<Item> iterator = queue.iterator();
		while (iterator.hasNext()) {
			temp.enqueue(iterator.next());
		}
		last.next = temp.first;
	}


}