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

public final class Quartet<A, B, C, D> implements Tuple {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    Quartet(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public A getFirst() {
        return a;
    }

    public B getSecond() {
        return b;
    }

    public C getThird() {
        return c;
    }

    public D get() {
        return d;
    }

    public <X0> Quintet<X0, A, B, C, D> addFirst(X0 x0) {
        return new Quintet<>(x0, a, b, c, d);
    }

    public <X0> Quintet<A, X0, B, C, D> addSecond(X0 x0) {
        return new Quintet<>(a, x0, b, c, d);
    }

    public <X0> Quintet<A, B, X0, C, D> addThird(X0 x0) {
        return new Quintet<>(a, b, x0, c, d);
    }

    public <X0> Quintet<A, B, C, X0, D> addFourth(X0 x0) {
        return new Quintet<>(a, b, c, x0, d);
    }

    public <X0> Quintet<A, B, C, D, X0> add(X0 x0) {
        return new Quintet<>(a, b, c, d, x0);
    }

    public Triplet<B, C, D> removeFirst() {
        return new Triplet<>(b, c, d);
    }

    public Triplet<A, C, D> removeSecond() {
        return new Triplet<>(a, c, d);
    }

    public Triplet<A, B, D> removeThird() {
        return new Triplet<>(a, b, d);
    }

    public Triplet<A, B, C> remove() {
        return new Triplet<>(a, b, c);
    }

    public <X> Quartet<X, B, C, D> replaceFirst(X x) {
        return new Quartet<>(x, b, c, d);
    }

    public <X> Quartet<A, X, C, D> replaceSecond(X x) {
        return new Quartet<>(a, x, c, d);
    }

    public <X> Quartet<A, B, X, D> replaceThird(X x) {
        return new Quartet<>(a, b, x, d);
    }

    public <X> Quartet<A, B, C, X> replace(X x) {
        return new Quartet<>(a, b, c, x);
    }

    public <X> Quartet<X, B, C, D> mapFirst(Function<A, X> mapper) {
        return new Quartet<>(mapper.apply(a), b, c, d);
    }

    public <X> Quartet<A, X, C, D> mapSecond(Function<B, X> mapper) {
        return new Quartet<>(a, mapper.apply(b), c, d);
    }

    public <X> Quartet<A, B, X, D> mapThird(Function<C, X> mapper) {
        return new Quartet<>(a, b, mapper.apply(c), d);
    }

    public <X> Quartet<A, B, C, X> map(Function<D, X> mapper) {
        return new Quartet<>(a, b, c, mapper.apply(d));
    }

    public Quartet<D, C, B, A> reverse() {
        return new Quartet<>(d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || this.getClass() != that.getClass()) return false;
        Quartet<?, ?, ?, ?> thatQuartet = (Quartet<?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatQuartet.a) && 
                Objects.equals(this.b, thatQuartet.b) && 
                Objects.equals(this.c, thatQuartet.c) && 
                Objects.equals(this.d, thatQuartet.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "Quartet{" +
                "a=" + a + ", " +
                "b=" + b + ", " +
                "c=" + c + ", " +
                "d=" + d +
                "}";
    }
}
