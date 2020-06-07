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

import java.util.Comparator;
import java.util.function.Function;

public interface Single<A> {
    A get();

    /**
     * Compare tuple fields in order requiring that the fields are Comparable
     * Each tuple field is compared using natural ordering
     * Null values are not allowed, use the alternative method that accepts a Comparator
     */
    static <A extends Comparable<? super A>> Comparator<Single<A>> compareByAllFieldsInOrder() {
        Comparator<Single<A>> a = Comparator.comparing(Single::get);
        return (a);
    }

    /**
     * Compare tuple fields in order using a Function to make each value Comparable
     * Especially useful where the value is not comparable, but it has a field that can be extracted for comparison
     * Null values are not allowed, use the alternative method that accepts a Comparator
     */
    static <A, FA extends Comparable<? super FA>> Comparator<Single<A>> compareByAllFieldsInOrder(
            Function<A, FA> fa) {
        Comparator<Single<A>> a = Comparator.comparing(fa.compose(Single::get));
        return (a);
    }

    /**
     * Compare tuple fields in order using a Comparator for each field
     * Especially useful for null-safe comparison, eg:
     * <pre>{@code
     * Single.compareByAllFieldsInOrder(Comparator.nullsLast(Integer::compareTo))
     * }</pre>
     */
    static <A> Comparator<Single<A>> compareByAllFieldsInOrder(Comparator<? super A> ca) {
        Comparator<Single<A>> a = Comparator.comparing(Single::get, ca);
        return (a);
    }
}
