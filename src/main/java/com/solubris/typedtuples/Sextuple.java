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

public interface Sextuple<A, B, C, D, E, F> {
    A getFirst();

    B getSecond();

    C getThird();

    D getFourth();

    E getFifth();

    F get();

    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>, F extends Comparable<? super F>> Comparator<Sextuple<A, B, C, D, E, F>> compareByAllFieldsInOrder(
    ) {
        Comparator<Sextuple<A, B, C, D, E, F>> a = Comparator.comparing(Sextuple::getFirst);
        Comparator<Sextuple<A, B, C, D, E, F>> b = Comparator.comparing(Sextuple::getSecond);
        Comparator<Sextuple<A, B, C, D, E, F>> c = Comparator.comparing(Sextuple::getThird);
        Comparator<Sextuple<A, B, C, D, E, F>> d = Comparator.comparing(Sextuple::getFourth);
        Comparator<Sextuple<A, B, C, D, E, F>> e = Comparator.comparing(Sextuple::getFifth);
        Comparator<Sextuple<A, B, C, D, E, F>> f = Comparator.comparing(Sextuple::get);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f);
    }

    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>, F extends Comparable<? super F>> Comparator<Sextuple<A, B, C, D, E, F>> compareByAllFieldsInReverseOrder(
    ) {
        Comparator<Sextuple<A, B, C, D, E, F>> a = Comparator.comparing(Sextuple::getFirst);
        Comparator<Sextuple<A, B, C, D, E, F>> b = Comparator.comparing(Sextuple::getSecond);
        Comparator<Sextuple<A, B, C, D, E, F>> c = Comparator.comparing(Sextuple::getThird);
        Comparator<Sextuple<A, B, C, D, E, F>> d = Comparator.comparing(Sextuple::getFourth);
        Comparator<Sextuple<A, B, C, D, E, F>> e = Comparator.comparing(Sextuple::getFifth);
        Comparator<Sextuple<A, B, C, D, E, F>> f = Comparator.comparing(Sextuple::get);
        return (f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>, F, FF extends Comparable<? super FF>> Comparator<Sextuple<A, B, C, D, E, F>> compareByAllFieldsInOrder(
            Function<A, FA> fa, Function<B, FB> fb, Function<C, FC> fc, Function<D, FD> fd,
            Function<E, FE> fe, Function<F, FF> ff) {
        Comparator<Sextuple<A, B, C, D, E, F>> a = Comparator.comparing(fa.compose(Sextuple::getFirst));
        Comparator<Sextuple<A, B, C, D, E, F>> b = Comparator.comparing(fb.compose(Sextuple::getSecond));
        Comparator<Sextuple<A, B, C, D, E, F>> c = Comparator.comparing(fc.compose(Sextuple::getThird));
        Comparator<Sextuple<A, B, C, D, E, F>> d = Comparator.comparing(fd.compose(Sextuple::getFourth));
        Comparator<Sextuple<A, B, C, D, E, F>> e = Comparator.comparing(fe.compose(Sextuple::getFifth));
        Comparator<Sextuple<A, B, C, D, E, F>> f = Comparator.comparing(ff.compose(Sextuple::get));
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>, F, FF extends Comparable<? super FF>> Comparator<Sextuple<A, B, C, D, E, F>> compareByAllFieldsInReverseOrder(
            Function<A, FA> fa, Function<B, FB> fb, Function<C, FC> fc, Function<D, FD> fd,
            Function<E, FE> fe, Function<F, FF> ff) {
        Comparator<Sextuple<A, B, C, D, E, F>> a = Comparator.comparing(fa.compose(Sextuple::getFirst));
        Comparator<Sextuple<A, B, C, D, E, F>> b = Comparator.comparing(fb.compose(Sextuple::getSecond));
        Comparator<Sextuple<A, B, C, D, E, F>> c = Comparator.comparing(fc.compose(Sextuple::getThird));
        Comparator<Sextuple<A, B, C, D, E, F>> d = Comparator.comparing(fd.compose(Sextuple::getFourth));
        Comparator<Sextuple<A, B, C, D, E, F>> e = Comparator.comparing(fe.compose(Sextuple::getFifth));
        Comparator<Sextuple<A, B, C, D, E, F>> f = Comparator.comparing(ff.compose(Sextuple::get));
        return (f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    static <A, B, C, D, E, F> Comparator<Sextuple<A, B, C, D, E, F>> compareByAllFieldsInOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce, Comparator<? super F> cf) {
        Comparator<Sextuple<A, B, C, D, E, F>> a = Comparator.comparing(Sextuple::getFirst, ca);
        Comparator<Sextuple<A, B, C, D, E, F>> b = Comparator.comparing(Sextuple::getSecond, cb);
        Comparator<Sextuple<A, B, C, D, E, F>> c = Comparator.comparing(Sextuple::getThird, cc);
        Comparator<Sextuple<A, B, C, D, E, F>> d = Comparator.comparing(Sextuple::getFourth, cd);
        Comparator<Sextuple<A, B, C, D, E, F>> e = Comparator.comparing(Sextuple::getFifth, ce);
        Comparator<Sextuple<A, B, C, D, E, F>> f = Comparator.comparing(Sextuple::get, cf);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f);
    }

    static <A, B, C, D, E, F> Comparator<Sextuple<A, B, C, D, E, F>> compareByAllFieldsInReverseOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce, Comparator<? super F> cf) {
        Comparator<Sextuple<A, B, C, D, E, F>> a = Comparator.comparing(Sextuple::getFirst, ca);
        Comparator<Sextuple<A, B, C, D, E, F>> b = Comparator.comparing(Sextuple::getSecond, cb);
        Comparator<Sextuple<A, B, C, D, E, F>> c = Comparator.comparing(Sextuple::getThird, cc);
        Comparator<Sextuple<A, B, C, D, E, F>> d = Comparator.comparing(Sextuple::getFourth, cd);
        Comparator<Sextuple<A, B, C, D, E, F>> e = Comparator.comparing(Sextuple::getFifth, ce);
        Comparator<Sextuple<A, B, C, D, E, F>> f = Comparator.comparing(Sextuple::get, cf);
        return (f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }
}
