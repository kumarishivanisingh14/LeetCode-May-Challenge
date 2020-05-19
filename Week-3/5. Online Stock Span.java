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
