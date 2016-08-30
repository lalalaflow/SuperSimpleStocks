package coding.interview.supersimplestocks;

import coding.interview.supersimplestocks.recorder.StockTradeHistory;
import coding.interview.supersimplestocks.trader.MainTrader;
import coding.interview.supersimplestocks.trader.Trade;
import coding.interview.supersimplestocks.stock.StockDashBoard;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by yarbong on 19/04/2016.
 */
public class TradeEnterance {
    public static void main(String[] args){
        System.out.println("Welcome to Super Simple Stock Market!! \n");

        StockDashBoard stockDashBoard = new StockDashBoard();
        stockDashBoard.printDashboard();
        System.out.println();

        StockTradeHistory stockTradeHistory = StockTradeHistory.getInstance();

        //TODO - Catch Exceptions

        TraderCaller traderCaller = new TraderCaller(stockDashBoard,stockTradeHistory);
        traderCaller.callTraders();

/*
        Scanner scanner = new Scanner(System.in);
        //1. Receive a stock symbol from the User
        System.out.print("Please, input the stock symbol : ");
        String stockSymbol = scanner.next();

        //2. Receive price from the User
        System.out.print("Please, input the stock price : ");
        BigDecimal tradePrice = new BigDecimal(scanner.next());

        // 3. Receive quantity from the User
        System.out.print("Please, input the trade quantity : ");
        long tradeQuantity = Long.parseLong(scanner.next());

        System.out.print("Buy or Sell? Please, input 'B' or 'S' ");
        String indicator = scanner.next();

        System.out.println("Start trading with "+stockSymbol +" "+ tradePrice +" "+  tradeQuantity +" "+ indicator+"\n\n");

        // 4. Trade
        MainTrader mainTrader = new MainTrader(stockDashBoard, stockTradeHistory,
                stockSymbol, tradePrice, tradeQuantity, indicator);

        // 5. Print Result
        Trade trade = mainTrader.trade();
        System.out.println("Traed Success!!");
        System.out.println("Dividend Yield : " + trade.getDividendYield());
        System.out.println("P/E Ratio : " +  trade.getPeRatio());
        System.out.println("Volume Weighted stock Price for past 15 min. : " +  trade.getVolumeWeightedStockPrice());

        System.out.println("GBCE (by using Geometric Mean)  : " + trade.getGeometricMean());
*/

    }

}
