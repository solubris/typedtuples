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

import com.solubris.typedtuples.Nonuple;

import java.util.Objects;
import java.util.function.Function;

final class ImmutableNonupleImpl<A, B, C, D, E, F, G, H, I> implements ImmutableNonuple<A, B, C, D, E, F, G, H, I> {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    private final E e;

    private final F f;

    private final G g;

    private final H h;

    private final I i;

    ImmutableNonupleImpl(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
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
    public I get() {
        return i;
    }

    @Override
    public <X0> ImmutableDecuple<X0, A, B, C, D, E, F, G, H, I> addFirst(X0 x0) {
        return new ImmutableDecupleImpl<>(x0, a, b, c, d, e, f, g, h, i);
    }

    @Override
    public <X0> ImmutableDecuple<A, X0, B, C, D, E, F, G, H, I> addSecond(X0 x0) {
        return new ImmutableDecupleImpl<>(a, x0, b, c, d, e, f, g, h, i);
    }

    @Override
    public <X0> ImmutableDecuple<A, B, X0, C, D, E, F, G, H, I> addThird(X0 x0) {
        return new ImmutableDecupleImpl<>(a, b, x0, c, d, e, f, g, h, i);
    }

    @Override
    public <X0> ImmutableDecuple<A, B, C, X0, D, E, F, G, H, I> addFourth(X0 x0) {
        return new ImmutableDecupleImpl<>(a, b, c, x0, d, e, f, g, h, i);
    }

    @Override
    public <X0> ImmutableDecuple<A, B, C, D, X0, E, F, G, H, I> addFifth(X0 x0) {
        return new ImmutableDecupleImpl<>(a, b, c, d, x0, e, f, g, h, i);
    }

    @Override
    public <X0> ImmutableDecuple<A, B, C, D, E, X0, F, G, H, I> addSixth(X0 x0) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, x0, f, g, h, i);
    }

    @Override
    public <X0> ImmutableDecuple<A, B, C, D, E, F, X0, G, H, I> addSeventh(X0 x0) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, x0, g, h, i);
    }

    @Override
    public <X0> ImmutableDecuple<A, B, C, D, E, F, G, X0, H, I> addEighth(X0 x0) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, x0, h, i);
    }

    @Override
    public <X0> ImmutableDecuple<A, B, C, D, E, F, G, H, X0, I> addNinth(X0 x0) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, x0, i);
    }

    @Override
    public <X0> ImmutableDecuple<A, B, C, D, E, F, G, H, I, X0> add(X0 x0) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, x0);
    }

    @Override
    public ImmutableDecuple<A, A, B, C, D, E, F, G, H, I> duplicateFirst() {
        return new ImmutableDecupleImpl<>(a, a, b, c, d, e, f, g, h, i);
    }

    @Override
    public ImmutableDecuple<A, B, B, C, D, E, F, G, H, I> duplicateSecond() {
        return new ImmutableDecupleImpl<>(a, b, b, c, d, e, f, g, h, i);
    }

    @Override
    public ImmutableDecuple<A, B, C, C, D, E, F, G, H, I> duplicateThird() {
        return new ImmutableDecupleImpl<>(a, b, c, c, d, e, f, g, h, i);
    }

    @Override
    public ImmutableDecuple<A, B, C, D, D, E, F, G, H, I> duplicateFourth() {
        return new ImmutableDecupleImpl<>(a, b, c, d, d, e, f, g, h, i);
    }

    @Override
    public ImmutableDecuple<A, B, C, D, E, E, F, G, H, I> duplicateFifth() {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, e, f, g, h, i);
    }

    @Override
    public ImmutableDecuple<A, B, C, D, E, F, F, G, H, I> duplicateSixth() {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, f, g, h, i);
    }

    @Override
    public ImmutableDecuple<A, B, C, D, E, F, G, G, H, I> duplicateSeventh() {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, g, h, i);
    }

    @Override
    public ImmutableDecuple<A, B, C, D, E, F, G, H, H, I> duplicateEighth() {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, h, i);
    }

    @Override
    public ImmutableDecuple<A, B, C, D, E, F, G, H, I, I> duplicate() {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, i);
    }

    @Override
    public ImmutableOctuple<B, C, D, E, F, G, H, I> removeFirst() {
        return new ImmutableOctupleImpl<>(b, c, d, e, f, g, h, i);
    }

    @Override
    public ImmutableOctuple<A, C, D, E, F, G, H, I> removeSecond() {
        return new ImmutableOctupleImpl<>(a, c, d, e, f, g, h, i);
    }

    @Override
    public ImmutableOctuple<A, B, D, E, F, G, H, I> removeThird() {
        return new ImmutableOctupleImpl<>(a, b, d, e, f, g, h, i);
    }

    @Override
    public ImmutableOctuple<A, B, C, E, F, G, H, I> removeFourth() {
        return new ImmutableOctupleImpl<>(a, b, c, e, f, g, h, i);
    }

    @Override
    public ImmutableOctuple<A, B, C, D, F, G, H, I> removeFifth() {
        return new ImmutableOctupleImpl<>(a, b, c, d, f, g, h, i);
    }

    @Override
    public ImmutableOctuple<A, B, C, D, E, G, H, I> removeSixth() {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, g, h, i);
    }

    @Override
    public ImmutableOctuple<A, B, C, D, E, F, H, I> removeSeventh() {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, h, i);
    }

    @Override
    public ImmutableOctuple<A, B, C, D, E, F, G, I> removeEighth() {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, i);
    }

    @Override
    public ImmutableOctuple<A, B, C, D, E, F, G, H> remove() {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, h);
    }

    @Override
    public <X> ImmutableNonuple<X, B, C, D, E, F, G, H, I> replaceFirst(X x) {
        return new ImmutableNonupleImpl<>(x, b, c, d, e, f, g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, X, C, D, E, F, G, H, I> replaceSecond(X x) {
        return new ImmutableNonupleImpl<>(a, x, c, d, e, f, g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, X, D, E, F, G, H, I> replaceThird(X x) {
        return new ImmutableNonupleImpl<>(a, b, x, d, e, f, g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, X, E, F, G, H, I> replaceFourth(X x) {
        return new ImmutableNonupleImpl<>(a, b, c, x, e, f, g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, X, F, G, H, I> replaceFifth(X x) {
        return new ImmutableNonupleImpl<>(a, b, c, d, x, f, g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, X, G, H, I> replaceSixth(X x) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, x, g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, X, H, I> replaceSeventh(X x) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, x, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, X, I> replaceEighth(X x) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, x, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> replace(X x) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, x);
    }

    @Override
    public <X> ImmutableNonuple<X, B, C, D, E, F, G, H, I> mapFirst(Function<A, X> mapper) {
        return new ImmutableNonupleImpl<>(mapper.apply(a), b, c, d, e, f, g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, X, C, D, E, F, G, H, I> mapSecond(Function<B, X> mapper) {
        return new ImmutableNonupleImpl<>(a, mapper.apply(b), c, d, e, f, g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, X, D, E, F, G, H, I> mapThird(Function<C, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, mapper.apply(c), d, e, f, g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, X, E, F, G, H, I> mapFourth(Function<D, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, mapper.apply(d), e, f, g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, X, F, G, H, I> mapFifth(Function<E, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, mapper.apply(e), f, g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, X, G, H, I> mapSixth(Function<F, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, mapper.apply(f), g, h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, X, H, I> mapSeventh(Function<G, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, mapper.apply(g), h, i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, X, I> mapEighth(Function<H, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, mapper.apply(h), i);
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> map(Function<I, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, mapper.apply(i));
    }

    @Override
    public ImmutableNonuple<I, H, G, F, E, D, C, B, A> reverse() {
        return new ImmutableNonupleImpl<>(i, h, g, f, e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Nonuple<?, ?, ?, ?, ?, ?, ?, ?, ?>)) return false;
        Nonuple<?, ?, ?, ?, ?, ?, ?, ?, ?> thatNonuple = (Nonuple<?, ?, ?, ?, ?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatNonuple.getFirst()) &&
                Objects.equals(this.b, thatNonuple.getSecond()) &&
                Objects.equals(this.c, thatNonuple.getThird()) &&
                Objects.equals(this.d, thatNonuple.getFourth()) &&
                Objects.equals(this.e, thatNonuple.getFifth()) &&
                Objects.equals(this.f, thatNonuple.getSixth()) &&
                Objects.equals(this.g, thatNonuple.getSeventh()) &&
                Objects.equals(this.h, thatNonuple.getEighth()) &&
                Objects.equals(this.i, thatNonuple.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f, g, h, i);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h + ", " + i + ")";
    }
}
