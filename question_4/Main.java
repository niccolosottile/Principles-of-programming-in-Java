package question_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
    	
        ArrayList<String> filesOne = new ArrayList<String>();
        filesOne.add("1831-06-01.txt");
        filesOne.add("2003-08-27.txt");

        ArrayList<String> filesTwo = new ArrayList<String>();
        filesTwo.add("1961-04-12.txt");
        filesTwo.add("1972-12-11.txt");

        int numAttempts = 1;

        for(int i = 0; i < numAttempts; i++){
            System.out.println("Run: " + (i+1));
            PopThread popRunnableOne = new PopThread(filesOne);
            PopThread popRunnableTwo = new PopThread(filesTwo);
            Thread threadOne = new Thread(popRunnableOne);
            Thread threadTwo = new Thread(popRunnableTwo);
            threadOne.start();
            threadTwo.start();
            try{
                threadOne.join();
                threadTwo.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            try (BufferedReader br = new BufferedReader(new FileReader("result.txt"))){
                String line;
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
