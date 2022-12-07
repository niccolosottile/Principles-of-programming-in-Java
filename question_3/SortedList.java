package question_3;

public interface SortedList {

	/**
	* Returns the number of Nodes in the linked list.
	*
	* @return      the number of Nodes in the linked list
	*/
	public int size();

	/**
	* Adds a Node with the specified string to the linked list in
	* the appropriate position given the specified alphabetical order
	* (i.e., ascending/descending).
	*
	* @param  string  a String to be added to the linked list
	*/
	public void add(String string);

	/**
	* Adds a Node to the linked list in the appropriate position
	* given the specified alphabetical order (i.e., ascending/descending).
	*
	* @param  node  a Node to be added to the linked list
	*/
	public void add(Node node);

	/**
	* Returns the first Node of the linked list given the specified
	* alphabetical order (i.e., ascending/descending).
	*
	* @return      the first Node in the linked list
	*/
	public Node getFirst();

	/**
	* Returns the last Node of the linked list given the specified
	* alphabetical order (i.e., ascending/descending).
	*
	* @return      the last Node in the linked list
	*/
	public Node getLast();

	/**
	* Returns the Node at the specified index assuming indices start
	* at 0 and end with size-1 given the specified alphabetical order
	* (i.e., ascending/descending).
	*
	* @param  index  the index of the Node in the linked list to be retrieved
	* @return      the Node in the linked list at the specified index
	*/
	public Node get(int index);

	/**
	* Checks to see if the list contains a Node with the specified
	* string.
	*
	* @param  string  the String to be searched for in the linked list
	* @return       True if the string is present or false if not
	*/
	public boolean isPresent(String string);

	/**
	* Removes the first Node from the list given the specified
	* alphabetical order (i.e., ascending/descending).
	*
	* @return      Returns true if successful or false if unsuccessful
	*/
	public boolean removeFirst();

	/**
	* Removes the last Node from the list given the specified
	* alphabetical order (i.e., ascending/descending).
	*
	* @return      Returns true if successful or false if unsuccessful
	*/
	public boolean removeLast();

	/**
	* Removes the Node at the specified index from the list assuming indices
	* start at 0 and end with size-1 given the specified alphabetical order
	* (i.e., ascending/descending)
	*
	* @param  index  the index of the Node in the linked list to be removed
	* @return      Returns true if successful or false if unsuccessful
	*/
	public boolean remove(int index);

	/**
	* Removes the Node from the list that contains the specified string.
	*
	* @param  string  the string to be removed from the linked list
	* @return      Returns true if successful or false if unsuccessful
	*/
	public boolean remove(String string);

	/**
	* Orders the linked list in ascending alphabetical order.
	*
	*/
	public void orderAscending();

	/**
	* Orders the linked list in descending alphabetical order.
	*
	*/
	public void orderDescending();

	/**
	* Prints the contents of the linked list in the specified alphabetical order
	* (i.e., ascending/descending) to System.out with each node's string on
	* a new line.
	*
	*/
	public void print();
}
