package Ex2_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ThreadFile extends Thread {
    private String file;
    private int lines = 0;

    /**
     * constructor  , receive the file's name.
     * @param file - String - file name
     */
    public ThreadFile (String file)
    {
        this.file = file;
    }

    /**
     * This method calculate the numbers of the line in the file, and return it.
     */
    public void run()
    {
        int count = 0;
        try {
            File file = new File(this.file);
            Scanner Reader = new Scanner(file);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                //System.out.println(data);
                count++;
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        this.lines = count;
    }

    /**
     * This method return the lines of the file
     * @return  int - number of lines
     * @throws InterruptedException
     */
    public int getLines() throws InterruptedException {
        return lines;
    }
}

