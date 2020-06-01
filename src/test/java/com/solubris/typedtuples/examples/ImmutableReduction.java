/*
 * Copyright 2020 Solubris Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
 * Immutable reduction uses the reduce method on a stream
 * <p>
 * These examples compare how to reduce multiple values in a stream, eg:
 * - compute sum(N), sum(N^2)
 * - compute sum(N), sum(sqrt(N)) -- requires different types
 */
public class ImmutableReduction {

    @Test
    void computeSumAndSumOfSquaresIntArrayReduction() {
        // compute sum(N), sum(N^2)

        // creates a new int array for each item during reduction
        int[] result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new int[]{i, i * i})
                .reduce(
                        new int[2],
                        (l, r) -> new int[]{l[0] + r[0], l[1] + r[1]}
                );
        System.out.println(Arrays.toString(result));

        assertThat(result)
                .containsExactly(6, 14);
    }

    /**
     * Uses tuples and an accumulator tuple for reduction
     * No ugly array creation
     */
    @Test
    void computeSumAndSumOfSquaresTupleReduction() {
        // compute sum(N), sum(N^2)
        CoupleAccumulator<Integer, Integer> accumulator = Accumulator.of(Integer::sum, Integer::sum);

        Couple<Integer, Integer> result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> ImmutableTuple.of(i, i * i))
                .reduce(
                        ImmutableTuple.of(0, 0),
                        accumulator::combine
                );
        System.out.println(result);

        assertThat(result)
                .isEqualTo(ImmutableTuple.of(6, 14));
    }

    /**
     * Need to use Number[] to handle different types
     * And intValue()/doubleValue() in the reduction
     */
    @Test
    void computeSumAndSumOfSquareRootsNumberArrayReduction() {
        // compute sum(N), sum(sqrt(N))

        // creates a new int array for each item during reduction
        Number[] result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new Number[]{i, Math.sqrt(i)})
                .reduce(
                        new Number[]{0, 0},
                        (l, r) -> new Number[]{l[0].intValue() + r[0].intValue(), l[1].doubleValue() + r[1].doubleValue()}
                );
        System.out.println(Arrays.toString(result));

        assertThat(result)
                .containsExactly(6, 4.146264369941973);
    }

    @Test
    void computeSumAndSumOfSquareRootsTupleReduction() throws Exception {
        // compute sum(N), sum(sqrt(N))
        CoupleAccumulator<Integer, Double> accumulator = Accumulator.of(Integer::sum, Double::sum);

        Couple<Integer, Double> result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> ImmutableTuple.of(i, Math.sqrt(i)))
                .reduce(
                        ImmutableTuple.of(0, 0D),
                        accumulator::combine
                );
        System.out.println(result);

        assertThat(result)
                .isEqualTo(ImmutableTuple.of(6, 4.146264369941973));
    }
}
