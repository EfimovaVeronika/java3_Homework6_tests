import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestArrMethods {


    @ParameterizedTest
    @MethodSource ("test1RemainArrLastFour")
    public void testRemainArrLastFour ( int [] arr, int [] arrResult ) {
        ArrMethods arrMethods = new ArrMethods();
        Assertions.assertArrayEquals(arrResult, arrMethods.remainArrLastFour(arr));

    }

    public static Stream<Arguments> test1RemainArrLastFour () {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] { 1, 1, 1, 4},new int[] {}));
        out.add(Arguments.arguments(new int[] { 4, 4 , 4, 9, 8, 7}, new int[] { 9, 8, 7}));
        out.add(Arguments.arguments(new int[] { 4, 4 , 4, 9, 6, 5}, new int[] { 9, 6, 5}));
        out.add(Arguments.arguments(new int[] { 4, 0, 0, 0}, new int[] {0, 0, 0}));
        return out.stream();
    }

    @Test
    public void testArrayWithoutFourException () {
        ArrMethods arrMethods = new ArrMethods();
        Assertions.assertThrows(RuntimeException.class, () -> {
            arrMethods.remainArrLastFour(new int[] {1, 1, 1, 1, 1});
        });
    }

    @Test
    public void test1ArrayNullException () {
        ArrMethods arrMethods = new ArrMethods();
        Assertions.assertThrows(RuntimeException.class, () -> {
            arrMethods.remainArrLastFour(new int[] {});
        });
    }


    @ParameterizedTest
    @MethodSource ("test1OneAndFourArr")
    public void testOneAndFourArr ( int [] arr, boolean result) {
        ArrMethods arrMethods = new ArrMethods();
        Assertions.assertEquals(result, arrMethods.oneAndFourArr(arr));

    }

    public static Stream<Arguments> test1OneAndFourArr () {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] { 1, 1, 1, 4}, true));
        out.add(Arguments.arguments(new int[] { 4, 4 , 4}, false));
        out.add(Arguments.arguments(new int[] { 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[] { 1, 3, 1, 4}, false));
        return out.stream();
    }

    @Test
    public void test2ArrayNullException () {
        ArrMethods arrMethods = new ArrMethods();
        Assertions.assertThrows(RuntimeException.class, () -> {
         arrMethods.oneAndFourArr(new int[] {});
        });
    }

}

