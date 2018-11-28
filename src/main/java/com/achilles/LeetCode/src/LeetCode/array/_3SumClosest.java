package LeetCode.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _3SumClosest {
	public static int threeSumClosest(int[] nums, int target){
		//穷举法   时间复杂度O（n^3）
		/*int sum = 0;
		int minusVal = 0;
		Deque<Integer> queue = new ArrayDeque<Integer>();
		int result = 0, min = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					sum = nums[i] + nums[j]+ nums[k];
					minusVal = Math.abs(target-sum);
					if(!queue.isEmpty()){
						result = queue.pop();
						min = queue.pop();
						if(minusVal < min){
							queue.push(minusVal);
							queue.push(sum);
						}else{
							queue.push(min);
							queue.push(result);
						}
					}
					else{
						queue.push(minusVal);
						queue.push(sum);
					}
				}
			}
		}
		result = queue.pop();
		return result;*/
		
		//如何优化算法，优化代码。
		int result = nums[0] + nums[1] + nums[nums.length-1];
		Arrays.sort(nums);
		for(int i = 0; i < nums.length-2; i++){
			int start = i + 1, end = nums.length - 1;
			while(start < end){
				int sum = nums[i] + nums[start] + nums[end];
				if(sum > target){
					end --;
				}
				else{
					start ++;
				}
				if(Math.abs(sum - target) < Math.abs(result - target)){
					result = sum;
				}
			}
		}
		return result;
	}
	//test
	public static void main(String[] args) {
		int[] s = {-1,2,1,-4};
		int target = 1;
		System.out.println(threeSumClosest(s, target));
	}
}
