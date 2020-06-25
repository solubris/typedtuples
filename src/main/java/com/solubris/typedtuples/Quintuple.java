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

public interface Quintuple<A, B, C, D, E> {
    A getFirst();

    B getSecond();

    C getThird();

    D getFourth();

    E getFifth();

    /**
     * Compare tuple fields in order requiring that the fields are Comparable.
     * Each tuple field is compared using natural ordering.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>> Comparator<Quintuple<A, B, C, D, E>> compareByAllFieldsInOrder(
            ) {
        Comparator<Quintuple<A, B, C, D, E>> a = Comparator.comparing(Quintuple::getFirst);
                Comparator<Quintuple<A, B, C, D, E>> b = Comparator.comparing(Quintuple::getSecond);
                Comparator<Quintuple<A, B, C, D, E>> c = Comparator.comparing(Quintuple::getThird);
                Comparator<Quintuple<A, B, C, D, E>> d = Comparator.comparing(Quintuple::getFourth);
                Comparator<Quintuple<A, B, C, D, E>> e = Comparator.comparing(Quintuple::getFifth);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e);
    }

    /**
     * Compare tuple fields in reverse order requiring that the fields are Comparable.
     * Each tuple field is compared using natural ordering.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>> Comparator<Quintuple<A, B, C, D, E>> compareByAllFieldsInReverseOrder(
            ) {
        Comparator<Quintuple<A, B, C, D, E>> a = Comparator.comparing(Quintuple::getFirst);
                Comparator<Quintuple<A, B, C, D, E>> b = Comparator.comparing(Quintuple::getSecond);
                Comparator<Quintuple<A, B, C, D, E>> c = Comparator.comparing(Quintuple::getThird);
                Comparator<Quintuple<A, B, C, D, E>> d = Comparator.comparing(Quintuple::getFourth);
                Comparator<Quintuple<A, B, C, D, E>> e = Comparator.comparing(Quintuple::getFifth);
        return (e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    /**
     * Compare tuple fields in order using a Function to make each value Comparable.
     * Especially useful where the value is not comparable, but it has a field that can be extracted for comparison.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>> Comparator<Quintuple<A, B, C, D, E>> compareByAllFieldsInOrder(
            Function<? super A, FA> fa, Function<? super B, FB> fb, Function<? super C, FC> fc,
            Function<? super D, FD> fd, Function<? super E, FE> fe) {
        Comparator<Quintuple<A, B, C, D, E>> a = Comparator.comparing(fa.compose(Quintuple::getFirst));
                Comparator<Quintuple<A, B, C, D, E>> b = Comparator.comparing(fb.compose(Quintuple::getSecond));
                Comparator<Quintuple<A, B, C, D, E>> c = Comparator.comparing(fc.compose(Quintuple::getThird));
                Comparator<Quintuple<A, B, C, D, E>> d = Comparator.comparing(fd.compose(Quintuple::getFourth));
                Comparator<Quintuple<A, B, C, D, E>> e = Comparator.comparing(fe.compose(Quintuple::getFifth));
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e);
    }

    /**
     * Compare tuple fields in reverse order using a Function to make each value Comparable.
     * Especially useful where the value is not comparable, but it has a field that can be extracted for comparison.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>> Comparator<Quintuple<A, B, C, D, E>> compareByAllFieldsInReverseOrder(
            Function<? super A, FA> fa, Function<? super B, FB> fb, Function<? super C, FC> fc,
            Function<? super D, FD> fd, Function<? super E, FE> fe) {
        Comparator<Quintuple<A, B, C, D, E>> a = Comparator.comparing(fa.compose(Quintuple::getFirst));
                Comparator<Quintuple<A, B, C, D, E>> b = Comparator.comparing(fb.compose(Quintuple::getSecond));
                Comparator<Quintuple<A, B, C, D, E>> c = Comparator.comparing(fc.compose(Quintuple::getThird));
                Comparator<Quintuple<A, B, C, D, E>> d = Comparator.comparing(fd.compose(Quintuple::getFourth));
                Comparator<Quintuple<A, B, C, D, E>> e = Comparator.comparing(fe.compose(Quintuple::getFifth));
        return (e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    /**
     * Compare tuple fields in order using a Comparator for each field.
     * Especially useful for null-safe comparison, eg:
     * <pre>{@code
     * Quintuple.compareByAllFieldsInOrder(Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo))
     * }</pre>
     */
    static <A, B, C, D, E> Comparator<Quintuple<A, B, C, D, E>> compareByAllFieldsInOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce) {
        Comparator<Quintuple<A, B, C, D, E>> a = Comparator.comparing(Quintuple::getFirst, ca);
                Comparator<Quintuple<A, B, C, D, E>> b = Comparator.comparing(Quintuple::getSecond, cb);
                Comparator<Quintuple<A, B, C, D, E>> c = Comparator.comparing(Quintuple::getThird, cc);
                Comparator<Quintuple<A, B, C, D, E>> d = Comparator.comparing(Quintuple::getFourth, cd);
                Comparator<Quintuple<A, B, C, D, E>> e = Comparator.comparing(Quintuple::getFifth, ce);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e);
    }

    /**
     * Compare tuple fields in reverse order using a Comparator for each field.
     * Especially useful for null-safe comparison, eg:
     * <pre>{@code
     * Quintuple.compareByAllFieldsInReverseOrder(Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo))
     * }</pre>
     */
    static <A, B, C, D, E> Comparator<Quintuple<A, B, C, D, E>> compareByAllFieldsInReverseOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce) {
        Comparator<Quintuple<A, B, C, D, E>> a = Comparator.comparing(Quintuple::getFirst, ca);
                Comparator<Quintuple<A, B, C, D, E>> b = Comparator.comparing(Quintuple::getSecond, cb);
                Comparator<Quintuple<A, B, C, D, E>> c = Comparator.comparing(Quintuple::getThird, cc);
                Comparator<Quintuple<A, B, C, D, E>> d = Comparator.comparing(Quintuple::getFourth, cd);
                Comparator<Quintuple<A, B, C, D, E>> e = Comparator.comparing(Quintuple::getFifth, ce);
        return (e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }
}
