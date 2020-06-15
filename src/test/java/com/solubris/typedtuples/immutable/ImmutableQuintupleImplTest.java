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

package com.solubris.typedtuples.immutable;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class ImmutableQuintupleImplTest {
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
        var actual = ImmutableTuple.of(a, b, c, d, value);
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(a, b, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void copyOf(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = ImmutableTuple.copyOf(underTest);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFirst(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.getFirst();
        Assertions.assertThat(actual).isEqualTo(a);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSecond(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.getSecond();
        Assertions.assertThat(actual).isEqualTo(b);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getThird(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.getThird();
        Assertions.assertThat(actual).isEqualTo(c);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFourth(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.getFourth();
        Assertions.assertThat(actual).isEqualTo(d);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void get(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.get();
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void addFirst(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.addFirst(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(1, a, b, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void addSecond(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.addSecond(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, 1, b, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void addThird(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.addThird(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, 1, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void addFourth(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.addFourth(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, c, 1, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void addFifth(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.addFifth(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, c, d, 1, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void add(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.add(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, c, d, value, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicateFirst(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.duplicateFirst();
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, a, b, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicateSecond(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.duplicateSecond();
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, b, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicateThird(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.duplicateThird();
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, c, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicateFourth(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.duplicateFourth();
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, c, d, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicate(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.duplicate();
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, c, d, value, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeFirst(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.removeFirst();
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuadrupleImpl<>(b, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeSecond(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.removeSecond();
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuadrupleImpl<>(a, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeThird(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.removeThird();
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuadrupleImpl<>(a, b, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeFourth(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.removeFourth();
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuadrupleImpl<>(a, b, c, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void remove(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.remove();
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuadrupleImpl<>(a, b, c, d));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceFirst(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.replaceFirst(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(1, b, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceSecond(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.replaceSecond(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(a, 1, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceThird(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.replaceThird(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(a, b, 1, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceFourth(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.replaceFourth(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(a, b, c, 1, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replace(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.replace(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(a, b, c, d, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapFirst(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.mapFirst(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(1, b, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapSecond(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.mapSecond(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(a, 1, c, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapThird(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.mapThird(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(a, b, 1, d, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapFourth(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.mapFourth(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(a, b, c, 1, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void map(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.map(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(a, b, c, d, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapFirstAndAdd(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.mapFirstAndAdd(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, c, d, value, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapSecondAndAdd(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.mapSecondAndAdd(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, c, d, value, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapThirdAndAdd(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.mapThirdAndAdd(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, c, d, value, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapFourthAndAdd(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.mapFourthAndAdd(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, c, d, value, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapAndAdd(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.mapAndAdd(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSextupleImpl<>(a, b, c, d, value, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapAll(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.mapAll(ImmutableQuintupleImpl::new);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void reverse(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.reverse();
        Assertions.assertThat(actual).isEqualTo(new ImmutableQuintupleImpl<>(value, d, c, b, a));
    }

    @Test
    void equalsHashCode() {
        EqualsVerifier.forClass(ImmutableQuintupleImpl.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void toStringHas5Values(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = underTest.toString();
        Assertions.assertThat(actual).isEqualTo("(" + a + ", " + b + ", " + c + ", " + d + ", " + value + ")");
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void to(Integer value) {
        var underTest = new ImmutableQuintupleImpl<>(a, b, c, d, value);
        var actual = Stream.of(underTest).map(ImmutableTuple.to(ImmutableQuintupleImpl::new)).collect(Collectors.toList());
        Assertions.assertThat(actual).containsExactly(underTest);
    }
}
