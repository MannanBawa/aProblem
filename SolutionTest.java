import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SolutionTest {

    @Test
    public void TestZero() {
        Solution thisSoln = new Solution();
        int result = thisSoln.addFive(-999);
        int improvedResult = thisSoln.addFiveImproved(-999);
        assertEquals(-5999, result);
        assertEquals(-5999, improvedResult);
    }

    @Test
    public void TestOne() {
        Solution thisSoln = new Solution();
        int result = thisSoln.addFive(-1234);
        int improvedResult = thisSoln.addFiveImproved(-1234);
        assertEquals(-12345, result);
        assertEquals(-12345, improvedResult);
    }

    @Test
    public void TestTwo() {
        Solution thisSoln = new Solution();
        int result = thisSoln.addFive(98765);
        int improvedResult = thisSoln.addFiveImproved(98765);
        assertEquals(987655, result);
        assertEquals(987655, improvedResult);
    }

    @Test
    public void TestThree() {
        Solution thisSoln = new Solution();
        int result = thisSoln.addFive(1234);
        int improvedResult = thisSoln.addFiveImproved(1234);
        assertEquals(51234, result);
        assertEquals(51234, improvedResult);
    }

    @Test
    public void TestFour() {
        Solution thisSoln = new Solution();
        int result = thisSoln.addFive(-465);
        int improvedResult = thisSoln.addFive(-465);
        assertEquals(-4565, result);
        assertEquals(-4565, improvedResult);
    }

    @Test
    public void TestFive() {
        Solution thisSoln = new Solution();
        int result = thisSoln.addFive(96472);
        int improvedResult = thisSoln.addFiveImproved(96472);
        assertEquals(965472, result);
        assertEquals(965472, improvedResult);
    }



}
