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

public final class Sextet<A, B, C, D, E, F> implements Tuple {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    private final E e;

    private final F f;

    Sextet(A a, B b, C c, D d, E e, F f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
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

    public E getFifth() {
        return e;
    }

    public F get() {
        return f;
    }

    public <X0> Septet<X0, A, B, C, D, E, F> addFirst(X0 x0) {
        return new Septet<>(x0, a, b, c, d, e, f);
    }

    public <X0> Septet<A, X0, B, C, D, E, F> addSecond(X0 x0) {
        return new Septet<>(a, x0, b, c, d, e, f);
    }

    public <X0> Septet<A, B, X0, C, D, E, F> addThird(X0 x0) {
        return new Septet<>(a, b, x0, c, d, e, f);
    }

    public <X0> Septet<A, B, C, X0, D, E, F> addFourth(X0 x0) {
        return new Septet<>(a, b, c, x0, d, e, f);
    }

    public <X0> Septet<A, B, C, D, X0, E, F> addFifth(X0 x0) {
        return new Septet<>(a, b, c, d, x0, e, f);
    }

    public <X0> Septet<A, B, C, D, E, X0, F> addSixth(X0 x0) {
        return new Septet<>(a, b, c, d, e, x0, f);
    }

    public <X0> Septet<A, B, C, D, E, F, X0> add(X0 x0) {
        return new Septet<>(a, b, c, d, e, f, x0);
    }

    public Quintet<B, C, D, E, F> removeFirst() {
        return new Quintet<>(b, c, d, e, f);
    }

    public Quintet<A, C, D, E, F> removeSecond() {
        return new Quintet<>(a, c, d, e, f);
    }

    public Quintet<A, B, D, E, F> removeThird() {
        return new Quintet<>(a, b, d, e, f);
    }

    public Quintet<A, B, C, E, F> removeFourth() {
        return new Quintet<>(a, b, c, e, f);
    }

    public Quintet<A, B, C, D, F> removeFifth() {
        return new Quintet<>(a, b, c, d, f);
    }

    public Quintet<A, B, C, D, E> remove() {
        return new Quintet<>(a, b, c, d, e);
    }

    public <X> Sextet<X, B, C, D, E, F> replaceFirst(X x) {
        return new Sextet<>(x, b, c, d, e, f);
    }

    public <X> Sextet<A, X, C, D, E, F> replaceSecond(X x) {
        return new Sextet<>(a, x, c, d, e, f);
    }

    public <X> Sextet<A, B, X, D, E, F> replaceThird(X x) {
        return new Sextet<>(a, b, x, d, e, f);
    }

    public <X> Sextet<A, B, C, X, E, F> replaceFourth(X x) {
        return new Sextet<>(a, b, c, x, e, f);
    }

    public <X> Sextet<A, B, C, D, X, F> replaceFifth(X x) {
        return new Sextet<>(a, b, c, d, x, f);
    }

    public <X> Sextet<A, B, C, D, E, X> replace(X x) {
        return new Sextet<>(a, b, c, d, e, x);
    }

    public <X> Sextet<X, B, C, D, E, F> mapFirst(Function<A, X> mapper) {
        return new Sextet<>(mapper.apply(a), b, c, d, e, f);
    }

    public <X> Sextet<A, X, C, D, E, F> mapSecond(Function<B, X> mapper) {
        return new Sextet<>(a, mapper.apply(b), c, d, e, f);
    }

    public <X> Sextet<A, B, X, D, E, F> mapThird(Function<C, X> mapper) {
        return new Sextet<>(a, b, mapper.apply(c), d, e, f);
    }

    public <X> Sextet<A, B, C, X, E, F> mapFourth(Function<D, X> mapper) {
        return new Sextet<>(a, b, c, mapper.apply(d), e, f);
    }

    public <X> Sextet<A, B, C, D, X, F> mapFifth(Function<E, X> mapper) {
        return new Sextet<>(a, b, c, d, mapper.apply(e), f);
    }

    public <X> Sextet<A, B, C, D, E, X> map(Function<F, X> mapper) {
        return new Sextet<>(a, b, c, d, e, mapper.apply(f));
    }

    public Sextet<F, E, D, C, B, A> reverse() {
        return new Sextet<>(f, e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || this.getClass() != that.getClass()) return false;
        Sextet<?, ?, ?, ?, ?, ?> thatSextet = (Sextet<?, ?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatSextet.a) && 
                Objects.equals(this.b, thatSextet.b) && 
                Objects.equals(this.c, thatSextet.c) && 
                Objects.equals(this.d, thatSextet.d) && 
                Objects.equals(this.e, thatSextet.e) && 
                Objects.equals(this.f, thatSextet.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f);
    }

    @Override
    public String toString() {
        return "Sextet{" +
                "a=" + a + ", " +
                "b=" + b + ", " +
                "c=" + c + ", " +
                "d=" + d + ", " +
                "e=" + e + ", " +
                "f=" + f +
                "}";
    }
}
