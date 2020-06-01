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
import com.solubris.typedtuples.mutable.MutableTuple;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Mutable reduction uses the collect method on a stream
 * <p>
 * These examples compare how to collect multiple values in a stream, eg:
 * - compute sum(N), sum(N^2)
 */
class MutableReduction {

    /**
     * Accumulating the array values is quite verbose
     */
    @Test
    void computeSumAndSumOfSquaresIntArrayCollection() {
        // compute sum(N), sum(N^2)

        int[] result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new int[]{i, i * i})
                .collect(Collector.of(
                        () -> new int[2],
                        (a, t) -> {
                            a[0] += t[0];
                            a[1] += t[1];
                        },
                        (a, b) -> {
                            a[0] += b[0];
                            a[1] += b[1];
                            return a;
                        }
                        )
                );
        System.out.println(Arrays.toString(result));

        assertThat(result)
                .containsExactly(6, 14);
    }

    /**
     * By defining an accumulator, it means it can be used both the accumulate and combine operations in the collector
     * This obviously reduces duplication of redefining the summations for these methods
     */
    @Test
    void computeSumAndSumOfSquaresTupleCollection() {
        // compute sum(N), sum(N^2)
        CoupleAccumulator<Integer, Integer> accumulator = Accumulator.of(Integer::sum, Integer::sum);

        Couple<Integer, Integer> result = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> ImmutableTuple.of(i, i * i))
                .collect(Collector.of(
                        () -> MutableTuple.of(0, 0),
                        accumulator::accumulate,
                        accumulator::combine
                        )
                );
        System.out.println(result);

        assertThat(result)
                .isEqualTo(ImmutableTuple.of(6, 14));
    }
}
