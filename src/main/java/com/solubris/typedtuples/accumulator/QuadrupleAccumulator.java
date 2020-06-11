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

import com.solubris.typedtuples.Quadruple;
import com.solubris.typedtuples.immutable.ImmutableQuadruple;
import com.solubris.typedtuples.mutable.MutableQuadruple;

import java.util.function.BinaryOperator;

public interface QuadrupleAccumulator<A, B, C, D> extends Quadruple<BinaryOperator<A>, BinaryOperator<B>, BinaryOperator<C>, BinaryOperator<D>> {
    void accumulate(MutableQuadruple<A, B, C, D> acc, Quadruple<A, B, C, D> t);

    MutableQuadruple<A, B, C, D> combine(MutableQuadruple<A, B, C, D> l,
            MutableQuadruple<A, B, C, D> r);

    ImmutableQuadruple<A, B, C, D> combine(ImmutableQuadruple<A, B, C, D> l,
            ImmutableQuadruple<A, B, C, D> r);
}
