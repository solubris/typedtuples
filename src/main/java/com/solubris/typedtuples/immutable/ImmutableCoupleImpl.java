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

package com.solubris.typedtuples.immutable;

import com.solubris.typedtuples.Couple;
import com.solubris.typedtuples.function.CoupleFunction;

import java.util.Objects;
import java.util.function.Function;

final class ImmutableCoupleImpl<A, B> implements ImmutableCouple<A, B> {
    private final A a;

    private final B b;

    ImmutableCoupleImpl(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public A getFirst() {
        return a;
    }

    @Override
    public B getSecond() {
        return b;
    }

    @Override
    public <X0> ImmutableTriple<X0, A, B> addFirst(X0 x0) {
        return ImmutableTuple.of(x0, a, b);
    }

    @Override
    public <X0> ImmutableTriple<A, X0, B> addSecond(X0 x0) {
        return ImmutableTuple.of(a, x0, b);
    }

    @Override
    public <X0> ImmutableTriple<A, B, X0> add(X0 x0) {
        return ImmutableTuple.of(a, b, x0);
    }

    @Override
    public ImmutableTriple<A, A, B> duplicateFirst() {
        return ImmutableTuple.of(a, a, b);
    }

    @Override
    public ImmutableTriple<A, B, B> duplicateSecond() {
        return ImmutableTuple.of(a, b, b);
    }

    @Override
    public ImmutableSingle<B> removeFirst() {
        return ImmutableTuple.of(b);
    }

    @Override
    public ImmutableSingle<A> removeSecond() {
        return ImmutableTuple.of(a);
    }

    @Override
    public <X> ImmutableCouple<X, B> replaceFirst(X x) {
        return new ImmutableCoupleImpl<>(x, b);
    }

    @Override
    public <X> ImmutableCouple<A, X> replaceSecond(X x) {
        return new ImmutableCoupleImpl<>(a, x);
    }

    @Override
    public <X> ImmutableCouple<X, B> mapFirst(Function<? super A, X> mapper) {
        return new ImmutableCoupleImpl<>(mapper.apply(a), b);
    }

    @Override
    public <X> ImmutableCouple<A, X> mapSecond(Function<? super B, X> mapper) {
        return new ImmutableCoupleImpl<>(a, mapper.apply(b));
    }

    @Override
    public <X> ImmutableTriple<A, B, X> mapFirstAndAdd(Function<? super A, X> mapper) {
        return ImmutableTuple.of(a, b, mapper.apply(a));
    }

    @Override
    public <X> ImmutableTriple<A, B, X> mapSecondAndAdd(Function<? super B, X> mapper) {
        return ImmutableTuple.of(a, b, mapper.apply(b));
    }

    @Override
    public <R> R transform(CoupleFunction<? super A, ? super B, R> mapper) {
        return mapper.apply(a, b);
    }

    @Override
    public ImmutableCouple<B, A> reverse() {
        return new ImmutableCoupleImpl<>(b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Couple<?, ?>)) return false;
        Couple<?, ?> thatCouple = (Couple<?, ?>) that;
        return Objects.equals(this.a, thatCouple.getFirst()) && 
                Objects.equals(this.b, thatCouple.getSecond());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }
}
