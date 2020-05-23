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

public final class Triplet<A, B, C> implements Tuple {
    private final A a;

    private final B b;

    private final C c;

    Triplet(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public A getFirst() {
        return a;
    }

    public B getSecond() {
        return b;
    }

    public C get() {
        return c;
    }

    public <X0> Quartet<X0, A, B, C> addFirst(X0 x0) {
        return new Quartet<>(x0, a, b, c);
    }

    public <X0> Quartet<A, X0, B, C> addSecond(X0 x0) {
        return new Quartet<>(a, x0, b, c);
    }

    public <X0> Quartet<A, B, X0, C> addThird(X0 x0) {
        return new Quartet<>(a, b, x0, c);
    }

    public <X0> Quartet<A, B, C, X0> add(X0 x0) {
        return new Quartet<>(a, b, c, x0);
    }

    public Pair<B, C> removeFirst() {
        return new Pair<>(b, c);
    }

    public Pair<A, C> removeSecond() {
        return new Pair<>(a, c);
    }

    public Pair<A, B> remove() {
        return new Pair<>(a, b);
    }

    public <X> Triplet<X, B, C> replaceFirst(X x) {
        return new Triplet<>(x, b, c);
    }

    public <X> Triplet<A, X, C> replaceSecond(X x) {
        return new Triplet<>(a, x, c);
    }

    public <X> Triplet<A, B, X> replace(X x) {
        return new Triplet<>(a, b, x);
    }

    public <X> Triplet<X, B, C> mapFirst(Function<A, X> mapper) {
        return new Triplet<>(mapper.apply(a), b, c);
    }

    public <X> Triplet<A, X, C> mapSecond(Function<B, X> mapper) {
        return new Triplet<>(a, mapper.apply(b), c);
    }

    public <X> Triplet<A, B, X> map(Function<C, X> mapper) {
        return new Triplet<>(a, b, mapper.apply(c));
    }

    public Triplet<C, B, A> reverse() {
        return new Triplet<>(c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || this.getClass() != that.getClass()) return false;
        Triplet<?, ?, ?> thatTriplet = (Triplet<?, ?, ?>) that;
        return Objects.equals(this.a, thatTriplet.a) && 
                Objects.equals(this.b, thatTriplet.b) && 
                Objects.equals(this.c, thatTriplet.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "a=" + a + ", " +
                "b=" + b + ", " +
                "c=" + c +
                "}";
    }
}
