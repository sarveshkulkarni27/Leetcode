class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] distanceArray = new int[points.length][3];
        int distance = 0;
        int position = 0;
        for(int[] point : points){
            distance = (point[0] * point[0]) + (point[1] * point[1]);
            distanceArray[position][0] = (point[0]);
            distanceArray[position][1] = (point[1]);
            distanceArray[position++][2] = distance;
        }
        Arrays.sort(distanceArray, Comparator.comparingInt(o -> o[2]));
        int[][] kClosestPoints = new int[k][2];
        for(int count = 0; count < k; count++){
            kClosestPoints[count][0] = distanceArray[count][0];
            kClosestPoints[count][1] = distanceArray[count][1];
        }
        return kClosestPoints;
    }
}