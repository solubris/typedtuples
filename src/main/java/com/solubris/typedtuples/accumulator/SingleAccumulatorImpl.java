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

import com.solubris.typedtuples.Single;
import com.solubris.typedtuples.immutable.ImmutableSingle;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import com.solubris.typedtuples.mutable.MutableSingle;
import com.solubris.typedtuples.mutable.MutableTuple;

import java.util.function.BinaryOperator;

public final class SingleAccumulatorImpl<A> implements SingleAccumulator<A> {
    private final BinaryOperator<A> a;

    SingleAccumulatorImpl(BinaryOperator<A> a) {
        this.a = a;
    }

    @Override
    public BinaryOperator<A> get() {
        return a;
    }

    @Override
    public void accumulate(MutableSingle<A> acc, Single<A> t) {
        acc.set(a.apply(acc.get(), t.get()));
    }

    @Override
    public MutableSingle<A> combine(MutableSingle<A> l, MutableSingle<A> r) {
        A fa = a.apply(l.get(), r.get());
        return MutableTuple.of(fa);
    }

    @Override
    public ImmutableSingle<A> combine(ImmutableSingle<A> l, ImmutableSingle<A> r) {
        A fa = a.apply(l.get(), r.get());
        return ImmutableTuple.of(fa);
    }
}
