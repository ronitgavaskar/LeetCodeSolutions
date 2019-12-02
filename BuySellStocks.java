// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

// Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).


// Ronits Thinking
// Essentially the profit is only generated from increasing stocks or more precisely, non-decreasing
// so we need a helper method that would check the indices for the start of increasing trend and end of trend

// Then we need a helper method to find the profit combined of everything
class BuySellStocks {
    public int maxProfit(int[] prices) {
        // helper method for finding index of increasing trends
        ArrayList<List<Integer>> values = findIncreasing(prices);
        if (!values.isEmpty()) {
            int maxProf = getTotalProfit(values);
            return maxProf;
        }

        return 0;
    }
    
    
    public ArrayList<List<Integer>> findIncreasing(int[] prices) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        List<Integer> ind = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            // if increasing in value
            if (prices[i] < prices[i + 1]){
                // if nothings been added yet
                if (count == 0) {
                    //add start of trend
                    ind.add(i);
                    count++;
                }
                //if your indices are not empty and you're at the last index of the array then you know its the last day of increasing trend so just add it
                if (i + 1 == prices.length - 1 && !ind.isEmpty()) {
                    ind.add(i + 1);
                    count++;
                }
            } else {
                // if you see that the next day is decreasing, then you're currently at the peak so add this index
                if (count > 0) {
                    ind.add(i);
                    count++;
                }
            }
             
            //Since I declared that the pair would be lowest day and highest day, then do the following
            if (count == 2) {
                //take diff and add (this will be the profit)
                int profit = prices[ind.get(1)] - prices[ind.get(0)]; 
                ind.add(profit);
                // this above profit is from this particular trend
                ret.add(ind);
                count = 0;
                ind = new ArrayList<>();
            }
        }
        return ret;
    }

    public int getTotalProfit(ArrayList<List<Integer>> values) {
        // remember we only reached here since we have seen atleast one increasing trend
        // the prof variable will be the total profit reached throughout the array
        int prof= 0;
        for (int i = 0; i < values.size(); i++) {
            prof += values.get(i).get(2);
        }
        return prof;
    }
}
