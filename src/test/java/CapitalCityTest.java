import com.napier.sem.CapitalCity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CapitalCityTest
{
    static CapitalCity capitalcity = new CapitalCity();

    @Test
    void getCapCityWorldPop()

    {
       assertNotNull(capitalcity.getCapCityWorldPop());
    }

    @Test
    void getCapCityContPop()
    {
        assertNotNull(capitalcity.getCapCityContPop("Asia"));
    }

    @Test
    void getCapCityRegPop()

    {
        assertNotNull(capitalcity.getCapCityRegPop("Eastern Europe"));
    }

    @Test
    void getCapCityWorldPopLimit()

    {
        assertNotNull(capitalcity.getCapCityWorldPopLimit("10"));
    }

    @Test
    void getCapCityContPopLimit()

    {
        assertNotNull(capitalcity.getCapCityContPopLimit("Asia", "10"));
    }

    @Test
    void getCapCityRegPopLimit()
    {
        assertNotNull(capitalcity.getCapCityRegPopLimit("Eastern Europe", "10"));
    }

}
