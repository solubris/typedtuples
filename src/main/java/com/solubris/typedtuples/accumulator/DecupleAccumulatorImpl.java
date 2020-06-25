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

package com.solubris.typedtuples.accumulator;

import com.solubris.typedtuples.Decuple;
import com.solubris.typedtuples.immutable.ImmutableDecuple;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import com.solubris.typedtuples.mutable.MutableDecuple;
import com.solubris.typedtuples.mutable.MutableTuple;

import java.util.function.BinaryOperator;

final class DecupleAccumulatorImpl<A, B, C, D, E, F, G, H, I, J> implements DecupleAccumulator<A, B, C, D, E, F, G, H, I, J> {
    private final BinaryOperator<A> a;

    private final BinaryOperator<B> b;

    private final BinaryOperator<C> c;

    private final BinaryOperator<D> d;

    private final BinaryOperator<E> e;

    private final BinaryOperator<F> f;

    private final BinaryOperator<G> g;

    private final BinaryOperator<H> h;

    private final BinaryOperator<I> i;

    private final BinaryOperator<J> j;

    DecupleAccumulatorImpl(BinaryOperator<A> a, BinaryOperator<B> b, BinaryOperator<C> c,
            BinaryOperator<D> d, BinaryOperator<E> e, BinaryOperator<F> f, BinaryOperator<G> g,
            BinaryOperator<H> h, BinaryOperator<I> i, BinaryOperator<J> j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }

    @Override
    public BinaryOperator<A> getFirst() {
        return a;
    }

    @Override
    public BinaryOperator<B> getSecond() {
        return b;
    }

    @Override
    public BinaryOperator<C> getThird() {
        return c;
    }

    @Override
    public BinaryOperator<D> getFourth() {
        return d;
    }

    @Override
    public BinaryOperator<E> getFifth() {
        return e;
    }

    @Override
    public BinaryOperator<F> getSixth() {
        return f;
    }

    @Override
    public BinaryOperator<G> getSeventh() {
        return g;
    }

    @Override
    public BinaryOperator<H> getEighth() {
        return h;
    }

    @Override
    public BinaryOperator<I> getNinth() {
        return i;
    }

    @Override
    public BinaryOperator<J> getTenth() {
        return j;
    }

    @Override
    public void accumulate(MutableDecuple<A, B, C, D, E, F, G, H, I, J> acc,
            Decuple<A, B, C, D, E, F, G, H, I, J> t) {
        acc.setFirst(a.apply(acc.getFirst(), t.getFirst()));
        acc.setSecond(b.apply(acc.getSecond(), t.getSecond()));
        acc.setThird(c.apply(acc.getThird(), t.getThird()));
        acc.setFourth(d.apply(acc.getFourth(), t.getFourth()));
        acc.setFifth(e.apply(acc.getFifth(), t.getFifth()));
        acc.setSixth(f.apply(acc.getSixth(), t.getSixth()));
        acc.setSeventh(g.apply(acc.getSeventh(), t.getSeventh()));
        acc.setEighth(h.apply(acc.getEighth(), t.getEighth()));
        acc.setNinth(i.apply(acc.getNinth(), t.getNinth()));
        acc.setTenth(j.apply(acc.getTenth(), t.getTenth()));
    }

    @Override
    public MutableDecuple<A, B, C, D, E, F, G, H, I, J> combine(
            MutableDecuple<A, B, C, D, E, F, G, H, I, J> l,
            MutableDecuple<A, B, C, D, E, F, G, H, I, J> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        C fc = c.apply(l.getThird(), r.getThird());
        D fd = d.apply(l.getFourth(), r.getFourth());
        E fe = e.apply(l.getFifth(), r.getFifth());
        F ff = f.apply(l.getSixth(), r.getSixth());
        G fg = g.apply(l.getSeventh(), r.getSeventh());
        H fh = h.apply(l.getEighth(), r.getEighth());
        I fi = i.apply(l.getNinth(), r.getNinth());
        J fj = j.apply(l.getTenth(), r.getTenth());
        return MutableTuple.of(fa, fb, fc, fd, fe, ff, fg, fh, fi, fj);
    }

    @Override
    public ImmutableDecuple<A, B, C, D, E, F, G, H, I, J> combine(
            ImmutableDecuple<A, B, C, D, E, F, G, H, I, J> l,
            ImmutableDecuple<A, B, C, D, E, F, G, H, I, J> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        C fc = c.apply(l.getThird(), r.getThird());
        D fd = d.apply(l.getFourth(), r.getFourth());
        E fe = e.apply(l.getFifth(), r.getFifth());
        F ff = f.apply(l.getSixth(), r.getSixth());
        G fg = g.apply(l.getSeventh(), r.getSeventh());
        H fh = h.apply(l.getEighth(), r.getEighth());
        I fi = i.apply(l.getNinth(), r.getNinth());
        J fj = j.apply(l.getTenth(), r.getTenth());
        return ImmutableTuple.of(fa, fb, fc, fd, fe, ff, fg, fh, fi, fj);
    }
}
