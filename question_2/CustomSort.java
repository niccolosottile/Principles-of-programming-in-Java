package question_2;

import java.util.ArrayList;

public class CustomSort implements SortingInterface {

    // Custom sorted array list
    private ArrayList<Double> customSorted;

	@Override
	public void setValues(ArrayList<Double> values){

        // Set values to custom sorted array list
        this.customSorted = values;

        // Sort the values using the sort function
        this.sort();
    }

	@Override
	public ArrayList<Integer> getGaps(){

        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> gaps = new ArrayList<Integer>();

        int n = this.customSorted.size();

        int gap = 1, i = 2;

        while(gap < n){

            temp.add(gap);

            gap = (int) Math.pow(2, i) - 1;

            i++;
        }

        for(i = (temp.size() - 1); i >= 0; i--){

            gaps.add(temp.get(i));

        }

        return gaps;
    }

	@Override
	public void add(Double value){

        // Add value to sorted array list
        this.customSorted.add(value);

        // Sort the array list
        this.sort();
    }

	@Override
	public void remove(int index){
        
        // If not out of bounds, remove the value at the specified index
        if(index >= 0 && index < this.customSorted.size()){
            this.customSorted.remove(index);
        }
    }

    @Override
	public void sort(){

        int n = this.customSorted.size();
        ArrayList<Integer> gaps = this.getGaps();

        for(int q = 0; q < gaps.size(); q++){

            for(int i = gaps.get(q); i < n; i++){

                double temp = this.customSorted.get(i);

                int j = 0;

                for(j = i; j >= gaps.get(q); j -= gaps.get(q)){

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

        values.add(9.0);
        values.add(8.0);
        values.add(7.0);
        values.add(6.0);
        values.add(5.0);
        values.add(4.0);
        values.add(3.0);
        values.add(2.0);
        values.add(1.0);

        gapSort.setValues(values);

        gapSort.printAll();

    }

}
