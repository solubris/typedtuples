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
package com.solubris.typedtuples.accumulator;

import com.solubris.typedtuples.Nonuple;
import com.solubris.typedtuples.immutable.ImmutableNonuple;
import com.solubris.typedtuples.mutable.MutableNonuple;

import java.util.function.BinaryOperator;

public interface NonupleAccumulator<A, B, C, D, E, F, G, H, I> extends Nonuple<BinaryOperator<A>, BinaryOperator<B>, BinaryOperator<C>, BinaryOperator<D>, BinaryOperator<E>, BinaryOperator<F>, BinaryOperator<G>, BinaryOperator<H>, BinaryOperator<I>> {
    void accumulate(MutableNonuple<A, B, C, D, E, F, G, H, I> acc,
            Nonuple<A, B, C, D, E, F, G, H, I> t);

    MutableNonuple<A, B, C, D, E, F, G, H, I> combine(MutableNonuple<A, B, C, D, E, F, G, H, I> l,
            MutableNonuple<A, B, C, D, E, F, G, H, I> r);

    ImmutableNonuple<A, B, C, D, E, F, G, H, I> combine(
            ImmutableNonuple<A, B, C, D, E, F, G, H, I> l,
            ImmutableNonuple<A, B, C, D, E, F, G, H, I> r);
}
