package LeetCode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bobo on 2015/9/13.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> list = new LinkedList<>();
        if (candidates.length == 0) return list;
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++){
            if (target == 0)
//                list.add();
            ;
            else
                target -= candidates[i];
        }
        return list;
    }
}
