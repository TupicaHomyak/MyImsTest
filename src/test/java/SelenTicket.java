import org.junit.Assert;
import org.junit.Test;

public class SelenTicket {
    private String getRefundTicketPricePercent(Integer hoursBeforeConcert,
                                               Boolean wasConcertCancelled,
                                               Boolean wasConcertRescheduled) {

        if((wasConcertCancelled == true) || (wasConcertRescheduled == true))
            return "100";
        if((hoursBeforeConcert>240) && (wasConcertCancelled == false) && (wasConcertRescheduled == false))
            return "100";
        if((hoursBeforeConcert>=144 && hoursBeforeConcert<=240) && (wasConcertCancelled == false) && (wasConcertRescheduled == false))
            return "50";
        if((hoursBeforeConcert>72 && hoursBeforeConcert<=144) && (wasConcertCancelled == false) && (wasConcertRescheduled == false))
            return "30";
        return "0";
    }
    @Test
    public void test11(){
        var actualResult = getRefundTicketPricePercent( 280, false,false);
        Assert.assertEquals("100", actualResult);
        System.out.println("за 280ч - " + actualResult);
    }
    @Test
    public void test7(){
        var actualResult = getRefundTicketPricePercent( 144, false,false);
        Assert.assertEquals("50", actualResult);
        System.out.println("за 144ч - " + actualResult);
    }
    @Test
    public void test7Cancelled(){
        var actualResult = getRefundTicketPricePercent( 144, true,false);
        Assert.assertEquals("100", actualResult);
        System.out.println("за 144ч при отмене - " + actualResult);
    }
    @Test
    public void test3Rescheduled(){
        var actualResult = getRefundTicketPricePercent( 75, false,true);
        Assert.assertEquals("100", actualResult);
        System.out.println("за 75ч при переносе - " + actualResult);
    }
    @Test
    public void test3(){
        var actualResult = getRefundTicketPricePercent( 75, false,false);
        Assert.assertEquals("30", actualResult);
        System.out.println("за 75ч - " + actualResult);
    }
    @Test
    public void test1(){
        var actualResult = getRefundTicketPricePercent( 24, false,false);
        Assert.assertEquals("0", actualResult);
        System.out.println("за 24ч - " + actualResult);
    }
    @Test
    public void test1Rescheduled(){
        var actualResult = getRefundTicketPricePercent( 24, false,true);
        Assert.assertEquals("100", actualResult);
        System.out.println("за 24ч при переносе - " + actualResult);
    }

}
