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

import com.solubris.typedtuples.Quadruple;

import java.util.function.Function;

public interface ImmutableQuadruple<A, B, C, D> extends Quadruple<A, B, C, D> {
    <X0> ImmutableQuintuple<X0, A, B, C, D> addFirst(X0 x0);

    <X0> ImmutableQuintuple<A, X0, B, C, D> addSecond(X0 x0);

    <X0> ImmutableQuintuple<A, B, X0, C, D> addThird(X0 x0);

    <X0> ImmutableQuintuple<A, B, C, X0, D> addFourth(X0 x0);

    <X0> ImmutableQuintuple<A, B, C, D, X0> add(X0 x0);

    ImmutableTriple<B, C, D> removeFirst();

    ImmutableTriple<A, C, D> removeSecond();

    ImmutableTriple<A, B, D> removeThird();

    ImmutableTriple<A, B, C> remove();

    <X> ImmutableQuadruple<X, B, C, D> replaceFirst(X x);

    <X> ImmutableQuadruple<A, X, C, D> replaceSecond(X x);

    <X> ImmutableQuadruple<A, B, X, D> replaceThird(X x);

    <X> ImmutableQuadruple<A, B, C, X> replace(X x);

    <X> ImmutableQuadruple<X, B, C, D> mapFirst(Function<A, X> mapper);

    <X> ImmutableQuadruple<A, X, C, D> mapSecond(Function<B, X> mapper);

    <X> ImmutableQuadruple<A, B, X, D> mapThird(Function<C, X> mapper);

    <X> ImmutableQuadruple<A, B, C, X> map(Function<D, X> mapper);

    ImmutableQuadruple<D, C, B, A> reverse();
}