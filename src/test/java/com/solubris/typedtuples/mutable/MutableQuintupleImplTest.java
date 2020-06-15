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

class MutableQuintupleImplTest {
    final int a = 0;

    final int b = 1;

    final int c = 2;

    final int d = 3;

    final int e = 4;

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void of(Integer value) {
        var actual = MutableTuple.of(a, b, c, d, value);
        Assertions.assertThat(actual).isEqualTo(new MutableQuintupleImpl<>(a, b, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void copyOf(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        var actual = MutableTuple.copyOf(underTest);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFirst(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.getFirst();
        Assertions.assertThat(actual).isEqualTo(a);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSecond(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.getSecond();
        Assertions.assertThat(actual).isEqualTo(b);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getThird(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.getThird();
        Assertions.assertThat(actual).isEqualTo(c);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFourth(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.getFourth();
        Assertions.assertThat(actual).isEqualTo(d);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void get(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.get();
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setFirst(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        underTest.setFirst(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableQuintupleImpl<>(10, b, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setSecond(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        underTest.setSecond(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableQuintupleImpl<>(a, 10, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setThird(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        underTest.setThird(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableQuintupleImpl<>(a, b, 10, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setFourth(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        underTest.setFourth(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableQuintupleImpl<>(a, b, c, 10, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void set(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        underTest.set(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableQuintupleImpl<>(a, b, c, d, 10));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setAll(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        underTest.setAll(10, 10, 10, 10, 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableQuintupleImpl<>(10, 10, 10, 10, 10));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapAll(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.mapAll(MutableQuintupleImpl::new);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeFirst(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        underTest.computeFirst(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableQuintupleImpl<>(10, b, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeSecond(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        underTest.computeSecond(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableQuintupleImpl<>(a, 10, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeThird(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        underTest.computeThird(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableQuintupleImpl<>(a, b, 10, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeFourth(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        underTest.computeFourth(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableQuintupleImpl<>(a, b, c, 10, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void compute(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        underTest.compute(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableQuintupleImpl<>(a, b, c, d, 10));
    }

    @Test
    void equalsHashCode() {
        EqualsVerifier.forClass(MutableQuintupleImpl.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void toStringHas5Values(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.toString();
        Assertions.assertThat(actual).isEqualTo("(" + a + ", " + b + ", " + c + ", " + d + ", " + value + ")");
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void to(Integer value) {
        var underTest = new MutableQuintupleImpl<>(a, b, c, d, value);
        var actual = Stream.of(underTest).map(MutableTuple.to(MutableQuintupleImpl::new)).collect(Collectors.toList());
        Assertions.assertThat(actual).containsExactly(underTest);
    }
}
