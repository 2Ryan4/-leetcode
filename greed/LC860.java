package greed;

public class LC860 {
    public boolean lemonadeChange(int[] bills) {
        //代表拥有5,10元的零钱
        int[] charge = new int[2];

        for (int i = 0; i < bills.length; i++) {
            //顾客给5元不用找零钱
            if (bills[i] == 5) {
                charge[0]++;
            } else if (bills[i] == 10) {
                //顾客给10元，要找5元的零钱
                charge[0]--;
                if (charge[0] < 0) {
                    return false;
                }
                charge[1]++;
            } else {
                //顾客给20元，要找15块零钱，优先给10元加5元的零钱组合
                if (charge[1] > 0 && charge[0] > 0) {
                    charge[1]--;
                    charge[0]--;
                } else if (charge[0] >= 3) {
                    charge[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
