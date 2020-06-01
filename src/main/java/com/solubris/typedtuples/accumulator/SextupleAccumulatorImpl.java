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

import com.solubris.typedtuples.Sextuple;
import com.solubris.typedtuples.immutable.ImmutableSextuple;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import com.solubris.typedtuples.mutable.MutableSextuple;
import com.solubris.typedtuples.mutable.MutableTuple;

import java.util.function.BinaryOperator;

final class SextupleAccumulatorImpl<A, B, C, D, E, F> implements SextupleAccumulator<A, B, C, D, E, F> {
    private final BinaryOperator<A> a;

    private final BinaryOperator<B> b;

    private final BinaryOperator<C> c;

    private final BinaryOperator<D> d;

    private final BinaryOperator<E> e;

    private final BinaryOperator<F> f;

    SextupleAccumulatorImpl(BinaryOperator<A> a, BinaryOperator<B> b, BinaryOperator<C> c,
                            BinaryOperator<D> d, BinaryOperator<E> e, BinaryOperator<F> f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
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
    public BinaryOperator<F> get() {
        return f;
    }

    @Override
    public void accumulate(MutableSextuple<A, B, C, D, E, F> acc, Sextuple<A, B, C, D, E, F> t) {
        acc.setFirst(a.apply(acc.getFirst(), t.getFirst()));
        acc.setSecond(b.apply(acc.getSecond(), t.getSecond()));
        acc.setThird(c.apply(acc.getThird(), t.getThird()));
        acc.setFourth(d.apply(acc.getFourth(), t.getFourth()));
        acc.setFifth(e.apply(acc.getFifth(), t.getFifth()));
        acc.set(f.apply(acc.get(), t.get()));
    }

    @Override
    public MutableSextuple<A, B, C, D, E, F> combine(MutableSextuple<A, B, C, D, E, F> l,
                                                     MutableSextuple<A, B, C, D, E, F> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        C fc = c.apply(l.getThird(), r.getThird());
        D fd = d.apply(l.getFourth(), r.getFourth());
        E fe = e.apply(l.getFifth(), r.getFifth());
        F ff = f.apply(l.get(), r.get());
        return MutableTuple.of(fa, fb, fc, fd, fe, ff);
    }

    @Override
    public ImmutableSextuple<A, B, C, D, E, F> combine(ImmutableSextuple<A, B, C, D, E, F> l,
                                                       ImmutableSextuple<A, B, C, D, E, F> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        C fc = c.apply(l.getThird(), r.getThird());
        D fd = d.apply(l.getFourth(), r.getFourth());
        E fe = e.apply(l.getFifth(), r.getFifth());
        F ff = f.apply(l.get(), r.get());
        return ImmutableTuple.of(fa, fb, fc, fd, fe, ff);
    }
}
