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

class MutableNonupleImplTest {
    final int a = 0;

    final int b = 1;

    final int c = 2;

    final int d = 3;

    final int e = 4;

    final int f = 5;

    final int g = 6;

    final int h = 7;

    final int i = 8;

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void of(Integer value) {
        var actual = MutableTuple.of(a, b, c, d, e, f, g, h, value);
        Assertions.assertThat(actual).isEqualTo(new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void copyOf(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = MutableTuple.copyOf(underTest);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFirst(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = underTest.getFirst();
        Assertions.assertThat(actual).isEqualTo(a);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSecond(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = underTest.getSecond();
        Assertions.assertThat(actual).isEqualTo(b);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getThird(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = underTest.getThird();
        Assertions.assertThat(actual).isEqualTo(c);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFourth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = underTest.getFourth();
        Assertions.assertThat(actual).isEqualTo(d);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFifth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = underTest.getFifth();
        Assertions.assertThat(actual).isEqualTo(e);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSixth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = underTest.getSixth();
        Assertions.assertThat(actual).isEqualTo(f);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSeventh(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = underTest.getSeventh();
        Assertions.assertThat(actual).isEqualTo(g);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getEighth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = underTest.getEighth();
        Assertions.assertThat(actual).isEqualTo(h);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getNinth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = underTest.getNinth();
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setFirst(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.setFirst(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(10, b, c, d, e, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setSecond(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.setSecond(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, 10, c, d, e, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setThird(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.setThird(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, 10, d, e, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setFourth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.setFourth(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, 10, e, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setFifth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.setFifth(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, d, 10, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setSixth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.setSixth(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, d, e, 10, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setSeventh(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.setSeventh(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, d, e, f, 10, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setEighth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.setEighth(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, d, e, f, g, 10, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setNinth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.setNinth(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, 10));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setAll(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.setAll(10, 10, 10, 10, 10, 10, 10, 10, 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(10, 10, 10, 10, 10, 10, 10, 10, 10));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void transform(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = underTest.transform(MutableNonupleImpl::new);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeFirst(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.computeFirst(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(10, b, c, d, e, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeSecond(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.computeSecond(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, 10, c, d, e, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeThird(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.computeThird(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, 10, d, e, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeFourth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.computeFourth(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, 10, e, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeFifth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.computeFifth(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, d, 10, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeSixth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.computeSixth(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, d, e, 10, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeSeventh(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.computeSeventh(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, d, e, f, 10, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeEighth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.computeEighth(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, d, e, f, g, 10, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeNinth(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        underTest.computeNinth(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, 10));
    }

    @Test
    void equalsHashCode() {
        EqualsVerifier.forClass(MutableNonupleImpl.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void toStringHas9Values(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = underTest.toString();
        Assertions.assertThat(actual).isEqualTo("(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h + ", " + value + ")");
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void to(Integer value) {
        var underTest = new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, value);
        var actual = Stream.of(underTest).map(MutableTuple.to(MutableNonupleImpl::new)).collect(Collectors.toList());
        Assertions.assertThat(actual).containsExactly(underTest);
    }
}
