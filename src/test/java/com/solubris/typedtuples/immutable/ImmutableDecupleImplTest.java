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

class ImmutableDecupleImplTest {
    final int a = 0;

    final int b = 1;

    final int c = 2;

    final int d = 3;

    final int e = 4;

    final int f = 5;

    final int g = 6;

    final int h = 7;

    final int i = 8;

    final int j = 9;

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void of(Integer value) {
        var actual = ImmutableTuple.of(a, b, c, d, e, f, g, h, i, value);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void copyOf(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = ImmutableTuple.copyOf(underTest);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFirst(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.getFirst();
        Assertions.assertThat(actual).isEqualTo(a);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSecond(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.getSecond();
        Assertions.assertThat(actual).isEqualTo(b);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getThird(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.getThird();
        Assertions.assertThat(actual).isEqualTo(c);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFourth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.getFourth();
        Assertions.assertThat(actual).isEqualTo(d);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFifth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.getFifth();
        Assertions.assertThat(actual).isEqualTo(e);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSixth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.getSixth();
        Assertions.assertThat(actual).isEqualTo(f);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getSeventh(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.getSeventh();
        Assertions.assertThat(actual).isEqualTo(g);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getEighth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.getEighth();
        Assertions.assertThat(actual).isEqualTo(h);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getNinth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.getNinth();
        Assertions.assertThat(actual).isEqualTo(i);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void get(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.get();
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeFirst(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.removeFirst();
        Assertions.assertThat(actual).isEqualTo(new ImmutableNonupleImpl<>(b, c, d, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeSecond(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.removeSecond();
        Assertions.assertThat(actual).isEqualTo(new ImmutableNonupleImpl<>(a, c, d, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeThird(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.removeThird();
        Assertions.assertThat(actual).isEqualTo(new ImmutableNonupleImpl<>(a, b, d, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeFourth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.removeFourth();
        Assertions.assertThat(actual).isEqualTo(new ImmutableNonupleImpl<>(a, b, c, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeFifth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.removeFifth();
        Assertions.assertThat(actual).isEqualTo(new ImmutableNonupleImpl<>(a, b, c, d, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeSixth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.removeSixth();
        Assertions.assertThat(actual).isEqualTo(new ImmutableNonupleImpl<>(a, b, c, d, e, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeSeventh(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.removeSeventh();
        Assertions.assertThat(actual).isEqualTo(new ImmutableNonupleImpl<>(a, b, c, d, e, f, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeEighth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.removeEighth();
        Assertions.assertThat(actual).isEqualTo(new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void removeNinth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.removeNinth();
        Assertions.assertThat(actual).isEqualTo(new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void remove(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.remove();
        Assertions.assertThat(actual).isEqualTo(new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, i));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceFirst(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.replaceFirst(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(1, b, c, d, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceSecond(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.replaceSecond(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, 1, c, d, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceThird(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.replaceThird(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, 1, d, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceFourth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.replaceFourth(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, 1, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceFifth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.replaceFifth(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, 1, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceSixth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.replaceSixth(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, e, 1, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceSeventh(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.replaceSeventh(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, e, f, 1, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceEighth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.replaceEighth(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, 1, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replaceNinth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.replaceNinth(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, 1, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replace(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.replace(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapFirst(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.mapFirst(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(1, b, c, d, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapSecond(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.mapSecond(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, 1, c, d, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapThird(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.mapThird(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, 1, d, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapFourth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.mapFourth(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, 1, e, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapFifth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.mapFifth(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, 1, f, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapSixth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.mapSixth(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, e, 1, g, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapSeventh(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.mapSeventh(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, e, f, 1, h, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapEighth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.mapEighth(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, 1, i, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapNinth(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.mapNinth(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, 1, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void map(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.map(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapAll(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.mapAll(ImmutableDecupleImpl::new);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void reverse(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.reverse();
        Assertions.assertThat(actual).isEqualTo(new ImmutableDecupleImpl<>(value, i, h, g, f, e, d, c, b, a));
    }

    @Test
    void equalsHashCode() {
        EqualsVerifier.forClass(ImmutableDecupleImpl.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void toStringHas10Values(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = underTest.toString();
        Assertions.assertThat(actual).isEqualTo("(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h + ", " + i + ", " + value + ")");
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void to(Integer value) {
        var underTest = new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, value);
        var actual = Stream.of(underTest).map(ImmutableTuple.to(ImmutableDecupleImpl::new)).collect(Collectors.toList());
        Assertions.assertThat(actual).containsExactly(underTest);
    }
}
