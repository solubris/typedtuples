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

import com.solubris.typedtuples.Decuple;
import com.solubris.typedtuples.function.DecupleFunction;

import java.util.Objects;
import java.util.function.Function;

final class ImmutableDecupleImpl<A, B, C, D, E, F, G, H, I, J> implements ImmutableDecuple<A, B, C, D, E, F, G, H, I, J> {
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

    ImmutableDecupleImpl(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
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
    public D getFourth() {
        return d;
    }

    @Override
    public E getFifth() {
        return e;
    }

    @Override
    public F getSixth() {
        return f;
    }

    @Override
    public G getSeventh() {
        return g;
    }

    @Override
    public H getEighth() {
        return h;
    }

    @Override
    public I getNinth() {
        return i;
    }

    @Override
    public J get() {
        return j;
    }

    @Override
    public ImmutableNonuple<B, C, D, E, F, G, H, I, J> removeFirst() {
        return new ImmutableNonupleImpl<>(b, c, d, e, f, g, h, i, j);
    }

    @Override
    public ImmutableNonuple<A, C, D, E, F, G, H, I, J> removeSecond() {
        return new ImmutableNonupleImpl<>(a, c, d, e, f, g, h, i, j);
    }

    @Override
    public ImmutableNonuple<A, B, D, E, F, G, H, I, J> removeThird() {
        return new ImmutableNonupleImpl<>(a, b, d, e, f, g, h, i, j);
    }

    @Override
    public ImmutableNonuple<A, B, C, E, F, G, H, I, J> removeFourth() {
        return new ImmutableNonupleImpl<>(a, b, c, e, f, g, h, i, j);
    }

    @Override
    public ImmutableNonuple<A, B, C, D, F, G, H, I, J> removeFifth() {
        return new ImmutableNonupleImpl<>(a, b, c, d, f, g, h, i, j);
    }

    @Override
    public ImmutableNonuple<A, B, C, D, E, G, H, I, J> removeSixth() {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, g, h, i, j);
    }

    @Override
    public ImmutableNonuple<A, B, C, D, E, F, H, I, J> removeSeventh() {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, h, i, j);
    }

    @Override
    public ImmutableNonuple<A, B, C, D, E, F, G, I, J> removeEighth() {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, i, j);
    }

    @Override
    public ImmutableNonuple<A, B, C, D, E, F, G, H, J> removeNinth() {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, j);
    }

    @Override
    public ImmutableNonuple<A, B, C, D, E, F, G, H, I> remove() {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, i);
    }

    @Override
    public <X> ImmutableDecuple<X, B, C, D, E, F, G, H, I, J> replaceFirst(X x) {
        return new ImmutableDecupleImpl<>(x, b, c, d, e, f, g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, X, C, D, E, F, G, H, I, J> replaceSecond(X x) {
        return new ImmutableDecupleImpl<>(a, x, c, d, e, f, g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, X, D, E, F, G, H, I, J> replaceThird(X x) {
        return new ImmutableDecupleImpl<>(a, b, x, d, e, f, g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, X, E, F, G, H, I, J> replaceFourth(X x) {
        return new ImmutableDecupleImpl<>(a, b, c, x, e, f, g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, X, F, G, H, I, J> replaceFifth(X x) {
        return new ImmutableDecupleImpl<>(a, b, c, d, x, f, g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, E, X, G, H, I, J> replaceSixth(X x) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, x, g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, E, F, X, H, I, J> replaceSeventh(X x) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, x, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, E, F, G, X, I, J> replaceEighth(X x) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, x, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, E, F, G, H, X, J> replaceNinth(X x) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, x, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, E, F, G, H, I, X> replace(X x) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, x);
    }

    @Override
    public <X> ImmutableDecuple<X, B, C, D, E, F, G, H, I, J> mapFirst(Function<A, X> mapper) {
        return new ImmutableDecupleImpl<>(mapper.apply(a), b, c, d, e, f, g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, X, C, D, E, F, G, H, I, J> mapSecond(Function<B, X> mapper) {
        return new ImmutableDecupleImpl<>(a, mapper.apply(b), c, d, e, f, g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, X, D, E, F, G, H, I, J> mapThird(Function<C, X> mapper) {
        return new ImmutableDecupleImpl<>(a, b, mapper.apply(c), d, e, f, g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, X, E, F, G, H, I, J> mapFourth(Function<D, X> mapper) {
        return new ImmutableDecupleImpl<>(a, b, c, mapper.apply(d), e, f, g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, X, F, G, H, I, J> mapFifth(Function<E, X> mapper) {
        return new ImmutableDecupleImpl<>(a, b, c, d, mapper.apply(e), f, g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, E, X, G, H, I, J> mapSixth(Function<F, X> mapper) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, mapper.apply(f), g, h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, E, F, X, H, I, J> mapSeventh(Function<G, X> mapper) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, mapper.apply(g), h, i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, E, F, G, X, I, J> mapEighth(Function<H, X> mapper) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, mapper.apply(h), i, j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, E, F, G, H, X, J> mapNinth(Function<I, X> mapper) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, mapper.apply(i), j);
    }

    @Override
    public <X> ImmutableDecuple<A, B, C, D, E, F, G, H, I, X> map(Function<J, X> mapper) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, mapper.apply(j));
    }

    @Override
    public <R> R mapAll(DecupleFunction<A, B, C, D, E, F, G, H, I, J, R> mapper) {
        return mapper.apply(a, b, c, d, e, f, g, h, i, j);
    }

    @Override
    public ImmutableDecuple<J, I, H, G, F, E, D, C, B, A> reverse() {
        return new ImmutableDecupleImpl<>(j, i, h, g, f, e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Decuple<?, ?, ?, ?, ?, ?, ?, ?, ?, ?>)) return false;
        Decuple<?, ?, ?, ?, ?, ?, ?, ?, ?, ?> thatDecuple = (Decuple<?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatDecuple.getFirst()) &&
                Objects.equals(this.b, thatDecuple.getSecond()) &&
                Objects.equals(this.c, thatDecuple.getThird()) &&
                Objects.equals(this.d, thatDecuple.getFourth()) &&
                Objects.equals(this.e, thatDecuple.getFifth()) &&
                Objects.equals(this.f, thatDecuple.getSixth()) &&
                Objects.equals(this.g, thatDecuple.getSeventh()) &&
                Objects.equals(this.h, thatDecuple.getEighth()) &&
                Objects.equals(this.i, thatDecuple.getNinth()) &&
                Objects.equals(this.j, thatDecuple.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f, g, h, i, j);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h + ", " + i + ", " + j + ")";
    }
}
