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

import com.solubris.typedtuples.Octuple;

import java.util.function.Function;

public interface ImmutableOctuple<A, B, C, D, E, F, G, H> extends Octuple<A, B, C, D, E, F, G, H> {
    <X0> ImmutableNonuple<X0, A, B, C, D, E, F, G, H> addFirst(X0 x0);

    <X0> ImmutableNonuple<A, X0, B, C, D, E, F, G, H> addSecond(X0 x0);

    <X0> ImmutableNonuple<A, B, X0, C, D, E, F, G, H> addThird(X0 x0);

    <X0> ImmutableNonuple<A, B, C, X0, D, E, F, G, H> addFourth(X0 x0);

    <X0> ImmutableNonuple<A, B, C, D, X0, E, F, G, H> addFifth(X0 x0);

    <X0> ImmutableNonuple<A, B, C, D, E, X0, F, G, H> addSixth(X0 x0);

    <X0> ImmutableNonuple<A, B, C, D, E, F, X0, G, H> addSeventh(X0 x0);

    <X0> ImmutableNonuple<A, B, C, D, E, F, G, X0, H> addEighth(X0 x0);

    <X0> ImmutableNonuple<A, B, C, D, E, F, G, H, X0> add(X0 x0);

    ImmutableNonuple<A, A, B, C, D, E, F, G, H> duplicateFirst();

    ImmutableNonuple<A, B, B, C, D, E, F, G, H> duplicateSecond();

    ImmutableNonuple<A, B, C, C, D, E, F, G, H> duplicateThird();

    ImmutableNonuple<A, B, C, D, D, E, F, G, H> duplicateFourth();

    ImmutableNonuple<A, B, C, D, E, E, F, G, H> duplicateFifth();

    ImmutableNonuple<A, B, C, D, E, F, F, G, H> duplicateSixth();

    ImmutableNonuple<A, B, C, D, E, F, G, G, H> duplicateSeventh();

    ImmutableNonuple<A, B, C, D, E, F, G, H, H> duplicate();

    ImmutableSeptuple<B, C, D, E, F, G, H> removeFirst();

    ImmutableSeptuple<A, C, D, E, F, G, H> removeSecond();

    ImmutableSeptuple<A, B, D, E, F, G, H> removeThird();

    ImmutableSeptuple<A, B, C, E, F, G, H> removeFourth();

    ImmutableSeptuple<A, B, C, D, F, G, H> removeFifth();

    ImmutableSeptuple<A, B, C, D, E, G, H> removeSixth();

    ImmutableSeptuple<A, B, C, D, E, F, H> removeSeventh();

    ImmutableSeptuple<A, B, C, D, E, F, G> remove();

    <X> ImmutableOctuple<X, B, C, D, E, F, G, H> replaceFirst(X x);

    <X> ImmutableOctuple<A, X, C, D, E, F, G, H> replaceSecond(X x);

    <X> ImmutableOctuple<A, B, X, D, E, F, G, H> replaceThird(X x);

    <X> ImmutableOctuple<A, B, C, X, E, F, G, H> replaceFourth(X x);

    <X> ImmutableOctuple<A, B, C, D, X, F, G, H> replaceFifth(X x);

    <X> ImmutableOctuple<A, B, C, D, E, X, G, H> replaceSixth(X x);

    <X> ImmutableOctuple<A, B, C, D, E, F, X, H> replaceSeventh(X x);

    <X> ImmutableOctuple<A, B, C, D, E, F, G, X> replace(X x);

    <X> ImmutableOctuple<X, B, C, D, E, F, G, H> mapFirst(Function<A, X> mapper);

    <X> ImmutableOctuple<A, X, C, D, E, F, G, H> mapSecond(Function<B, X> mapper);

    <X> ImmutableOctuple<A, B, X, D, E, F, G, H> mapThird(Function<C, X> mapper);

    <X> ImmutableOctuple<A, B, C, X, E, F, G, H> mapFourth(Function<D, X> mapper);

    <X> ImmutableOctuple<A, B, C, D, X, F, G, H> mapFifth(Function<E, X> mapper);

    <X> ImmutableOctuple<A, B, C, D, E, X, G, H> mapSixth(Function<F, X> mapper);

    <X> ImmutableOctuple<A, B, C, D, E, F, X, H> mapSeventh(Function<G, X> mapper);

    <X> ImmutableOctuple<A, B, C, D, E, F, G, X> map(Function<H, X> mapper);

    ImmutableOctuple<H, G, F, E, D, C, B, A> reverse();
}
