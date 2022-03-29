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

    // Method calculates the power of an int
    private int pow(int n, int p){
        
        while(p != 1){

            n = n * n;

            p--;
        }

        return n;
    }

    // PRIORITY
	@Override
	public ArrayList<Integer> getGaps(){

        // FOLLOWED THE PSEDUCODE

        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> gaps = new ArrayList<Integer>();

        int n = this.customSorted.size();

        int gap = 1, i = 2;

        while(gap < n){

            temp.add(gap);

            gap = pow(2, i) - 1;

            i++;
        }

        for(i = (temp.size() - 1); i >= 0; i--){

            gaps.add(temp.get(i));

        }

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

        // FOLLOWED THE PSEDUCODE

        int n = this.customSorted.size();
        ArrayList<Integer> gaps = getGaps();

        for(int q = 0; q < gaps.size(); q++){

            for(int i = gaps.get(q); i < n; i++){

                double temp = this.customSorted.get(i);

                int j = 0;

                for(j = i; j <= gaps.get(q); j -= gaps.get(q)){

                    if(this.customSorted.get(j - gaps.get(q)) <= temp){
                        break;
                    }

                    this.customSorted.set(j, this.customSorted.get(j - gaps.get(q)));

                }

                this.customSorted.set(j, temp);
            }
        }
    }

    public void printAll(){

        for(int i = 0; i < this.customSorted.size(); i++){
            System.out.print(this.customSorted.get(i) + " ");
        }

        System.out.println("");

    }

    public static void main(String[] args) {

        CustomSort gapSort = new CustomSort();

        ArrayList<Double> values = new ArrayList<Double>();

        values.add(13.9);
        values.add(2.3);
        values.add(4.3);
        values.add(9.2);
        values.add(5.1);

        gapSort.setValues(values);

        gapSort.printAll();

    }

}
