package supersimplestocks.calculator;

import supersimplestocks.stock.VolumePrice;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yarbong on 21/04/2016.
 */
public class VolumeWeightedStockPriceTest extends TestCase{

    protected VolumeWeightedStockPrice volumeWeightedStockPrice;

    protected void setUp(){
        volumeWeightedStockPrice = new VolumeWeightedStockPrice();
    }

    public void testCalculate(){

        List<VolumePrice> volumePriceList = createVolumePriceList();

        BigDecimal volumeWeightedStockPriceValue =
                volumeWeightedStockPrice.calculate(volumePriceList);

        assertEquals(new BigDecimal(14).doubleValue(), volumeWeightedStockPriceValue.doubleValue());
    }

    private List<VolumePrice> createVolumePriceList(){
        List<VolumePrice> volumePrices = new ArrayList<VolumePrice>();
        volumePrices.add(new VolumePrice(new BigDecimal(20), 100l));
        volumePrices.add(new VolumePrice(new BigDecimal(10), 10l));
        volumePrices.add(new VolumePrice(new BigDecimal(5), 50l));
        volumePrices.add(new VolumePrice(new BigDecimal(7), 30l));
        volumePrices.add(new VolumePrice(new BigDecimal(17), 50l));

        return volumePrices;
    }
}
