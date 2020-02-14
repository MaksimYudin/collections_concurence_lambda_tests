import org.junit.Test;
import ru.maks.springcource.ServerUtil;

public class ServerUtilTest {
    @Test(timeout = 1000)
    public void timeShouldBeFasterOneSecond() {
        ServerUtil serverUtil = new ServerUtil();
        serverUtil.connect();
    }
}
