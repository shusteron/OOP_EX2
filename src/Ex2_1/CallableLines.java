package Ex2_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class CallableLines implements Callable<Integer> {
    private String file;

    /**
     * Constructor that receive the name of a file
     * @param file -String - the name of the file
     */
    public CallableLines(String file)
    {
        this.file = file;
    }


    /**
     * This method calculate the numbers of the line in the file, and return it.
     * @return int - numbers of line
     * @throws Exception - FileNotFoundException
     */
    @Override
    public Integer call() throws Exception {
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
        return count;
    }
}

