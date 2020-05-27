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

import com.solubris.typedtuples.Sextuple;
import com.solubris.typedtuples.immutable.ImmutableSextuple;
import com.solubris.typedtuples.mutable.MutableSextuple;

import java.util.function.BinaryOperator;

public interface SextupleAccumulator<A, B, C, D, E, F> extends Sextuple<BinaryOperator<A>, BinaryOperator<B>, BinaryOperator<C>, BinaryOperator<D>, BinaryOperator<E>, BinaryOperator<F>> {
    void accumulate(MutableSextuple<A, B, C, D, E, F> acc, Sextuple<A, B, C, D, E, F> t);

    MutableSextuple<A, B, C, D, E, F> combine(MutableSextuple<A, B, C, D, E, F> l,
                                              MutableSextuple<A, B, C, D, E, F> r);

    ImmutableSextuple<A, B, C, D, E, F> combine(ImmutableSextuple<A, B, C, D, E, F> l,
                                                ImmutableSextuple<A, B, C, D, E, F> r);
}
