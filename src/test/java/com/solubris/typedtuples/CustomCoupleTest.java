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
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CustomCoupleTest {
    @Test
    void compareByAllFieldsInOrder() {
        var t1 = ImmutableTuple.of(1, 1);
        var t2 = ImmutableTuple.of(1, 2);
        var t3 = ImmutableTuple.of(2, 1);
        var list = new ArrayList<>(List.of(t3, t2, t1));
        list.sort(Couple.compareByAllFieldsInOrder(i -> i * i, i -> i * i));
        Assertions.assertThat(list).containsExactly(t1, t2, t3);
    }


    private static class Bbb extends Ccc {
    }

    private static class Ccc implements Comparable<Ccc> {
        @Override
        public int compareTo(Ccc o) {
            return 0;
        }
    }

    @Test
    void sortingSuper() {
        var t1 = InnerTuple.of(1, new Bbb());
        var t2 = InnerTuple.of(2, new Bbb());

        var list = new ArrayList<>(List.of(t2, t1));

        list.sort(Couple.compareByAllFieldsInOrder());

        assertThat(list).containsExactly(t1, t2);
    }

    @Test
    void sorting() {
        var t1 = InnerTuple.of(1, 2);
        var t2 = InnerTuple.of(1, 3);

        var list = new ArrayList<>(List.of(t2, t1));

        list.sort(Couple.compareByAllFieldsInOrder());

        assertThat(list).containsExactly(t1, t2);
    }

    @Test
    void sortingNullSafe() {
        var t1 = InnerTuple.of(1, 2);
        var t2 = InnerTuple.of(1, (Integer) null);

        var list = new ArrayList<>(List.of(t2, t1));

        Throwable thrown = catchThrowable(() -> list.sort(Couple.compareByAllFieldsInOrder()));

        assertThat(thrown).isInstanceOf(NullPointerException.class);
    }

    @Test
    void sortingReverseTuples() {
        var t1 = InnerTuple.of(1, 2);
        var t2 = InnerTuple.of(2, 1);
        var t3 = InnerTuple.of(3, 3);

        var list = new ArrayList<>(List.of(t1, t2, t3));

        list.sort(Couple.compareByAllFieldsInReverseOrder());

        assertThat(list).containsExactly(t2, t1, t3);
    }

    public static class Aaa {
    }

    @Test
    void sortingWithMappingFunction() {

        var t1 = InnerTuple.of(1, new Aaa());
        var t2 = InnerTuple.of(2, new Aaa());

        var list = new ArrayList<>(List.of(t2, t1));

        list.sort(Couple.compareByAllFieldsInOrder(integer -> integer, aaa -> 1));

        assertThat(list).containsExactly(t1, t2);
    }

    @Test
    void sortingWithComparatorFunction() {

        var t1 = InnerTuple.of(1, new Aaa());
        var t2 = InnerTuple.of(2, new Aaa());

        var list = new ArrayList<>(List.of(t2, t1));

        list.sort(Couple.compareByAllFieldsInOrder(Integer::compareTo, (o1, o2) -> 0));

        assertThat(list).containsExactly(t1, t2);
    }

    @Test
    void sortingNullSafeComparator() {

        var t1 = ImmutableTuple.of(1, new Aaa());
        var t2 = InnerTuple.of((Integer) null, new Aaa());

        var list = new ArrayList<>(List.of(t2, t1));

        list.sort(Couple.compareByAllFieldsInOrder(Comparator.nullsLast(Integer::compareTo), (o1, o2) -> 0));

        assertThat(list).containsExactly(t1, t2);
    }

    /**
     * Creating a new tuple definition so the tests don't rely on Immutable tuple classes
     * Is it worth it?
     */
    static class InnerTuple<A, B> implements Couple<A, B> {
        private final A a;
        private final B b;

        private InnerTuple(A a, B b) {
            this.a = a;
            this.b = b;
        }

        public static <A, B> Couple<A, B> of(A a, B b) {
            return new InnerTuple<>(a, b);
        }

        @Override
        public A getFirst() {
            return a;
        }

        @Override
        public B get() {
            return b;
        }
    }
}
