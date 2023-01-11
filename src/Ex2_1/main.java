    public static void main(String[] args) {
        Ex2_1 ex2_1 = new Ex2_1();

        int n= 1000 , seed = (int) (Math.random() * 10), bound = 1000;
        String[] names = createTextFiles(n , seed , bound);

        long start1 = System.currentTimeMillis();
        int lines = getNumOfLines(names);
        long end1 = System.currentTimeMillis();
        System.out.println("All the files contains " + lines + " lines, calc without thread");
        System.out.println("Time of calc in milli seconds: "+ (end1-start1));

        long start2 = System.currentTimeMillis();
        lines = ex2_1.getNumOfLinesThreads(names);
        long end2 = System.currentTimeMillis();
        System.out.println("All the files contains " + lines + " lines, calc with thread");
        System.out.println("Time of calc in milli seconds: "+ (end2-start2));

        long start3 = System.currentTimeMillis();
        lines = ex2_1.getNumOfLinesThreadPool(names);
        long end3 = System.currentTimeMillis();
        System.out.println("All the files contains " + lines + " lines, calc with threadPool");
        System.out.println("Time of calc in milli seconds: "+ (end3-start3));
    }
