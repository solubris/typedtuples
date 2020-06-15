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

package com.solubris.typedtuples.mutable;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class MutableOctupleImplTest {
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
    void of(Integer value) {
        var actual = MutableTuple.of(a, b, c, d, e, f, g, value);
        Assertions.assertThat(actual).isEqualTo(new MutableOctupleImpl<>(a, b, c, d, e, f, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void copyOf(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = MutableTuple.copyOf(underTest);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFirst(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = underTest.getFirst();
        Assertions.assertThat(actual).isEqualTo(a);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSecond(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = underTest.getSecond();
        Assertions.assertThat(actual).isEqualTo(b);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getThird(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = underTest.getThird();
        Assertions.assertThat(actual).isEqualTo(c);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFourth(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = underTest.getFourth();
        Assertions.assertThat(actual).isEqualTo(d);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFifth(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = underTest.getFifth();
        Assertions.assertThat(actual).isEqualTo(e);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSixth(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = underTest.getSixth();
        Assertions.assertThat(actual).isEqualTo(f);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSeventh(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = underTest.getSeventh();
        Assertions.assertThat(actual).isEqualTo(g);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void get(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = underTest.get();
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setFirst(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.setFirst(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(10, b, c, d, e, f, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setSecond(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.setSecond(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, 10, c, d, e, f, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setThird(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.setThird(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, 10, d, e, f, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setFourth(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.setFourth(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, c, 10, e, f, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setFifth(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.setFifth(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, c, d, 10, f, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setSixth(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.setSixth(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, c, d, e, 10, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setSeventh(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.setSeventh(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, c, d, e, f, 10, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void set(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.set(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, c, d, e, f, g, 10));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setAll(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.setAll(10, 10, 10, 10, 10, 10, 10, 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(10, 10, 10, 10, 10, 10, 10, 10));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapAll(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = underTest.mapAll(MutableOctupleImpl::new);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeFirst(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.computeFirst(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(10, b, c, d, e, f, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeSecond(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.computeSecond(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, 10, c, d, e, f, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeThird(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.computeThird(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, 10, d, e, f, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeFourth(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.computeFourth(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, c, 10, e, f, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeFifth(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.computeFifth(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, c, d, 10, f, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeSixth(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.computeSixth(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, c, d, e, 10, g, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeSeventh(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.computeSeventh(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, c, d, e, f, 10, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void compute(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        underTest.compute(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableOctupleImpl<>(a, b, c, d, e, f, g, 10));
    }

    @Test
    void equalsHashCode() {
        EqualsVerifier.forClass(MutableOctupleImpl.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void toStringHas8Values(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = underTest.toString();
        Assertions.assertThat(actual).isEqualTo("(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + value + ")");
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void to(Integer value) {
        var underTest = new MutableOctupleImpl<>(a, b, c, d, e, f, g, value);
        var actual = Stream.of(underTest).map(MutableTuple.to(MutableOctupleImpl::new)).collect(Collectors.toList());
        Assertions.assertThat(actual).containsExactly(underTest);
    }
}
