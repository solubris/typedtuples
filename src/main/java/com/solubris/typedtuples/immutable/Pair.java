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
package com.solubris.typedtuples.immutable;

import java.util.Objects;
import java.util.function.Function;

public final class Pair<A, B> implements Tuple {
    private final A a;

    private final B b;

    Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getFirst() {
        return a;
    }

    public B get() {
        return b;
    }

    public <X0> Triplet<X0, A, B> addFirst(X0 x0) {
        return new Triplet<>(x0, a, b);
    }

    public <X0> Triplet<A, X0, B> addSecond(X0 x0) {
        return new Triplet<>(a, x0, b);
    }

    public <X0> Triplet<A, B, X0> add(X0 x0) {
        return new Triplet<>(a, b, x0);
    }

    public Unit<B> removeFirst() {
        return new Unit<>(b);
    }

    public Unit<A> remove() {
        return new Unit<>(a);
    }

    public <X> Pair<X, B> replaceFirst(X x) {
        return new Pair<>(x, b);
    }

    public <X> Pair<A, X> replace(X x) {
        return new Pair<>(a, x);
    }

    public <X> Pair<X, B> mapFirst(Function<A, X> mapper) {
        return new Pair<>(mapper.apply(a), b);
    }

    public <X> Pair<A, X> map(Function<B, X> mapper) {
        return new Pair<>(a, mapper.apply(b));
    }

    public Pair<B, A> reverse() {
        return new Pair<>(b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || this.getClass() != that.getClass()) return false;
        Pair<?, ?> thatPair = (Pair<?, ?>) that;
        return Objects.equals(this.a, thatPair.a) && 
                Objects.equals(this.b, thatPair.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "a=" + a + ", " +
                "b=" + b +
                "}";
    }
}
