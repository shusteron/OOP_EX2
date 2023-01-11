package Ex2_1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    private static String[] names;
    private static Ex2_1 ex2_1 = new Ex2_1();

    @BeforeAll
    static void createTextFiles() {
        int n= 1000 , seed = (int) (Math.random() * 10), bound = 1000;
        names = Ex2_1.createTextFiles(n , seed , bound);
    }

    @Test
    void getNumOfLines() {
        long start1 = System.currentTimeMillis();
        int lines = Ex2_1.getNumOfLines(names);
        long end1 = System.currentTimeMillis();
        System.out.println("All the files contains " + lines + " lines, calc without thread");
        System.out.println("Time of calc in milli seconds: "+ (end1-start1));
    }


    @Test
    void getNumOfLinesThreads() {
        long start2 = System.currentTimeMillis();
        int lines = ex2_1.getNumOfLinesThreads(names);
        long end2 = System.currentTimeMillis();
        System.out.println("All the files contains " + lines + " lines, calc with thread");
        System.out.println("Time of calc in milli seconds: "+ (end2-start2));

    }

    @Test
    void getNumOfLinesThreadPool() {
        long start3 = System.currentTimeMillis();
        int lines = ex2_1.getNumOfLinesThreadPool(names);
        long end3 = System.currentTimeMillis();
        System.out.println("All the files contains " + lines + " lines, calc with threadPool");
        System.out.println("Time of calc in milli seconds: "+ (end3-start3));
    }

}
