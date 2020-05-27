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

import com.solubris.typedtuples.Octuple;
import com.solubris.typedtuples.immutable.ImmutableOctuple;
import com.solubris.typedtuples.mutable.MutableOctuple;

import java.util.function.BinaryOperator;

public interface OctupleAccumulator<A, B, C, D, E, F, G, H> extends Octuple<BinaryOperator<A>, BinaryOperator<B>, BinaryOperator<C>, BinaryOperator<D>, BinaryOperator<E>, BinaryOperator<F>, BinaryOperator<G>, BinaryOperator<H>> {
    void accumulate(MutableOctuple<A, B, C, D, E, F, G, H> acc, Octuple<A, B, C, D, E, F, G, H> t);

    MutableOctuple<A, B, C, D, E, F, G, H> combine(MutableOctuple<A, B, C, D, E, F, G, H> l,
                                                   MutableOctuple<A, B, C, D, E, F, G, H> r);

    ImmutableOctuple<A, B, C, D, E, F, G, H> combine(ImmutableOctuple<A, B, C, D, E, F, G, H> l,
                                                     ImmutableOctuple<A, B, C, D, E, F, G, H> r);
}
