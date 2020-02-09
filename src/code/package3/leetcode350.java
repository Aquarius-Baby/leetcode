package code.package3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 350 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 */
public class leetcode350 {
    //
    /**
     *     统计nums1中数字的个数，遍历nums2，进行匹配。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int num1 : nums1){
            int count = map.getOrDefault(num1,0);
            map.put(num1,count + 1);
        }
        List<Integer> list = new LinkedList<>();
        for(int num2 : nums2){
            int count = map.getOrDefault(num2,0);
            if( count > 0){
                list.add(num2);
                map.put(num2,count -1 );
            }
        }
        int size = list.size();
        int[] result = new int[size];
        for(int i = 0 ; i < size; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
