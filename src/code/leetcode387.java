package code;

import java.util.HashMap;
import java.util.Map;

/**
 * 387 字符串中的第一个唯一字符
 * tip 哈希表
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 */
public class leetcode387 {
    public int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char t : array){
            if(map.containsKey(t)){
                map.put(t,map.get(t)+1);
            }else{
                map.put(t,1);
            }
        }

        int i = 0 ;
        for(char t : array){
            if(map.get(t) == 1){
                return i;
            }
            i++;
        }
        return -1;
    }
}
