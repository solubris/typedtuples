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

import com.solubris.typedtuples.Triple;
import com.solubris.typedtuples.immutable.ImmutableTriple;
import com.solubris.typedtuples.mutable.MutableTriple;

import java.util.function.BinaryOperator;

public interface TripleAccumulator<A, B, C> extends Triple<BinaryOperator<A>, BinaryOperator<B>, BinaryOperator<C>> {
    void accumulate(MutableTriple<A, B, C> acc, Triple<A, B, C> t);

    MutableTriple<A, B, C> combine(MutableTriple<A, B, C> l, MutableTriple<A, B, C> r);

    ImmutableTriple<A, B, C> combine(ImmutableTriple<A, B, C> l, ImmutableTriple<A, B, C> r);
}
