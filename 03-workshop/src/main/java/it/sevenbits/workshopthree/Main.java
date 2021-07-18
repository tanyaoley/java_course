package it.sevenbits.workshopthree;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    private long i = 0;

    public static void read(String filename, String dirname) {
        try {
            OutputStream out = new FileOutputStream(filename);
            scanDir(new File(dirname), out , 0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static long scanDir(File dir, OutputStream out,long  counter){
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                String rwx = null;
                try {
                    rwx = " |R:" + file.canRead() + " W:" + file.canWrite() + " E:" + file.canExecute() + "| " + file.getCanonicalPath();

                    if (file.isDirectory()) {
                        out.write((file.getName() + " directory" + rwx + "\n").getBytes(StandardCharsets.UTF_8));
                        counter = scanDir(file, out, counter);
                    }
                    out.write((file.getName() + " file" + rwx + "\n").getBytes(StandardCharsets.UTF_8));

                    counter++;
                    if (counter % 5 == 0) {
                        out.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return counter;
    }


    public static void main(String[] args) {

        String outputFile = args[0];
        String dirname = args[1];
        read(outputFile, dirname);

    }

}
