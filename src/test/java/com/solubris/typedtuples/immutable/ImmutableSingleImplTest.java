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

class ImmutableSingleImplTest {
    final int a = 0;

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void of(Integer value) {
        var actual = ImmutableTuple.of(value);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSingleImpl<>(value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void copyOf(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = ImmutableTuple.copyOf(underTest);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void get(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = underTest.get();
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void addFirst(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = underTest.addFirst(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableCoupleImpl<>(1, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void add(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = underTest.add(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableCoupleImpl<>(value, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicate(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = underTest.duplicate();
        Assertions.assertThat(actual).isEqualTo(new ImmutableCoupleImpl<>(value, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void remove(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = underTest.remove();
        Assertions.assertThat(actual).isEqualTo(ImmutableUnitImpl.INSTANCE);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void replace(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = underTest.replace(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSingleImpl<>(1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void map(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = underTest.map(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSingleImpl<>(1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapAndAdd(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = underTest.mapAndAdd(i -> 1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableCoupleImpl<>(value, 1));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapAll(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = underTest.mapAll(ImmutableSingleImpl::new);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @Test
    void equalsHashCode() {
        EqualsVerifier.forClass(ImmutableSingleImpl.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void toStringHas1Value(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = underTest.toString();
        Assertions.assertThat(actual).isEqualTo("(" + value + ")");
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void to(Integer value) {
        var underTest = new ImmutableSingleImpl<>(value);
        var actual = Stream.of(underTest).map(ImmutableTuple.to(ImmutableSingleImpl::new)).collect(Collectors.toList());
        Assertions.assertThat(actual).containsExactly(underTest);
    }
}
