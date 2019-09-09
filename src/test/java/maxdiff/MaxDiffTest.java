package maxdiff;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxDiffTest {
    private static List<Integer> input;

    @Test
    public void testcase1() throws Exception {
        input = new ArrayList<>();

        input.add(7);
        input.add(2);
        input.add(3);
        input.add(10);
        input.add(2);
        input.add(4);
        input.add(8);
        input.add(1);

        assertThat(
                MaxDiff.maxDifference(input)
        ).isEqualTo(8);
    }

    @Test
    public void testcase2() throws Exception {
        input = new ArrayList<>();

        input.add(5);
        input.add(10);
        input.add(8);
        input.add(7);
        input.add(6);
        input.add(5);

        assertThat(
                MaxDiff.maxDifference(input)
        ).isEqualTo(-1);
    }

    @Test
    public void testcase3() throws Exception {
        input = new ArrayList<>();

        input.add(6);
        input.add(7);
        input.add(9);
        input.add(5);
        input.add(6);
        input.add(3);
        input.add(2);

        assertThat(
                MaxDiff.maxDifference(input)
        ).isEqualTo(2);
    }

    @Test
    public void testcase4() throws Exception {
        input = new ArrayList<>();

        input.add(4);
        input.add(1);
        input.add(2);
        input.add(6);
        input.add(4);

        assertThat(
                MaxDiff.maxDifference(input)
        ).isEqualTo(5);
    }

    @Test
    public void testcase5() throws Exception {
        input = new ArrayList<>();

        input.add(5);
        input.add(5);
        input.add(4);
        input.add(3);
        input.add(2);
        input.add(1);

        assertThat(
                MaxDiff.maxDifference(input)
        ).isEqualTo(-1);
    }

    @Test
    public void testcase6() throws Exception {
        input = new ArrayList<>();

        input.add(4);
        input.add(1);
        input.add(2);
        input.add(6);
        input.add(4);

        assertThat(
                MaxDiff.maxDifference(input)
        ).isEqualTo(5);
    }
}