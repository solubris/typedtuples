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

import com.solubris.typedtuples.Triple;
import com.solubris.typedtuples.function.TripleFunction;

import java.util.function.Function;

public interface ImmutableTriple<A, B, C> extends Triple<A, B, C> {
    <X0> ImmutableQuadruple<X0, A, B, C> addFirst(X0 x0);

    <X0> ImmutableQuadruple<A, X0, B, C> addSecond(X0 x0);

    <X0> ImmutableQuadruple<A, B, X0, C> addThird(X0 x0);

    <X0> ImmutableQuadruple<A, B, C, X0> add(X0 x0);

    ImmutableQuadruple<A, A, B, C> duplicateFirst();

    ImmutableQuadruple<A, B, B, C> duplicateSecond();

    ImmutableQuadruple<A, B, C, C> duplicate();

    ImmutableCouple<B, C> removeFirst();

    ImmutableCouple<A, C> removeSecond();

    ImmutableCouple<A, B> remove();

    <X> ImmutableTriple<X, B, C> replaceFirst(X x);

    <X> ImmutableTriple<A, X, C> replaceSecond(X x);

    <X> ImmutableTriple<A, B, X> replace(X x);

    <X> ImmutableTriple<X, B, C> mapFirst(Function<? super A, X> mapper);

    <X> ImmutableTriple<A, X, C> mapSecond(Function<? super B, X> mapper);

    <X> ImmutableTriple<A, B, X> map(Function<? super C, X> mapper);

    <X> ImmutableQuadruple<A, B, C, X> mapFirstAndAdd(Function<? super A, X> mapper);

    <X> ImmutableQuadruple<A, B, C, X> mapSecondAndAdd(Function<? super B, X> mapper);

    <X> ImmutableQuadruple<A, B, C, X> mapAndAdd(Function<? super C, X> mapper);

    <R> R mapAll(TripleFunction<A, B, C, R> mapper);

    ImmutableTriple<C, B, A> reverse();
}
