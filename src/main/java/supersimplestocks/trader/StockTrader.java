package supersimplestocks.trader;

import supersimplestocks.calculator.DividendYield;
import supersimplestocks.calculator.PERatio;
import supersimplestocks.stock.VolumePrice;
import supersimplestocks.calculator.VolumeWeightedStockPrice;
import supersimplestocks.recorder.StockTradeHistory;
import supersimplestocks.recorder.StockTradeRecord;
import supersimplestocks.stock.Stock;
import supersimplestocks.stock.StockType;

import java.math.BigDecimal;
import java.util.*;


/**
 * Created by yarbong on 20/04/2016.
 */
public class StockTrader {

    DividendYield calculatorDividendYield;
    PERatio calculatorPERatio;
    VolumeWeightedStockPrice calculatorVolumeWeightedStockPrice;

    private Stock stock;
    private StockTradeHistory stockTradeHistory;
    private Trade trade;

    private final long MILLISECOND_15_MIN = (1*1000*60*15);

    public Trade tradeStock() {
        //TODO - Catch Exceptions
        getTrade().setDividendYield(calculateDividenYield());
        getTrade().setPeRatio(calculatePERatio());
        long lastRecordTime = recordStockTrade();
        getTrade().setVolumeWeightedStockPrice(calcaulateVolumeWeighedStockPrice(lastRecordTime));
        return getTrade();
    }

    /**
     * Distinguish calculation depends on StockType
     * @return
     */
    public  BigDecimal calculateDividenYield() {

        if (StockType.PREFERRED.equals(stock.getStockType())) {
            return getCalculatorDividendYield()
                    .calculate(getStock().getFixedDividend(), getTrade().getTradePrice(), getStock().getParValue());
        } else {
            return getCalculatorDividendYield()
                    .calculate(getStock().getLastDividend(), getTrade().getTradePrice());
        }
    }

    public BigDecimal calculatePERatio(){
        return getCalculatorPERatio()
                .calculate(getStock().getLastDividend(), getTrade().getTradePrice());
    }

    public long recordStockTrade(){
        StockTradeRecord stockTradeRecord =
                new StockTradeRecord(getStock().getStockSymbol(),getTrade().getTradeQuantity(), getTrade().getIndicator(), getTrade().getTradePrice());

        getStockTradeHistory().addRecord(stockTradeRecord);

        return stockTradeRecord.getTradeTime();
    }

    public BigDecimal calcaulateVolumeWeighedStockPrice(long lastRecordTime){
        List<VolumePrice> volumePriceList = getTradeListForPast15Min(lastRecordTime);
        return getCalculatorVolumeWeightedStockPrice().calculate(volumePriceList);
    }

    public List<VolumePrice> getTradeListForPast15Min(long lastRecordTime){
        // TradeList from history for 15 minutes
        List<VolumePrice> volumePriceList = new ArrayList<VolumePrice>();
        long before15Min = lastRecordTime - MILLISECOND_15_MIN;
        if(stockTradeHistory.getStockTradeRecords() != null) {
            List<StockTradeRecord> records = new LinkedList<StockTradeRecord>(stockTradeHistory.getStockTradeRecords());
            for (int i = (records.size() - 1); i >= 0; i--) {
                StockTradeRecord stockTradeRecord = records.get(i);
                // Find records for given stock type
                if (getStock().getStockSymbol().equals(stockTradeRecord.getStockSymbol())
                        && stockTradeRecord.getTradeTime() > before15Min) {
                    volumePriceList.add(new Trade(stockTradeRecord.getStockSymbol(), stockTradeRecord.getPrice(),
                            stockTradeRecord.getQuantity(), stockTradeRecord.getIndicator()));
                }
            }
        }
        return volumePriceList;
    }

    public DividendYield getCalculatorDividendYield() {
        return calculatorDividendYield;
    }

    public PERatio getCalculatorPERatio() {
        return calculatorPERatio;
    }

    public VolumeWeightedStockPrice getCalculatorVolumeWeightedStockPrice() {
        return calculatorVolumeWeightedStockPrice;
    }

    public Stock getStock() {
        return stock;
    }

    public StockTradeHistory getStockTradeHistory() {
        return stockTradeHistory;
    }

    public Trade getTrade() {
        return trade;
    }

    public StockTrader(Stock stock, Trade trade, StockTradeHistory stockTradeHistory)
    {
        this.calculatorDividendYield = new DividendYield();
        this.calculatorPERatio = new PERatio();
        this.calculatorVolumeWeightedStockPrice = new VolumeWeightedStockPrice();

        this.stock = stock;
        this.stockTradeHistory = stockTradeHistory;
        this.trade = trade;
    }

}
