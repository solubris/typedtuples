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

import com.solubris.typedtuples.Triple;
import com.solubris.typedtuples.function.TripleFunction;

import java.util.Objects;
import java.util.function.Function;

final class ImmutableTripleImpl<A, B, C> implements ImmutableTriple<A, B, C> {
    private final A a;

    private final B b;

    private final C c;

    ImmutableTripleImpl(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
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
    public C getThird() {
        return c;
    }

    @Override
    public <X0> ImmutableQuadruple<X0, A, B, C> addFirst(X0 x0) {
        return ImmutableTuple.of(x0, a, b, c);
    }

    @Override
    public <X0> ImmutableQuadruple<A, X0, B, C> addSecond(X0 x0) {
        return ImmutableTuple.of(a, x0, b, c);
    }

    @Override
    public <X0> ImmutableQuadruple<A, B, X0, C> addThird(X0 x0) {
        return ImmutableTuple.of(a, b, x0, c);
    }

    @Override
    public <X0> ImmutableQuadruple<A, B, C, X0> add(X0 x0) {
        return ImmutableTuple.of(a, b, c, x0);
    }

    @Override
    public ImmutableQuadruple<A, A, B, C> duplicateFirst() {
        return ImmutableTuple.of(a, a, b, c);
    }

    @Override
    public ImmutableQuadruple<A, B, B, C> duplicateSecond() {
        return ImmutableTuple.of(a, b, b, c);
    }

    @Override
    public ImmutableQuadruple<A, B, C, C> duplicateThird() {
        return ImmutableTuple.of(a, b, c, c);
    }

    @Override
    public ImmutableCouple<B, C> removeFirst() {
        return ImmutableTuple.of(b, c);
    }

    @Override
    public ImmutableCouple<A, C> removeSecond() {
        return ImmutableTuple.of(a, c);
    }

    @Override
    public ImmutableCouple<A, B> removeThird() {
        return ImmutableTuple.of(a, b);
    }

    @Override
    public <X> ImmutableTriple<X, B, C> replaceFirst(X x) {
        return ImmutableTuple.of(x, b, c);
    }

    @Override
    public <X> ImmutableTriple<A, X, C> replaceSecond(X x) {
        return ImmutableTuple.of(a, x, c);
    }

    @Override
    public <X> ImmutableTriple<A, B, X> replaceThird(X x) {
        return ImmutableTuple.of(a, b, x);
    }

    @Override
    public <X> ImmutableTriple<X, B, C> mapFirst(Function<? super A, X> mapper) {
        return ImmutableTuple.of(mapper.apply(a), b, c);
    }

    @Override
    public <X> ImmutableTriple<A, X, C> mapSecond(Function<? super B, X> mapper) {
        return ImmutableTuple.of(a, mapper.apply(b), c);
    }

    @Override
    public <X> ImmutableTriple<A, B, X> mapThird(Function<? super C, X> mapper) {
        return ImmutableTuple.of(a, b, mapper.apply(c));
    }

    @Override
    public <X> ImmutableQuadruple<A, B, C, X> mapFirstAndAdd(Function<? super A, X> mapper) {
        return ImmutableTuple.of(a, b, c, mapper.apply(a));
    }

    @Override
    public <X> ImmutableQuadruple<A, B, C, X> mapSecondAndAdd(Function<? super B, X> mapper) {
        return ImmutableTuple.of(a, b, c, mapper.apply(b));
    }

    @Override
    public <X> ImmutableQuadruple<A, B, C, X> mapThirdAndAdd(Function<? super C, X> mapper) {
        return ImmutableTuple.of(a, b, c, mapper.apply(c));
    }

    @Override
    public <R> R transform(TripleFunction<? super A, ? super B, ? super C, R> mapper) {
        return mapper.apply(a, b, c);
    }

    @Override
    public ImmutableTriple<C, B, A> reverse() {
        return ImmutableTuple.of(c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Triple<?, ?, ?>)) return false;
        Triple<?, ?, ?> thatTriple = (Triple<?, ?, ?>) that;
        return Objects.equals(this.a, thatTriple.getFirst()) && 
                Objects.equals(this.b, thatTriple.getSecond()) && 
                Objects.equals(this.c, thatTriple.getThird());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ")";
    }
}
