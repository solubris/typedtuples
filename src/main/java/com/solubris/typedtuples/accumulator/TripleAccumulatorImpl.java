// Copyright 2020 Solubris Ltd.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.solubris.typedtuples.accumulator;

import com.solubris.typedtuples.Triple;
import com.solubris.typedtuples.immutable.ImmutableTriple;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import com.solubris.typedtuples.mutable.MutableTriple;
import com.solubris.typedtuples.mutable.MutableTuple;

import java.util.function.BinaryOperator;

final class TripleAccumulatorImpl<A, B, C> implements TripleAccumulator<A, B, C> {
    private final BinaryOperator<A> a;

    private final BinaryOperator<B> b;

    private final BinaryOperator<C> c;

    TripleAccumulatorImpl(BinaryOperator<A> a, BinaryOperator<B> b, BinaryOperator<C> c) {
        this.a = a;
        this.b = b;
        this.c = c;
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
    public BinaryOperator<C> get() {
        return c;
    }

    @Override
    public void accumulate(MutableTriple<A, B, C> acc, Triple<A, B, C> t) {
        acc.setFirst(a.apply(acc.getFirst(), t.getFirst()));
        acc.setSecond(b.apply(acc.getSecond(), t.getSecond()));
        acc.set(c.apply(acc.get(), t.get()));
    }

    @Override
    public MutableTriple<A, B, C> combine(MutableTriple<A, B, C> l, MutableTriple<A, B, C> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        C fc = c.apply(l.get(), r.get());
        return MutableTuple.of(fa, fb, fc);
    }

    @Override
    public ImmutableTriple<A, B, C> combine(ImmutableTriple<A, B, C> l,
            ImmutableTriple<A, B, C> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        C fc = c.apply(l.get(), r.get());
        return ImmutableTuple.of(fa, fb, fc);
    }
}
