public class TwoSum{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndex = new HashMap<>();
        int[] sumIndex = new int[2];

        for(int i = 0; i < nums.length; i++) {
            valueIndex.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if(valueIndex.containsKey(value) && valueIndex.get(value) > i) {
                sumIndex[0] = i;
                sumIndex[1] = valueIndex.get(value);
                return sumIndex;
            }
        }

        return sumIndex;
    }
}