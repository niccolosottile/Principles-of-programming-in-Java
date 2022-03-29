package question_2;

import java.util.ArrayList;

public class CustomSort implements SortingInterface {

    // Custom sorted array list
    private ArrayList<Double> customSorted;

	@Override
	public void setValues(ArrayList<Double> values){

        // Set values to custom sorted array list
        this.customSorted = new ArrayList<>(values);

        // Sort the values using the sort function
        sort();
    }

    // PRIORITY
	@Override
	public ArrayList<Integer> getGaps(){

        ArrayList<Integer> gaps = new ArrayList<Integer>();

        return gaps;
    }

    // Method used to move the array list forward by 1 element, starting at index
    private void moveForward(int index){

        for(int i = index; i < (this.customSorted.size() - 1); i++){

            // If at last element, add a new element 
            if(i == (this.customSorted.size() - 1)){
                this.customSorted.add(this.customSorted.get(i));
                break;
            }

            // Set next element equal to current element
            this.customSorted.set(i + 1, this.customSorted.get(i));

        }

    }

	@Override
	public void add(Double value){

        // Loop through the custom sorted array list
        for(int i = 0; i < this.customSorted.size(); i++){

            // if i is equal to size - 1, check previous value
            if(i == (this.customSorted.size() - 1)){
                if(value >= this.customSorted.get(i)){

                    // Add value at the end
                    this.customSorted.add(value);

                }
            }

            // If i is bigger than 0 and smaller than size - 1, check in between
            if(i > 0 && i < (this.customSorted.size() - 1)){
                if(value >= this.customSorted.get(i) && value <= this.customSorted.get(i + 1)){

                    // Switch all values 1 position forward from i + 1
                    moveForward(i + 1);

                    // Set position i + 1 to value
                    this.customSorted.set(i + 1, value);

                }

            }

            // If i is equal to 0, check next value
            if(i == 0){
                if(value <= this.customSorted.get(i)){

                    // Switch all values 1 position forward from i
                    moveForward(i);

                    // Set current position i to value
                    this.customSorted.set(i, value);

                }
            }
        }
    }

	@Override
	public void remove(int index){
        
        // If not out of bounds, remove the value at the specified index
        if(index < this.customSorted.size()){
            this.customSorted.remove(index);
        }
    }

    // PRIORITY
    @Override
	public void sort(){
        
    }
}
