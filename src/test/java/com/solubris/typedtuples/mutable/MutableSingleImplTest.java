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

class MutableSingleImplTest {
    final int a = 0;

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void of(Integer value) {
        var actual = MutableTuple.of(value);
        Assertions.assertThat(actual).isEqualTo(new MutableSingleImpl<>(value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void copyOf(Integer value) {
        var underTest = new MutableSingleImpl<>(value);
        var actual = MutableTuple.copyOf(underTest);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void get(Integer value) {
        var underTest = new MutableSingleImpl<>(value);
        var actual = underTest.get();
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void set(Integer value) {
        var underTest = new MutableSingleImpl<>(value);
        underTest.set(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableSingleImpl<>(10));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void transform(Integer value) {
        var underTest = new MutableSingleImpl<>(value);
        var actual = underTest.transform(MutableSingleImpl::new);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void compute(Integer value) {
        var underTest = new MutableSingleImpl<>(value);
        underTest.compute(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableSingleImpl<>(10));
    }

    @Test
    void equalsHashCode() {
        EqualsVerifier.forClass(MutableSingleImpl.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void toStringHas1Value(Integer value) {
        var underTest = new MutableSingleImpl<>(value);
        var actual = underTest.toString();
        Assertions.assertThat(actual).isEqualTo("(" + value + ")");
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void to(Integer value) {
        var underTest = new MutableSingleImpl<>(value);
        var actual = Stream.of(underTest).map(MutableTuple.to(MutableSingleImpl::new)).collect(Collectors.toList());
        Assertions.assertThat(actual).containsExactly(underTest);
    }
}
