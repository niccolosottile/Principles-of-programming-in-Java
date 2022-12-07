package question_2;

import java.util.ArrayList;

public interface SortingInterface {

	/**
	* Sets and sorts the values provided in ascending order.
	*
	* @param  values		the values to be sorted
	*/
	public void setValues(ArrayList<Double> values);

	/**
	* Returns the gaps used by the sorting algorithm.
	*
	* @return       The gaps used by the sorting algorithm to sort the ArrayList
	*/
	public ArrayList<Integer> getGaps();

	/**
	* Adds a value to the sorted ArrayList in ascending order.
	*
	* @param  value		the double to be added to the array list
	*/
	public void add(Double value);

	/**
	* Removes a value at the specified index from the sorted ArrayList.
	*
	* @param  index			the index of the double to be removed
	*/
	public void remove(int index);

	/**
	* Sorts the ArrayList in ascending order.
	*
	*/
	public void sort();
}
