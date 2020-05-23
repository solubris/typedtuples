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

public final class Ennead<A, B, C, D, E, F, G, H, I> implements Tuple {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    private final E e;

    private final F f;

    private final G g;

    private final H h;

    private final I i;

    Ennead(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
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

    public H getEighth() {
        return h;
    }

    public I get() {
        return i;
    }

    public <X0> Decade<X0, A, B, C, D, E, F, G, H, I> addFirst(X0 x0) {
        return new Decade<>(x0, a, b, c, d, e, f, g, h, i);
    }

    public <X0> Decade<A, X0, B, C, D, E, F, G, H, I> addSecond(X0 x0) {
        return new Decade<>(a, x0, b, c, d, e, f, g, h, i);
    }

    public <X0> Decade<A, B, X0, C, D, E, F, G, H, I> addThird(X0 x0) {
        return new Decade<>(a, b, x0, c, d, e, f, g, h, i);
    }

    public <X0> Decade<A, B, C, X0, D, E, F, G, H, I> addFourth(X0 x0) {
        return new Decade<>(a, b, c, x0, d, e, f, g, h, i);
    }

    public <X0> Decade<A, B, C, D, X0, E, F, G, H, I> addFifth(X0 x0) {
        return new Decade<>(a, b, c, d, x0, e, f, g, h, i);
    }

    public <X0> Decade<A, B, C, D, E, X0, F, G, H, I> addSixth(X0 x0) {
        return new Decade<>(a, b, c, d, e, x0, f, g, h, i);
    }

    public <X0> Decade<A, B, C, D, E, F, X0, G, H, I> addSeventh(X0 x0) {
        return new Decade<>(a, b, c, d, e, f, x0, g, h, i);
    }

    public <X0> Decade<A, B, C, D, E, F, G, X0, H, I> addEighth(X0 x0) {
        return new Decade<>(a, b, c, d, e, f, g, x0, h, i);
    }

    public <X0> Decade<A, B, C, D, E, F, G, H, X0, I> addNinth(X0 x0) {
        return new Decade<>(a, b, c, d, e, f, g, h, x0, i);
    }

    public <X0> Decade<A, B, C, D, E, F, G, H, I, X0> add(X0 x0) {
        return new Decade<>(a, b, c, d, e, f, g, h, i, x0);
    }

    public Octet<B, C, D, E, F, G, H, I> removeFirst() {
        return new Octet<>(b, c, d, e, f, g, h, i);
    }

    public Octet<A, C, D, E, F, G, H, I> removeSecond() {
        return new Octet<>(a, c, d, e, f, g, h, i);
    }

    public Octet<A, B, D, E, F, G, H, I> removeThird() {
        return new Octet<>(a, b, d, e, f, g, h, i);
    }

    public Octet<A, B, C, E, F, G, H, I> removeFourth() {
        return new Octet<>(a, b, c, e, f, g, h, i);
    }

    public Octet<A, B, C, D, F, G, H, I> removeFifth() {
        return new Octet<>(a, b, c, d, f, g, h, i);
    }

    public Octet<A, B, C, D, E, G, H, I> removeSixth() {
        return new Octet<>(a, b, c, d, e, g, h, i);
    }

    public Octet<A, B, C, D, E, F, H, I> removeSeventh() {
        return new Octet<>(a, b, c, d, e, f, h, i);
    }

    public Octet<A, B, C, D, E, F, G, I> removeEighth() {
        return new Octet<>(a, b, c, d, e, f, g, i);
    }

    public Octet<A, B, C, D, E, F, G, H> remove() {
        return new Octet<>(a, b, c, d, e, f, g, h);
    }

    public <X> Ennead<X, B, C, D, E, F, G, H, I> replaceFirst(X x) {
        return new Ennead<>(x, b, c, d, e, f, g, h, i);
    }

    public <X> Ennead<A, X, C, D, E, F, G, H, I> replaceSecond(X x) {
        return new Ennead<>(a, x, c, d, e, f, g, h, i);
    }

    public <X> Ennead<A, B, X, D, E, F, G, H, I> replaceThird(X x) {
        return new Ennead<>(a, b, x, d, e, f, g, h, i);
    }

    public <X> Ennead<A, B, C, X, E, F, G, H, I> replaceFourth(X x) {
        return new Ennead<>(a, b, c, x, e, f, g, h, i);
    }

    public <X> Ennead<A, B, C, D, X, F, G, H, I> replaceFifth(X x) {
        return new Ennead<>(a, b, c, d, x, f, g, h, i);
    }

    public <X> Ennead<A, B, C, D, E, X, G, H, I> replaceSixth(X x) {
        return new Ennead<>(a, b, c, d, e, x, g, h, i);
    }

    public <X> Ennead<A, B, C, D, E, F, X, H, I> replaceSeventh(X x) {
        return new Ennead<>(a, b, c, d, e, f, x, h, i);
    }

    public <X> Ennead<A, B, C, D, E, F, G, X, I> replaceEighth(X x) {
        return new Ennead<>(a, b, c, d, e, f, g, x, i);
    }

    public <X> Ennead<A, B, C, D, E, F, G, H, X> replace(X x) {
        return new Ennead<>(a, b, c, d, e, f, g, h, x);
    }

    public <X> Ennead<X, B, C, D, E, F, G, H, I> mapFirst(Function<A, X> mapper) {
        return new Ennead<>(mapper.apply(a), b, c, d, e, f, g, h, i);
    }

    public <X> Ennead<A, X, C, D, E, F, G, H, I> mapSecond(Function<B, X> mapper) {
        return new Ennead<>(a, mapper.apply(b), c, d, e, f, g, h, i);
    }

    public <X> Ennead<A, B, X, D, E, F, G, H, I> mapThird(Function<C, X> mapper) {
        return new Ennead<>(a, b, mapper.apply(c), d, e, f, g, h, i);
    }

    public <X> Ennead<A, B, C, X, E, F, G, H, I> mapFourth(Function<D, X> mapper) {
        return new Ennead<>(a, b, c, mapper.apply(d), e, f, g, h, i);
    }

    public <X> Ennead<A, B, C, D, X, F, G, H, I> mapFifth(Function<E, X> mapper) {
        return new Ennead<>(a, b, c, d, mapper.apply(e), f, g, h, i);
    }

    public <X> Ennead<A, B, C, D, E, X, G, H, I> mapSixth(Function<F, X> mapper) {
        return new Ennead<>(a, b, c, d, e, mapper.apply(f), g, h, i);
    }

    public <X> Ennead<A, B, C, D, E, F, X, H, I> mapSeventh(Function<G, X> mapper) {
        return new Ennead<>(a, b, c, d, e, f, mapper.apply(g), h, i);
    }

    public <X> Ennead<A, B, C, D, E, F, G, X, I> mapEighth(Function<H, X> mapper) {
        return new Ennead<>(a, b, c, d, e, f, g, mapper.apply(h), i);
    }

    public <X> Ennead<A, B, C, D, E, F, G, H, X> map(Function<I, X> mapper) {
        return new Ennead<>(a, b, c, d, e, f, g, h, mapper.apply(i));
    }

    public Ennead<I, H, G, F, E, D, C, B, A> reverse() {
        return new Ennead<>(i, h, g, f, e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || this.getClass() != that.getClass()) return false;
        Ennead<?, ?, ?, ?, ?, ?, ?, ?, ?> thatEnnead = (Ennead<?, ?, ?, ?, ?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatEnnead.a) && 
                Objects.equals(this.b, thatEnnead.b) && 
                Objects.equals(this.c, thatEnnead.c) && 
                Objects.equals(this.d, thatEnnead.d) && 
                Objects.equals(this.e, thatEnnead.e) && 
                Objects.equals(this.f, thatEnnead.f) && 
                Objects.equals(this.g, thatEnnead.g) && 
                Objects.equals(this.h, thatEnnead.h) && 
                Objects.equals(this.i, thatEnnead.i);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f, g, h, i);
    }

    @Override
    public String toString() {
        return "Ennead{" +
                "a=" + a + ", " +
                "b=" + b + ", " +
                "c=" + c + ", " +
                "d=" + d + ", " +
                "e=" + e + ", " +
                "f=" + f + ", " +
                "g=" + g + ", " +
                "h=" + h + ", " +
                "i=" + i +
                "}";
    }
}
