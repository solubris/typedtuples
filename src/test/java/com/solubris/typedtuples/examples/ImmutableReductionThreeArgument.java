package com.solubris.typedtuples.examples;

import com.solubris.typedtuples.Couple;
import com.solubris.typedtuples.accumulator.Accumulator;
import com.solubris.typedtuples.accumulator.CoupleAccumulator;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Immutable reduction using three argument reduce
 * <p>
 * These examples compare how to reduce multiple values in a stream, eg:
 * - compute sum(N), sum(N^2)
 */
public class ImmutableReductionThreeArgument {

    @Test
    void computeSumAndSumOfSquaresIntArrayReduction() {
        // compute sum(N), sum(N^2)

        // creates a new int array for each item during reduction
        int[] result = IntStream.rangeClosed(1, 3)
                .boxed()
                .reduce(
                        new int[2],
                        (acc, i) -> new int[]{acc[0] + i, acc[1] + (i * i)},
                        (l, r) -> new int[]{l[0] + r[0], l[1] + r[1]}
                );
        System.out.println(Arrays.toString(result));

        assertThat(result)
                .containsExactly(6, 14);
    }

    /**
     * Can't use the the accumulator for accumulate phase but can use it for the combine
     */
    @Test
    void computeSumAndSumOfSquaresTupleReduction() {
        // compute sum(N), sum(N^2)
        CoupleAccumulator<Integer, Integer> accumulator = Accumulator.of(Integer::sum, Integer::sum);

        Couple<Integer, Integer> result = IntStream.rangeClosed(1, 3)
                .boxed()
                .reduce(
                        ImmutableTuple.of(0, 0),
                        (acc, integer) -> ImmutableTuple.of(acc.getFirst() + integer, acc.get() + (integer*integer)),
                        accumulator::combine
                );
        System.out.println(result);

        assertThat(result)
                .isEqualTo(ImmutableTuple.of(6, 14));
    }
}
