import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main(String[] args) {
        int []nums = new int[]{1,5,3,6};
        int target = 8;
        int [] result = twoSum(nums, target);
//        int [] result = twoSumTimeComplexityOptimisation(nums, target);
//        int [] result = twoSumTimeComplexityOptimisationOneForLoop(nums, target);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

//  2 for loops
//  time complexity: O(n2), due to 2 for loops
//  space complexity O(1)

    public static int[] twoSum(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] == target - nums[i]){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

//    time complexity can be reduced to O(n)
//    but space complexity will get increased to O(n)
//    to do so, only one for loop has to be used


    public static int[] twoSumTimeComplexityOptimisation(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }

//    While moving element into map. We can add check code in the same loop itself and also add array values in map. Both can be done in only one for loop

    public static int[] twoSumTimeComplexityOptimisationOneForLoop(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
        }
        return null;
    }

}
