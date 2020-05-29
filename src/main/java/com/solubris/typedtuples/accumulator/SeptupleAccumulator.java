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
package com.solubris.typedtuples.accumulator;

import com.solubris.typedtuples.Septuple;
import com.solubris.typedtuples.immutable.ImmutableSeptuple;
import com.solubris.typedtuples.mutable.MutableSeptuple;

import java.util.function.BinaryOperator;

public interface SeptupleAccumulator<A, B, C, D, E, F, G> extends Septuple<BinaryOperator<A>, BinaryOperator<B>, BinaryOperator<C>, BinaryOperator<D>, BinaryOperator<E>, BinaryOperator<F>, BinaryOperator<G>> {
    void accumulate(MutableSeptuple<A, B, C, D, E, F, G> acc, Septuple<A, B, C, D, E, F, G> t);

    MutableSeptuple<A, B, C, D, E, F, G> combine(MutableSeptuple<A, B, C, D, E, F, G> l,
                                                 MutableSeptuple<A, B, C, D, E, F, G> r);

    ImmutableSeptuple<A, B, C, D, E, F, G> combine(ImmutableSeptuple<A, B, C, D, E, F, G> l,
                                                   ImmutableSeptuple<A, B, C, D, E, F, G> r);
}
