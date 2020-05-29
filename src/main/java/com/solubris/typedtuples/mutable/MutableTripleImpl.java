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
package com.solubris.typedtuples.mutable;

import com.solubris.typedtuples.Triple;

import java.util.Objects;
import java.util.function.UnaryOperator;

final class MutableTripleImpl<A, B, C> implements MutableTriple<A, B, C> {
    private A a;

    private B b;

    private C c;

    MutableTripleImpl(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public A getFirst() {
        return a;
    }

    @Override
    public B getSecond() {
        return b;
    }

    @Override
    public C get() {
        return c;
    }

    @Override
    public void setFirst(A a) {
        this.a = a;
    }

    @Override
    public void setSecond(B b) {
        this.b = b;
    }

    @Override
    public void set(C c) {
        this.c = c;
    }

    @Override
    public void setAll(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void computeFirst(UnaryOperator<A> mapper) {
        this.a = mapper.apply(a);
    }

    @Override
    public void computeSecond(UnaryOperator<B> mapper) {
        this.b = mapper.apply(b);
    }

    @Override
    public void compute(UnaryOperator<C> mapper) {
        this.c = mapper.apply(c);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Triple<?, ?, ?>)) return false;
        Triple<?, ?, ?> thatTriple = (Triple<?, ?, ?>) that;
        return Objects.equals(this.a, thatTriple.getFirst()) &&
                Objects.equals(this.b, thatTriple.getSecond()) &&
                Objects.equals(this.c, thatTriple.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ")";
    }
}
