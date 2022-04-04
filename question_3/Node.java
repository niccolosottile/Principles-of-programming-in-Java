package question_3;

/**
* Node class for use with the CM10228: Principles of Programming 2 coursework.
* 
* This should not be modified by the student.
* 
* @author		Christopher Clarke
* @version		1.0	
*/
public class Node {
	private String name;
	private Node prev;
	private Node next;
	
	public Node(String name) {
		this.prev = null;
		this.name = name;
		this.next = null;
	}
	
	public Node(String name, Node next) {
		this.prev = null;
		this.name = name;
		this.next = next;
	}
	
	public Node(Node prev, String name) {
		this.prev = prev;
		this.name = name;
		this.next = null;
	}
	
	public Node(Node prev, String name, Node next) {
		this.prev = prev;
		this.name = name;
		this.next = next;
	}
	
	public void setString(String name) {
		this.name = name;
	}
	
	public String getString() {
		return this.name;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public Node getPrev() {
		return this.prev;
	}
}