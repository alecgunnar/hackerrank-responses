package maxdiff;

import java.util.List;

public class MaxDiff {
    public static int maxDifference(List<Integer> arr) {
        return findMaxDifference(arr.subList(1, arr.size()));
    }

    private static int findMaxDifference(List<Integer> numbers) {
        int size = numbers.size();

        if (size == 1)
            return -1;

        int indexOfLastNumber = size - 1;
        int maxDiff = findMaxDifference(numbers.subList(0, indexOfLastNumber));
        int compareTo = numbers.get(indexOfLastNumber);

        for (int number : numbers)
            if (number < compareTo && compareTo - number > maxDiff)
                maxDiff = compareTo - number;

        return maxDiff;
    }
}
