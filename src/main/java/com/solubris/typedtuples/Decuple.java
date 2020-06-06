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

public interface Decuple<A, B, C, D, E, F, G, H, I, J> {
    A getFirst();

    B getSecond();

    C getThird();

    D getFourth();

    E getFifth();

    F getSixth();

    G getSeventh();

    H getEighth();

    I getNinth();

    J get();

    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>, F extends Comparable<? super F>, G extends Comparable<? super G>, H extends Comparable<? super H>, I extends Comparable<? super I>, J extends Comparable<? super J>> Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> compareByAllFieldsInOrder(
    ) {
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> a = Comparator.comparing(Decuple::getFirst);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> b = Comparator.comparing(Decuple::getSecond);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> c = Comparator.comparing(Decuple::getThird);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> d = Comparator.comparing(Decuple::getFourth);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> e = Comparator.comparing(Decuple::getFifth);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> f = Comparator.comparing(Decuple::getSixth);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> g = Comparator.comparing(Decuple::getSeventh);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> h = Comparator.comparing(Decuple::getEighth);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> i = Comparator.comparing(Decuple::getNinth);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> j = Comparator.comparing(Decuple::get);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g).thenComparing(h).thenComparing(i).thenComparing(j);
    }

    static <A extends Comparable<? super A>, B extends Comparable<? super B>, C extends Comparable<? super C>, D extends Comparable<? super D>, E extends Comparable<? super E>, F extends Comparable<? super F>, G extends Comparable<? super G>, H extends Comparable<? super H>, I extends Comparable<? super I>, J extends Comparable<? super J>> Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> compareByAllFieldsInReverseOrder(
    ) {
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> a = Comparator.comparing(Decuple::getFirst);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> b = Comparator.comparing(Decuple::getSecond);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> c = Comparator.comparing(Decuple::getThird);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> d = Comparator.comparing(Decuple::getFourth);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> e = Comparator.comparing(Decuple::getFifth);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> f = Comparator.comparing(Decuple::getSixth);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> g = Comparator.comparing(Decuple::getSeventh);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> h = Comparator.comparing(Decuple::getEighth);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> i = Comparator.comparing(Decuple::getNinth);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> j = Comparator.comparing(Decuple::get);
        return (j).thenComparing(i).thenComparing(h).thenComparing(g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>, F, FF extends Comparable<? super FF>, G, FG extends Comparable<? super FG>, H, FH extends Comparable<? super FH>, I, FI extends Comparable<? super FI>, J, FJ extends Comparable<? super FJ>> Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> compareByAllFieldsInOrder(
            Function<A, FA> fa, Function<B, FB> fb, Function<C, FC> fc, Function<D, FD> fd,
            Function<E, FE> fe, Function<F, FF> ff, Function<G, FG> fg, Function<H, FH> fh,
            Function<I, FI> fi, Function<J, FJ> fj) {
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> a = Comparator.comparing(fa.compose(Decuple::getFirst));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> b = Comparator.comparing(fb.compose(Decuple::getSecond));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> c = Comparator.comparing(fc.compose(Decuple::getThird));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> d = Comparator.comparing(fd.compose(Decuple::getFourth));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> e = Comparator.comparing(fe.compose(Decuple::getFifth));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> f = Comparator.comparing(ff.compose(Decuple::getSixth));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> g = Comparator.comparing(fg.compose(Decuple::getSeventh));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> h = Comparator.comparing(fh.compose(Decuple::getEighth));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> i = Comparator.comparing(fi.compose(Decuple::getNinth));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> j = Comparator.comparing(fj.compose(Decuple::get));
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g).thenComparing(h).thenComparing(i).thenComparing(j);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>, C, FC extends Comparable<? super FC>, D, FD extends Comparable<? super FD>, E, FE extends Comparable<? super FE>, F, FF extends Comparable<? super FF>, G, FG extends Comparable<? super FG>, H, FH extends Comparable<? super FH>, I, FI extends Comparable<? super FI>, J, FJ extends Comparable<? super FJ>> Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> compareByAllFieldsInReverseOrder(
            Function<A, FA> fa, Function<B, FB> fb, Function<C, FC> fc, Function<D, FD> fd,
            Function<E, FE> fe, Function<F, FF> ff, Function<G, FG> fg, Function<H, FH> fh,
            Function<I, FI> fi, Function<J, FJ> fj) {
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> a = Comparator.comparing(fa.compose(Decuple::getFirst));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> b = Comparator.comparing(fb.compose(Decuple::getSecond));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> c = Comparator.comparing(fc.compose(Decuple::getThird));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> d = Comparator.comparing(fd.compose(Decuple::getFourth));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> e = Comparator.comparing(fe.compose(Decuple::getFifth));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> f = Comparator.comparing(ff.compose(Decuple::getSixth));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> g = Comparator.comparing(fg.compose(Decuple::getSeventh));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> h = Comparator.comparing(fh.compose(Decuple::getEighth));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> i = Comparator.comparing(fi.compose(Decuple::getNinth));
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> j = Comparator.comparing(fj.compose(Decuple::get));
        return (j).thenComparing(i).thenComparing(h).thenComparing(g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }

    static <A, B, C, D, E, F, G, H, I, J> Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> compareByAllFieldsInOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce, Comparator<? super F> cf,
            Comparator<? super G> cg, Comparator<? super H> ch, Comparator<? super I> ci,
            Comparator<? super J> cj) {
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> a = Comparator.comparing(Decuple::getFirst, ca);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> b = Comparator.comparing(Decuple::getSecond, cb);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> c = Comparator.comparing(Decuple::getThird, cc);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> d = Comparator.comparing(Decuple::getFourth, cd);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> e = Comparator.comparing(Decuple::getFifth, ce);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> f = Comparator.comparing(Decuple::getSixth, cf);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> g = Comparator.comparing(Decuple::getSeventh, cg);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> h = Comparator.comparing(Decuple::getEighth, ch);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> i = Comparator.comparing(Decuple::getNinth, ci);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> j = Comparator.comparing(Decuple::get, cj);
        return (a).thenComparing(b).thenComparing(c).thenComparing(d).thenComparing(e).thenComparing(f).thenComparing(g).thenComparing(h).thenComparing(i).thenComparing(j);
    }

    static <A, B, C, D, E, F, G, H, I, J> Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> compareByAllFieldsInReverseOrder(
            Comparator<? super A> ca, Comparator<? super B> cb, Comparator<? super C> cc,
            Comparator<? super D> cd, Comparator<? super E> ce, Comparator<? super F> cf,
            Comparator<? super G> cg, Comparator<? super H> ch, Comparator<? super I> ci,
            Comparator<? super J> cj) {
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> a = Comparator.comparing(Decuple::getFirst, ca);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> b = Comparator.comparing(Decuple::getSecond, cb);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> c = Comparator.comparing(Decuple::getThird, cc);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> d = Comparator.comparing(Decuple::getFourth, cd);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> e = Comparator.comparing(Decuple::getFifth, ce);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> f = Comparator.comparing(Decuple::getSixth, cf);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> g = Comparator.comparing(Decuple::getSeventh, cg);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> h = Comparator.comparing(Decuple::getEighth, ch);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> i = Comparator.comparing(Decuple::getNinth, ci);
        Comparator<Decuple<A, B, C, D, E, F, G, H, I, J>> j = Comparator.comparing(Decuple::get, cj);
        return (j).thenComparing(i).thenComparing(h).thenComparing(g).thenComparing(f).thenComparing(e).thenComparing(d).thenComparing(c).thenComparing(b).thenComparing(a);
    }
}
