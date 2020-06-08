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

class MutableCoupleImplTest {
    final int a = 0;

    final int b = 1;

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void getFirst(Integer value) {
        var underTest = new MutableCoupleImpl<>(a, value);
        var actual = underTest.getFirst();
        Assertions.assertThat(actual).isEqualTo(a);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void get(Integer value) {
        var underTest = new MutableCoupleImpl<>(a, value);
        var actual = underTest.get();
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setFirst(Integer value) {
        var underTest = new MutableCoupleImpl<>(a, value);
        underTest.setFirst(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableCoupleImpl<>(10, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void set(Integer value) {
        var underTest = new MutableCoupleImpl<>(a, value);
        underTest.set(10);
        Assertions.assertThat(underTest).isEqualTo(new MutableCoupleImpl<>(a, 10));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void setAll(Integer value) {
        var underTest = new MutableCoupleImpl<>(a, value);
        underTest.setAll(10, 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableCoupleImpl<>(10, 10));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void mapAll(Integer value) {
        var underTest = new MutableCoupleImpl<>(a, value);
        var actual = underTest.mapAll(MutableCoupleImpl::new);
        Assertions.assertThat(actual).isEqualTo(underTest);
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void computeFirst(Integer value) {
        var underTest = new MutableCoupleImpl<>(a, value);
        underTest.computeFirst(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableCoupleImpl<>(10, value));
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void compute(Integer value) {
        var underTest = new MutableCoupleImpl<>(a, value);
        underTest.compute(i -> 10);
        Assertions.assertThat(underTest).isEqualTo(new MutableCoupleImpl<>(a, 10));
    }

    @Test
    void equalsHashCode() {
        EqualsVerifier.forClass(MutableCoupleImpl.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @ParameterizedTest
    @ValueSource(
            ints = 1
    )
    @NullSource
    void toStringHas2Values(Integer value) {
        var underTest = new MutableCoupleImpl<>(a, value);
        var actual = underTest.toString();
        Assertions.assertThat(actual).isEqualTo("(" + a + ", " + value + ")");
    }
}
