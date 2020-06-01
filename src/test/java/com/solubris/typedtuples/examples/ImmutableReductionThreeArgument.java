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
 * Immutable reduction using three argument reduce
 * <p>
 * These examples compare how to reduce multiple values in a stream, eg:
 * - compute sum(N), sum(N^2)
 */
class ImmutableReductionThreeArgument {

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
