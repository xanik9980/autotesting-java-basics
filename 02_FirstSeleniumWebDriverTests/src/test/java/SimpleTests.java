import org.junit.Assert;
import org.junit.Test;

public class SimpleTests {

    @Test
    public void testOver10Days() {
        long actualResult = getRefundTicketPricePercent(10 * 24 + 1, false, false);
        Assert.assertEquals(100L, actualResult);
    }

    @Test
    public void test10Days() {
        long actualResult = getRefundTicketPricePercent(10 * 24, false, false);
        Assert.assertEquals(50L, actualResult);
    }

    @Test
    public void test6Days() {
        long actualResult = getRefundTicketPricePercent(6 * 24, false, false);
        Assert.assertEquals(50L, actualResult);
    }

    @Test
    public void test5Days() {
        long actualResult = getRefundTicketPricePercent(5 * 24, false, false);
        Assert.assertEquals(30L, actualResult);
    }

    @Test
    public void test3Days() {
        long actualResult = getRefundTicketPricePercent(3 * 24 + 1, false, false);
        Assert.assertEquals(30L, actualResult);
    }

    @Test
    public void test72hours() {
        long actualResult = getRefundTicketPricePercent(72, false, false);
        Assert.assertEquals(0L, actualResult);
    }

    @Test
    public void testBefore72hours() {
        long actualResult = getRefundTicketPricePercent(71, false, false);
        Assert.assertEquals(0L, actualResult);
    }

    @Test
    public void testConcertCancelledAndRescheduled() {
        long actualResult = getRefundTicketPricePercent(3 * 24 + 1, true, true);
        Assert.assertEquals(100L, actualResult);
    }

    @Test
    public void testConcertCancelled() {
        long actualResult = getRefundTicketPricePercent(3 * 24 + 1, true, false);
        Assert.assertEquals(30L, actualResult);
    }

    @Test
    public void testConcertRescheduled() {
        long actualResult = getRefundTicketPricePercent(3 * 24 + 1, false, true);
        Assert.assertEquals(30L, actualResult);
    }



    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled) {
        if (wasConcertCancelled && wasConcertRescheduled) return 100;
        if (hoursBeforeConcert>240) return 100;
        if (hoursBeforeConcert>=144 && hoursBeforeConcert<=240) return 50;
        if (hoursBeforeConcert>3 && hoursBeforeConcert<=144) return 30; // баг - 3 вместо 72
        return 0;
    }

}
