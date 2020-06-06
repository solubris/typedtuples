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

import com.solubris.typedtuples.Couple;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CoupleImmutableTest {
    final int first = 0;

    @ParameterizedTest
    @ValueSource(ints = {1})
    @NullSource
    void checkAll(Integer value) {
        var underTest = ImmutableTuple.of(first, value);

        assertThat(underTest)
                .isEqualTo(ImmutableTuple.of(first, value));
        assertThat(underTest.getFirst())
                .isEqualTo(first);
        assertThat(underTest.get())
                .isEqualTo(value);
        assertThat(underTest.duplicateFirst())
                .isEqualTo(ImmutableTuple.of(first, first, value));
        assertThat(underTest.duplicate())
                .isEqualTo(ImmutableTuple.of(first, value, value));
        assertThat(underTest.mapFirst(i -> 1))
                .isEqualTo(ImmutableTuple.of(1, value));
        assertThat(underTest.map(i -> 1))
                .isEqualTo(ImmutableTuple.of(first, 1));
        assertThat(underTest.removeFirst())
                .isEqualTo(ImmutableTuple.of(value));
        assertThat(underTest.remove())
                .isEqualTo(ImmutableTuple.of(first));
        assertThat(underTest.addFirst("x"))
                .isEqualTo(ImmutableTuple.of("x", first, value));
        assertThat(underTest.addSecond("x"))
                .isEqualTo(ImmutableTuple.of(first, "x", value));
        assertThat(underTest.add("x"))
                .isEqualTo(ImmutableTuple.of(first, value, "x"));
        assertThat(underTest.replaceFirst("x"))
                .isEqualTo(ImmutableTuple.of("x", value));
        assertThat(underTest.replace("x"))
                .isEqualTo(ImmutableTuple.of(first, "x"));
        assertThat(underTest.toString())
                .isEqualTo("(" + first + ", " + value + ")");
        assertThat(underTest.mapFirstAndAdd(i1 -> 1))
                .isEqualTo(ImmutableTuple.of(first, value, 1));
        assertThat(underTest.mapAndAdd(i -> 1))
                .isEqualTo(ImmutableTuple.of(first, value, 1));
        assertThat(underTest.reverse())
                .isEqualTo(ImmutableTuple.of(value, first));
    }

    @ParameterizedTest
    @ValueSource(ints = 1)
    @NullSource
    void mapAll(Integer value) {
        var underTest = ImmutableTuple.of(first, value);

        var actual = underTest.mapAll(ImmutableTuple::of);

        assertThat(actual).isEqualTo(underTest);
    }

    public static class Bbb extends Ccc {
    }

    private static class Ccc implements Comparable<Ccc> {
        @Override
        public int compareTo(Ccc o) {
            return 0;
        }
    }

    @Test
    void sortingSuper() {
        var t1 = ImmutableTuple.of(1, new Bbb());
        var t2 = ImmutableTuple.of(1, new Bbb());

        var list = new ArrayList<>(List.of(t2, t1));

        list.sort(Couple.compareByAllFieldsInOrder());

        assertThat(list).containsExactly(t1, t2);
    }

    @Test
    void sorting() {
        var t1 = ImmutableTuple.of(1, 2);
        var t2 = ImmutableTuple.of(1, 3);

        var list = new ArrayList<>(List.of(t2, t1));

        list.sort(Couple.compareByAllFieldsInOrder());

        assertThat(list).containsExactly(t1, t2);
    }

    @Test
    void sortingReverseTuples() {
        var t1 = ImmutableTuple.of(1, 2);
        var t2 = ImmutableTuple.of(2, 1);
        var t3 = ImmutableTuple.of(3, 3);

        var list = new ArrayList<>(List.of(t1, t2, t3));

        list.sort(Couple.compareByAllFieldsInReverseOrder());

        assertThat(list).containsExactly(t2, t1, t3);
    }

    public static class Aaa {
    }

    @Test
    void sortingWithMappingFunction() {

        var t1 = ImmutableTuple.of(1, new Aaa());
        var t2 = ImmutableTuple.of(2, new Aaa());

        var list = new ArrayList<>(List.of(t2, t1));

        list.sort(Couple.compareByAllFieldsInOrder(integer -> integer, aaa -> 1));

        assertThat(list).containsExactly(t1, t2);
    }

    @Test
    void sortingWithComparatorFunction() {

        var t1 = ImmutableTuple.of(1, new Aaa());
        var t2 = ImmutableTuple.of(2, new Aaa());

        var list = new ArrayList<>(List.of(t2, t1));

        list.sort(Couple.compareByAllFieldsInOrder(Integer::compareTo, (o1, o2) -> 0));

        assertThat(list).containsExactly(t1, t2);
    }

    @Test
    void checkEqualsHashCode() {
        EqualsVerifier.forClass(ImmutableCoupleImpl.class)
                .verify();
    }
}
