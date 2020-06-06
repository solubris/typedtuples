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

public interface Octuple<A, B, C, D, E, F, G, H> {
    A getFirst();

    B getSecond();

    C getThird();

    D getFourth();

    E getFifth();

    F getSixth();

    G getSeventh();

    H get();

    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>, F extends Comparable<? super F>, G extends Comparable<? super G>, H extends Comparable<? super H>> Comparator<Octuple<A, B, C, D, E, F, G, H>> compareByAllFieldsInOrder(
    ) {
        Comparator<Octuple<A, B, C, D, E, F, G, H>> a = Comparator.comparing(Octuple::getFirst);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> b = Comparator.comparing(Octuple::getSecond);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> c = Comparator.comparing(Octuple::getThird);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> d = Comparator.comparing(Octuple::getFourth);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> e = Comparator.comparing(Octuple::getFifth);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> f = Comparator.comparing(Octuple::getSixth);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> g = Comparator.comparing(Octuple::getSeventh);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> h = Comparator.comparing(Octuple::get);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g).thenComparing(h);
    }

    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>, F extends Comparable<? super F>, G extends Comparable<? super G>, H extends Comparable<? super H>> Comparator<Octuple<A, B, C, D, E, F, G, H>> compareByAllFieldsInReverseOrder(
    ) {
        Comparator<Octuple<A, B, C, D, E, F, G, H>> a = Comparator.comparing(Octuple::getFirst);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> b = Comparator.comparing(Octuple::getSecond);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> c = Comparator.comparing(Octuple::getThird);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> d = Comparator.comparing(Octuple::getFourth);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> e = Comparator.comparing(Octuple::getFifth);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> f = Comparator.comparing(Octuple::getSixth);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> g = Comparator.comparing(Octuple::getSeventh);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> h = Comparator.comparing(Octuple::get);
        return (h).thenComparing(g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>, F, FF extends Comparable<? super FF>, G, FG extends Comparable<? super FG>, H, FH extends Comparable<? super FH>> Comparator<Octuple<A, B, C, D, E, F, G, H>> compareByAllFieldsInOrder(
            Function<A, FA> fa, Function<B, FB> fb, Function<C, FC> fc, Function<D, FD> fd,
            Function<E, FE> fe, Function<F, FF> ff, Function<G, FG> fg, Function<H, FH> fh) {
        Comparator<Octuple<A, B, C, D, E, F, G, H>> a = Comparator.comparing(fa.compose(Octuple::getFirst));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> b = Comparator.comparing(fb.compose(Octuple::getSecond));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> c = Comparator.comparing(fc.compose(Octuple::getThird));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> d = Comparator.comparing(fd.compose(Octuple::getFourth));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> e = Comparator.comparing(fe.compose(Octuple::getFifth));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> f = Comparator.comparing(ff.compose(Octuple::getSixth));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> g = Comparator.comparing(fg.compose(Octuple::getSeventh));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> h = Comparator.comparing(fh.compose(Octuple::get));
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g).thenComparing(h);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>, F, FF extends Comparable<? super FF>, G, FG extends Comparable<? super FG>, H, FH extends Comparable<? super FH>> Comparator<Octuple<A, B, C, D, E, F, G, H>> compareByAllFieldsInReverseOrder(
            Function<A, FA> fa, Function<B, FB> fb, Function<C, FC> fc, Function<D, FD> fd,
            Function<E, FE> fe, Function<F, FF> ff, Function<G, FG> fg, Function<H, FH> fh) {
        Comparator<Octuple<A, B, C, D, E, F, G, H>> a = Comparator.comparing(fa.compose(Octuple::getFirst));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> b = Comparator.comparing(fb.compose(Octuple::getSecond));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> c = Comparator.comparing(fc.compose(Octuple::getThird));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> d = Comparator.comparing(fd.compose(Octuple::getFourth));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> e = Comparator.comparing(fe.compose(Octuple::getFifth));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> f = Comparator.comparing(ff.compose(Octuple::getSixth));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> g = Comparator.comparing(fg.compose(Octuple::getSeventh));
        Comparator<Octuple<A, B, C, D, E, F, G, H>> h = Comparator.comparing(fh.compose(Octuple::get));
        return (h).thenComparing(g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    static <A, B, C, D, E, F, G, H> Comparator<Octuple<A, B, C, D, E, F, G, H>> compareByAllFieldsInOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce, Comparator<? super F> cf,
            Comparator<? super G> cg, Comparator<? super H> ch) {
        Comparator<Octuple<A, B, C, D, E, F, G, H>> a = Comparator.comparing(Octuple::getFirst, ca);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> b = Comparator.comparing(Octuple::getSecond, cb);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> c = Comparator.comparing(Octuple::getThird, cc);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> d = Comparator.comparing(Octuple::getFourth, cd);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> e = Comparator.comparing(Octuple::getFifth, ce);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> f = Comparator.comparing(Octuple::getSixth, cf);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> g = Comparator.comparing(Octuple::getSeventh, cg);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> h = Comparator.comparing(Octuple::get, ch);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g).thenComparing(h);
    }

    static <A, B, C, D, E, F, G, H> Comparator<Octuple<A, B, C, D, E, F, G, H>> compareByAllFieldsInReverseOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce, Comparator<? super F> cf,
            Comparator<? super G> cg, Comparator<? super H> ch) {
        Comparator<Octuple<A, B, C, D, E, F, G, H>> a = Comparator.comparing(Octuple::getFirst, ca);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> b = Comparator.comparing(Octuple::getSecond, cb);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> c = Comparator.comparing(Octuple::getThird, cc);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> d = Comparator.comparing(Octuple::getFourth, cd);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> e = Comparator.comparing(Octuple::getFifth, ce);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> f = Comparator.comparing(Octuple::getSixth, cf);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> g = Comparator.comparing(Octuple::getSeventh, cg);
        Comparator<Octuple<A, B, C, D, E, F, G, H>> h = Comparator.comparing(Octuple::get, ch);
        return (h).thenComparing(g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }
}
