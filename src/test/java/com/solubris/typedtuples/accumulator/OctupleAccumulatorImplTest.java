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

class OctupleAccumulatorImplTest {
    final int a = 0;

    final int b = 1;

    final int c = 2;

    final int d = 3;

    final int e = 4;

    final int f = 5;

    final int g = 6;

    final int h = 7;

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFirst(Integer value) {
        OctupleAccumulatorImpl<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = new OctupleAccumulatorImpl<>((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var actual = underTest.getFirst().apply(null, null);
        Assertions.assertThat(actual).isEqualTo(a);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSecond(Integer value) {
        OctupleAccumulatorImpl<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = new OctupleAccumulatorImpl<>((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var actual = underTest.getSecond().apply(null, null);
        Assertions.assertThat(actual).isEqualTo(b);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getThird(Integer value) {
        OctupleAccumulatorImpl<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = new OctupleAccumulatorImpl<>((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var actual = underTest.getThird().apply(null, null);
        Assertions.assertThat(actual).isEqualTo(c);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFourth(Integer value) {
        OctupleAccumulatorImpl<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = new OctupleAccumulatorImpl<>((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var actual = underTest.getFourth().apply(null, null);
        Assertions.assertThat(actual).isEqualTo(d);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFifth(Integer value) {
        OctupleAccumulatorImpl<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = new OctupleAccumulatorImpl<>((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var actual = underTest.getFifth().apply(null, null);
        Assertions.assertThat(actual).isEqualTo(e);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSixth(Integer value) {
        OctupleAccumulatorImpl<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = new OctupleAccumulatorImpl<>((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var actual = underTest.getSixth().apply(null, null);
        Assertions.assertThat(actual).isEqualTo(f);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSeventh(Integer value) {
        OctupleAccumulatorImpl<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = new OctupleAccumulatorImpl<>((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var actual = underTest.getSeventh().apply(null, null);
        Assertions.assertThat(actual).isEqualTo(g);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getEighth(Integer value) {
        OctupleAccumulatorImpl<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = new OctupleAccumulatorImpl<>((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var actual = underTest.getEighth().apply(null, null);
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void accumulate(Integer value) {
        OctupleAccumulatorImpl<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = new OctupleAccumulatorImpl<>((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var expected = MutableTuple.of(a, b, c, d, e, f, g, value);
        var acc = MutableTuple.of(1, 1, 1, 1, 1, 1, 1, 1);
        var t = MutableTuple.of(1, 1, 1, 1, 1, 1, 1, 1);
        underTest.accumulate(acc, t);
        Assertions.assertThat(acc).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void of(Integer value) {
        OctupleAccumulator<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = Accumulator.of((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var actualA = underTest.getFirst().apply(null, null);
        Assertions.assertThat(actualA).isEqualTo(a);
        var actualB = underTest.getSecond().apply(null, null);
        Assertions.assertThat(actualB).isEqualTo(b);
        var actualC = underTest.getThird().apply(null, null);
        Assertions.assertThat(actualC).isEqualTo(c);
        var actualD = underTest.getFourth().apply(null, null);
        Assertions.assertThat(actualD).isEqualTo(d);
        var actualE = underTest.getFifth().apply(null, null);
        Assertions.assertThat(actualE).isEqualTo(e);
        var actualF = underTest.getSixth().apply(null, null);
        Assertions.assertThat(actualF).isEqualTo(f);
        var actualG = underTest.getSeventh().apply(null, null);
        Assertions.assertThat(actualG).isEqualTo(g);
        var actualValue = underTest.getEighth().apply(null, null);
        Assertions.assertThat(actualValue).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mutableCombine(Integer value) {
        OctupleAccumulatorImpl<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = new OctupleAccumulatorImpl<>((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var expected = MutableTuple.of(a, b, c, d, e, f, g, value);
        var l = MutableTuple.of(1, 1, 1, 1, 1, 1, 1, 1);
        var r = MutableTuple.of(1, 1, 1, 1, 1, 1, 1, 1);
        var actual = underTest.combine(l, r);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void immutableCombine(Integer value) {
        OctupleAccumulatorImpl<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> underTest = new OctupleAccumulatorImpl<>((l, r) -> a, (l, r) -> b, (l, r) -> c, (l, r) -> d, (l, r) -> e, (l, r) -> f, (l, r) -> g, (l, r) -> value);
        var expected = ImmutableTuple.of(a, b, c, d, e, f, g, value);
        var l = ImmutableTuple.of(1, 1, 1, 1, 1, 1, 1, 1);
        var r = ImmutableTuple.of(1, 1, 1, 1, 1, 1, 1, 1);
        var actual = underTest.combine(l, r);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
