import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    //@Parameterized.Parameter
    public String sex;
    // @Parameterized.Parameter(1)
    public boolean expected;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline felineMock;


    public LionParameterizedTest(boolean expected, String sex) {
        this.expected = expected;
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {true,"Самец"},
                {false, "Самка"},
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(felineMock, sex);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

}

