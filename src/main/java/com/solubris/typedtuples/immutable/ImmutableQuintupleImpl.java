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

import com.solubris.typedtuples.Quintuple;
import com.solubris.typedtuples.function.QuintupleFunction;

import java.util.Objects;
import java.util.function.Function;

final class ImmutableQuintupleImpl<A, B, C, D, E> implements ImmutableQuintuple<A, B, C, D, E> {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    private final E e;

    ImmutableQuintupleImpl(A a, B b, C c, D d, E e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
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
    public E get() {
        return e;
    }

    @Override
    public <X0> ImmutableSextuple<X0, A, B, C, D, E> addFirst(X0 x0) {
        return new ImmutableSextupleImpl<>(x0, a, b, c, d, e);
    }

    @Override
    public <X0> ImmutableSextuple<A, X0, B, C, D, E> addSecond(X0 x0) {
        return new ImmutableSextupleImpl<>(a, x0, b, c, d, e);
    }

    @Override
    public <X0> ImmutableSextuple<A, B, X0, C, D, E> addThird(X0 x0) {
        return new ImmutableSextupleImpl<>(a, b, x0, c, d, e);
    }

    @Override
    public <X0> ImmutableSextuple<A, B, C, X0, D, E> addFourth(X0 x0) {
        return new ImmutableSextupleImpl<>(a, b, c, x0, d, e);
    }

    @Override
    public <X0> ImmutableSextuple<A, B, C, D, X0, E> addFifth(X0 x0) {
        return new ImmutableSextupleImpl<>(a, b, c, d, x0, e);
    }

    @Override
    public <X0> ImmutableSextuple<A, B, C, D, E, X0> add(X0 x0) {
        return new ImmutableSextupleImpl<>(a, b, c, d, e, x0);
    }

    @Override
    public ImmutableSextuple<A, A, B, C, D, E> duplicateFirst() {
        return new ImmutableSextupleImpl<>(a, a, b, c, d, e);
    }

    @Override
    public ImmutableSextuple<A, B, B, C, D, E> duplicateSecond() {
        return new ImmutableSextupleImpl<>(a, b, b, c, d, e);
    }

    @Override
    public ImmutableSextuple<A, B, C, C, D, E> duplicateThird() {
        return new ImmutableSextupleImpl<>(a, b, c, c, d, e);
    }

    @Override
    public ImmutableSextuple<A, B, C, D, D, E> duplicateFourth() {
        return new ImmutableSextupleImpl<>(a, b, c, d, d, e);
    }

    @Override
    public ImmutableSextuple<A, B, C, D, E, E> duplicate() {
        return new ImmutableSextupleImpl<>(a, b, c, d, e, e);
    }

    @Override
    public ImmutableQuadruple<B, C, D, E> removeFirst() {
        return new ImmutableQuadrupleImpl<>(b, c, d, e);
    }

    @Override
    public ImmutableQuadruple<A, C, D, E> removeSecond() {
        return new ImmutableQuadrupleImpl<>(a, c, d, e);
    }

    @Override
    public ImmutableQuadruple<A, B, D, E> removeThird() {
        return new ImmutableQuadrupleImpl<>(a, b, d, e);
    }

    @Override
    public ImmutableQuadruple<A, B, C, E> removeFourth() {
        return new ImmutableQuadrupleImpl<>(a, b, c, e);
    }

    @Override
    public ImmutableQuadruple<A, B, C, D> remove() {
        return new ImmutableQuadrupleImpl<>(a, b, c, d);
    }

    @Override
    public <X> ImmutableQuintuple<X, B, C, D, E> replaceFirst(X x) {
        return new ImmutableQuintupleImpl<>(x, b, c, d, e);
    }

    @Override
    public <X> ImmutableQuintuple<A, X, C, D, E> replaceSecond(X x) {
        return new ImmutableQuintupleImpl<>(a, x, c, d, e);
    }

    @Override
    public <X> ImmutableQuintuple<A, B, X, D, E> replaceThird(X x) {
        return new ImmutableQuintupleImpl<>(a, b, x, d, e);
    }

    @Override
    public <X> ImmutableQuintuple<A, B, C, X, E> replaceFourth(X x) {
        return new ImmutableQuintupleImpl<>(a, b, c, x, e);
    }

    @Override
    public <X> ImmutableQuintuple<A, B, C, D, X> replace(X x) {
        return new ImmutableQuintupleImpl<>(a, b, c, d, x);
    }

    @Override
    public <X> ImmutableQuintuple<X, B, C, D, E> mapFirst(Function<A, X> mapper) {
        return new ImmutableQuintupleImpl<>(mapper.apply(a), b, c, d, e);
    }

    @Override
    public <X> ImmutableQuintuple<A, X, C, D, E> mapSecond(Function<B, X> mapper) {
        return new ImmutableQuintupleImpl<>(a, mapper.apply(b), c, d, e);
    }

    @Override
    public <X> ImmutableQuintuple<A, B, X, D, E> mapThird(Function<C, X> mapper) {
        return new ImmutableQuintupleImpl<>(a, b, mapper.apply(c), d, e);
    }

    @Override
    public <X> ImmutableQuintuple<A, B, C, X, E> mapFourth(Function<D, X> mapper) {
        return new ImmutableQuintupleImpl<>(a, b, c, mapper.apply(d), e);
    }

    @Override
    public <X> ImmutableQuintuple<A, B, C, D, X> map(Function<E, X> mapper) {
        return new ImmutableQuintupleImpl<>(a, b, c, d, mapper.apply(e));
    }

    @Override
    public <R> R mapAll(QuintupleFunction<A, B, C, D, E, R> mapper) {
        return mapper.apply(a, b, c, d, e);
    }

    @Override
    public ImmutableQuintuple<E, D, C, B, A> reverse() {
        return new ImmutableQuintupleImpl<>(e, d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Quintuple<?, ?, ?, ?, ?>)) return false;
        Quintuple<?, ?, ?, ?, ?> thatQuintuple = (Quintuple<?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatQuintuple.getFirst()) &&
                Objects.equals(this.b, thatQuintuple.getSecond()) &&
                Objects.equals(this.c, thatQuintuple.getThird()) &&
                Objects.equals(this.d, thatQuintuple.getFourth()) &&
                Objects.equals(this.e, thatQuintuple.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ")";
    }
}
