Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].

 Solution :   
class StockSpanner {
    LinkedList<Integer> prices;
    LinkedList<Integer> spans;
    public StockSpanner() {
        prices = new LinkedList<>();
        spans = new LinkedList<>();
    }
    
    public int next(int price) {
        int span = 1;
        int index = prices.size()-1;
        while(index >= 0 && price >= prices.get(index)){
            span += spans.get(index);
            index -= spans.get(index);
        }
        spans.add(span);
        prices.add(price);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
