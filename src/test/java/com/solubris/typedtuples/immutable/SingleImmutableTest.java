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

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
class SingleImmutableTest {

    @Test
    void checkAll() {
        var underTest = ImmutableTuple.of(0);

        assertThat(underTest.get())
                .isEqualTo(0);
        assertThat(underTest.duplicate())
                .isEqualTo(ImmutableTuple.of(0, 0));
        assertThat(underTest.map(i -> i + 1))
                .isEqualTo(ImmutableTuple.of(1));
        assertThat(underTest.map(i -> i + 1))
                .isEqualTo(ImmutableTuple.of(1));
        assertThat(underTest.remove())
                .isEqualTo(ImmutableTuple.of());
        assertThat(underTest.add("x"))
                .isEqualTo(ImmutableTuple.of(0, "x"));
        assertThat(underTest.addFirst("x"))
                .isEqualTo(ImmutableTuple.of("x", 0));
        assertThat(underTest.replace("x"))
                .isEqualTo(ImmutableTuple.of("x"));
        assertThat(underTest)
                .isEqualTo(ImmutableTuple.of(0));
        assertThat(underTest.toString())
                .isEqualTo("(0)");
        assertThat(underTest.<String>mapAll(String::valueOf))
                .isEqualTo("0");
        assertThat(underTest.mapAndAdd(i -> i + 1))
                .isEqualTo(ImmutableTuple.of(0, 1));

        EqualsVerifier.forClass(underTest.getClass())
//                .suppress(Warning.IDENTICAL_COPY)
//                .withIgnoredFields("INSTANCE")
                .verify();
    }

}
