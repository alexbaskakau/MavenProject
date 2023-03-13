
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class BonusServiceTest {

    @ParameterizedTest
    @CsvFileSource(files ="src/test/resources/bonus.csv")
   // @CsvSource({
           // "1000,true,30",
          //  "1000000,true,500",
           // "1000,false,10",
          //  "1000000,false,500",
   // })
    public void shouldCalculateForRegisteredAndUnderLimit(long amount, boolean registered, long expected) {
        BonusService service = new BonusService();

        // подготавливаем данные:
        //pected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    // @Test
    //  void shouldCalculateForRegisteredAndOverLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    // long amount = 1_000_000;
    // boolean registered = true;
    // long expected = 500;

    // вызываем целевой метод:
    // long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    // Assertions.assertEquals(expected, actual);
    //  }

    // @Test
    //  void shouldCalculateForNonRegisteredAndUnderLimit() {
    //  BonusService service = new BonusService();
    // подготавливаем данные:
    //  long amount = 1000;
    // boolean registered = false;
    //  long expected = 10;
    // вызываем целевой метод:
    // long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    // Assertions.assertEquals(expected, actual);
    //  }

    @Test
    void shouldCalculateForNonRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }
}
