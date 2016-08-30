package coding.interview.supersimplestocks.calculator;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yarbong on 21/04/2016.
 */
public class GeometricMeanTest  extends TestCase{

    protected GeometricMean geometricMean;

    protected void setUp(){
        geometricMean = new GeometricMean();
    }

    public void testCalculate(){
        List<BigDecimal> priceList = createPriceList();
        BigDecimal geometicMeanValue = geometricMean.calculate(priceList);

        assertEquals(new BigDecimal(24.19018).doubleValue(), geometicMeanValue.doubleValue());
    }

    private List<BigDecimal> createPriceList() {
        List<BigDecimal> priceList = new ArrayList<BigDecimal>();
        priceList.add(new BigDecimal(40));
        priceList.add(new BigDecimal(30));
        priceList.add(new BigDecimal(54));
        priceList.add(new BigDecimal(20));
        priceList.add(new BigDecimal(17));
        priceList.add(new BigDecimal(10));
        priceList.add(new BigDecimal(22));

        return priceList;
    }
}
