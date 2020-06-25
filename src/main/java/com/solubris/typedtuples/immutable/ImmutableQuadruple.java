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

import java.util.function.Function;

public interface ImmutableQuadruple<A, B, C, D> extends Quadruple<A, B, C, D> {
    <X0> ImmutableQuintuple<X0, A, B, C, D> addFirst(X0 x0);

    <X0> ImmutableQuintuple<A, X0, B, C, D> addSecond(X0 x0);

    <X0> ImmutableQuintuple<A, B, X0, C, D> addThird(X0 x0);

    <X0> ImmutableQuintuple<A, B, C, X0, D> addFourth(X0 x0);

    <X0> ImmutableQuintuple<A, B, C, D, X0> add(X0 x0);

    ImmutableQuintuple<A, A, B, C, D> duplicateFirst();

    ImmutableQuintuple<A, B, B, C, D> duplicateSecond();

    ImmutableQuintuple<A, B, C, C, D> duplicateThird();

    ImmutableQuintuple<A, B, C, D, D> duplicateFourth();

    ImmutableTriple<B, C, D> removeFirst();

    ImmutableTriple<A, C, D> removeSecond();

    ImmutableTriple<A, B, D> removeThird();

    ImmutableTriple<A, B, C> removeFourth();

    <X> ImmutableQuadruple<X, B, C, D> replaceFirst(X x);

    <X> ImmutableQuadruple<A, X, C, D> replaceSecond(X x);

    <X> ImmutableQuadruple<A, B, X, D> replaceThird(X x);

    <X> ImmutableQuadruple<A, B, C, X> replaceFourth(X x);

    <X> ImmutableQuadruple<X, B, C, D> mapFirst(Function<? super A, X> mapper);

    <X> ImmutableQuadruple<A, X, C, D> mapSecond(Function<? super B, X> mapper);

    <X> ImmutableQuadruple<A, B, X, D> mapThird(Function<? super C, X> mapper);

    <X> ImmutableQuadruple<A, B, C, X> mapFourth(Function<? super D, X> mapper);

    <X> ImmutableQuintuple<A, B, C, D, X> mapFirstAndAdd(Function<? super A, X> mapper);

    <X> ImmutableQuintuple<A, B, C, D, X> mapSecondAndAdd(Function<? super B, X> mapper);

    <X> ImmutableQuintuple<A, B, C, D, X> mapThirdAndAdd(Function<? super C, X> mapper);

    <X> ImmutableQuintuple<A, B, C, D, X> mapFourthAndAdd(Function<? super D, X> mapper);

    <R> R mapAll(QuadrupleFunction<? super A, ? super B, ? super C, ? super D, R> mapper);

    ImmutableQuadruple<D, C, B, A> reverse();
}
