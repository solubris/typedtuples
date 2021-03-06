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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ImmutableUnitImplTest {
    @Test
    void of() {
        var actual = ImmutableTuple.of();
        Assertions.assertThat(actual).isEqualTo(ImmutableUnitImpl.INSTANCE);
    }

    @Test
    void add() {
        var underTest = ImmutableUnitImpl.INSTANCE;
        var actual = underTest.add(1);
        Assertions.assertThat(actual).isEqualTo(new ImmutableSingleImpl<>(1));
    }

    @Test
    void toStringHas0Values() {
        var underTest = ImmutableUnitImpl.INSTANCE;
        var actual = underTest.toString();
        Assertions.assertThat(actual).isEqualTo("()");
    }
}
