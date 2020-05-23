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
package com.solubris.typedtuples.immutable;

import java.util.Objects;
import java.util.function.Function;

public final class Unit<A> implements Tuple {
    private final A a;

    Unit(A a) {
        this.a = a;
    }

    public A get() {
        return a;
    }

    public <X0> Pair<X0, A> addFirst(X0 x0) {
        return new Pair<>(x0, a);
    }

    public <X0> Pair<A, X0> add(X0 x0) {
        return new Pair<>(a, x0);
    }

    public Identity remove() {
        return Identity.INSTANCE;
    }

    public <X> Unit<X> replace(X x) {
        return new Unit<>(x);
    }

    public <X> Unit<X> map(Function<A, X> mapper) {
        return new Unit<>(mapper.apply(a));
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || this.getClass() != that.getClass()) return false;
        Unit<?> thatUnit = (Unit<?>) that;
        return Objects.equals(this.a, thatUnit.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        return "Unit{" +
                "a=" + a +
                "}";
    }
}
