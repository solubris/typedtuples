// Copyright 2020 Solubris Ltd.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.solubris.typedtuples.immutable;

import com.solubris.typedtuples.Nonuple;

import java.util.function.Function;

public interface ImmutableNonuple<A, B, C, D, E, F, G, H, I> extends Nonuple<A, B, C, D, E, F, G, H, I> {
    <X0> ImmutableDecuple<X0, A, B, C, D, E, F, G, H, I> addFirst(X0 x0);

    <X0> ImmutableDecuple<A, X0, B, C, D, E, F, G, H, I> addSecond(X0 x0);

    <X0> ImmutableDecuple<A, B, X0, C, D, E, F, G, H, I> addThird(X0 x0);

    <X0> ImmutableDecuple<A, B, C, X0, D, E, F, G, H, I> addFourth(X0 x0);

    <X0> ImmutableDecuple<A, B, C, D, X0, E, F, G, H, I> addFifth(X0 x0);

    <X0> ImmutableDecuple<A, B, C, D, E, X0, F, G, H, I> addSixth(X0 x0);

    <X0> ImmutableDecuple<A, B, C, D, E, F, X0, G, H, I> addSeventh(X0 x0);

    <X0> ImmutableDecuple<A, B, C, D, E, F, G, X0, H, I> addEighth(X0 x0);

    <X0> ImmutableDecuple<A, B, C, D, E, F, G, H, X0, I> addNinth(X0 x0);

    <X0> ImmutableDecuple<A, B, C, D, E, F, G, H, I, X0> add(X0 x0);

    ImmutableOctuple<B, C, D, E, F, G, H, I> removeFirst();

    ImmutableOctuple<A, C, D, E, F, G, H, I> removeSecond();

    ImmutableOctuple<A, B, D, E, F, G, H, I> removeThird();

    ImmutableOctuple<A, B, C, E, F, G, H, I> removeFourth();

    ImmutableOctuple<A, B, C, D, F, G, H, I> removeFifth();

    ImmutableOctuple<A, B, C, D, E, G, H, I> removeSixth();

    ImmutableOctuple<A, B, C, D, E, F, H, I> removeSeventh();

    ImmutableOctuple<A, B, C, D, E, F, G, I> removeEighth();

    ImmutableOctuple<A, B, C, D, E, F, G, H> remove();

    <X> ImmutableNonuple<X, B, C, D, E, F, G, H, I> replaceFirst(X x);

    <X> ImmutableNonuple<A, X, C, D, E, F, G, H, I> replaceSecond(X x);

    <X> ImmutableNonuple<A, B, X, D, E, F, G, H, I> replaceThird(X x);

    <X> ImmutableNonuple<A, B, C, X, E, F, G, H, I> replaceFourth(X x);

    <X> ImmutableNonuple<A, B, C, D, X, F, G, H, I> replaceFifth(X x);

    <X> ImmutableNonuple<A, B, C, D, E, X, G, H, I> replaceSixth(X x);

    <X> ImmutableNonuple<A, B, C, D, E, F, X, H, I> replaceSeventh(X x);

    <X> ImmutableNonuple<A, B, C, D, E, F, G, X, I> replaceEighth(X x);

    <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> replace(X x);

    <X> ImmutableNonuple<X, B, C, D, E, F, G, H, I> mapFirst(Function<A, X> mapper);

    <X> ImmutableNonuple<A, X, C, D, E, F, G, H, I> mapSecond(Function<B, X> mapper);

    <X> ImmutableNonuple<A, B, X, D, E, F, G, H, I> mapThird(Function<C, X> mapper);

    <X> ImmutableNonuple<A, B, C, X, E, F, G, H, I> mapFourth(Function<D, X> mapper);

    <X> ImmutableNonuple<A, B, C, D, X, F, G, H, I> mapFifth(Function<E, X> mapper);

    <X> ImmutableNonuple<A, B, C, D, E, X, G, H, I> mapSixth(Function<F, X> mapper);

    <X> ImmutableNonuple<A, B, C, D, E, F, X, H, I> mapSeventh(Function<G, X> mapper);

    <X> ImmutableNonuple<A, B, C, D, E, F, G, X, I> mapEighth(Function<H, X> mapper);

    <X> ImmutableNonuple<A, B, C, D, E, F, G, H, X> map(Function<I, X> mapper);

    ImmutableNonuple<I, H, G, F, E, D, C, B, A> reverse();
}
