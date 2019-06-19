package LeetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _3Sum {
	public static List<List<Integer>> threeSum(int[] nums){
		//如何解决数字串唯一性！
		/*List<List<Integer>> list = new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-2; i++) {
			int start = i+1;
			int end = nums.length-1;
			while(start < end){
				int sum = nums[i] + nums[start] + nums[end];
				if(sum == 0){
					List<Integer> result = new ArrayList<Integer>();
					result.add(nums[i]);
					result.add(nums[start]);
					result.add(nums[end]);
					list.add(result);
					while(start < end && nums[start] == nums[start+1]) start ++;
					while(start < end && nums[end] == nums[end-1]) end--;
					start++;end--;
				}
				else if(sum < 0){
					start++;
				}
				else{
					end--;
				}
			}
		}
		return list;*/
		
		// better one
		// remenber this: the array has already been sorted!!!
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length-2; i++) {
			if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
				int l = i+1, h = nums.length-1, sum = 0-nums[i];
				while(l < h){
					if(nums[l] + nums[h] == sum){
						res.add(Arrays.asList(nums[i],nums[l], nums[h]));
						while(l < h && nums[l] == nums[l+1]) l++;
						while(l < h && nums[h] == nums[h+1]) h--;
						l++;
						h--;
					}
					else if(nums[l] + nums[h] < sum) l++;
					else h--;
				}
			}
		}
		return res;
	}
	//test
	public static void main(String[] args) {
		int[] arr = {0,0,0,0};
		List<List<Integer>> list = threeSum(arr);
		for (List<Integer> list2 : list) {
			for (Integer integer : list2) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
