//Group of anagrams 
/*Medium Level
Logic:Basicallly get an array of 26 length cuz we know only lower case letters so 26
and as you know the way of finding anagrams is to check the count/frequency of the letterrs
Note : You have to return the list of anagramns ie an array of array strigs
*/ 
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}