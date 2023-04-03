import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class KittensParameterizedTest {

    private int kittensCount;
    private int expected;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getKittensCountData() {
        return new Object[][]{
                {1, 1},
                {0, 0},
                {-1, -1},
                {1000, 1000}
        };
    }

    public KittensParameterizedTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Test
    public void KittensReturnsCorrectCount() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        MatcherAssert.assertThat(actual, is(expected));
    }
}

