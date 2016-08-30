package coding.interview.supersimplestocks.trader;

import coding.interview.supersimplestocks.recorder.StockTradeHistory;
import coding.interview.supersimplestocks.recorder.StockTradeRecord;
import coding.interview.supersimplestocks.stock.Stock;
import coding.interview.supersimplestocks.stock.StockSymbol;
import coding.interview.supersimplestocks.stock.StockType;
import junit.framework.TestCase;

import java.math.BigDecimal;

/**
 * Created by yarbong on 21/04/2016.
 */
public class StockTraderTest extends TestCase {

    protected StockTrader stockTrader;

    protected void setUp(){
        stockTrader = new StockTrader(createStock(),createTrade(), createStockTradeHistory());
    }

    public void testTradeStock(){
        Trade trade = stockTrader.tradeStock();
        assertEquals(new BigDecimal(20).doubleValue(),
                trade.getVolumeWeightedStockPrice().doubleValue());
    }

    private StockTradeHistory createStockTradeHistory(){
        StockTradeHistory stockTradeHistory = StockTradeHistory.getInstance();
        stockTradeHistory.addRecord(new StockTradeRecord(StockSymbol.TEA, 100l,"B", new BigDecimal(20)));
        stockTradeHistory.addRecord(new StockTradeRecord(StockSymbol.GIN, 10l,"S", new BigDecimal(80)));
        stockTradeHistory.addRecord(new StockTradeRecord(StockSymbol.ALE, 80l,"B", new BigDecimal(17)));
        stockTradeHistory.addRecord(new StockTradeRecord(StockSymbol.TEA, 100l,"B", new BigDecimal(20)));

        return stockTradeHistory;
    }
    private Stock createStock(){
        return new Stock(StockSymbol.TEA, StockType.COMMON, new BigDecimal(9), new BigDecimal(0),new BigDecimal(100));
    }
    private Trade createTrade(){
        return new Trade(StockSymbol.TEA, new BigDecimal(20), 100l, "B");
    }
}
