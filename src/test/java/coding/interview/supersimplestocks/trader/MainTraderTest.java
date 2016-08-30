package coding.interview.supersimplestocks.trader;

import coding.interview.supersimplestocks.recorder.StockTradeHistory;
import coding.interview.supersimplestocks.recorder.StockTradeRecord;
import coding.interview.supersimplestocks.stock.Stock;
import coding.interview.supersimplestocks.stock.StockDashBoard;
import coding.interview.supersimplestocks.stock.StockSymbol;
import coding.interview.supersimplestocks.stock.StockType;
import junit.framework.TestCase;

import java.math.BigDecimal;

/**
 * Created by yarbong on 21/04/2016.
 */
public class MainTraderTest extends TestCase {

    protected MainTrader mainTrader;

    protected void setUp(){
        mainTrader = new MainTrader(createStockDatshBoard(),createStockTradeHistory(),
                                    "TEA", new BigDecimal(20), 100l,"B");
    }

    public void testTrade(){
        Trade trade = mainTrader.trade();
        assertEquals(new BigDecimal(10880000).doubleValue() ,trade.getGeometricMean().doubleValue());
    }

    private StockDashBoard createStockDatshBoard(){
        return StockDashBoard.getInstance();
    }

    private StockTradeHistory createStockTradeHistory(){
        StockTradeHistory stockTradeHistory = StockTradeHistory.getInstance();
        stockTradeHistory.addRecord(new StockTradeRecord(StockSymbol.TEA, 100l,"B", new BigDecimal(20)));
        stockTradeHistory.addRecord(new StockTradeRecord(StockSymbol.GIN, 10l,"S", new BigDecimal(80)));
        stockTradeHistory.addRecord(new StockTradeRecord(StockSymbol.ALE, 80l,"B", new BigDecimal(17)));
        stockTradeHistory.addRecord(new StockTradeRecord(StockSymbol.TEA, 100l,"B", new BigDecimal(20)));

        return stockTradeHistory;
    }

}
