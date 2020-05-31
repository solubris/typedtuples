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

import com.solubris.typedtuples.Sextuple;
import com.solubris.typedtuples.function.SextupleFunction;

import java.util.function.Function;

public interface ImmutableSextuple<A, B, C, D, E, F> extends Sextuple<A, B, C, D, E, F> {
    <X0> ImmutableSeptuple<X0, A, B, C, D, E, F> addFirst(X0 x0);

    <X0> ImmutableSeptuple<A, X0, B, C, D, E, F> addSecond(X0 x0);

    <X0> ImmutableSeptuple<A, B, X0, C, D, E, F> addThird(X0 x0);

    <X0> ImmutableSeptuple<A, B, C, X0, D, E, F> addFourth(X0 x0);

    <X0> ImmutableSeptuple<A, B, C, D, X0, E, F> addFifth(X0 x0);

    <X0> ImmutableSeptuple<A, B, C, D, E, X0, F> addSixth(X0 x0);

    <X0> ImmutableSeptuple<A, B, C, D, E, F, X0> add(X0 x0);

    ImmutableSeptuple<A, A, B, C, D, E, F> duplicateFirst();

    ImmutableSeptuple<A, B, B, C, D, E, F> duplicateSecond();

    ImmutableSeptuple<A, B, C, C, D, E, F> duplicateThird();

    ImmutableSeptuple<A, B, C, D, D, E, F> duplicateFourth();

    ImmutableSeptuple<A, B, C, D, E, E, F> duplicateFifth();

    ImmutableSeptuple<A, B, C, D, E, F, F> duplicate();

    ImmutableQuintuple<B, C, D, E, F> removeFirst();

    ImmutableQuintuple<A, C, D, E, F> removeSecond();

    ImmutableQuintuple<A, B, D, E, F> removeThird();

    ImmutableQuintuple<A, B, C, E, F> removeFourth();

    ImmutableQuintuple<A, B, C, D, F> removeFifth();

    ImmutableQuintuple<A, B, C, D, E> remove();

    <X> ImmutableSextuple<X, B, C, D, E, F> replaceFirst(X x);

    <X> ImmutableSextuple<A, X, C, D, E, F> replaceSecond(X x);

    <X> ImmutableSextuple<A, B, X, D, E, F> replaceThird(X x);

    <X> ImmutableSextuple<A, B, C, X, E, F> replaceFourth(X x);

    <X> ImmutableSextuple<A, B, C, D, X, F> replaceFifth(X x);

    <X> ImmutableSextuple<A, B, C, D, E, X> replace(X x);

    <X> ImmutableSextuple<X, B, C, D, E, F> mapFirst(Function<A, X> mapper);

    <X> ImmutableSextuple<A, X, C, D, E, F> mapSecond(Function<B, X> mapper);

    <X> ImmutableSextuple<A, B, X, D, E, F> mapThird(Function<C, X> mapper);

    <X> ImmutableSextuple<A, B, C, X, E, F> mapFourth(Function<D, X> mapper);

    <X> ImmutableSextuple<A, B, C, D, X, F> mapFifth(Function<E, X> mapper);

    <X> ImmutableSextuple<A, B, C, D, E, X> map(Function<F, X> mapper);

    <X> ImmutableSeptuple<A, B, C, D, E, F, X> mapFirstAndAdd(Function<A, X> mapper);

    <X> ImmutableSeptuple<A, B, C, D, E, F, X> mapSecondAndAdd(Function<B, X> mapper);

    <X> ImmutableSeptuple<A, B, C, D, E, F, X> mapThirdAndAdd(Function<C, X> mapper);

    <X> ImmutableSeptuple<A, B, C, D, E, F, X> mapFourthAndAdd(Function<D, X> mapper);

    <X> ImmutableSeptuple<A, B, C, D, E, F, X> mapFifthAndAdd(Function<E, X> mapper);

    <X> ImmutableSeptuple<A, B, C, D, E, F, X> mapAndAdd(Function<F, X> mapper);

    <R> R mapAll(SextupleFunction<A, B, C, D, E, F, R> mapper);

    ImmutableSextuple<F, E, D, C, B, A> reverse();
}
