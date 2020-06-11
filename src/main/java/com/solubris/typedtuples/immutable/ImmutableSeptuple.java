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

import java.util.function.Function;

public interface ImmutableSeptuple<A, B, C, D, E, F, G> extends Septuple<A, B, C, D, E, F, G> {
    <X0> ImmutableOctuple<X0, A, B, C, D, E, F, G> addFirst(X0 x0);

    <X0> ImmutableOctuple<A, X0, B, C, D, E, F, G> addSecond(X0 x0);

    <X0> ImmutableOctuple<A, B, X0, C, D, E, F, G> addThird(X0 x0);

    <X0> ImmutableOctuple<A, B, C, X0, D, E, F, G> addFourth(X0 x0);

    <X0> ImmutableOctuple<A, B, C, D, X0, E, F, G> addFifth(X0 x0);

    <X0> ImmutableOctuple<A, B, C, D, E, X0, F, G> addSixth(X0 x0);

    <X0> ImmutableOctuple<A, B, C, D, E, F, X0, G> addSeventh(X0 x0);

    <X0> ImmutableOctuple<A, B, C, D, E, F, G, X0> add(X0 x0);

    ImmutableOctuple<A, A, B, C, D, E, F, G> duplicateFirst();

    ImmutableOctuple<A, B, B, C, D, E, F, G> duplicateSecond();

    ImmutableOctuple<A, B, C, C, D, E, F, G> duplicateThird();

    ImmutableOctuple<A, B, C, D, D, E, F, G> duplicateFourth();

    ImmutableOctuple<A, B, C, D, E, E, F, G> duplicateFifth();

    ImmutableOctuple<A, B, C, D, E, F, F, G> duplicateSixth();

    ImmutableOctuple<A, B, C, D, E, F, G, G> duplicate();

    ImmutableSextuple<B, C, D, E, F, G> removeFirst();

    ImmutableSextuple<A, C, D, E, F, G> removeSecond();

    ImmutableSextuple<A, B, D, E, F, G> removeThird();

    ImmutableSextuple<A, B, C, E, F, G> removeFourth();

    ImmutableSextuple<A, B, C, D, F, G> removeFifth();

    ImmutableSextuple<A, B, C, D, E, G> removeSixth();

    ImmutableSextuple<A, B, C, D, E, F> remove();

    <X> ImmutableSeptuple<X, B, C, D, E, F, G> replaceFirst(X x);

    <X> ImmutableSeptuple<A, X, C, D, E, F, G> replaceSecond(X x);

    <X> ImmutableSeptuple<A, B, X, D, E, F, G> replaceThird(X x);

    <X> ImmutableSeptuple<A, B, C, X, E, F, G> replaceFourth(X x);

    <X> ImmutableSeptuple<A, B, C, D, X, F, G> replaceFifth(X x);

    <X> ImmutableSeptuple<A, B, C, D, E, X, G> replaceSixth(X x);

    <X> ImmutableSeptuple<A, B, C, D, E, F, X> replace(X x);

    <X> ImmutableSeptuple<X, B, C, D, E, F, G> mapFirst(Function<? super A, X> mapper);

    <X> ImmutableSeptuple<A, X, C, D, E, F, G> mapSecond(Function<? super B, X> mapper);

    <X> ImmutableSeptuple<A, B, X, D, E, F, G> mapThird(Function<? super C, X> mapper);

    <X> ImmutableSeptuple<A, B, C, X, E, F, G> mapFourth(Function<? super D, X> mapper);

    <X> ImmutableSeptuple<A, B, C, D, X, F, G> mapFifth(Function<? super E, X> mapper);

    <X> ImmutableSeptuple<A, B, C, D, E, X, G> mapSixth(Function<? super F, X> mapper);

    <X> ImmutableSeptuple<A, B, C, D, E, F, X> map(Function<? super G, X> mapper);

    <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapFirstAndAdd(Function<? super A, X> mapper);

    <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapSecondAndAdd(Function<? super B, X> mapper);

    <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapThirdAndAdd(Function<? super C, X> mapper);

    <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapFourthAndAdd(Function<? super D, X> mapper);

    <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapFifthAndAdd(Function<? super E, X> mapper);

    <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapSixthAndAdd(Function<? super F, X> mapper);

    <X> ImmutableOctuple<A, B, C, D, E, F, G, X> mapAndAdd(Function<? super G, X> mapper);

    <R> R mapAll(
            SeptupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, R> mapper);

    ImmutableSeptuple<G, F, E, D, C, B, A> reverse();
}
