public class StocksMoney {
    public static void main(String[] args) {
        int[] a = new int[]{3,8,5,1,7,8};
        int money = calculateMax(a);
        System.out.println(money);
    }
    private static int calculateMax(int[] prices) {
        int firstBuy = Integer.MAX_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        for (int price:prices) {
            firstBuy = Math.min(firstBuy,price);
            firstSell  = Math.max(firstSell,price - firstBuy);
            secondBuy = Math.max(secondBuy,firstSell - price);
            secondSell = Math.max(secondSell,secondBuy + price);
        }
        return secondSell;
    }
}
