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

package com.solubris.typedtuples;

import com.solubris.typedtuples.immutable.ImmutableTuple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class QuadrupleTest {
    @Test
    void compareByAllFieldsInOrder() {
        var t1 = ImmutableTuple.of(1, 1, 1, 1);
        var t2 = ImmutableTuple.of(1, 1, 1, 2);
        var t3 = ImmutableTuple.of(2, 1, 1, 1);
        var list = new ArrayList<>(List.of(t3, t2, t1));
        list.sort(Quadruple.compareByAllFieldsInOrder());
        Assertions.assertThat(list).containsExactly(t1, t2, t3);
    }

    @Test
    void compareByAllFieldsInReverseOrder() {
        var t1 = ImmutableTuple.of(1, 1, 1, 1);
        var t2 = ImmutableTuple.of(1, 1, 1, 2);
        var t3 = ImmutableTuple.of(2, 1, 1, 1);
        var list = new ArrayList<>(List.of(t3, t2, t1));
        list.sort(Quadruple.compareByAllFieldsInReverseOrder());
        Assertions.assertThat(list).containsExactly(t1, t3, t2);
    }
}
