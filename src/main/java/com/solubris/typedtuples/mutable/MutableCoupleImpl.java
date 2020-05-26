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
package com.solubris.typedtuples.mutable;

import com.solubris.typedtuples.Couple;

import java.util.Objects;
import java.util.function.UnaryOperator;

public final class MutableCoupleImpl<A, B> implements MutableCouple<A, B> {
    private A a;

    private B b;

    MutableCoupleImpl(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public A getFirst() {
        return a;
    }

    @Override
    public B get() {
        return b;
    }

    @Override
    public void setFirst(A a) {
        this.a = a;
    }

    @Override
    public void set(B b) {
        this.b = b;
    }

    @Override
    public void computeFirst(UnaryOperator<A> mapper) {
        this.a = mapper.apply(a);
    }

    @Override
    public void compute(UnaryOperator<B> mapper) {
        this.b = mapper.apply(b);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Couple<?, ?>)) return false;
        Couple<?, ?> thatCouple = (Couple<?, ?>) that;
        return Objects.equals(this.a, thatCouple.getFirst()) && 
                Objects.equals(this.b, thatCouple.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }
}
