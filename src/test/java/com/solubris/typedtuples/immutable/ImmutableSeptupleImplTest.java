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

class ImmutableSeptupleImplTest {
    final int a = 0;

    final int b = 1;

    final int c = 2;

    final int d = 3;

    final int e = 4;

    final int f = 5;

    final int g = 6;

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicateFirst(Integer value) {
        var underTest = new ImmutableSeptupleImpl<>(a, b, c, d, e, f, value);
        var actual = underTest.duplicateFirst();
        Assertions.assertThat(actual).isEqualTo(new ImmutableOctupleImpl<>(a, a, b, c, d, e, f, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicateSecond(Integer value) {
        var underTest = new ImmutableSeptupleImpl<>(a, b, c, d, e, f, value);
        var actual = underTest.duplicateSecond();
        Assertions.assertThat(actual).isEqualTo(new ImmutableOctupleImpl<>(a, b, b, c, d, e, f, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicateThird(Integer value) {
        var underTest = new ImmutableSeptupleImpl<>(a, b, c, d, e, f, value);
        var actual = underTest.duplicateThird();
        Assertions.assertThat(actual).isEqualTo(new ImmutableOctupleImpl<>(a, b, c, c, d, e, f, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicateFourth(Integer value) {
        var underTest = new ImmutableSeptupleImpl<>(a, b, c, d, e, f, value);
        var actual = underTest.duplicateFourth();
        Assertions.assertThat(actual).isEqualTo(new ImmutableOctupleImpl<>(a, b, c, d, d, e, f, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicateFifth(Integer value) {
        var underTest = new ImmutableSeptupleImpl<>(a, b, c, d, e, f, value);
        var actual = underTest.duplicateFifth();
        Assertions.assertThat(actual).isEqualTo(new ImmutableOctupleImpl<>(a, b, c, d, e, e, f, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicateSixth(Integer value) {
        var underTest = new ImmutableSeptupleImpl<>(a, b, c, d, e, f, value);
        var actual = underTest.duplicateSixth();
        Assertions.assertThat(actual).isEqualTo(new ImmutableOctupleImpl<>(a, b, c, d, e, f, f, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void duplicate(Integer value) {
        var underTest = new ImmutableSeptupleImpl<>(a, b, c, d, e, f, value);
        var actual = underTest.duplicate();
        Assertions.assertThat(actual).isEqualTo(new ImmutableOctupleImpl<>(a, b, c, d, e, f, value, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapAll(Integer value) {
        var underTest = new ImmutableSeptupleImpl<>(a, b, c, d, e, f, value);
        var actual = underTest.mapAll(ImmutableSeptupleImpl::new);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void reverse(Integer value) {
        var underTest = new ImmutableSeptupleImpl<>(a, b, c, d, e, f, value);
        var actual = underTest.reverse();
        Assertions.assertThat(actual).isEqualTo(new ImmutableSeptupleImpl<>(value, f, e, d, c, b, a));
    }

    @Test
    void equalsHashCode() {
        EqualsVerifier.forClass(ImmutableSeptupleImpl.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void toStringHas7Values(Integer value) {
        var underTest = new ImmutableSeptupleImpl<>(a, b, c, d, e, f, value);
        var actual = underTest.toString();
        Assertions.assertThat(actual).isEqualTo("(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + value + ")");
    }
}
