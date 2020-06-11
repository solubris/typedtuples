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

import com.solubris.typedtuples.Decuple;
import com.solubris.typedtuples.immutable.ImmutableDecuple;
import com.solubris.typedtuples.mutable.MutableDecuple;

import java.util.function.BinaryOperator;

public interface DecupleAccumulator<A, B, C, D, E, F, G, H, I, J> extends Decuple<BinaryOperator<A>, BinaryOperator<B>, BinaryOperator<C>, BinaryOperator<D>, BinaryOperator<E>, BinaryOperator<F>, BinaryOperator<G>, BinaryOperator<H>, BinaryOperator<I>, BinaryOperator<J>> {
    void accumulate(MutableDecuple<A, B, C, D, E, F, G, H, I, J> acc,
            Decuple<A, B, C, D, E, F, G, H, I, J> t);

    MutableDecuple<A, B, C, D, E, F, G, H, I, J> combine(
            MutableDecuple<A, B, C, D, E, F, G, H, I, J> l,
            MutableDecuple<A, B, C, D, E, F, G, H, I, J> r);

    ImmutableDecuple<A, B, C, D, E, F, G, H, I, J> combine(
            ImmutableDecuple<A, B, C, D, E, F, G, H, I, J> l,
            ImmutableDecuple<A, B, C, D, E, F, G, H, I, J> r);
}
