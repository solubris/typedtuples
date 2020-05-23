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

public final class Quintet<A, B, C, D, E> implements Tuple {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    private final E e;

    Quintet(A a, B b, C c, D d, E e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
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

    public D getFourth() {
        return d;
    }

    public E get() {
        return e;
    }

    public <X0> Sextet<X0, A, B, C, D, E> addFirst(X0 x0) {
        return new Sextet<>(x0, a, b, c, d, e);
    }

    public <X0> Sextet<A, X0, B, C, D, E> addSecond(X0 x0) {
        return new Sextet<>(a, x0, b, c, d, e);
    }

    public <X0> Sextet<A, B, X0, C, D, E> addThird(X0 x0) {
        return new Sextet<>(a, b, x0, c, d, e);
    }

    public <X0> Sextet<A, B, C, X0, D, E> addFourth(X0 x0) {
        return new Sextet<>(a, b, c, x0, d, e);
    }

    public <X0> Sextet<A, B, C, D, X0, E> addFifth(X0 x0) {
        return new Sextet<>(a, b, c, d, x0, e);
    }

    public <X0> Sextet<A, B, C, D, E, X0> add(X0 x0) {
        return new Sextet<>(a, b, c, d, e, x0);
    }

    public Quartet<B, C, D, E> removeFirst() {
        return new Quartet<>(b, c, d, e);
    }

    public Quartet<A, C, D, E> removeSecond() {
        return new Quartet<>(a, c, d, e);
    }

    public Quartet<A, B, D, E> removeThird() {
        return new Quartet<>(a, b, d, e);
    }

    public Quartet<A, B, C, E> removeFourth() {
        return new Quartet<>(a, b, c, e);
    }

    public Quartet<A, B, C, D> remove() {
        return new Quartet<>(a, b, c, d);
    }

    public <X> Quintet<X, B, C, D, E> replaceFirst(X x) {
        return new Quintet<>(x, b, c, d, e);
    }

    public <X> Quintet<A, X, C, D, E> replaceSecond(X x) {
        return new Quintet<>(a, x, c, d, e);
    }

    public <X> Quintet<A, B, X, D, E> replaceThird(X x) {
        return new Quintet<>(a, b, x, d, e);
    }

    public <X> Quintet<A, B, C, X, E> replaceFourth(X x) {
        return new Quintet<>(a, b, c, x, e);
    }

    public <X> Quintet<A, B, C, D, X> replace(X x) {
        return new Quintet<>(a, b, c, d, x);
    }

    public <X> Quintet<X, B, C, D, E> mapFirst(Function<A, X> mapper) {
        return new Quintet<>(mapper.apply(a), b, c, d, e);
    }

    public <X> Quintet<A, X, C, D, E> mapSecond(Function<B, X> mapper) {
        return new Quintet<>(a, mapper.apply(b), c, d, e);
    }

    public <X> Quintet<A, B, X, D, E> mapThird(Function<C, X> mapper) {
        return new Quintet<>(a, b, mapper.apply(c), d, e);
    }

    public <X> Quintet<A, B, C, X, E> mapFourth(Function<D, X> mapper) {
        return new Quintet<>(a, b, c, mapper.apply(d), e);
    }

    public <X> Quintet<A, B, C, D, X> map(Function<E, X> mapper) {
        return new Quintet<>(a, b, c, d, mapper.apply(e));
    }

    public Quintet<E, D, C, B, A> reverse() {
        return new Quintet<>(e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || this.getClass() != that.getClass()) return false;
        Quintet<?, ?, ?, ?, ?> thatQuintet = (Quintet<?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatQuintet.a) && 
                Objects.equals(this.b, thatQuintet.b) && 
                Objects.equals(this.c, thatQuintet.c) && 
                Objects.equals(this.d, thatQuintet.d) && 
                Objects.equals(this.e, thatQuintet.e);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e);
    }

    @Override
    public String toString() {
        return "Quintet{" +
                "a=" + a + ", " +
                "b=" + b + ", " +
                "c=" + c + ", " +
                "d=" + d + ", " +
                "e=" + e +
                "}";
    }
}
