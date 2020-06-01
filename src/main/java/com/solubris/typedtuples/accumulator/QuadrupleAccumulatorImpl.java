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

import com.solubris.typedtuples.Quadruple;
import com.solubris.typedtuples.immutable.ImmutableQuadruple;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import com.solubris.typedtuples.mutable.MutableQuadruple;
import com.solubris.typedtuples.mutable.MutableTuple;

import java.util.function.BinaryOperator;

final class QuadrupleAccumulatorImpl<A, B, C, D> implements QuadrupleAccumulator<A, B, C, D> {
    private final BinaryOperator<A> a;

    private final BinaryOperator<B> b;

    private final BinaryOperator<C> c;

    private final BinaryOperator<D> d;

    QuadrupleAccumulatorImpl(BinaryOperator<A> a, BinaryOperator<B> b, BinaryOperator<C> c,
                             BinaryOperator<D> d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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
    public BinaryOperator<D> get() {
        return d;
    }

    @Override
    public void accumulate(MutableQuadruple<A, B, C, D> acc, Quadruple<A, B, C, D> t) {
        acc.setFirst(a.apply(acc.getFirst(), t.getFirst()));
        acc.setSecond(b.apply(acc.getSecond(), t.getSecond()));
        acc.setThird(c.apply(acc.getThird(), t.getThird()));
        acc.set(d.apply(acc.get(), t.get()));
    }

    @Override
    public MutableQuadruple<A, B, C, D> combine(MutableQuadruple<A, B, C, D> l,
                                                MutableQuadruple<A, B, C, D> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        C fc = c.apply(l.getThird(), r.getThird());
        D fd = d.apply(l.get(), r.get());
        return MutableTuple.of(fa, fb, fc, fd);
    }

    @Override
    public ImmutableQuadruple<A, B, C, D> combine(ImmutableQuadruple<A, B, C, D> l,
                                                  ImmutableQuadruple<A, B, C, D> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        C fc = c.apply(l.getThird(), r.getThird());
        D fd = d.apply(l.get(), r.get());
        return ImmutableTuple.of(fa, fb, fc, fd);
    }
}
