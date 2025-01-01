import java.util.Arrays;

public class Minimum_Moves_To_Equal_Array_Elements {
        public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int moves = 0;
        
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        
        return moves;
    }
}
