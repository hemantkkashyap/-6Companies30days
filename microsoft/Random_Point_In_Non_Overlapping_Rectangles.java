import java.util.Random;

class Random_Point_In_Non_Overlapping_Rectangles {
    private int[][] rects;
    private int[] prefixSum;
    private Random rand;
    
    public Random_Point_In_Non_Overlapping_Rectangles(int[][] rects) {
        this.rects = rects;
        this.rand = new Random();
        this.prefixSum = new int[rects.length];
        
        int sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int x1 = rects[i][0];
            int y1 = rects[i][1];
            int x2 = rects[i][2];
            int y2 = rects[i][3];
            sum += (x2 - x1 + 1) * (y2 - y1 + 1);
            prefixSum[i] = sum;
        }
    }
    
    public int[] pick() {
        int target = rand.nextInt(prefixSum[prefixSum.length - 1]);
        int low = 0, high = prefixSum.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefixSum[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        int[] rect = rects[low];
        int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
        int width = x2 - x1 + 1;
        int height = y2 - y1 + 1;
        
        int x = x1 + rand.nextInt(width);
        int y = y1 + rand.nextInt(height);
        
        return new int[]{x, y};
    }
}
