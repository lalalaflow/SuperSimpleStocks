package coding.interview.supersimplestocks.calculator;

import junit.framework.TestCase;

import java.math.BigDecimal;

/**
 * Created by yarbong on 21/04/2016.
 */
public class PERatioTest extends TestCase {
    protected PERatio peRatio;

    protected void setUp(){
        peRatio = new PERatio();
    }

    public void testCalculate(){
        BigDecimal lastDividend = new BigDecimal(8);
        BigDecimal price = new BigDecimal(2);

        BigDecimal peRatioValue = peRatio.calculate(lastDividend, price);

        assertEquals(new BigDecimal(4).doubleValue(),peRatioValue.doubleValue());
    }
}
