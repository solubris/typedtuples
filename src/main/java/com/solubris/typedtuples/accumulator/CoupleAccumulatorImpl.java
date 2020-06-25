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

import com.solubris.typedtuples.Couple;
import com.solubris.typedtuples.immutable.ImmutableCouple;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import com.solubris.typedtuples.mutable.MutableCouple;
import com.solubris.typedtuples.mutable.MutableTuple;

import java.util.function.BinaryOperator;

final class CoupleAccumulatorImpl<A, B> implements CoupleAccumulator<A, B> {
    private final BinaryOperator<A> a;

    private final BinaryOperator<B> b;

    CoupleAccumulatorImpl(BinaryOperator<A> a, BinaryOperator<B> b) {
        this.a = a;
        this.b = b;
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
    public void accumulate(MutableCouple<A, B> acc, Couple<A, B> t) {
        acc.setFirst(a.apply(acc.getFirst(), t.getFirst()));
        acc.setSecond(b.apply(acc.getSecond(), t.getSecond()));
    }

    @Override
    public MutableCouple<A, B> combine(MutableCouple<A, B> l, MutableCouple<A, B> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        return MutableTuple.of(fa, fb);
    }

    @Override
    public ImmutableCouple<A, B> combine(ImmutableCouple<A, B> l, ImmutableCouple<A, B> r) {
        A fa = a.apply(l.getFirst(), r.getFirst());
        B fb = b.apply(l.getSecond(), r.getSecond());
        return ImmutableTuple.of(fa, fb);
    }
}
