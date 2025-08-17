/* K frequent elements : ie find the k times most frequent elements
Level :Medium 

Logic: We need to find the K times most frequent time elements in the array so the 
linear time complexity looks like thi
creare a array or an hashmap of length n but now the index of this array doesnot defines
the position but the frequency of the element and using hashmap you can easily find out
the count of the elements. So u have n elements given in an array so the max freq can 
never be greater than n .And it id very obivous that a single index can conatain more
than 1 number so its not an array use a map cuz u need to map an list of numbers 
to the corresponding index.And finally iterate the map in an descending oder till u 
get k numbers
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}