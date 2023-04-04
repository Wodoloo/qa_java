import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.Feline;
import org.hamcrest.MatcherAssert;
import com.example.Cat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline mockFeline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(mockFeline);
        String expected = "Мяу";
        String actual = cat.getSound();
        MatcherAssert.assertThat(actual, is(expected));
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(mockFeline);
        cat.getFood();
        Mockito.verify(mockFeline).eatMeat();
    }
}