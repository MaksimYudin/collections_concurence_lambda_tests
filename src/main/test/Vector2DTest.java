import org.junit.Assert;
import org.junit.Test;
import ru.maks.springcource.Vector2D;

public class Vector2DTest {
    @Test
    public void newVectorLengthShouldBeEqualsZero() {
        Vector2D vector2D = new Vector2D();

        Assert.assertEquals(0, vector2D.length(), 1e-9);
    }

    @Test
    public void newVectroXShouldBeEqualsZero() {
        Vector2D vector2D = new Vector2D();

        Assert.assertEquals(0, vector2D.getX(), 1e-9);
    }

    @Test
    public void newVectroYShouldBeEqualsZero() {
        Vector2D vector2D = new Vector2D();

        Assert.assertEquals(0, vector2D.getY(), 1e-9);
    }
}
