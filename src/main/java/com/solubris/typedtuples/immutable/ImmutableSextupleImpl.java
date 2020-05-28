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

import com.solubris.typedtuples.Sextuple;

import java.util.Objects;
import java.util.function.Function;

final class ImmutableSextupleImpl<A, B, C, D, E, F> implements ImmutableSextuple<A, B, C, D, E, F> {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    private final E e;

    private final F f;

    ImmutableSextupleImpl(A a, B b, C c, D d, E e, F f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
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
    public F get() {
        return f;
    }

    @Override
    public <X0> ImmutableSeptuple<X0, A, B, C, D, E, F> addFirst(X0 x0) {
        return new ImmutableSeptupleImpl<>(x0, a, b, c, d, e, f);
    }

    @Override
    public <X0> ImmutableSeptuple<A, X0, B, C, D, E, F> addSecond(X0 x0) {
        return new ImmutableSeptupleImpl<>(a, x0, b, c, d, e, f);
    }

    @Override
    public <X0> ImmutableSeptuple<A, B, X0, C, D, E, F> addThird(X0 x0) {
        return new ImmutableSeptupleImpl<>(a, b, x0, c, d, e, f);
    }

    @Override
    public <X0> ImmutableSeptuple<A, B, C, X0, D, E, F> addFourth(X0 x0) {
        return new ImmutableSeptupleImpl<>(a, b, c, x0, d, e, f);
    }

    @Override
    public <X0> ImmutableSeptuple<A, B, C, D, X0, E, F> addFifth(X0 x0) {
        return new ImmutableSeptupleImpl<>(a, b, c, d, x0, e, f);
    }

    @Override
    public <X0> ImmutableSeptuple<A, B, C, D, E, X0, F> addSixth(X0 x0) {
        return new ImmutableSeptupleImpl<>(a, b, c, d, e, x0, f);
    }

    @Override
    public <X0> ImmutableSeptuple<A, B, C, D, E, F, X0> add(X0 x0) {
        return new ImmutableSeptupleImpl<>(a, b, c, d, e, f, x0);
    }

    @Override
    public ImmutableQuintuple<B, C, D, E, F> removeFirst() {
        return new ImmutableQuintupleImpl<>(b, c, d, e, f);
    }

    @Override
    public ImmutableQuintuple<A, C, D, E, F> removeSecond() {
        return new ImmutableQuintupleImpl<>(a, c, d, e, f);
    }

    @Override
    public ImmutableQuintuple<A, B, D, E, F> removeThird() {
        return new ImmutableQuintupleImpl<>(a, b, d, e, f);
    }

    @Override
    public ImmutableQuintuple<A, B, C, E, F> removeFourth() {
        return new ImmutableQuintupleImpl<>(a, b, c, e, f);
    }

    @Override
    public ImmutableQuintuple<A, B, C, D, F> removeFifth() {
        return new ImmutableQuintupleImpl<>(a, b, c, d, f);
    }

    @Override
    public ImmutableQuintuple<A, B, C, D, E> remove() {
        return new ImmutableQuintupleImpl<>(a, b, c, d, e);
    }

    @Override
    public <X> ImmutableSextuple<X, B, C, D, E, F> replaceFirst(X x) {
        return new ImmutableSextupleImpl<>(x, b, c, d, e, f);
    }

    @Override
    public <X> ImmutableSextuple<A, X, C, D, E, F> replaceSecond(X x) {
        return new ImmutableSextupleImpl<>(a, x, c, d, e, f);
    }

    @Override
    public <X> ImmutableSextuple<A, B, X, D, E, F> replaceThird(X x) {
        return new ImmutableSextupleImpl<>(a, b, x, d, e, f);
    }

    @Override
    public <X> ImmutableSextuple<A, B, C, X, E, F> replaceFourth(X x) {
        return new ImmutableSextupleImpl<>(a, b, c, x, e, f);
    }

    @Override
    public <X> ImmutableSextuple<A, B, C, D, X, F> replaceFifth(X x) {
        return new ImmutableSextupleImpl<>(a, b, c, d, x, f);
    }

    @Override
    public <X> ImmutableSextuple<A, B, C, D, E, X> replace(X x) {
        return new ImmutableSextupleImpl<>(a, b, c, d, e, x);
    }

    @Override
    public <X> ImmutableSextuple<X, B, C, D, E, F> mapFirst(Function<A, X> mapper) {
        return new ImmutableSextupleImpl<>(mapper.apply(a), b, c, d, e, f);
    }

    @Override
    public <X> ImmutableSextuple<A, X, C, D, E, F> mapSecond(Function<B, X> mapper) {
        return new ImmutableSextupleImpl<>(a, mapper.apply(b), c, d, e, f);
    }

    @Override
    public <X> ImmutableSextuple<A, B, X, D, E, F> mapThird(Function<C, X> mapper) {
        return new ImmutableSextupleImpl<>(a, b, mapper.apply(c), d, e, f);
    }

    @Override
    public <X> ImmutableSextuple<A, B, C, X, E, F> mapFourth(Function<D, X> mapper) {
        return new ImmutableSextupleImpl<>(a, b, c, mapper.apply(d), e, f);
    }

    @Override
    public <X> ImmutableSextuple<A, B, C, D, X, F> mapFifth(Function<E, X> mapper) {
        return new ImmutableSextupleImpl<>(a, b, c, d, mapper.apply(e), f);
    }

    @Override
    public <X> ImmutableSextuple<A, B, C, D, E, X> map(Function<F, X> mapper) {
        return new ImmutableSextupleImpl<>(a, b, c, d, e, mapper.apply(f));
    }

    @Override
    public ImmutableSextuple<F, E, D, C, B, A> reverse() {
        return new ImmutableSextupleImpl<>(f, e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Sextuple<?, ?, ?, ?, ?, ?>)) return false;
        Sextuple<?, ?, ?, ?, ?, ?> thatSextuple = (Sextuple<?, ?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatSextuple.getFirst()) && 
                Objects.equals(this.b, thatSextuple.getSecond()) && 
                Objects.equals(this.c, thatSextuple.getThird()) && 
                Objects.equals(this.d, thatSextuple.getFourth()) && 
                Objects.equals(this.e, thatSextuple.getFifth()) && 
                Objects.equals(this.f, thatSextuple.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ")";
    }
}
