import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline mockFeline;

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        boolean expected = true;
        boolean actual = lion.doesHaveMane();
        MatcherAssert.assertThat(actual, is(expected));
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }

    @Test
    public void checkExceptionTest() {
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion("Недопустимо", mockFeline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}