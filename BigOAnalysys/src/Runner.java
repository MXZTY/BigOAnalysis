
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Runner {
    public void addingHash(HashTable hasher, ArrayList<String> names) {
        int arraySize = names.size();
        long end = System.currentTimeMillis() + 1000;
        int j = 0;
        while (System.currentTimeMillis() < end) {
            hasher.add(names.get(j));
            j++;
        }
        System.out.println(j + " out of " + arraySize);
    }

    public void addingList(LinkedList linker, ArrayList<String> names, int timeScale) {
        int arraySize = names.size();
        long end = System.currentTimeMillis() + timeScale;
        int j = 0;
        while (System.currentTimeMillis() < end) {
            linker.add(names.get(j));
            j++;
        }
        System.out.println(j + " out of " + arraySize);
    }
    public void timeForTen(HashTable hasher, ArrayList<String> names) {
        PrintWriter writer = null;
        int size = 0;
        int wantSize = 200;

        try {
            writer = new PrintWriter(new FileWriter("graphList.txt", false));
            writer.println("LinkList");
            writer.println(" time, number_values");
        } catch (FileNotFoundException ex1) {
            //do not
        } catch (IOException e) {
            //do not
        } finally {
            writer.close();
        }
        while (size <= 200000) {
            for (int i = size; i < wantSize; i++) {
                hasher.add(names.get(i));
            }
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                hasher.find(names.get(i % wantSize));
            }
            long end = System.currentTimeMillis();
            long totalTime = end - start;
            double secondsForOp = totalTime / 1000.0;
            try {
                writer = new PrintWriter(new FileWriter("graphList.txt", true));
                writer.println(secondsForOp + " " + wantSize);
            } catch (FileNotFoundException ex1) {
                //do not
            } catch (IOException e) {
                //do not
            } finally {
                writer.close();
            }
            System.out.println(wantSize + " " + "at " + secondsForOp);
            size += 1800;
            wantSize += 1800;
    }
    }
        public void timeForTen(LinkedList linker, ArrayList<String> names) {
            PrintWriter writer = null;
            int size = 0;
            int wantSize = 200;

            try {
                writer = new PrintWriter(new FileWriter("graphList.txt", false));
                writer.println("LinkList");
                writer.println(" time, number_values");
            } catch (FileNotFoundException ex1) {
                //do not
            } catch (IOException e) {
                //do not
            } finally {
                writer.close();
            }
            while (size <= 200000) {
                for (int i = size; i < wantSize; i++) {
                    linker.add(names.get(i));
                }
                long start = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++) {
                    linker.find(names.get(i % wantSize));
                }
                long end = System.currentTimeMillis();
                long totalTime = end - start;
                double secondsForOp = totalTime / 1000.0;
                try {
                    writer = new PrintWriter(new FileWriter("graphList.txt", true));
                    writer.println(secondsForOp + " " + wantSize);
                } catch (FileNotFoundException ex1) {
                    //do not
                } catch (IOException e) {
                    //do not
                } finally {
                    writer.close();
                }
                System.out.println(wantSize + " " + "at " + secondsForOp);
                size += 1800;
                wantSize += 1800;
        }

        }
    }
