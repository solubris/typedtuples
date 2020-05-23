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

public final class Septet<A, B, C, D, E, F, G> implements Tuple {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    private final E e;

    private final F f;

    private final G g;

    Septet(A a, B b, C c, D d, E e, F f, G g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
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

    public F getSixth() {
        return f;
    }

    public G get() {
        return g;
    }

    public <X0> Octet<X0, A, B, C, D, E, F, G> addFirst(X0 x0) {
        return new Octet<>(x0, a, b, c, d, e, f, g);
    }

    public <X0> Octet<A, X0, B, C, D, E, F, G> addSecond(X0 x0) {
        return new Octet<>(a, x0, b, c, d, e, f, g);
    }

    public <X0> Octet<A, B, X0, C, D, E, F, G> addThird(X0 x0) {
        return new Octet<>(a, b, x0, c, d, e, f, g);
    }

    public <X0> Octet<A, B, C, X0, D, E, F, G> addFourth(X0 x0) {
        return new Octet<>(a, b, c, x0, d, e, f, g);
    }

    public <X0> Octet<A, B, C, D, X0, E, F, G> addFifth(X0 x0) {
        return new Octet<>(a, b, c, d, x0, e, f, g);
    }

    public <X0> Octet<A, B, C, D, E, X0, F, G> addSixth(X0 x0) {
        return new Octet<>(a, b, c, d, e, x0, f, g);
    }

    public <X0> Octet<A, B, C, D, E, F, X0, G> addSeventh(X0 x0) {
        return new Octet<>(a, b, c, d, e, f, x0, g);
    }

    public <X0> Octet<A, B, C, D, E, F, G, X0> add(X0 x0) {
        return new Octet<>(a, b, c, d, e, f, g, x0);
    }

    public Sextet<B, C, D, E, F, G> removeFirst() {
        return new Sextet<>(b, c, d, e, f, g);
    }

    public Sextet<A, C, D, E, F, G> removeSecond() {
        return new Sextet<>(a, c, d, e, f, g);
    }

    public Sextet<A, B, D, E, F, G> removeThird() {
        return new Sextet<>(a, b, d, e, f, g);
    }

    public Sextet<A, B, C, E, F, G> removeFourth() {
        return new Sextet<>(a, b, c, e, f, g);
    }

    public Sextet<A, B, C, D, F, G> removeFifth() {
        return new Sextet<>(a, b, c, d, f, g);
    }

    public Sextet<A, B, C, D, E, G> removeSixth() {
        return new Sextet<>(a, b, c, d, e, g);
    }

    public Sextet<A, B, C, D, E, F> remove() {
        return new Sextet<>(a, b, c, d, e, f);
    }

    public <X> Septet<X, B, C, D, E, F, G> replaceFirst(X x) {
        return new Septet<>(x, b, c, d, e, f, g);
    }

    public <X> Septet<A, X, C, D, E, F, G> replaceSecond(X x) {
        return new Septet<>(a, x, c, d, e, f, g);
    }

    public <X> Septet<A, B, X, D, E, F, G> replaceThird(X x) {
        return new Septet<>(a, b, x, d, e, f, g);
    }

    public <X> Septet<A, B, C, X, E, F, G> replaceFourth(X x) {
        return new Septet<>(a, b, c, x, e, f, g);
    }

    public <X> Septet<A, B, C, D, X, F, G> replaceFifth(X x) {
        return new Septet<>(a, b, c, d, x, f, g);
    }

    public <X> Septet<A, B, C, D, E, X, G> replaceSixth(X x) {
        return new Septet<>(a, b, c, d, e, x, g);
    }

    public <X> Septet<A, B, C, D, E, F, X> replace(X x) {
        return new Septet<>(a, b, c, d, e, f, x);
    }

    public <X> Septet<X, B, C, D, E, F, G> mapFirst(Function<A, X> mapper) {
        return new Septet<>(mapper.apply(a), b, c, d, e, f, g);
    }

    public <X> Septet<A, X, C, D, E, F, G> mapSecond(Function<B, X> mapper) {
        return new Septet<>(a, mapper.apply(b), c, d, e, f, g);
    }

    public <X> Septet<A, B, X, D, E, F, G> mapThird(Function<C, X> mapper) {
        return new Septet<>(a, b, mapper.apply(c), d, e, f, g);
    }

    public <X> Septet<A, B, C, X, E, F, G> mapFourth(Function<D, X> mapper) {
        return new Septet<>(a, b, c, mapper.apply(d), e, f, g);
    }

    public <X> Septet<A, B, C, D, X, F, G> mapFifth(Function<E, X> mapper) {
        return new Septet<>(a, b, c, d, mapper.apply(e), f, g);
    }

    public <X> Septet<A, B, C, D, E, X, G> mapSixth(Function<F, X> mapper) {
        return new Septet<>(a, b, c, d, e, mapper.apply(f), g);
    }

    public <X> Septet<A, B, C, D, E, F, X> map(Function<G, X> mapper) {
        return new Septet<>(a, b, c, d, e, f, mapper.apply(g));
    }

    public Septet<G, F, E, D, C, B, A> reverse() {
        return new Septet<>(g, f, e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || this.getClass() != that.getClass()) return false;
        Septet<?, ?, ?, ?, ?, ?, ?> thatSeptet = (Septet<?, ?, ?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatSeptet.a) && 
                Objects.equals(this.b, thatSeptet.b) && 
                Objects.equals(this.c, thatSeptet.c) && 
                Objects.equals(this.d, thatSeptet.d) && 
                Objects.equals(this.e, thatSeptet.e) && 
                Objects.equals(this.f, thatSeptet.f) && 
                Objects.equals(this.g, thatSeptet.g);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f, g);
    }

    @Override
    public String toString() {
        return "Septet{" +
                "a=" + a + ", " +
                "b=" + b + ", " +
                "c=" + c + ", " +
                "d=" + d + ", " +
                "e=" + e + ", " +
                "f=" + f + ", " +
                "g=" + g +
                "}";
    }
}
