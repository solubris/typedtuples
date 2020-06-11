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

public interface Nonuple<A, B, C, D, E, F, G, H, I> {
    A getFirst();

    B getSecond();

    C getThird();

    D getFourth();

    E getFifth();

    F getSixth();

    G getSeventh();

    H getEighth();

    I get();

    /**
     * Compare tuple fields in order requiring that the fields are Comparable.
     * Each tuple field is compared using natural ordering.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>, F extends Comparable<? super F>, G extends Comparable<? super G>, H extends Comparable<? super H>, I extends Comparable<? super I>> Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> compareByAllFieldsInOrder(
            ) {
        Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> a = Comparator.comparing(Nonuple::getFirst);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> b = Comparator.comparing(Nonuple::getSecond);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> c = Comparator.comparing(Nonuple::getThird);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> d = Comparator.comparing(Nonuple::getFourth);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> e = Comparator.comparing(Nonuple::getFifth);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> f = Comparator.comparing(Nonuple::getSixth);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> g = Comparator.comparing(Nonuple::getSeventh);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> h = Comparator.comparing(Nonuple::getEighth);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> i = Comparator.comparing(Nonuple::get);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g).thenComparing(h).thenComparing(i);
    }

    /**
     * Compare tuple fields in reverse order requiring that the fields are Comparable.
     * Each tuple field is compared using natural ordering.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>, F extends Comparable<? super F>, G extends Comparable<? super G>, H extends Comparable<? super H>, I extends Comparable<? super I>> Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> compareByAllFieldsInReverseOrder(
            ) {
        Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> a = Comparator.comparing(Nonuple::getFirst);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> b = Comparator.comparing(Nonuple::getSecond);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> c = Comparator.comparing(Nonuple::getThird);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> d = Comparator.comparing(Nonuple::getFourth);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> e = Comparator.comparing(Nonuple::getFifth);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> f = Comparator.comparing(Nonuple::getSixth);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> g = Comparator.comparing(Nonuple::getSeventh);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> h = Comparator.comparing(Nonuple::getEighth);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> i = Comparator.comparing(Nonuple::get);
        return (i).thenComparing(h).thenComparing(g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    /**
     * Compare tuple fields in order using a Function to make each value Comparable.
     * Especially useful where the value is not comparable, but it has a field that can be extracted for comparison.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>, F, FF extends Comparable<? super FF>, G, FG extends Comparable<? super FG>, H, FH extends Comparable<? super FH>, I, FI extends Comparable<? super FI>> Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> compareByAllFieldsInOrder(
            Function<? super A, FA> fa, Function<? super B, FB> fb, Function<? super C, FC> fc,
            Function<? super D, FD> fd, Function<? super E, FE> fe, Function<? super F, FF> ff,
            Function<? super G, FG> fg, Function<? super H, FH> fh, Function<? super I, FI> fi) {
        Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> a = Comparator.comparing(fa.compose(Nonuple::getFirst));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> b = Comparator.comparing(fb.compose(Nonuple::getSecond));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> c = Comparator.comparing(fc.compose(Nonuple::getThird));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> d = Comparator.comparing(fd.compose(Nonuple::getFourth));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> e = Comparator.comparing(fe.compose(Nonuple::getFifth));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> f = Comparator.comparing(ff.compose(Nonuple::getSixth));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> g = Comparator.comparing(fg.compose(Nonuple::getSeventh));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> h = Comparator.comparing(fh.compose(Nonuple::getEighth));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> i = Comparator.comparing(fi.compose(Nonuple::get));
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g).thenComparing(h).thenComparing(i);
    }

    /**
     * Compare tuple fields in reverse order using a Function to make each value Comparable.
     * Especially useful where the value is not comparable, but it has a field that can be extracted for comparison.
     * Null values are not allowed, use the alternative method that accepts a Comparator.
     */
    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>, F, FF extends Comparable<? super FF>, G, FG extends Comparable<? super FG>, H, FH extends Comparable<? super FH>, I, FI extends Comparable<? super FI>> Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> compareByAllFieldsInReverseOrder(
            Function<? super A, FA> fa, Function<? super B, FB> fb, Function<? super C, FC> fc,
            Function<? super D, FD> fd, Function<? super E, FE> fe, Function<? super F, FF> ff,
            Function<? super G, FG> fg, Function<? super H, FH> fh, Function<? super I, FI> fi) {
        Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> a = Comparator.comparing(fa.compose(Nonuple::getFirst));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> b = Comparator.comparing(fb.compose(Nonuple::getSecond));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> c = Comparator.comparing(fc.compose(Nonuple::getThird));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> d = Comparator.comparing(fd.compose(Nonuple::getFourth));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> e = Comparator.comparing(fe.compose(Nonuple::getFifth));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> f = Comparator.comparing(ff.compose(Nonuple::getSixth));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> g = Comparator.comparing(fg.compose(Nonuple::getSeventh));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> h = Comparator.comparing(fh.compose(Nonuple::getEighth));
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> i = Comparator.comparing(fi.compose(Nonuple::get));
        return (i).thenComparing(h).thenComparing(g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    /**
     * Compare tuple fields in order using a Comparator for each field.
     * Especially useful for null-safe comparison, eg:
     * <pre>{@code
     * Nonuple.compareByAllFieldsInOrder(Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo))
     * }</pre>
     */
    static <A, B, C, D, E, F, G, H, I> Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> compareByAllFieldsInOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce, Comparator<? super F> cf,
            Comparator<? super G> cg, Comparator<? super H> ch, Comparator<? super I> ci) {
        Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> a = Comparator.comparing(Nonuple::getFirst, ca);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> b = Comparator.comparing(Nonuple::getSecond, cb);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> c = Comparator.comparing(Nonuple::getThird, cc);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> d = Comparator.comparing(Nonuple::getFourth, cd);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> e = Comparator.comparing(Nonuple::getFifth, ce);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> f = Comparator.comparing(Nonuple::getSixth, cf);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> g = Comparator.comparing(Nonuple::getSeventh, cg);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> h = Comparator.comparing(Nonuple::getEighth, ch);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> i = Comparator.comparing(Nonuple::get, ci);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g).thenComparing(h).thenComparing(i);
    }

    /**
     * Compare tuple fields in reverse order using a Comparator for each field.
     * Especially useful for null-safe comparison, eg:
     * <pre>{@code
     * Nonuple.compareByAllFieldsInReverseOrder(Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo), 
     *     Comparator.nullsLast(Integer::compareTo))
     * }</pre>
     */
    static <A, B, C, D, E, F, G, H, I> Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> compareByAllFieldsInReverseOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce, Comparator<? super F> cf,
            Comparator<? super G> cg, Comparator<? super H> ch, Comparator<? super I> ci) {
        Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> a = Comparator.comparing(Nonuple::getFirst, ca);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> b = Comparator.comparing(Nonuple::getSecond, cb);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> c = Comparator.comparing(Nonuple::getThird, cc);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> d = Comparator.comparing(Nonuple::getFourth, cd);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> e = Comparator.comparing(Nonuple::getFifth, ce);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> f = Comparator.comparing(Nonuple::getSixth, cf);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> g = Comparator.comparing(Nonuple::getSeventh, cg);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> h = Comparator.comparing(Nonuple::getEighth, ch);
                Comparator<Nonuple<A, B, C, D, E, F, G, H, I>> i = Comparator.comparing(Nonuple::get, ci);
        return (i).thenComparing(h).thenComparing(g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }
}
