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

import com.solubris.typedtuples.Couple;
import com.solubris.typedtuples.immutable.ImmutableCouple;
import com.solubris.typedtuples.mutable.MutableCouple;

import java.util.function.BinaryOperator;

public interface CoupleAccumulator<A, B> extends Couple<BinaryOperator<A>, BinaryOperator<B>> {
    void accumulate(MutableCouple<A, B> acc, Couple<A, B> t);

    MutableCouple<A, B> combine(MutableCouple<A, B> l, MutableCouple<A, B> r);

    ImmutableCouple<A, B> combine(ImmutableCouple<A, B> l, ImmutableCouple<A, B> r);
}
