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

public interface Couple<A, B> {
    A getFirst();

    B getSecond();

    /**
     * Compare tuple fields in order requiring that the fields are Comparable.
     * Each tuple field is compared using natural ordering.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A extends Comparable<? super A>, B extends Comparable<? super B>> Comparator<Couple<A, B>> compareByAllFieldsInOrder(
            ) {
        Comparator<Couple<A, B>> a = Comparator.comparing(Couple::getFirst);
                Comparator<Couple<A, B>> b = Comparator.comparing(Couple::getSecond);
        return (a).thenComparing(b);
    }

    /**
     * Compare tuple fields in reverse order requiring that the fields are Comparable.
     * Each tuple field is compared using natural ordering.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A extends Comparable<? super A>, B extends Comparable<? super B>> Comparator<Couple<A, B>> compareByAllFieldsInReverseOrder(
            ) {
        Comparator<Couple<A, B>> a = Comparator.comparing(Couple::getFirst);
                Comparator<Couple<A, B>> b = Comparator.comparing(Couple::getSecond);
        return (b).thenComparing(a);
    }

    /**
     * Compare tuple fields in order using a Function to make each value Comparable.
     * Especially useful where the value is not comparable, but it has a field that can be extracted for comparison.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>> Comparator<Couple<A, B>> compareByAllFieldsInOrder(
            Function<? super A, FA> fa, Function<? super B, FB> fb) {
        Comparator<Couple<A, B>> a = Comparator.comparing(fa.compose(Couple::getFirst));
                Comparator<Couple<A, B>> b = Comparator.comparing(fb.compose(Couple::getSecond));
        return (a).thenComparing(b);
    }

    /**
     * Compare tuple fields in reverse order using a Function to make each value Comparable.
     * Especially useful where the value is not comparable, but it has a field that can be extracted for comparison.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>> Comparator<Couple<A, B>> compareByAllFieldsInReverseOrder(
            Function<? super A, FA> fa, Function<? super B, FB> fb) {
        Comparator<Couple<A, B>> a = Comparator.comparing(fa.compose(Couple::getFirst));
                Comparator<Couple<A, B>> b = Comparator.comparing(fb.compose(Couple::getSecond));
        return (b).thenComparing(a);
    }

    /**
     * Compare tuple fields in order using a Comparator for each field.
     * Especially useful for null-safe comparison, eg:
     * <pre>{@code
     * Couple.compareByAllFieldsInOrder(Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo))
     * }</pre>
     */
    static <A, B> Comparator<Couple<A, B>> compareByAllFieldsInOrder(Comparator<? super A> ca,
            Comparator<? super B> cb) {
        Comparator<Couple<A, B>> a = Comparator.comparing(Couple::getFirst, ca);
                Comparator<Couple<A, B>> b = Comparator.comparing(Couple::getSecond, cb);
        return (a).thenComparing(b);
    }

    /**
     * Compare tuple fields in reverse order using a Comparator for each field.
     * Especially useful for null-safe comparison, eg:
     * <pre>{@code
     * Couple.compareByAllFieldsInReverseOrder(Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo))
     * }</pre>
     */
    static <A, B> Comparator<Couple<A, B>> compareByAllFieldsInReverseOrder(
            Comparator<? super A> ca, Comparator<? super B> cb) {
        Comparator<Couple<A, B>> a = Comparator.comparing(Couple::getFirst, ca);
                Comparator<Couple<A, B>> b = Comparator.comparing(Couple::getSecond, cb);
        return (b).thenComparing(a);
    }
}
