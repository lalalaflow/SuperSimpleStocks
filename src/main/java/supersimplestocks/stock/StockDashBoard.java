package supersimplestocks.stock;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by yarbong on 20/04/2016.
 */
public class StockDashBoard {

    private static StockDashBoard stockDashBoard;
    private Set<Stock> stocks;

    public synchronized static StockDashBoard getInstance(){
        if(stockDashBoard == null){
            stockDashBoard = new StockDashBoard();
        }

        return stockDashBoard;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public Set<Stock> getStocks() {
        checkStocks();
        return new TreeSet<Stock>(stocks);
    }

    public synchronized void addStock(Stock stock){
        checkStocks();
        stocks.add(stock);
    }

    private void checkStocks(){
        if(stocks == null){
            stocks = new TreeSet<Stock>();
        }
    }

    public StockDashBoard(){
        checkStocks();
        stocks.add(new Stock(StockSymbol.TEA, StockType.COMMON, BigDecimal.ZERO, new BigDecimal(-1), new BigDecimal(100)));
        stocks.add(new Stock(StockSymbol.POP, StockType.COMMON, new BigDecimal(8), new BigDecimal(-1), new BigDecimal(100)));
        stocks.add(new Stock(StockSymbol.ALE, StockType.COMMON,new BigDecimal(8), new BigDecimal(2), new BigDecimal(100)));
        stocks.add(new Stock(StockSymbol.GIN, StockType.PREFERRED,new BigDecimal(23), new BigDecimal(-1), new BigDecimal(60)));
        stocks.add(new Stock(StockSymbol.JOE, StockType.COMMON,new BigDecimal(13), new BigDecimal(-1), new BigDecimal(250)));
        stocks.add(new Stock(StockSymbol.JOE, StockType.COMMON,new BigDecimal(13), new BigDecimal(-1), new BigDecimal(250)));
    }

    public void printDashboard(){

        System.out.println("Symbol" +"\t\t"+ "Type"+"\t\t"+"Last Dividend"+"\t\t"+"Fixed Dividend"+"\t\t"+"Par Value");
        for (Stock stock:getStocks()) {
            System.out.println(stock.getStockSymbol()
                    +"\t\t\t"+ stock.getStockType()
                    +(stock.getStockType().equals(StockType.COMMON)?"\t\t\t\t":"\t\t\t")+ stock.getLastDividend()
                    +"\t\t\t\t"+(stock.getFixedDividend().compareTo(BigDecimal.ZERO)>0? stock.getFixedDividend().scaleByPowerOfTen(2) +"%" : " ")
                    +"\t\t\t\t"+ stock.getParValue()
            );
        }
    }
}
