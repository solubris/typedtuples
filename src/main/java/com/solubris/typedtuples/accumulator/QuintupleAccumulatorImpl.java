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

import com.solubris.typedtuples.Quintuple;
import com.solubris.typedtuples.immutable.ImmutableQuintuple;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import com.solubris.typedtuples.mutable.MutableQuintuple;
import com.solubris.typedtuples.mutable.MutableTuple;

import java.util.function.BinaryOperator;

final class QuintupleAccumulatorImpl<A, B, C, D, E> implements QuintupleAccumulator<A, B, C, D, E> {
    private final BinaryOperator<A> a;

    private final BinaryOperator<B> b;

    private final BinaryOperator<C> c;

    private final BinaryOperator<D> d;

    private final BinaryOperator<E> e;

    QuintupleAccumulatorImpl(BinaryOperator<A> a, BinaryOperator<B> b, BinaryOperator<C> c,
                             BinaryOperator<D> d, BinaryOperator<E> e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
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
    public BinaryOperator<E> get() {
        return e;
    }

    @Override
    public void accumulate(MutableQuintuple<A, B, C, D, E> acc, Quintuple<A, B, C, D, E> t) {
        acc.setFirst(a.apply(acc.getFirst(), t.getFirst()));
        acc.setSecond(b.apply(acc.getSecond(), t.getSecond()));
        acc.setThird(c.apply(acc.getThird(), t.getThird()));
        acc.setFourth(d.apply(acc.getFourth(), t.getFourth()));
        acc.set(e.apply(acc.get(), t.get()));
    }

    @Override
    public MutableQuintuple<A, B, C, D, E> combine(MutableQuintuple<A, B, C, D, E> l,
                                                   MutableQuintuple<A, B, C, D, E> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        C fc = c.apply(l.getThird(), r.getThird());
        D fd = d.apply(l.getFourth(), r.getFourth());
        E fe = e.apply(l.get(), r.get());
        return MutableTuple.of(fa, fb, fc, fd, fe);
    }

    @Override
    public ImmutableQuintuple<A, B, C, D, E> combine(ImmutableQuintuple<A, B, C, D, E> l,
                                                     ImmutableQuintuple<A, B, C, D, E> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        C fc = c.apply(l.getThird(), r.getThird());
        D fd = d.apply(l.getFourth(), r.getFourth());
        E fe = e.apply(l.get(), r.get());
        return ImmutableTuple.of(fa, fb, fc, fd, fe);
    }
}
