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

public interface Septuple<A, B, C, D, E, F, G> {
    A getFirst();

    B getSecond();

    C getThird();

    D getFourth();

    E getFifth();

    F getSixth();

    G get();

    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>, F extends Comparable<? super F>, G extends Comparable<? super G>> Comparator<Septuple<A, B, C, D, E, F, G>> compareByAllFieldsInOrder(
    ) {
        Comparator<Septuple<A, B, C, D, E, F, G>> a = Comparator.comparing(Septuple::getFirst);
        Comparator<Septuple<A, B, C, D, E, F, G>> b = Comparator.comparing(Septuple::getSecond);
        Comparator<Septuple<A, B, C, D, E, F, G>> c = Comparator.comparing(Septuple::getThird);
        Comparator<Septuple<A, B, C, D, E, F, G>> d = Comparator.comparing(Septuple::getFourth);
        Comparator<Septuple<A, B, C, D, E, F, G>> e = Comparator.comparing(Septuple::getFifth);
        Comparator<Septuple<A, B, C, D, E, F, G>> f = Comparator.comparing(Septuple::getSixth);
        Comparator<Septuple<A, B, C, D, E, F, G>> g = Comparator.comparing(Septuple::get);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g);
    }

    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>, F extends Comparable<? super F>, G extends Comparable<? super G>> Comparator<Septuple<A, B, C, D, E, F, G>> compareByAllFieldsInReverseOrder(
    ) {
        Comparator<Septuple<A, B, C, D, E, F, G>> a = Comparator.comparing(Septuple::getFirst);
        Comparator<Septuple<A, B, C, D, E, F, G>> b = Comparator.comparing(Septuple::getSecond);
        Comparator<Septuple<A, B, C, D, E, F, G>> c = Comparator.comparing(Septuple::getThird);
        Comparator<Septuple<A, B, C, D, E, F, G>> d = Comparator.comparing(Septuple::getFourth);
        Comparator<Septuple<A, B, C, D, E, F, G>> e = Comparator.comparing(Septuple::getFifth);
        Comparator<Septuple<A, B, C, D, E, F, G>> f = Comparator.comparing(Septuple::getSixth);
        Comparator<Septuple<A, B, C, D, E, F, G>> g = Comparator.comparing(Septuple::get);
        return (g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>, F, FF extends Comparable<? super FF>, G, FG extends Comparable<? super FG>> Comparator<Septuple<A, B, C, D, E, F, G>> compareByAllFieldsInOrder(
            Function<A, FA> fa, Function<B, FB> fb, Function<C, FC> fc, Function<D, FD> fd,
            Function<E, FE> fe, Function<F, FF> ff, Function<G, FG> fg) {
        Comparator<Septuple<A, B, C, D, E, F, G>> a = Comparator.comparing(fa.compose(Septuple::getFirst));
        Comparator<Septuple<A, B, C, D, E, F, G>> b = Comparator.comparing(fb.compose(Septuple::getSecond));
        Comparator<Septuple<A, B, C, D, E, F, G>> c = Comparator.comparing(fc.compose(Septuple::getThird));
        Comparator<Septuple<A, B, C, D, E, F, G>> d = Comparator.comparing(fd.compose(Septuple::getFourth));
        Comparator<Septuple<A, B, C, D, E, F, G>> e = Comparator.comparing(fe.compose(Septuple::getFifth));
        Comparator<Septuple<A, B, C, D, E, F, G>> f = Comparator.comparing(ff.compose(Septuple::getSixth));
        Comparator<Septuple<A, B, C, D, E, F, G>> g = Comparator.comparing(fg.compose(Septuple::get));
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>, F, FF extends Comparable<? super FF>, G, FG extends Comparable<? super FG>> Comparator<Septuple<A, B, C, D, E, F, G>> compareByAllFieldsInReverseOrder(
            Function<A, FA> fa, Function<B, FB> fb, Function<C, FC> fc, Function<D, FD> fd,
            Function<E, FE> fe, Function<F, FF> ff, Function<G, FG> fg) {
        Comparator<Septuple<A, B, C, D, E, F, G>> a = Comparator.comparing(fa.compose(Septuple::getFirst));
        Comparator<Septuple<A, B, C, D, E, F, G>> b = Comparator.comparing(fb.compose(Septuple::getSecond));
        Comparator<Septuple<A, B, C, D, E, F, G>> c = Comparator.comparing(fc.compose(Septuple::getThird));
        Comparator<Septuple<A, B, C, D, E, F, G>> d = Comparator.comparing(fd.compose(Septuple::getFourth));
        Comparator<Septuple<A, B, C, D, E, F, G>> e = Comparator.comparing(fe.compose(Septuple::getFifth));
        Comparator<Septuple<A, B, C, D, E, F, G>> f = Comparator.comparing(ff.compose(Septuple::getSixth));
        Comparator<Septuple<A, B, C, D, E, F, G>> g = Comparator.comparing(fg.compose(Septuple::get));
        return (g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    static <A, B, C, D, E, F, G> Comparator<Septuple<A, B, C, D, E, F, G>> compareByAllFieldsInOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce, Comparator<? super F> cf,
            Comparator<? super G> cg) {
        Comparator<Septuple<A, B, C, D, E, F, G>> a = Comparator.comparing(Septuple::getFirst, ca);
        Comparator<Septuple<A, B, C, D, E, F, G>> b = Comparator.comparing(Septuple::getSecond, cb);
        Comparator<Septuple<A, B, C, D, E, F, G>> c = Comparator.comparing(Septuple::getThird, cc);
        Comparator<Septuple<A, B, C, D, E, F, G>> d = Comparator.comparing(Septuple::getFourth, cd);
        Comparator<Septuple<A, B, C, D, E, F, G>> e = Comparator.comparing(Septuple::getFifth, ce);
        Comparator<Septuple<A, B, C, D, E, F, G>> f = Comparator.comparing(Septuple::getSixth, cf);
        Comparator<Septuple<A, B, C, D, E, F, G>> g = Comparator.comparing(Septuple::get, cg);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g);
    }

    static <A, B, C, D, E, F, G> Comparator<Septuple<A, B, C, D, E, F, G>> compareByAllFieldsInReverseOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce, Comparator<? super F> cf,
            Comparator<? super G> cg) {
        Comparator<Septuple<A, B, C, D, E, F, G>> a = Comparator.comparing(Septuple::getFirst, ca);
        Comparator<Septuple<A, B, C, D, E, F, G>> b = Comparator.comparing(Septuple::getSecond, cb);
        Comparator<Septuple<A, B, C, D, E, F, G>> c = Comparator.comparing(Septuple::getThird, cc);
        Comparator<Septuple<A, B, C, D, E, F, G>> d = Comparator.comparing(Septuple::getFourth, cd);
        Comparator<Septuple<A, B, C, D, E, F, G>> e = Comparator.comparing(Septuple::getFifth, ce);
        Comparator<Septuple<A, B, C, D, E, F, G>> f = Comparator.comparing(Septuple::getSixth, cf);
        Comparator<Septuple<A, B, C, D, E, F, G>> g = Comparator.comparing(Septuple::get, cg);
        return (g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }
}
