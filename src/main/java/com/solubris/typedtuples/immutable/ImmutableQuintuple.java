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

import java.util.function.Function;

public interface ImmutableQuintuple<A, B, C, D, E> extends Quintuple<A, B, C, D, E> {
    <X0> ImmutableSextuple<X0, A, B, C, D, E> addFirst(X0 x0);

    <X0> ImmutableSextuple<A, X0, B, C, D, E> addSecond(X0 x0);

    <X0> ImmutableSextuple<A, B, X0, C, D, E> addThird(X0 x0);

    <X0> ImmutableSextuple<A, B, C, X0, D, E> addFourth(X0 x0);

    <X0> ImmutableSextuple<A, B, C, D, X0, E> addFifth(X0 x0);

    <X0> ImmutableSextuple<A, B, C, D, E, X0> add(X0 x0);

    ImmutableSextuple<A, A, B, C, D, E> duplicateFirst();

    ImmutableSextuple<A, B, B, C, D, E> duplicateSecond();

    ImmutableSextuple<A, B, C, C, D, E> duplicateThird();

    ImmutableSextuple<A, B, C, D, D, E> duplicateFourth();

    ImmutableSextuple<A, B, C, D, E, E> duplicate();

    ImmutableQuadruple<B, C, D, E> removeFirst();

    ImmutableQuadruple<A, C, D, E> removeSecond();

    ImmutableQuadruple<A, B, D, E> removeThird();

    ImmutableQuadruple<A, B, C, E> removeFourth();

    ImmutableQuadruple<A, B, C, D> remove();

    <X> ImmutableQuintuple<X, B, C, D, E> replaceFirst(X x);

    <X> ImmutableQuintuple<A, X, C, D, E> replaceSecond(X x);

    <X> ImmutableQuintuple<A, B, X, D, E> replaceThird(X x);

    <X> ImmutableQuintuple<A, B, C, X, E> replaceFourth(X x);

    <X> ImmutableQuintuple<A, B, C, D, X> replace(X x);

    <X> ImmutableQuintuple<X, B, C, D, E> mapFirst(Function<? super A, X> mapper);

    <X> ImmutableQuintuple<A, X, C, D, E> mapSecond(Function<? super B, X> mapper);

    <X> ImmutableQuintuple<A, B, X, D, E> mapThird(Function<? super C, X> mapper);

    <X> ImmutableQuintuple<A, B, C, X, E> mapFourth(Function<? super D, X> mapper);

    <X> ImmutableQuintuple<A, B, C, D, X> map(Function<? super E, X> mapper);

    <X> ImmutableSextuple<A, B, C, D, E, X> mapFirstAndAdd(Function<? super A, X> mapper);

    <X> ImmutableSextuple<A, B, C, D, E, X> mapSecondAndAdd(Function<? super B, X> mapper);

    <X> ImmutableSextuple<A, B, C, D, E, X> mapThirdAndAdd(Function<? super C, X> mapper);

    <X> ImmutableSextuple<A, B, C, D, E, X> mapFourthAndAdd(Function<? super D, X> mapper);

    <X> ImmutableSextuple<A, B, C, D, E, X> mapAndAdd(Function<? super E, X> mapper);

    <R> R mapAll(
            QuintupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, R> mapper);

    ImmutableQuintuple<E, D, C, B, A> reverse();
}
