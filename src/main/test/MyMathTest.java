import org.junit.Test;
import ru.maks.springcource.MyMath;

public class MyMathTest {
    @Test(expected = ArithmeticException.class)
    public void zeroDenominatorShouldThrowException() {
        MyMath.divide(1, 0);
    }
}
