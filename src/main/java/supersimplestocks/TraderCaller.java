package supersimplestocks;

import supersimplestocks.recorder.StockTradeHistory;
import supersimplestocks.stock.StockDashBoard;
import supersimplestocks.trader.MainTrader;
import supersimplestocks.trader.Trade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yarbong on 21/04/2016.
 */
public class TraderCaller {
    private List<MainTrader> mainTraders;



    public void callTraders(){

        for (MainTrader mainTrader: mainTraders) {
            Trade trade = mainTrader.trade();
            System.out.println("Traed Success!!");
            System.out.println("Stock Symbol : "+trade.getStockSymbol().toString());
            System.out.println("Trade Price : " + trade.getTradePrice());
            System.out.println("Trade Quantity : "+trade.getTradeQuantity());
            System.out.println("Dividend Yield : " + trade.getDividendYield());
            System.out.println("P/E Ratio : " +  trade.getPeRatio());
            System.out.println("Volume Weighted stock Price for past 15 min. : " +  trade.getVolumeWeightedStockPrice());

            System.out.println("GBCE (by using Geometric Mean)  : " + trade.getGeometricMean());
            System.out.println("\n\n");
        }
    }

    public TraderCaller(StockDashBoard stockDashBoard, StockTradeHistory stockTradeHistory) {
        this.mainTraders = new ArrayList<MainTrader>();
        this.mainTraders.add(new MainTrader(stockDashBoard, stockTradeHistory,"TEA", new BigDecimal(20), 100l,"B"));
        this.mainTraders.add(new MainTrader(stockDashBoard, stockTradeHistory,"GIN", new BigDecimal(10), 80l,"S"));
        this.mainTraders.add(new MainTrader(stockDashBoard, stockTradeHistory,"ALE", new BigDecimal(17), 34L,"B"));
        this.mainTraders.add(new MainTrader(stockDashBoard, stockTradeHistory,"TEA", new BigDecimal(10), 67L,"B"));
        this.mainTraders.add(new MainTrader(stockDashBoard, stockTradeHistory,"JOE", new BigDecimal(52), 78l,"S"));
        this.mainTraders.add(new MainTrader(stockDashBoard, stockTradeHistory,"POP", new BigDecimal(28), 90l,"B"));
        this.mainTraders.add(new MainTrader(stockDashBoard, stockTradeHistory,"TEA", new BigDecimal(70), 300l,"B"));
        this.mainTraders.add(new MainTrader(stockDashBoard, stockTradeHistory,"ALE", new BigDecimal(40), 54l,"S"));
        this.mainTraders.add(new MainTrader(stockDashBoard, stockTradeHistory,"POP", new BigDecimal(34), 23l,"B"));
        this.mainTraders.add(new MainTrader(stockDashBoard, stockTradeHistory,"ALE", new BigDecimal(56), 89l,"B"));
    }
}
