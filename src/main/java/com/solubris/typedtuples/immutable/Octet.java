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

public final class Octet<A, B, C, D, E, F, G, H> implements Tuple {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    private final E e;

    private final F f;

    private final G g;

    private final H h;

    Octet(A a, B b, C c, D d, E e, F f, G g, H h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
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

    public G getSeventh() {
        return g;
    }

    public H get() {
        return h;
    }

    public <X0> Ennead<X0, A, B, C, D, E, F, G, H> addFirst(X0 x0) {
        return new Ennead<>(x0, a, b, c, d, e, f, g, h);
    }

    public <X0> Ennead<A, X0, B, C, D, E, F, G, H> addSecond(X0 x0) {
        return new Ennead<>(a, x0, b, c, d, e, f, g, h);
    }

    public <X0> Ennead<A, B, X0, C, D, E, F, G, H> addThird(X0 x0) {
        return new Ennead<>(a, b, x0, c, d, e, f, g, h);
    }

    public <X0> Ennead<A, B, C, X0, D, E, F, G, H> addFourth(X0 x0) {
        return new Ennead<>(a, b, c, x0, d, e, f, g, h);
    }

    public <X0> Ennead<A, B, C, D, X0, E, F, G, H> addFifth(X0 x0) {
        return new Ennead<>(a, b, c, d, x0, e, f, g, h);
    }

    public <X0> Ennead<A, B, C, D, E, X0, F, G, H> addSixth(X0 x0) {
        return new Ennead<>(a, b, c, d, e, x0, f, g, h);
    }

    public <X0> Ennead<A, B, C, D, E, F, X0, G, H> addSeventh(X0 x0) {
        return new Ennead<>(a, b, c, d, e, f, x0, g, h);
    }

    public <X0> Ennead<A, B, C, D, E, F, G, X0, H> addEighth(X0 x0) {
        return new Ennead<>(a, b, c, d, e, f, g, x0, h);
    }

    public <X0> Ennead<A, B, C, D, E, F, G, H, X0> add(X0 x0) {
        return new Ennead<>(a, b, c, d, e, f, g, h, x0);
    }

    public Septet<B, C, D, E, F, G, H> removeFirst() {
        return new Septet<>(b, c, d, e, f, g, h);
    }

    public Septet<A, C, D, E, F, G, H> removeSecond() {
        return new Septet<>(a, c, d, e, f, g, h);
    }

    public Septet<A, B, D, E, F, G, H> removeThird() {
        return new Septet<>(a, b, d, e, f, g, h);
    }

    public Septet<A, B, C, E, F, G, H> removeFourth() {
        return new Septet<>(a, b, c, e, f, g, h);
    }

    public Septet<A, B, C, D, F, G, H> removeFifth() {
        return new Septet<>(a, b, c, d, f, g, h);
    }

    public Septet<A, B, C, D, E, G, H> removeSixth() {
        return new Septet<>(a, b, c, d, e, g, h);
    }

    public Septet<A, B, C, D, E, F, H> removeSeventh() {
        return new Septet<>(a, b, c, d, e, f, h);
    }

    public Septet<A, B, C, D, E, F, G> remove() {
        return new Septet<>(a, b, c, d, e, f, g);
    }

    public <X> Octet<X, B, C, D, E, F, G, H> replaceFirst(X x) {
        return new Octet<>(x, b, c, d, e, f, g, h);
    }

    public <X> Octet<A, X, C, D, E, F, G, H> replaceSecond(X x) {
        return new Octet<>(a, x, c, d, e, f, g, h);
    }

    public <X> Octet<A, B, X, D, E, F, G, H> replaceThird(X x) {
        return new Octet<>(a, b, x, d, e, f, g, h);
    }

    public <X> Octet<A, B, C, X, E, F, G, H> replaceFourth(X x) {
        return new Octet<>(a, b, c, x, e, f, g, h);
    }

    public <X> Octet<A, B, C, D, X, F, G, H> replaceFifth(X x) {
        return new Octet<>(a, b, c, d, x, f, g, h);
    }

    public <X> Octet<A, B, C, D, E, X, G, H> replaceSixth(X x) {
        return new Octet<>(a, b, c, d, e, x, g, h);
    }

    public <X> Octet<A, B, C, D, E, F, X, H> replaceSeventh(X x) {
        return new Octet<>(a, b, c, d, e, f, x, h);
    }

    public <X> Octet<A, B, C, D, E, F, G, X> replace(X x) {
        return new Octet<>(a, b, c, d, e, f, g, x);
    }

    public <X> Octet<X, B, C, D, E, F, G, H> mapFirst(Function<A, X> mapper) {
        return new Octet<>(mapper.apply(a), b, c, d, e, f, g, h);
    }

    public <X> Octet<A, X, C, D, E, F, G, H> mapSecond(Function<B, X> mapper) {
        return new Octet<>(a, mapper.apply(b), c, d, e, f, g, h);
    }

    public <X> Octet<A, B, X, D, E, F, G, H> mapThird(Function<C, X> mapper) {
        return new Octet<>(a, b, mapper.apply(c), d, e, f, g, h);
    }

    public <X> Octet<A, B, C, X, E, F, G, H> mapFourth(Function<D, X> mapper) {
        return new Octet<>(a, b, c, mapper.apply(d), e, f, g, h);
    }

    public <X> Octet<A, B, C, D, X, F, G, H> mapFifth(Function<E, X> mapper) {
        return new Octet<>(a, b, c, d, mapper.apply(e), f, g, h);
    }

    public <X> Octet<A, B, C, D, E, X, G, H> mapSixth(Function<F, X> mapper) {
        return new Octet<>(a, b, c, d, e, mapper.apply(f), g, h);
    }

    public <X> Octet<A, B, C, D, E, F, X, H> mapSeventh(Function<G, X> mapper) {
        return new Octet<>(a, b, c, d, e, f, mapper.apply(g), h);
    }

    public <X> Octet<A, B, C, D, E, F, G, X> map(Function<H, X> mapper) {
        return new Octet<>(a, b, c, d, e, f, g, mapper.apply(h));
    }

    public Octet<H, G, F, E, D, C, B, A> reverse() {
        return new Octet<>(h, g, f, e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || this.getClass() != that.getClass()) return false;
        Octet<?, ?, ?, ?, ?, ?, ?, ?> thatOctet = (Octet<?, ?, ?, ?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatOctet.a) && 
                Objects.equals(this.b, thatOctet.b) && 
                Objects.equals(this.c, thatOctet.c) && 
                Objects.equals(this.d, thatOctet.d) && 
                Objects.equals(this.e, thatOctet.e) && 
                Objects.equals(this.f, thatOctet.f) && 
                Objects.equals(this.g, thatOctet.g) && 
                Objects.equals(this.h, thatOctet.h);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f, g, h);
    }

    @Override
    public String toString() {
        return "Octet{" +
                "a=" + a + ", " +
                "b=" + b + ", " +
                "c=" + c + ", " +
                "d=" + d + ", " +
                "e=" + e + ", " +
                "f=" + f + ", " +
                "g=" + g + ", " +
                "h=" + h +
                "}";
    }
}
