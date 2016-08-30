package coding.interview.supersimplestocks.stock;

/**
 * Created by yarbong on 20/04/2016.
 */
public class StockFinder {
    public Stock findStock(StockSymbol stockSymbol, StockDashBoard stockDashBoard){
        Stock theStock = null;
        for (Stock stock:
             stockDashBoard.getStocks()) {
            if(stock.getStockSymbol().equals(stockSymbol)){
                theStock = stock;
                break;
            }

        }
        return theStock;
    }

}
