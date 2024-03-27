import org.junit.Assert;
import org.junit.Test;

public class SimpleIMTTest {
    @Test
    public void testNormal(){
        var actualResult = getIMTResult( 180f, 75f);
        Assert.assertNotEquals("нормальная масса тела: ", actualResult);
    }
    @Test
    public void testNotHeight(){
        var actualResult = getIMTResult( 0f, 75f);
        Assert.assertNotEquals("ошибка в данных: ", actualResult);
    }
    @Test
    public void testNotWeight(){
        var actualResult = getIMTResult( 180f, 0f);
        Assert.assertNotEquals("ошибка в данных: ", actualResult);
    }

    private String getIMTResult(Float heightCm, Float weightKg)
    {
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;

        if ((heightCm.equals(0.0f))||(weightKg.equals(0.0f))) {
            userResult += "ошибка в данных";
        } else if(userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex < 19)  {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }
        return userResult;
    }


    private String getMarkResult(Integer mark)
    {
        if(mark>=0 && mark <=35) return "2";
        if(mark>35 && mark <=56) return "3";
        if(mark>56 && mark<71) return "4";
        if(mark>72 && mark<100) return "5";
        return "no mark result";
    }

    @Test
    public void testMark2() {
        var actualResult = getMarkResult(24);
        Assert.assertEquals("2", actualResult);
    }
    @Test
    public void testMark3() {
        var actualResult = getMarkResult(44);
        Assert.assertEquals("3", actualResult);
    }
    @Test
    public void testMark4() {
        var actualResult = getMarkResult(58);
        Assert.assertEquals("4", actualResult);
    }
    @Test
    public void testMark5() {
        var actualResult = getMarkResult(76);
        Assert.assertEquals("5", actualResult);
    }
    @Test
    public void testMark0() {
        var actualResult = getMarkResult(104);
        Assert.assertEquals("no mark result", actualResult);
    }



}
