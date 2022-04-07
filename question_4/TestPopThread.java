package question_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TestPopThread {
    public static void main(String[] args) {

        int NUM_THREADS = 4;

        ArrayList<ArrayList<String>> thread_filelist = new ArrayList<ArrayList<String>>();
        ArrayList<String> current_list = null;
        for(int i=0; i<341; i++) {
            if( i % Math.ceil(341.0/NUM_THREADS) == 0){
                current_list = new ArrayList<String>();
                thread_filelist.add(current_list);
            }
            current_list.add(String.format("question_4/data/chunk_%03d.txt", i));
        }

        ArrayList<Thread> threads = new ArrayList<Thread>();
    
        for(ArrayList<String> filelist: thread_filelist){
            PopThread thread_obj = new PopThread(filelist);
            Thread t = new Thread(thread_obj);
            System.out.println("Thread " + t.getName() + " created. with filelist size: " + filelist.size());
            threads.add(t);
        }

        for(Thread t: threads){
            t.start();
            System.out.println("Thread " + t.getName() + " started");
        }

        try {
            for(Thread t: threads){
                t.join();
                System.out.println("Thread " + t.getName() + " finished");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
            BufferedReader reader1 = new BufferedReader(new FileReader("question_4/data/expected_result.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("question_4/result.txt"));
            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            int lineNumber = 1;
            while(line1.compareTo(line2) == 0) {
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                if(line1 == null || line2 == null)
                    break;
                lineNumber++;
            }
            boolean pass = true;
            if(line1 != null || line2 != null) {
                System.out.println("mismatch at line " + lineNumber);
                System.out.println("expect: " + line1);
                System.out.println("   got: " + line2);
                System.out.println("");
                pass = false;
            }

            if(line1 != null) {
                if(line1.length() == 0 || line2 == null){
                    System.out.println("missing newline at end of file?");
                }
            }

            if(pass)
                System.out.println("Test passed");
            else
                System.out.println("Test failed");

            reader1.close();
            reader2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
