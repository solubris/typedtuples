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

import com.solubris.typedtuples.Quadruple;
import com.solubris.typedtuples.function.QuadrupleFunction;

import java.util.Objects;
import java.util.function.Function;

final class ImmutableQuadrupleImpl<A, B, C, D> implements ImmutableQuadruple<A, B, C, D> {
    private final A a;

    private final B b;

    private final C c;

    private final D d;

    ImmutableQuadrupleImpl(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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
    public <X0> ImmutableQuintuple<X0, A, B, C, D> addFirst(X0 x0) {
        return ImmutableTuple.of(x0, a, b, c, d);
    }

    @Override
    public <X0> ImmutableQuintuple<A, X0, B, C, D> addSecond(X0 x0) {
        return ImmutableTuple.of(a, x0, b, c, d);
    }

    @Override
    public <X0> ImmutableQuintuple<A, B, X0, C, D> addThird(X0 x0) {
        return ImmutableTuple.of(a, b, x0, c, d);
    }

    @Override
    public <X0> ImmutableQuintuple<A, B, C, X0, D> addFourth(X0 x0) {
        return ImmutableTuple.of(a, b, c, x0, d);
    }

    @Override
    public <X0> ImmutableQuintuple<A, B, C, D, X0> add(X0 x0) {
        return ImmutableTuple.of(a, b, c, d, x0);
    }

    @Override
    public ImmutableQuintuple<A, A, B, C, D> duplicateFirst() {
        return ImmutableTuple.of(a, a, b, c, d);
    }

    @Override
    public ImmutableQuintuple<A, B, B, C, D> duplicateSecond() {
        return ImmutableTuple.of(a, b, b, c, d);
    }

    @Override
    public ImmutableQuintuple<A, B, C, C, D> duplicateThird() {
        return ImmutableTuple.of(a, b, c, c, d);
    }

    @Override
    public ImmutableQuintuple<A, B, C, D, D> duplicateFourth() {
        return ImmutableTuple.of(a, b, c, d, d);
    }

    @Override
    public ImmutableTriple<B, C, D> removeFirst() {
        return ImmutableTuple.of(b, c, d);
    }

    @Override
    public ImmutableTriple<A, C, D> removeSecond() {
        return ImmutableTuple.of(a, c, d);
    }

    @Override
    public ImmutableTriple<A, B, D> removeThird() {
        return ImmutableTuple.of(a, b, d);
    }

    @Override
    public ImmutableTriple<A, B, C> removeFourth() {
        return ImmutableTuple.of(a, b, c);
    }

    @Override
    public <X> ImmutableQuadruple<X, B, C, D> replaceFirst(X x) {
        return ImmutableTuple.of(x, b, c, d);
    }

    @Override
    public <X> ImmutableQuadruple<A, X, C, D> replaceSecond(X x) {
        return ImmutableTuple.of(a, x, c, d);
    }

    @Override
    public <X> ImmutableQuadruple<A, B, X, D> replaceThird(X x) {
        return ImmutableTuple.of(a, b, x, d);
    }

    @Override
    public <X> ImmutableQuadruple<A, B, C, X> replaceFourth(X x) {
        return ImmutableTuple.of(a, b, c, x);
    }

    @Override
    public <X> ImmutableQuadruple<X, B, C, D> mapFirst(Function<? super A, X> mapper) {
        return ImmutableTuple.of(mapper.apply(a), b, c, d);
    }

    @Override
    public <X> ImmutableQuadruple<A, X, C, D> mapSecond(Function<? super B, X> mapper) {
        return ImmutableTuple.of(a, mapper.apply(b), c, d);
    }

    @Override
    public <X> ImmutableQuadruple<A, B, X, D> mapThird(Function<? super C, X> mapper) {
        return ImmutableTuple.of(a, b, mapper.apply(c), d);
    }

    @Override
    public <X> ImmutableQuadruple<A, B, C, X> mapFourth(Function<? super D, X> mapper) {
        return ImmutableTuple.of(a, b, c, mapper.apply(d));
    }

    @Override
    public <X> ImmutableQuintuple<A, B, C, D, X> mapFirstAndAdd(Function<? super A, X> mapper) {
        return ImmutableTuple.of(a, b, c, d, mapper.apply(a));
    }

    @Override
    public <X> ImmutableQuintuple<A, B, C, D, X> mapSecondAndAdd(Function<? super B, X> mapper) {
        return ImmutableTuple.of(a, b, c, d, mapper.apply(b));
    }

    @Override
    public <X> ImmutableQuintuple<A, B, C, D, X> mapThirdAndAdd(Function<? super C, X> mapper) {
        return ImmutableTuple.of(a, b, c, d, mapper.apply(c));
    }

    @Override
    public <X> ImmutableQuintuple<A, B, C, D, X> mapFourthAndAdd(Function<? super D, X> mapper) {
        return ImmutableTuple.of(a, b, c, d, mapper.apply(d));
    }

    @Override
    public <R> R transform(
            QuadrupleFunction<? super A, ? super B, ? super C, ? super D, R> mapper) {
        return mapper.apply(a, b, c, d);
    }

    @Override
    public ImmutableQuadruple<D, C, B, A> reverse() {
        return ImmutableTuple.of(d, c, b, a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Quadruple<?, ?, ?, ?>)) return false;
        Quadruple<?, ?, ?, ?> thatQuadruple = (Quadruple<?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatQuadruple.getFirst()) && 
                Objects.equals(this.b, thatQuadruple.getSecond()) && 
                Objects.equals(this.c, thatQuadruple.getThird()) && 
                Objects.equals(this.d, thatQuadruple.getFourth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ", " + d + ")";
    }
}
