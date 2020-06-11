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

import com.solubris.typedtuples.Single;
import com.solubris.typedtuples.function.SingleFunction;

import java.util.Objects;
import java.util.function.Function;

final class ImmutableSingleImpl<A> implements ImmutableSingle<A> {
    private final A a;

    ImmutableSingleImpl(A a) {
        this.a = a;
    }

    @Override
    public A get() {
        return a;
    }

    @Override
    public <X0> ImmutableCouple<X0, A> addFirst(X0 x0) {
        return new ImmutableCoupleImpl<>(x0, a);
    }

    @Override
    public <X0> ImmutableCouple<A, X0> add(X0 x0) {
        return new ImmutableCoupleImpl<>(a, x0);
    }

    @Override
    public ImmutableCouple<A, A> duplicate() {
        return new ImmutableCoupleImpl<>(a, a);
    }

    @Override
    public ImmutableUnitImpl remove() {
        return ImmutableUnitImpl.INSTANCE;
    }

    @Override
    public <X> ImmutableSingle<X> replace(X x) {
        return new ImmutableSingleImpl<>(x);
    }

    @Override
    public <X> ImmutableSingle<X> map(Function<? super A, X> mapper) {
        return new ImmutableSingleImpl<>(mapper.apply(a));
    }

    @Override
    public <X> ImmutableCouple<A, X> mapAndAdd(Function<? super A, X> mapper) {
        return new ImmutableCoupleImpl<>(a, mapper.apply(a));
    }

    @Override
    public <R> R mapAll(SingleFunction<A, R> mapper) {
        return mapper.apply(a);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Single<?>)) return false;
        Single<?> thatSingle = (Single<?>) that;
        return Objects.equals(this.a, thatSingle.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        return "(" + a + ")";
    }
}
