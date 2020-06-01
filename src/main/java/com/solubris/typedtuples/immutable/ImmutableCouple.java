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

import com.solubris.typedtuples.Couple;
import com.solubris.typedtuples.function.CoupleFunction;

import java.util.function.Function;

public interface ImmutableCouple<A, B> extends Couple<A, B> {
    <X0> ImmutableTriple<X0, A, B> addFirst(X0 x0);

    <X0> ImmutableTriple<A, X0, B> addSecond(X0 x0);

    <X0> ImmutableTriple<A, B, X0> add(X0 x0);

    ImmutableTriple<A, A, B> duplicateFirst();

    ImmutableTriple<A, B, B> duplicate();

    ImmutableSingle<B> removeFirst();

    ImmutableSingle<A> remove();

    <X> ImmutableCouple<X, B> replaceFirst(X x);

    <X> ImmutableCouple<A, X> replace(X x);

    <X> ImmutableCouple<X, B> mapFirst(Function<A, X> mapper);

    <X> ImmutableCouple<A, X> map(Function<B, X> mapper);

    <X> ImmutableTriple<A, B, X> mapFirstAndAdd(Function<A, X> mapper);

    <X> ImmutableTriple<A, B, X> mapAndAdd(Function<B, X> mapper);

    <R> R mapAll(CoupleFunction<A, B, R> mapper);

    ImmutableCouple<B, A> reverse();
}
