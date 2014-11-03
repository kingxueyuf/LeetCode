package LRUCache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LRUCache {

	HashMap<Integer, Node> map;
	Node head;
	Node tail;
	int capacity;
	int amount;

	public LRUCache(int capacity) {
		map = new HashMap<Integer, Node>(capacity);
		this.capacity = capacity;
		this.amount = 0;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			addToHead(n);
			return n.val;
		}
		return -1;
	}

	private void addToHead(Node n) {
		// TODO Auto-generated method stub
		if (head == null) {
			head = n;
			tail = n;
		} else {
			head.pre = n;
			n.next = head;
			head = n;
		}
	}

	private void remove(Node n) {
		// TODO Auto-generated method stub
		if (head == n) {
			head = head.next;
			if (head == null)
				tail = null;
			else
				head.pre = null;
			return;
		}
		if (tail == n) {
			tail = tail.pre;
			if (tail == null)
				head = null;
			else
				tail.next = null;
			return;
		}
		n.pre.next = n.next;
		if (n.next != null)
			n.next.pre = n.pre;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			addToHead(n);
			n.val = value;
		} else {
			// not contain;
			if (amount == capacity) {
				// need to remove tail
				removeTail();
				amount--;
			}
			// does not remove tail
			Node n = new Node(key, value);
			addToHead(n);
			map.put(key, n);
			amount++;
		}
	}

	private void removeTail() {
		// TODO Auto-generated method stub
		if (tail == null)
			return;
		else {
			map.remove(tail.key);
			tail = tail.pre;
			if (tail == null)
				head = null;
			else {
				tail.next = null;
			}
		}
	}

	class Node {
		Node pre;
		Node next;
		Integer key;
		Integer val;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public static void main(String args[]) {
		LRUCache lru = new LRUCache(10);
		lru.set(10, 13);
		lru.set(3, 17);
		System.out.println(lru.get(10));
	}
}
