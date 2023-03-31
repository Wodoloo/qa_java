import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {


    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        MatcherAssert.assertThat(actual, is(expected));
    }

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        MatcherAssert.assertThat(actual, is(expected));
    }
}

