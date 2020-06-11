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

import com.solubris.typedtuples.Septuple;
import com.solubris.typedtuples.function.SeptupleFunction;

import java.util.Objects;
import java.util.function.Function;

final class ImmutableSeptupleImpl<A, B, C, D, E, F, G> implements ImmutableSeptuple<A, B, C, D, E, F, G> {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    private final E e;

    private final F f;

    private final G g;

    ImmutableSeptupleImpl(A a, B b, C c, D d, E e, F f, G g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
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
    public G get() {
        return g;
    }

    @Override
    public <X0> ImmutableOctuple<X0, A, B, C, D, E, F, G> addFirst(X0 x0) {
        return new ImmutableOctupleImpl<>(x0, a, b, c, d, e, f, g);
    }

    @Override
    public <X0> ImmutableOctuple<A, X0, B, C, D, E, F, G> addSecond(X0 x0) {
        return new ImmutableOctupleImpl<>(a, x0, b, c, d, e, f, g);
    }

    @Override
    public <X0> ImmutableOctuple<A, B, X0, C, D, E, F, G> addThird(X0 x0) {
        return new ImmutableOctupleImpl<>(a, b, x0, c, d, e, f, g);
    }

    @Override
    public <X0> ImmutableOctuple<A, B, C, X0, D, E, F, G> addFourth(X0 x0) {
        return new ImmutableOctupleImpl<>(a, b, c, x0, d, e, f, g);
    }

    @Override
    public <X0> ImmutableOctuple<A, B, C, D, X0, E, F, G> addFifth(X0 x0) {
        return new ImmutableOctupleImpl<>(a, b, c, d, x0, e, f, g);
    }

    @Override
    public <X0> ImmutableOctuple<A, B, C, D, E, X0, F, G> addSixth(X0 x0) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, x0, f, g);
    }

    @Override
    public <X0> ImmutableOctuple<A, B, C, D, E, F, X0, G> addSeventh(X0 x0) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, x0, g);
    }

    @Override
    public <X0> ImmutableOctuple<A, B, C, D, E, F, G, X0> add(X0 x0) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, x0);
    }

    @Override
    public ImmutableOctuple<A, A, B, C, D, E, F, G> duplicateFirst() {
        return new ImmutableOctupleImpl<>(a, a, b, c, d, e, f, g);
    }

    @Override
    public ImmutableOctuple<A, B, B, C, D, E, F, G> duplicateSecond() {
        return new ImmutableOctupleImpl<>(a, b, b, c, d, e, f, g);
    }

    @Override
    public ImmutableOctuple<A, B, C, C, D, E, F, G> duplicateThird() {
        return new ImmutableOctupleImpl<>(a, b, c, c, d, e, f, g);
    }

    @Override
    public ImmutableOctuple<A, B, C, D, D, E, F, G> duplicateFourth() {
        return new ImmutableOctupleImpl<>(a, b, c, d, d, e, f, g);
    }

    @Override
    public ImmutableOctuple<A, B, C, D, E, E, F, G> duplicateFifth() {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, e, f, g);
    }

    @Override
    public ImmutableOctuple<A, B, C, D, E, F, F, G> duplicateSixth() {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, f, g);
    }

    @Override
    public ImmutableOctuple<A, B, C, D, E, F, G, G> duplicate() {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, g);
    }

    @Override
    public ImmutableSextuple<B, C, D, E, F, G> removeFirst() {
        return new ImmutableSextupleImpl<>(b, c, d, e, f, g);
    }

    @Override
    public ImmutableSextuple<A, C, D, E, F, G> removeSecond() {
        return new ImmutableSextupleImpl<>(a, c, d, e, f, g);
    }

    @Override
    public ImmutableSextuple<A, B, D, E, F, G> removeThird() {
        return new ImmutableSextupleImpl<>(a, b, d, e, f, g);
    }

    @Override
    public ImmutableSextuple<A, B, C, E, F, G> removeFourth() {
        return new ImmutableSextupleImpl<>(a, b, c, e, f, g);
    }

    @Override
    public ImmutableSextuple<A, B, C, D, F, G> removeFifth() {
        return new ImmutableSextupleImpl<>(a, b, c, d, f, g);
    }

    @Override
    public ImmutableSextuple<A, B, C, D, E, G> removeSixth() {
        return new ImmutableSextupleImpl<>(a, b, c, d, e, g);
    }

    @Override
    public ImmutableSextuple<A, B, C, D, E, F> remove() {
        return new ImmutableSextupleImpl<>(a, b, c, d, e, f);
    }

    @Override
    public <X> ImmutableSeptuple<X, B, C, D, E, F, G> replaceFirst(X x) {
        return new ImmutableSeptupleImpl<>(x, b, c, d, e, f, g);
    }

    @Override
    public <X> ImmutableSeptuple<A, X, C, D, E, F, G> replaceSecond(X x) {
        return new ImmutableSeptupleImpl<>(a, x, c, d, e, f, g);
    }

    @Override
    public <X> ImmutableSeptuple<A, B, X, D, E, F, G> replaceThird(X x) {
        return new ImmutableSeptupleImpl<>(a, b, x, d, e, f, g);
    }

    @Override
    public <X> ImmutableSeptuple<A, B, C, X, E, F, G> replaceFourth(X x) {
        return new ImmutableSeptupleImpl<>(a, b, c, x, e, f, g);
    }

    @Override
    public <X> ImmutableSeptuple<A, B, C, D, X, F, G> replaceFifth(X x) {
        return new ImmutableSeptupleImpl<>(a, b, c, d, x, f, g);
    }

    @Override
    public <X> ImmutableSeptuple<A, B, C, D, E, X, G> replaceSixth(X x) {
        return new ImmutableSeptupleImpl<>(a, b, c, d, e, x, g);
    }

    @Override
    public <X> ImmutableSeptuple<A, B, C, D, E, F, X> replace(X x) {
        return new ImmutableSeptupleImpl<>(a, b, c, d, e, f, x);
    }

    @Override
    public <X> ImmutableSeptuple<X, B, C, D, E, F, G> mapFirst(Function<? super A, X> mapper) {
        return new ImmutableSeptupleImpl<>(mapper.apply(a), b, c, d, e, f, g);
    }

    @Override
    public <X> ImmutableSeptuple<A, X, C, D, E, F, G> mapSecond(Function<? super B, X> mapper) {
        return new ImmutableSeptupleImpl<>(a, mapper.apply(b), c, d, e, f, g);
    }

    @Override
    public <X> ImmutableSeptuple<A, B, X, D, E, F, G> mapThird(Function<? super C, X> mapper) {
        return new ImmutableSeptupleImpl<>(a, b, mapper.apply(c), d, e, f, g);
    }

    @Override
    public <X> ImmutableSeptuple<A, B, C, X, E, F, G> mapFourth(Function<? super D, X> mapper) {
        return new ImmutableSeptupleImpl<>(a, b, c, mapper.apply(d), e, f, g);
    }

    @Override
    public <X> ImmutableSeptuple<A, B, C, D, X, F, G> mapFifth(Function<? super E, X> mapper) {
        return new ImmutableSeptupleImpl<>(a, b, c, d, mapper.apply(e), f, g);
    }

    @Override
    public <X> ImmutableSeptuple<A, B, C, D, E, X, G> mapSixth(Function<? super F, X> mapper) {
        return new ImmutableSeptupleImpl<>(a, b, c, d, e, mapper.apply(f), g);
    }

    @Override
    public <X> ImmutableSeptuple<A, B, C, D, E, F, X> map(Function<? super G, X> mapper) {
        return new ImmutableSeptupleImpl<>(a, b, c, d, e, f, mapper.apply(g));
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapFirstAndAdd(
            Function<? super A, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, mapper.apply(a));
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapSecondAndAdd(
            Function<? super B, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, mapper.apply(b));
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapThirdAndAdd(
            Function<? super C, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, mapper.apply(c));
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapFourthAndAdd(
            Function<? super D, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, mapper.apply(d));
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapFifthAndAdd(
            Function<? super E, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, mapper.apply(e));
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapSixthAndAdd(
            Function<? super F, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, mapper.apply(f));
    }

    @Override
    public <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapAndAdd(Function<? super G, X> mapper) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, mapper.apply(g));
    }

    @Override
    public <R> R mapAll(SeptupleFunction<A, B, C, D, E, F, G, R> mapper) {
        return mapper.apply(a, b, c, d, e, f, g);
    }

    @Override
    public ImmutableSeptuple<G, F, E, D, C, B, A> reverse() {
        return new ImmutableSeptupleImpl<>(g, f, e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Septuple<?, ?, ?, ?, ?, ?, ?>)) return false;
        Septuple<?, ?, ?, ?, ?, ?, ?> thatSeptuple = (Septuple<?, ?, ?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatSeptuple.getFirst()) && 
                Objects.equals(this.b, thatSeptuple.getSecond()) && 
                Objects.equals(this.c, thatSeptuple.getThird()) && 
                Objects.equals(this.d, thatSeptuple.getFourth()) && 
                Objects.equals(this.e, thatSeptuple.getFifth()) && 
                Objects.equals(this.f, thatSeptuple.getSixth()) && 
                Objects.equals(this.g, thatSeptuple.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f, g);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ")";
    }
}
