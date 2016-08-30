package supersimplestocks.calculator;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.math.BigDecimal;

/**
 * Created by yarbong on 21/04/2016.
 */
public class DividendYieldTest extends TestCase {
    protected DividendYield dividendYield;

    protected void setUp(){
        dividendYield = new DividendYield();
    }

    public void testCalculate_param2(){
        BigDecimal lastDividend = new BigDecimal(40);
        BigDecimal price = new BigDecimal(8);
        BigDecimal dividendYieldValue = dividendYield.calculate(lastDividend,price);

        assertEquals(new BigDecimal(5).doubleValue(), dividendYieldValue.doubleValue());
    }

    public void testCalculate_param3(){
        BigDecimal fixedDividend = new BigDecimal(2).scaleByPowerOfTen(-2);
        BigDecimal price = new BigDecimal(5);
        BigDecimal parValue = new BigDecimal(100);
        BigDecimal dividendYieldValue = dividendYield.calculate(fixedDividend,price, parValue);
        assertEquals(new BigDecimal(4).scaleByPowerOfTen(-1).doubleValue(), dividendYieldValue.doubleValue());;
    }



}
