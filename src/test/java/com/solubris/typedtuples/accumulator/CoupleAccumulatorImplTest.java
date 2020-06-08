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

package com.solubris.typedtuples.accumulator;

import com.solubris.typedtuples.mutable.MutableTuple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CoupleAccumulatorImplTest {
    final int a = 0;

    final int b = 1;

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFirst(Integer value) {
        CoupleAccumulatorImpl<Integer, Integer> underTest = new CoupleAccumulatorImpl<>((l, r) -> a, (l, r) -> value);
        var actual = underTest.getFirst().apply(null, null);
        Assertions.assertThat(actual).isEqualTo(a);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void get(Integer value) {
        CoupleAccumulatorImpl<Integer, Integer> underTest = new CoupleAccumulatorImpl<>((l, r) -> a, (l, r) -> value);
        var actual = underTest.get().apply(null, null);
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void accumulate(Integer value) {
        CoupleAccumulatorImpl<Integer, Integer> underTest = new CoupleAccumulatorImpl<>((l, r) -> a, (l, r) -> value);
        var acc = MutableTuple.of(1, 1);
        var t = MutableTuple.of(1, 1);
        underTest.accumulate(acc, t);
        Assertions.assertThat(acc.getFirst()).isEqualTo(a);
        Assertions.assertThat(acc.get()).isEqualTo(value);
    }
}
