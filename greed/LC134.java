package greed;

public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;//一圈之后剩余的油量
        int curSum = 0;//当前到站剩余的油量
        int start = 0;//开始的汽油站

        for (int i = 0; i < gas.length; i++) {
            curSum += (gas[i] - cost[i]);
            totalSum += (gas[i] - cost[i]);
            //若当前剩余油量小于0，则开始的汽油站为i + 1
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        //若一圈之后剩余油量小于0， 说明无论从哪个汽油站出发都不能跑完一圈
        if (totalSum < 0) {
            return -1;
        }

        return start;
    }
}
