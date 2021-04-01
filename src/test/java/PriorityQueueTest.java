import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {

    public static Stream<Arguments> getParameters(){
        return Stream.of(
                arguments(new int[]{1, 3, 2, 4}, new int[]{1, 2, 3, 4}),
                arguments(new int[]{5, 4, 2, 3}, new int[]{2, 3, 4, 5}),
                arguments(new int[]{6, 2, 9, 7}, new int[]{2, 6, 7, 9}),
                arguments(new int[]{2, 6, 4, 9}, new int[]{2, 4, 6, 9}),
                arguments(new int[]{0, 3, 5, 8}, new int[]{0, 3, 5, 8})

        );
    }

    @ParameterizedTest
    @MethodSource("getParameters")
    public void parameterizedTest(int[] input, int[] expected){
        PriorityQueue pqInput = new PriorityQueue();
        for (int e : input) {
            pqInput.offer(e);
        }
        for (int e : expected) {
            assertEquals(e, pqInput.poll());
        }
    }

    @Test
    public void InitialCapacityTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, null);
        });
    }

    @Test
    public void OfferTest(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().offer(null);
        });
    }

    @Test
    publicvoid ForEachRemainingTest(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().forEach(null);
        });
    }
}
