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

public final class Decade<A, B, C, D, E, F, G, H, I, J> implements Tuple {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    private final E e;

    private final F f;

    private final G g;

    private final H h;

    private final I i;

    private final J j;

    Decade(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
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

    public I getNinth() {
        return i;
    }

    public J get() {
        return j;
    }

    public Ennead<B, C, D, E, F, G, H, I, J> removeFirst() {
        return new Ennead<>(b, c, d, e, f, g, h, i, j);
    }

    public Ennead<A, C, D, E, F, G, H, I, J> removeSecond() {
        return new Ennead<>(a, c, d, e, f, g, h, i, j);
    }

    public Ennead<A, B, D, E, F, G, H, I, J> removeThird() {
        return new Ennead<>(a, b, d, e, f, g, h, i, j);
    }

    public Ennead<A, B, C, E, F, G, H, I, J> removeFourth() {
        return new Ennead<>(a, b, c, e, f, g, h, i, j);
    }

    public Ennead<A, B, C, D, F, G, H, I, J> removeFifth() {
        return new Ennead<>(a, b, c, d, f, g, h, i, j);
    }

    public Ennead<A, B, C, D, E, G, H, I, J> removeSixth() {
        return new Ennead<>(a, b, c, d, e, g, h, i, j);
    }

    public Ennead<A, B, C, D, E, F, H, I, J> removeSeventh() {
        return new Ennead<>(a, b, c, d, e, f, h, i, j);
    }

    public Ennead<A, B, C, D, E, F, G, I, J> removeEighth() {
        return new Ennead<>(a, b, c, d, e, f, g, i, j);
    }

    public Ennead<A, B, C, D, E, F, G, H, J> removeNinth() {
        return new Ennead<>(a, b, c, d, e, f, g, h, j);
    }

    public Ennead<A, B, C, D, E, F, G, H, I> remove() {
        return new Ennead<>(a, b, c, d, e, f, g, h, i);
    }

    public <X> Decade<X, B, C, D, E, F, G, H, I, J> replaceFirst(X x) {
        return new Decade<>(x, b, c, d, e, f, g, h, i, j);
    }

    public <X> Decade<A, X, C, D, E, F, G, H, I, J> replaceSecond(X x) {
        return new Decade<>(a, x, c, d, e, f, g, h, i, j);
    }

    public <X> Decade<A, B, X, D, E, F, G, H, I, J> replaceThird(X x) {
        return new Decade<>(a, b, x, d, e, f, g, h, i, j);
    }

    public <X> Decade<A, B, C, X, E, F, G, H, I, J> replaceFourth(X x) {
        return new Decade<>(a, b, c, x, e, f, g, h, i, j);
    }

    public <X> Decade<A, B, C, D, X, F, G, H, I, J> replaceFifth(X x) {
        return new Decade<>(a, b, c, d, x, f, g, h, i, j);
    }

    public <X> Decade<A, B, C, D, E, X, G, H, I, J> replaceSixth(X x) {
        return new Decade<>(a, b, c, d, e, x, g, h, i, j);
    }

    public <X> Decade<A, B, C, D, E, F, X, H, I, J> replaceSeventh(X x) {
        return new Decade<>(a, b, c, d, e, f, x, h, i, j);
    }

    public <X> Decade<A, B, C, D, E, F, G, X, I, J> replaceEighth(X x) {
        return new Decade<>(a, b, c, d, e, f, g, x, i, j);
    }

    public <X> Decade<A, B, C, D, E, F, G, H, X, J> replaceNinth(X x) {
        return new Decade<>(a, b, c, d, e, f, g, h, x, j);
    }

    public <X> Decade<A, B, C, D, E, F, G, H, I, X> replace(X x) {
        return new Decade<>(a, b, c, d, e, f, g, h, i, x);
    }

    public <X> Decade<X, B, C, D, E, F, G, H, I, J> mapFirst(Function<A, X> mapper) {
        return new Decade<>(mapper.apply(a), b, c, d, e, f, g, h, i, j);
    }

    public <X> Decade<A, X, C, D, E, F, G, H, I, J> mapSecond(Function<B, X> mapper) {
        return new Decade<>(a, mapper.apply(b), c, d, e, f, g, h, i, j);
    }

    public <X> Decade<A, B, X, D, E, F, G, H, I, J> mapThird(Function<C, X> mapper) {
        return new Decade<>(a, b, mapper.apply(c), d, e, f, g, h, i, j);
    }

    public <X> Decade<A, B, C, X, E, F, G, H, I, J> mapFourth(Function<D, X> mapper) {
        return new Decade<>(a, b, c, mapper.apply(d), e, f, g, h, i, j);
    }

    public <X> Decade<A, B, C, D, X, F, G, H, I, J> mapFifth(Function<E, X> mapper) {
        return new Decade<>(a, b, c, d, mapper.apply(e), f, g, h, i, j);
    }

    public <X> Decade<A, B, C, D, E, X, G, H, I, J> mapSixth(Function<F, X> mapper) {
        return new Decade<>(a, b, c, d, e, mapper.apply(f), g, h, i, j);
    }

    public <X> Decade<A, B, C, D, E, F, X, H, I, J> mapSeventh(Function<G, X> mapper) {
        return new Decade<>(a, b, c, d, e, f, mapper.apply(g), h, i, j);
    }

    public <X> Decade<A, B, C, D, E, F, G, X, I, J> mapEighth(Function<H, X> mapper) {
        return new Decade<>(a, b, c, d, e, f, g, mapper.apply(h), i, j);
    }

    public <X> Decade<A, B, C, D, E, F, G, H, X, J> mapNinth(Function<I, X> mapper) {
        return new Decade<>(a, b, c, d, e, f, g, h, mapper.apply(i), j);
    }

    public <X> Decade<A, B, C, D, E, F, G, H, I, X> map(Function<J, X> mapper) {
        return new Decade<>(a, b, c, d, e, f, g, h, i, mapper.apply(j));
    }

    public Decade<J, I, H, G, F, E, D, C, B, A> reverse() {
        return new Decade<>(j, i, h, g, f, e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || this.getClass() != that.getClass()) return false;
        Decade<?, ?, ?, ?, ?, ?, ?, ?, ?, ?> thatDecade = (Decade<?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatDecade.a) && 
                Objects.equals(this.b, thatDecade.b) && 
                Objects.equals(this.c, thatDecade.c) && 
                Objects.equals(this.d, thatDecade.d) && 
                Objects.equals(this.e, thatDecade.e) && 
                Objects.equals(this.f, thatDecade.f) && 
                Objects.equals(this.g, thatDecade.g) && 
                Objects.equals(this.h, thatDecade.h) && 
                Objects.equals(this.i, thatDecade.i) && 
                Objects.equals(this.j, thatDecade.j);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f, g, h, i, j);
    }

    @Override
    public String toString() {
        return "Decade{" +
                "a=" + a + ", " +
                "b=" + b + ", " +
                "c=" + c + ", " +
                "d=" + d + ", " +
                "e=" + e + ", " +
                "f=" + f + ", " +
                "g=" + g + ", " +
                "h=" + h + ", " +
                "i=" + i + ", " +
                "j=" + j +
                "}";
    }
}
