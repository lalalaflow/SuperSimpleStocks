package coding.interview.supersimplestocks.trader;

import coding.interview.supersimplestocks.calculator.GeometricMean;
import coding.interview.supersimplestocks.recorder.StockTradeHistory;
import coding.interview.supersimplestocks.recorder.StockTradeRecord;
import coding.interview.supersimplestocks.stock.Stock;
import coding.interview.supersimplestocks.stock.StockDashBoard;
import coding.interview.supersimplestocks.stock.StockFinder;
import coding.interview.supersimplestocks.stock.StockSymbol;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.lang.String;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yarbong on 20/04/2016.
 */
public class MainTrader {

    private StockDashBoard stockDashBoard;
    private StockTradeHistory stockTradeHistory;
    private Trade trade;


    public Trade trade(){
        //TODO - Catch Exceptions
        // stock trade
        Stock stock = findStock();
        StockTrader stockTrader = new StockTrader(stock, getTrade(), getStockTradeHistory());
        this.trade = stockTrader.tradeStock();

        // Calculate the GBCE
        getTrade().setGeometricMean(calculateGeometicMean());
        return getTrade();
    }

    public Stock findStock(){
        StockFinder stockFinder = new StockFinder();
        return stockFinder.findStock(getTrade().getStockSymbol(),getStockDashBoard());
    }

    public BigDecimal calculateGeometicMean() {
        List<BigDecimal> tradeList = new ArrayList<BigDecimal>();

        for (StockTradeRecord stockTradeRecord:stockTradeHistory.getStockTradeRecords()) {
            // Find records for given stock type
            tradeList.add(stockTradeRecord.getPrice());
        }
        return new GeometricMean().calculate(tradeList);
    }

    public StockDashBoard getStockDashBoard() {
        return stockDashBoard;
    }

    public StockTradeHistory getStockTradeHistory() {
        return stockTradeHistory;
    }

    public Trade getTrade() {
        return trade;
    }

    public MainTrader(StockDashBoard stockDashBoard, StockTradeHistory stockTradeHistory,
                      String stockSymbol, BigDecimal tradePrice, long tradeQuantity, String indicator) {
        this.stockDashBoard = stockDashBoard;
        this.stockTradeHistory = stockTradeHistory;
        this.trade = new Trade(StockSymbol.valueOf(stockSymbol),tradePrice,tradeQuantity,indicator);
    }
}
