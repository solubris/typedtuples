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

public interface Triple<A, B, C> {
    A getFirst();

    B getSecond();

    C getThird();

    /**
     * Compare tuple fields in order requiring that the fields are Comparable.
     * Each tuple field is compared using natural ordering.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>> Comparator<Triple<A, B, C>> compareByAllFieldsInOrder(
            ) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(Triple::getFirst);
                Comparator<Triple<A, B, C>> b = Comparator.comparing(Triple::getSecond);
                Comparator<Triple<A, B, C>> c = Comparator.comparing(Triple::getThird);
        return (a).thenComparing(b).thenComparing(c);
    }

    /**
     * Compare tuple fields in reverse order requiring that the fields are Comparable.
     * Each tuple field is compared using natural ordering.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>> Comparator<Triple<A, B, C>> compareByAllFieldsInReverseOrder(
            ) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(Triple::getFirst);
                Comparator<Triple<A, B, C>> b = Comparator.comparing(Triple::getSecond);
                Comparator<Triple<A, B, C>> c = Comparator.comparing(Triple::getThird);
        return (c).thenComparing(b).thenComparing(a);
    }

    /**
     * Compare tuple fields in order using a Function to make each value Comparable.
     * Especially useful where the value is not comparable, but it has a field that can be extracted for comparison.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>> Comparator<Triple<A, B, C>> compareByAllFieldsInOrder(
            Function<? super A, FA> fa, Function<? super B, FB> fb, Function<? super C, FC> fc) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(fa.compose(Triple::getFirst));
                Comparator<Triple<A, B, C>> b = Comparator.comparing(fb.compose(Triple::getSecond));
                Comparator<Triple<A, B, C>> c = Comparator.comparing(fc.compose(Triple::getThird));
        return (a).thenComparing(b).thenComparing(c);
    }

    /**
     * Compare tuple fields in reverse order using a Function to make each value Comparable.
     * Especially useful where the value is not comparable, but it has a field that can be extracted for comparison.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>> Comparator<Triple<A, B, C>> compareByAllFieldsInReverseOrder(
            Function<? super A, FA> fa, Function<? super B, FB> fb, Function<? super C, FC> fc) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(fa.compose(Triple::getFirst));
                Comparator<Triple<A, B, C>> b = Comparator.comparing(fb.compose(Triple::getSecond));
                Comparator<Triple<A, B, C>> c = Comparator.comparing(fc.compose(Triple::getThird));
        return (c).thenComparing(b).thenComparing(a);
    }

    /**
     * Compare tuple fields in order using a Comparator for each field.
     * Especially useful for null-safe comparison, eg:
     * <pre>{@code
     * Triple.compareByAllFieldsInOrder(Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo))
     * }</pre>
     */
    static <A, B, C> Comparator<Triple<A, B, C>> compareByAllFieldsInOrder(Comparator<? super A> ca,
            Comparator<? super B> cb, Comparator<? super C> cc) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(Triple::getFirst, ca);
                Comparator<Triple<A, B, C>> b = Comparator.comparing(Triple::getSecond, cb);
                Comparator<Triple<A, B, C>> c = Comparator.comparing(Triple::getThird, cc);
        return (a).thenComparing(b).thenComparing(c);
    }

    /**
     * Compare tuple fields in reverse order using a Comparator for each field.
     * Especially useful for null-safe comparison, eg:
     * <pre>{@code
     * Triple.compareByAllFieldsInReverseOrder(Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo))
     * }</pre>
     */
    static <A, B, C> Comparator<Triple<A, B, C>> compareByAllFieldsInReverseOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc) {
        Comparator<Triple<A, B, C>> a = Comparator.comparing(Triple::getFirst, ca);
                Comparator<Triple<A, B, C>> b = Comparator.comparing(Triple::getSecond, cb);
                Comparator<Triple<A, B, C>> c = Comparator.comparing(Triple::getThird, cc);
        return (c).thenComparing(b).thenComparing(a);
    }
}
