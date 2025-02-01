import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

 @Mock
 Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        int actualKittensCount = lion.getKittens();
        int expectedKittensCount = 1;
        assertEquals("Тест не пройден", expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals("Тест не пройден", expected, actual);
    }


    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHaveMane = true;
        boolean actualHaveMane = lion.doesHaveMane();
        assertEquals("Тест не пройден", actualHaveMane, expectedHaveMane);
    }

    @Test
    public void doesHaveManeThrowsExceptionTest() {
        try {
            Lion lion = new Lion("jlkjlj", feline);
            fail("При запуске негативного теста использованы неверные входные параметры");
        } catch (Exception exception) {
            String textException = "Используйте допустимые значения пола животного - самец или самка"; // в коде задания опечатка
            Assert.assertEquals(textException, exception.getMessage());
        }
    }
}
