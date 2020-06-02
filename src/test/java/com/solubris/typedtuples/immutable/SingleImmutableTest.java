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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SingleImmutableTest {

    @ParameterizedTest
    @ValueSource(ints = {1})
    @NullSource
    void checkAll(Integer value) {
        var underTest = ImmutableTuple.of(value);

        assertThat(underTest)
                .isEqualTo(ImmutableTuple.of(value));
        assertThat(underTest.get())
                .isEqualTo(value);
        assertThat(underTest.duplicate())
                .isEqualTo(ImmutableTuple.of(value, value));
        assertThat(underTest.map(i -> 1))
                .isEqualTo(ImmutableTuple.of(1));
        assertThat(underTest.remove())
                .isEqualTo(ImmutableTuple.of());
        assertThat(underTest.addFirst("x"))
                .isEqualTo(ImmutableTuple.of("x", value));
        assertThat(underTest.add("x"))
                .isEqualTo(ImmutableTuple.of(value, "x"));
        assertThat(underTest.replace("x"))
                .isEqualTo(ImmutableTuple.of("x"));
        assertThat(underTest.toString())
                .isEqualTo("(" + value + ")");
        assertThat(underTest.<String>mapAll(String::valueOf))
                .isEqualTo("" + value);
        assertThat(underTest.mapAndAdd(i -> 1))
                .isEqualTo(ImmutableTuple.of(value, 1));
    }

    @Test
    void checkAll() {
        EqualsVerifier.forClass(ImmutableSingleImpl.class)
                .verify();
    }
}
