package LeetCode.array;

import java.util.HashMap;
import java.util.Map;
/**
 * HashMap 
 * @author huang
 *
 */
public class TwoSum {
	//Ò»°ã·½·¨  O(n^2)	about 452ms
	public static int[] twoSum(int[] nums, int target){
		int[] a = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++){
				if(nums[i] + nums[j] == target){
					a[0] = i+1;
					a[1] = j+1;
					break;
				}
			}
		}
		return a;
	}
	//hashmap	about 412ms
	public static int[] twoSumHashMap(int[] nums, int target){
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[1] = i + 1;
				result[0] = map.get(target-nums[i]);
				return result;
			}
			map.put(nums[i], i+1);
		}
		return result;
		
		// another version  about 356ms
		 /*HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
	        int len = nums.length;
	        for(int i = 0; i < len; i++){
	            if(tracker.containsKey(nums[i])){
	                int left = tracker.get(nums[i]);
	                return new int[]{left+1, i+1};
	            }else{
	                tracker.put(target - nums[i], i);
	            }
	        }
	        return new int[2];*/
	}
	//test
	public static void main(String[] args) {
		int[] arr = {2,7,11,15};
		int target = 9;
		int[] b = twoSum(arr, target);
		System.out.println(b[0] +"  "+ b[1]);
	}
}
