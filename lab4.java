import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array ---------------------------------------------------");
        ArrayList<Integer> integerList = Lab4.getList();
        Lab4.outputList(integerList);

        System.out.println("\n\nBubble sort results ----------------------------------------------");
        ArrayList<Integer> bubbleListCopy = new ArrayList<>(integerList); 
        long startBubble = System.nanoTime();
        ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(bubbleListCopy);
        long endBubble = System.nanoTime();
        Lab4.outputList(bubbleSortedList);
        System.out.printf("\nBubble sort time (ms): %.2f\n", (endBubble - startBubble)/1_000_000.0);

        System.out.println("\n\nInsertion sort results -------------------------------------------");
        ArrayList<Integer> insertionListCopy = new ArrayList<>(integerList); 
        long startInsertion = System.nanoTime();
        ArrayList<Integer> insertionSortedList = Lab4.insertionSort(insertionListCopy);
        long endInsertion = System.nanoTime();
        Lab4.outputList(insertionSortedList);
        System.out.printf("\nInsertion sort time (ms): %.2f\n", (endInsertion - startInsertion)/1_000_000.0);
    }
}

class Lab4 {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
        for (int i = 1; i < integerList.size(); i++) {
            int key = integerList.get(i);
            int j = i - 1;
            while (j >= 0 && integerList.get(j) > key) {
                integerList.set(j + 1, integerList.get(j));
                j--;
            }
            integerList.set(j + 1, key);
        }
        return integerList;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
        int n = integerList.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (integerList.get(j) > integerList.get(j + 1)) {
                    int temp = integerList.get(j);
                    integerList.set(j, integerList.get(j + 1));
                    integerList.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
        return integerList;
    }

    public static ArrayList<Integer> getList() {
        ArrayList<Integer> integerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
            while ((line = br.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    public static void outputList(ArrayList<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) + " ");
            if ((i + 1) % 20 == 0) System.out.println(); 
        }
        System.out.println();
    }
}