import java.util.ArrayList;
import java.util.List;

class Count_The_Number_Of_Incremovable_Subarrays_I {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> temp = new ArrayList<>();
                for (int k = 0; k < i; k++)
                    temp.add(nums[k]);
                for (int k = j + 1; k < n; k++)
                    temp.add(nums[k]);

                if (isStrictlyIncreasing(temp)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isStrictlyIncreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
