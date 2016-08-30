package supersimplestocks.recorder;

import java.util.*;

/**
 * Created by yarbong on 20/04/2016.
 */
public class StockTradeHistory {


    private static StockTradeHistory stockTradeHistory;
    private List<StockTradeRecord> stockTradeRecords;


    public synchronized static StockTradeHistory getInstance(){

        if(stockTradeHistory == null){
            stockTradeHistory = new StockTradeHistory();
        }

        return stockTradeHistory;
    }

    public synchronized void addRecord(StockTradeRecord stockTradeRecord){
        stockTradeRecords.add(stockTradeRecord);
    }

    public List<StockTradeRecord> getStockTradeRecords() {

        return stockTradeRecords;
    }

    public StockTradeHistory() {
        if(stockTradeRecords == null) {
            this.stockTradeRecords = new LinkedList<StockTradeRecord>();
        }
    }
}
