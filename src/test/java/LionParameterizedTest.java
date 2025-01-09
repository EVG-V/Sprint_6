import org.mockito.Mock;
import com.example.Feline;
import com.example.Lion;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class LionParameterizedTest {
    String sex;
    boolean hasMane;

    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Mock
    Feline feline;

    @Parameterized.Parameters()
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void haveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals("Тест не пройден", hasMane, lion.doesHaveMane());
    }
}
