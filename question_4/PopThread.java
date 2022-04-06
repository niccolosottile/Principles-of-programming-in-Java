package question_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PopThread implements Runnable {

    // Used to apply sinchronized lock on preceding file number
    private int precedingFile = 0;
    private final Object lock = new Object();

    private ArrayList<String> filenames;

    public PopThread(ArrayList<String> filenames) {
        this.filenames = filenames;
    }

    @Override
    public void run() {
        synchronized(lock)  {
            // Read each file's label (guard for inexistent file)
            for (String filename: this.filenames) {

                // Read label from file
                String label, currentLine;
                label = currentLine = "";

                try (BufferedReader labelReader = new BufferedReader(new FileReader(filename))) {

                    while ((currentLine = labelReader.readLine()) != null) {
                        label = currentLine;
                    }

                } catch (IOException e) {
                    continue;
                }

                // Extract file number from label (converting it into an int)
                int fileNumber = Integer.parseInt(label.substring(1, 4));

                // If label for preceding file is found
                if (fileNumber == precedingFile) {

                    // Copy file into result file (guard for inexistent file)
                    try (BufferedReader fileReader = new BufferedReader(new FileReader(filename)); 
                        FileWriter resultWriter = new FileWriter("result.txt");) {

                        File resultFile = new File("result.txt");
                        resultFile.createNewFile(); // Works both if file already exists or not

                        // Read and write line by line
                        while ((currentLine = fileReader.readLine()) != null) {
                            resultWriter.write(currentLine);
                        }

                        // Increase preceding file number
                        precedingFile++;

                        // Resume other threads' search for preceding file
                        lock.notifyAll();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            // Wait for other thread to find preceding file
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }        
    }
}