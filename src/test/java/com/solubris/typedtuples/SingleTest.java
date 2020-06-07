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
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SingleTest {


    @Test
    void sortingWithMappingFunction2() {

        var t1 = ImmutableTuple.of("short");
        var t2 = ImmutableTuple.of("longer");

        var list = new ArrayList<>(List.of(t2, t1));

        list.sort(Single.compareByAllFieldsInOrder(String::length));

        assertThat(list).containsExactly(t1, t2);
    }
}
