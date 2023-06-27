import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/////////////////////////////Without Optmize Approach////////////////////////////////////////// The Optimized approach is below

// public class Main {
//     public static void main(String[] args) {
//         int[] arr = {1, 3, 2, 2, -4, -6, -2, 8};
//         int target = 4;
//         List<List<Integer>> combinations = findCombinations(arr, target);

//         System.out.println("First Combination For " + target + ": " + combinations);
        
//         int[] mergedArray = mergeArray(combinations);
//         System.out.println("Merge Into a Single Array: " + Arrays.toString(mergedArray));
        
//         int doubledTarget = target * 2;
//         List<List<Integer>> combinationsDoubled = findCombinations(mergedArray, doubledTarget);
//         System.out.println("Second Combination For " + doubledTarget + ": " + combinationsDoubled);
//     }

//     private static List<List<Integer>> findCombinations(int[] arr, int target) {
//         List<List<Integer>> combinations = new ArrayList<>();

//         // Step 1: Find pairs of integers that sum up to the target value
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = i + 1; j < arr.length; j++) {
//                 if (arr[i] + arr[j] == target) {
//                     combinations.add(Arrays.asList(arr[i], arr[j]));
//                 }
//             }
//         }

//         return combinations;
//     }

//     private static int[] mergeArray(List<List<Integer>> combinations) {
//         List<Integer> mergedArray = new ArrayList<>();

//         // Step 2: Merge the pairs into a single array
//         for (List<Integer> pair : combinations) {
//             mergedArray.addAll(pair);
//         }

//         // Step 3: Sort the merged array in ascending order
//         mergedArray.sort(null);

//         // Convert the merged array back to an integer array
//         int[] result = new int[mergedArray.size()];
//         for (int i = 0; i < mergedArray.size(); i++) {
//             result[i] = mergedArray.get(i);
//         }

//         return result;
//     }
// }
//////////////////////////////////////////Optimize Approach using maps////////////////////////////////////


public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;
        List<List<Integer>> combinations = findCombinations(arr, target);

        System.out.println("First Combination For " + target + ": " + combinations);

        int[] mergedArray = mergeArray(combinations);
        System.out.println("Merge Into a Single Array: " + Arrays.toString(mergedArray));

        int doubledTarget = target * 2;
        List<List<Integer>> combinationsDoubled = findCombinations(mergedArray, doubledTarget);
        System.out.println("Second Combination For " + doubledTarget + ": " + combinationsDoubled);
    }

    private static List<List<Integer>> findCombinations(int[] arr, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Step 1: Populate the frequency map
        for (int num : arr) {
            int complement = target - num;
            if (frequencyMap.containsKey(complement) && frequencyMap.get(complement) > 0) {
                combinations.add(Arrays.asList(complement, num));
                frequencyMap.put(complement, frequencyMap.get(complement) - 1);
            } else {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
        }

        return combinations;
    }

    private static int[] mergeArray(List<List<Integer>> combinations) {
        List<Integer> mergedArray = new ArrayList<>();

        // Step 2: Merge the pairs into a single array
        for (List<Integer> pair : combinations) {
            mergedArray.addAll(pair);
        }

        // Step 3: Sort the merged array in ascending order
        mergedArray.sort(null);

        // Convert the merged array back to an integer array
        int[] result = new int[mergedArray.size()];
        for (int i = 0; i < mergedArray.size(); i++) {
            result[i] = mergedArray.get(i);
        }

        return result;
    }
}
