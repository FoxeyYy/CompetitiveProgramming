import java.util.*;

public class Solution {

    // Twilio 2020 OA problem
    public static void main(String[] args) throws Exception {
        Integer[] items = {8, 5, 5, 5, 5, 1, 1, 1, 4, 4};
        Integer[] desiredOutput = {8, 4, 4, 1, 1, 1, 5, 5, 5, 5};

        Integer[] output = sort(items);

        if (!Arrays.equals(output, desiredOutput)) throw new Exception("Wrong result!");

        System.out.println("OK");

    }

    //Time: O(nlogn) average, O(n^2) in worst case
    //Space: O(logn) average, O(n) in worst case
    //n is number of elements
    public static Integer[] sort(Integer[] numbers) {

        Integer[] sol = Arrays.copyOf(numbers, numbers.length);

        Map<Integer, Integer> frequencies = new HashMap<>();

        for(Integer num: numbers) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        ProductComparator comparator = new ProductComparator(frequencies);

        Arrays.sort(sol, comparator);

        return sol;

    }

    private static class ProductComparator implements Comparator<Integer> {

        Map<Integer, Integer> frequencies;

        public ProductComparator(Map<Integer, Integer> frequencies) {
            this.frequencies = frequencies;
        }

        @Override
        public int compare(Integer o1, Integer o2) {

            int freqComp = Integer.compare(
              frequencies.get(o1),
              frequencies.get(o2)
            );

            if (freqComp != 0) return freqComp;

            return Integer.compare(o1, o2);
        }

    }

}
