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

public interface Quadruple<A, B, C, D> {
    A getFirst();

    B getSecond();

    C getThird();

    D get();

    /**
     * Compare tuple fields in order requiring that the fields are Comparable.
     * Each tuple field is compared using natural ordering.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>> Comparator<Quadruple<A, B, C, D>> compareByAllFieldsInOrder(
            ) {
        Comparator<Quadruple<A, B, C, D>> a = Comparator.comparing(Quadruple::getFirst);
                Comparator<Quadruple<A, B, C, D>> b = Comparator.comparing(Quadruple::getSecond);
                Comparator<Quadruple<A, B, C, D>> c = Comparator.comparing(Quadruple::getThird);
                Comparator<Quadruple<A, B, C, D>> d = Comparator.comparing(Quadruple::get);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d);
    }

    /**
     * Compare tuple fields in reverse order requiring that the fields are Comparable.
     * Each tuple field is compared using natural ordering.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>> Comparator<Quadruple<A, B, C, D>> compareByAllFieldsInReverseOrder(
            ) {
        Comparator<Quadruple<A, B, C, D>> a = Comparator.comparing(Quadruple::getFirst);
                Comparator<Quadruple<A, B, C, D>> b = Comparator.comparing(Quadruple::getSecond);
                Comparator<Quadruple<A, B, C, D>> c = Comparator.comparing(Quadruple::getThird);
                Comparator<Quadruple<A, B, C, D>> d = Comparator.comparing(Quadruple::get);
        return (d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    /**
     * Compare tuple fields in order using a Function to make each value Comparable.
     * Especially useful where the value is not comparable, but it has a field that can be extracted for comparison.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>> Comparator<Quadruple<A, B, C, D>> compareByAllFieldsInOrder(
            Function<? super A, FA> fa, Function<? super B, FB> fb, Function<? super C, FC> fc,
            Function<? super D, FD> fd) {
        Comparator<Quadruple<A, B, C, D>> a = Comparator.comparing(fa.compose(Quadruple::getFirst));
                Comparator<Quadruple<A, B, C, D>> b = Comparator.comparing(fb.compose(Quadruple::getSecond));
                Comparator<Quadruple<A, B, C, D>> c = Comparator.comparing(fc.compose(Quadruple::getThird));
                Comparator<Quadruple<A, B, C, D>> d = Comparator.comparing(fd.compose(Quadruple::get));
        return (a).thenComparing(b).thenComparing(c).thenComparing(d);
    }

    /**
     * Compare tuple fields in reverse order using a Function to make each value Comparable.
     * Especially useful where the value is not comparable, but it has a field that can be extracted for comparison.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>> Comparator<Quadruple<A, B, C, D>> compareByAllFieldsInReverseOrder(
            Function<? super A, FA> fa, Function<? super B, FB> fb, Function<? super C, FC> fc,
            Function<? super D, FD> fd) {
        Comparator<Quadruple<A, B, C, D>> a = Comparator.comparing(fa.compose(Quadruple::getFirst));
                Comparator<Quadruple<A, B, C, D>> b = Comparator.comparing(fb.compose(Quadruple::getSecond));
                Comparator<Quadruple<A, B, C, D>> c = Comparator.comparing(fc.compose(Quadruple::getThird));
                Comparator<Quadruple<A, B, C, D>> d = Comparator.comparing(fd.compose(Quadruple::get));
        return (d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    /**
     * Compare tuple fields in order using a Comparator for each field.
     * Especially useful for null-safe comparison, eg:
     * <pre>{@code
     * Quadruple.compareByAllFieldsInOrder(Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo))
     * }</pre>
     */
    static <A, B, C, D> Comparator<Quadruple<A, B, C, D>> compareByAllFieldsInOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd) {
        Comparator<Quadruple<A, B, C, D>> a = Comparator.comparing(Quadruple::getFirst, ca);
                Comparator<Quadruple<A, B, C, D>> b = Comparator.comparing(Quadruple::getSecond, cb);
                Comparator<Quadruple<A, B, C, D>> c = Comparator.comparing(Quadruple::getThird, cc);
                Comparator<Quadruple<A, B, C, D>> d = Comparator.comparing(Quadruple::get, cd);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d);
    }

    /**
     * Compare tuple fields in reverse order using a Comparator for each field.
     * Especially useful for null-safe comparison, eg:
     * <pre>{@code
     * Quadruple.compareByAllFieldsInReverseOrder(Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo))
     * }</pre>
     */
    static <A, B, C, D> Comparator<Quadruple<A, B, C, D>> compareByAllFieldsInReverseOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd) {
        Comparator<Quadruple<A, B, C, D>> a = Comparator.comparing(Quadruple::getFirst, ca);
                Comparator<Quadruple<A, B, C, D>> b = Comparator.comparing(Quadruple::getSecond, cb);
                Comparator<Quadruple<A, B, C, D>> c = Comparator.comparing(Quadruple::getThird, cc);
                Comparator<Quadruple<A, B, C, D>> d = Comparator.comparing(Quadruple::get, cd);
        return (d).thenComparing(c).thenComparing(b).thenComparing(a);
    }
}
