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

import com.solubris.typedtuples.immutable.ImmutableTuple;
import com.solubris.typedtuples.mutable.MutableTuple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class SingleAccumulatorImplTest {
    final int a = 0;

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void get(Integer value) {
        SingleAccumulatorImpl<Integer> underTest = new SingleAccumulatorImpl<>((l, r) -> value);
        var actual = underTest.get().apply(null, null);
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void accumulate(Integer value) {
        SingleAccumulatorImpl<Integer> underTest = new SingleAccumulatorImpl<>((l, r) -> value);
        var expected = MutableTuple.of(value);
        var acc = MutableTuple.of(1);
        var t = MutableTuple.of(1);
        underTest.accumulate(acc, t);
        Assertions.assertThat(acc).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mutableCombine(Integer value) {
        SingleAccumulatorImpl<Integer> underTest = new SingleAccumulatorImpl<>((l, r) -> value);
        var expected = MutableTuple.of(value);
        var l = MutableTuple.of(1);
        var r = MutableTuple.of(1);
        var actual = underTest.combine(l, r);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void immutableCombine(Integer value) {
        SingleAccumulatorImpl<Integer> underTest = new SingleAccumulatorImpl<>((l, r) -> value);
        var expected = ImmutableTuple.of(value);
        var l = ImmutableTuple.of(1);
        var r = ImmutableTuple.of(1);
        var actual = underTest.combine(l, r);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
