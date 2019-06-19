package LeetCode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 和3Sum差不多的方法，只不过在外层再加了一层for语句。
 * 
 * @author bobo 2015年9月9日下午10:38:49
 */
public class _4Sum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new LinkedList<>();
		if (nums.length < 4) return list;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) continue;
				int l = j + 1;
				int r = nums.length - 1;
				while (l < r) {
					if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
						list.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
						while (l < r && nums[l] == nums[l + 1]) l++;
						while (l < r && nums[r] == nums[r - 1]) r--;
						l++;
						r--;
					}
					else if (nums[i] + nums[j] + nums[l] + nums[r] < target) l++;
					else r--;
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] num = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		List<List<Integer>> list = fourSum(num, target);
		for (List<Integer> list2 : list) {
			for (Integer integer : list2) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
