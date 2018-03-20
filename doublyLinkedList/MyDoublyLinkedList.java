package com.serova.doublyLinkedList;


public class MyDoublyLinkedList<E> {
	private Node head;
	private Node tail;
	private int size;

	public MyDoublyLinkedList() {
		size = 0;
	}
	private class Node {
		E element;
		Node next;
		Node prev;
		public Node(E element, Node next, Node prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
	}
	public int size() { 
		return size; 
	}
	public boolean isEmpty() { 
		return size == 0; 
	}
	public void addFirst(E element) {
		Node tmp = new Node(element, head, null);
		if(head != null ) {
			head.prev = tmp;
		}
		head = tmp;
		if(tail == null) {
			tail = tmp;
		}
		size++;
		System.out.println(element + " added at first position");
	}
	public void addLast(E element) {
		Node tmp = new Node(element, null, tail);
		if(tail != null) {
			tail.next = tmp;
		}
		tail = tmp;
		if(head == null) {
			head = tmp;
		}
		size++;
		System.out.println(element + " added at last");
	}
	public void traverseForward(){
		System.out.println("Traversal in forward Direction");
		Node tmp = head;
		while(tmp != null){
			System.out.println(tmp.element);
			tmp = tmp.next;
		}
	}
	public void traverseBackward(){
		System.out.println("Traversal in reverse direction");
		Node tmp = tail;
		while(tmp != null){
			System.out.println(tmp.element);
			tmp = tmp.prev;
		}
	}
	public E removeFirst() {
		if (size == 0);
		Node tmp = head;
		head = head.next;
		head.prev = null;
		size--;
		System.out.println(tmp.element + " deleted");
		return tmp.element;
	}
	public E removeLast() {
		if (size == 0);
		Node tmp = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		System.out.println(tmp.element + " deleted at the end");
		return tmp.element;
	}
	public E addIndex(E data, int position) {

		Node tmp= head;
		if(position == 0){
			tmp= new Node(data, tmp, tmp);
			tmp.next=head;
			return data;
		}
		else{
			for(int i=1;i<position;i++){
				tmp=tmp.next;
			}
			Node tmpI= tmp.next;
			tmp.next= new Node(data, tmpI, tmpI);
			tmp.next.next=tmpI;
			System.out.println(data + " added "+ " at " + position + " position");
			return data;
		}
	}
	public E remove(int position){
		assert(position >= 0 && position < size()); 
		Node tmp = head; 
		if(position == 0){
			head = head.next; 
			head.prev = null;
			size--;
			return tmp.element;
		}
		else if(position == size()){
			head = tail.next;
			tail = tail.prev;
			size--;
			return tmp.element;
		}
		for(int i = 0; i < position-1; i++) 
			tmp = tmp.next;
		Node two = tmp.next;
		tmp.next = two.next; 
		two = null; 
		size--; 
		System.out.println(tmp.element + " removed "+ " at " + position + " position");
		return tmp.element; 
	}
	public E set(E element, int position)  {
		remove(position);
		addIndex(element, position);	
		System.out.println(element + " replaced " + " at " + position + " position");
		return element;	
	}

	public static void main(String a[]){
		MyDoublyLinkedList<Integer> dll = new MyDoublyLinkedList<Integer>();
		dll.addFirst(14);
		dll.addFirst(44);
		dll.addFirst(10);
		dll.addFirst(34);
		dll.addLast(56);
		dll.addLast(364);
		dll.traverseForward();
		dll.removeFirst();
		dll.removeLast();
		dll.traverseBackward();
		System.out.println("The size of list is: " + dll.size());
		dll.addIndex(5, 2);
		dll.traverseForward();
		dll.remove(1);	
		dll.set(30, 1);
		dll.traverseForward();

	}
}
