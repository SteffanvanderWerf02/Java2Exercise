import java.util.ArrayList;

public class Money {

    /**
     * Round the amount to nearest integer value
     *
     * @param amount
     * @return rounded amount
     */
    public long round(double amount) {
        return Math.round(amount);
    }

    /**
     * Returns the amount with the interest rate
     *
     * @param amount       amount to add the interest to
     * @param interestRate the interest rate as a percentage
     * @return
     */
    public double addInterest(double amount, double interestRate) {
        return amount + (amount * (interestRate / 100));
    }

    /** *  Returns the smallest sequence of coins * to represent the input argument.
     *  Possible coins:
     *   1, 2, 5, 10, 20 and 50 cent and
     *   1 and 2 euro (100 and 200 cent)
      */

    public ArrayList<Integer> exchange (int amount)
    {
        ArrayList<Integer> result= new ArrayList<>();
        int[] coins = { 200, 100, 50, 20, 10,5,2,1};
        for(int coin: coins) {
            for (int i = 0;i< amount/ coin;i++)
            {
                result.add(coin);
            }
            amount = amount - (amount/ coin)* coin;
        }
        return result;
    }
}