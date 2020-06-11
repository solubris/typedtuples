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

import com.solubris.typedtuples.Octuple;
import com.solubris.typedtuples.function.OctupleFunction;

import java.util.Objects;
import java.util.function.Function;

final class ImmutableOctupleImpl<A, B, C, D, E, F, G, H> implements ImmutableOctuple<A, B, C, D, E, F, G, H> {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    private final E e;

    private final F f;

    private final G g;

    private final H h;

    ImmutableOctupleImpl(A a, B b, C c, D d, E e, F f, G g, H h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
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
    public H get() {
        return h;
    }

    @Override
    public <X0> ImmutableNonuple<X0, A, B, C, D, E, F, G, H> addFirst(X0 x0) {
        return new ImmutableNonupleImpl<>(x0, a, b, c, d, e, f, g, h);
    }

    @Override
    public <X0> ImmutableNonuple<A, X0, B, C, D, E, F, G, H> addSecond(X0 x0) {
        return new ImmutableNonupleImpl<>(a, x0, b, c, d, e, f, g, h);
    }

    @Override
    public <X0> ImmutableNonuple<A, B, X0, C, D, E, F, G, H> addThird(X0 x0) {
        return new ImmutableNonupleImpl<>(a, b, x0, c, d, e, f, g, h);
    }

    @Override
    public <X0> ImmutableNonuple<A, B, C, X0, D, E, F, G, H> addFourth(X0 x0) {
        return new ImmutableNonupleImpl<>(a, b, c, x0, d, e, f, g, h);
    }

    @Override
    public <X0> ImmutableNonuple<A, B, C, D, X0, E, F, G, H> addFifth(X0 x0) {
        return new ImmutableNonupleImpl<>(a, b, c, d, x0, e, f, g, h);
    }

    @Override
    public <X0> ImmutableNonuple<A, B, C, D, E, X0, F, G, H> addSixth(X0 x0) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, x0, f, g, h);
    }

    @Override
    public <X0> ImmutableNonuple<A, B, C, D, E, F, X0, G, H> addSeventh(X0 x0) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, x0, g, h);
    }

    @Override
    public <X0> ImmutableNonuple<A, B, C, D, E, F, G, X0, H> addEighth(X0 x0) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, x0, h);
    }

    @Override
    public <X0> ImmutableNonuple<A, B, C, D, E, F, G, H, X0> add(X0 x0) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, x0);
    }

    @Override
    public ImmutableNonuple<A, A, B, C, D, E, F, G, H> duplicateFirst() {
        return new ImmutableNonupleImpl<>(a, a, b, c, d, e, f, g, h);
    }

    @Override
    public ImmutableNonuple<A, B, B, C, D, E, F, G, H> duplicateSecond() {
        return new ImmutableNonupleImpl<>(a, b, b, c, d, e, f, g, h);
    }

    @Override
    public ImmutableNonuple<A, B, C, C, D, E, F, G, H> duplicateThird() {
        return new ImmutableNonupleImpl<>(a, b, c, c, d, e, f, g, h);
    }

    @Override
    public ImmutableNonuple<A, B, C, D, D, E, F, G, H> duplicateFourth() {
        return new ImmutableNonupleImpl<>(a, b, c, d, d, e, f, g, h);
    }

    @Override
    public ImmutableNonuple<A, B, C, D, E, E, F, G, H> duplicateFifth() {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, e, f, g, h);
    }

    @Override
    public ImmutableNonuple<A, B, C, D, E, F, F, G, H> duplicateSixth() {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, f, g, h);
    }

    @Override
    public ImmutableNonuple<A, B, C, D, E, F, G, G, H> duplicateSeventh() {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, g, h);
    }

    @Override
    public ImmutableNonuple<A, B, C, D, E, F, G, H, H> duplicate() {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, h);
    }

    @Override
    public ImmutableSeptuple<B, C, D, E, F, G, H> removeFirst() {
        return new ImmutableSeptupleImpl<>(b, c, d, e, f, g, h);
    }

    @Override
    public ImmutableSeptuple<A, C, D, E, F, G, H> removeSecond() {
        return new ImmutableSeptupleImpl<>(a, c, d, e, f, g, h);
    }

    @Override
    public ImmutableSeptuple<A, B, D, E, F, G, H> removeThird() {
        return new ImmutableSeptupleImpl<>(a, b, d, e, f, g, h);
    }

    @Override
    public ImmutableSeptuple<A, B, C, E, F, G, H> removeFourth() {
        return new ImmutableSeptupleImpl<>(a, b, c, e, f, g, h);
    }

    @Override
    public ImmutableSeptuple<A, B, C, D, F, G, H> removeFifth() {
        return new ImmutableSeptupleImpl<>(a, b, c, d, f, g, h);
    }

    @Override
    public ImmutableSeptuple<A, B, C, D, E, G, H> removeSixth() {
        return new ImmutableSeptupleImpl<>(a, b, c, d, e, g, h);
    }

    @Override
    public ImmutableSeptuple<A, B, C, D, E, F, H> removeSeventh() {
        return new ImmutableSeptupleImpl<>(a, b, c, d, e, f, h);
    }

    @Override
    public ImmutableSeptuple<A, B, C, D, E, F, G> remove() {
        return new ImmutableSeptupleImpl<>(a, b, c, d, e, f, g);
    }

    @Override
    public <X> ImmutableOctuple<X, B, C, D, E, F, G, H> replaceFirst(X x) {
        return new ImmutableOctupleImpl<>(x, b, c, d, e, f, g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, X, C, D, E, F, G, H> replaceSecond(X x) {
        return new ImmutableOctupleImpl<>(a, x, c, d, e, f, g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, X, D, E, F, G, H> replaceThird(X x) {
        return new ImmutableOctupleImpl<>(a, b, x, d, e, f, g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, X, E, F, G, H> replaceFourth(X x) {
        return new ImmutableOctupleImpl<>(a, b, c, x, e, f, g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, X, F, G, H> replaceFifth(X x) {
        return new ImmutableOctupleImpl<>(a, b, c, d, x, f, g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, X, G, H> replaceSixth(X x) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, x, g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, F, X, H> replaceSeventh(X x) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, x, h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, F, G, X> replace(X x) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, x);
    }

    @Override
    public <X> ImmutableOctuple<X, B, C, D, E, F, G, H> mapFirst(Function<? super A, X> mapper) {
        return new ImmutableOctupleImpl<>(mapper.apply(a), b, c, d, e, f, g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, X, C, D, E, F, G, H> mapSecond(Function<? super B, X> mapper) {
        return new ImmutableOctupleImpl<>(a, mapper.apply(b), c, d, e, f, g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, X, D, E, F, G, H> mapThird(Function<? super C, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, mapper.apply(c), d, e, f, g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, X, E, F, G, H> mapFourth(Function<? super D, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, mapper.apply(d), e, f, g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, X, F, G, H> mapFifth(Function<? super E, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, d, mapper.apply(e), f, g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, X, G, H> mapSixth(Function<? super F, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, mapper.apply(f), g, h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, F, X, H> mapSeventh(Function<? super G, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, mapper.apply(g), h);
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, F, G, X> map(Function<? super H, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, mapper.apply(h));
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> mapFirstAndAdd(
            Function<? super A, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, mapper.apply(a));
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> mapSecondAndAdd(
            Function<? super B, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, mapper.apply(b));
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> mapThirdAndAdd(
            Function<? super C, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, mapper.apply(c));
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> mapFourthAndAdd(
            Function<? super D, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, mapper.apply(d));
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> mapFifthAndAdd(
            Function<? super E, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, mapper.apply(e));
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> mapSixthAndAdd(
            Function<? super F, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, mapper.apply(f));
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> mapSeventhAndAdd(
            Function<? super G, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, mapper.apply(g));
    }

    @Override
    public <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> mapAndAdd(
            Function<? super H, X> mapper) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, mapper.apply(h));
    }

    @Override
    public <R> R mapAll(
            OctupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? super H, R> mapper) {
        return mapper.apply(a, b, c, d, e, f, g, h);
    }

    @Override
    public ImmutableOctuple<H, G, F, E, D, C, B, A> reverse() {
        return new ImmutableOctupleImpl<>(h, g, f, e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Octuple<?, ?, ?, ?, ?, ?, ?, ?>)) return false;
        Octuple<?, ?, ?, ?, ?, ?, ?, ?> thatOctuple = (Octuple<?, ?, ?, ?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatOctuple.getFirst()) && 
                Objects.equals(this.b, thatOctuple.getSecond()) && 
                Objects.equals(this.c, thatOctuple.getThird()) && 
                Objects.equals(this.d, thatOctuple.getFourth()) && 
                Objects.equals(this.e, thatOctuple.getFifth()) && 
                Objects.equals(this.f, thatOctuple.getSixth()) && 
                Objects.equals(this.g, thatOctuple.getSeventh()) && 
                Objects.equals(this.h, thatOctuple.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f, g, h);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h + ")";
    }
}
