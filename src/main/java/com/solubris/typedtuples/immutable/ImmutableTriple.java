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

import com.solubris.typedtuples.Triple;

import java.util.function.Function;

public interface ImmutableTriple<A, B, C> extends Triple<A, B, C> {
    <X0> ImmutableQuadruple<X0, A, B, C> addFirst(X0 x0);

    <X0> ImmutableQuadruple<A, X0, B, C> addSecond(X0 x0);

    <X0> ImmutableQuadruple<A, B, X0, C> addThird(X0 x0);

    <X0> ImmutableQuadruple<A, B, C, X0> add(X0 x0);

    ImmutableCouple<B, C> removeFirst();

    ImmutableCouple<A, C> removeSecond();

    ImmutableCouple<A, B> remove();

    <X> ImmutableTriple<X, B, C> replaceFirst(X x);

    <X> ImmutableTriple<A, X, C> replaceSecond(X x);

    <X> ImmutableTriple<A, B, X> replace(X x);

    <X> ImmutableTriple<X, B, C> mapFirst(Function<A, X> mapper);

    <X> ImmutableTriple<A, X, C> mapSecond(Function<B, X> mapper);

    <X> ImmutableTriple<A, B, X> map(Function<C, X> mapper);

    ImmutableTriple<C, B, A> reverse();
}