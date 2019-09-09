package cupcakes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CupcakesTest {
    static List<String> input = new ArrayList<>();

    static {
        input.add("11 2 5");
        input.add("12 4 4");
        input.add("6 2 2");
    }

    @Test
    public void testcase() throws Exception {
        List<Integer> values = Cupcakes.maximumCupcakes(input);

        assertThat(values).containsExactly(6, 3, 5);
    }
}