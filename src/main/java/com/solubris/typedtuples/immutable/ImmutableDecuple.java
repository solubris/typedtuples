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

import com.solubris.typedtuples.Decuple;
import com.solubris.typedtuples.function.DecupleFunction;

import java.util.function.Function;

public interface ImmutableDecuple<A, B, C, D, E, F, G, H, I, J> extends Decuple<A, B, C, D, E, F, G, H, I, J> {
    ImmutableNonuple<B, C, D, E, F, G, H, I, J> removeFirst();

    ImmutableNonuple<A, C, D, E, F, G, H, I, J> removeSecond();

    ImmutableNonuple<A, B, D, E, F, G, H, I, J> removeThird();

    ImmutableNonuple<A, B, C, E, F, G, H, I, J> removeFourth();

    ImmutableNonuple<A, B, C, D, F, G, H, I, J> removeFifth();

    ImmutableNonuple<A, B, C, D, E, G, H, I, J> removeSixth();

    ImmutableNonuple<A, B, C, D, E, F, H, I, J> removeSeventh();

    ImmutableNonuple<A, B, C, D, E, F, G, I, J> removeEighth();

    ImmutableNonuple<A, B, C, D, E, F, G, H, J> removeNinth();

    ImmutableNonuple<A, B, C, D, E, F, G, H, I> removeTenth();

    <X> ImmutableDecuple<X, B, C, D, E, F, G, H, I, J> replaceFirst(X x);

    <X> ImmutableDecuple<A, X, C, D, E, F, G, H, I, J> replaceSecond(X x);

    <X> ImmutableDecuple<A, B, X, D, E, F, G, H, I, J> replaceThird(X x);

    <X> ImmutableDecuple<A, B, C, X, E, F, G, H, I, J> replaceFourth(X x);

    <X> ImmutableDecuple<A, B, C, D, X, F, G, H, I, J> replaceFifth(X x);

    <X> ImmutableDecuple<A, B, C, D, E, X, G, H, I, J> replaceSixth(X x);

    <X> ImmutableDecuple<A, B, C, D, E, F, X, H, I, J> replaceSeventh(X x);

    <X> ImmutableDecuple<A, B, C, D, E, F, G, X, I, J> replaceEighth(X x);

    <X> ImmutableDecuple<A, B, C, D, E, F, G, H, X, J> replaceNinth(X x);

    <X> ImmutableDecuple<A, B, C, D, E, F, G, H, I, X> replaceTenth(X x);

    <X> ImmutableDecuple<X, B, C, D, E, F, G, H, I, J> mapFirst(Function<? super A, X> mapper);

    <X> ImmutableDecuple<A, X, C, D, E, F, G, H, I, J> mapSecond(Function<? super B, X> mapper);

    <X> ImmutableDecuple<A, B, X, D, E, F, G, H, I, J> mapThird(Function<? super C, X> mapper);

    <X> ImmutableDecuple<A, B, C, X, E, F, G, H, I, J> mapFourth(Function<? super D, X> mapper);

    <X> ImmutableDecuple<A, B, C, D, X, F, G, H, I, J> mapFifth(Function<? super E, X> mapper);

    <X> ImmutableDecuple<A, B, C, D, E, X, G, H, I, J> mapSixth(Function<? super F, X> mapper);

    <X> ImmutableDecuple<A, B, C, D, E, F, X, H, I, J> mapSeventh(Function<? super G, X> mapper);

    <X> ImmutableDecuple<A, B, C, D, E, F, G, X, I, J> mapEighth(Function<? super H, X> mapper);

    <X> ImmutableDecuple<A, B, C, D, E, F, G, H, X, J> mapNinth(Function<? super I, X> mapper);

    <X> ImmutableDecuple<A, B, C, D, E, F, G, H, I, X> mapTenth(Function<? super J, X> mapper);

    <R> R transform(
            DecupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? super H, ? super I, ? super J, R> mapper);

    ImmutableDecuple<J, I, H, G, F, E, D, C, B, A> reverse();
}
