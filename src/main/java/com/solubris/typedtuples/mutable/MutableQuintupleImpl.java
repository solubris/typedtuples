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

import com.solubris.typedtuples.Quintuple;

import java.util.Objects;
import java.util.function.UnaryOperator;

final class MutableQuintupleImpl<A, B, C, D, E> implements MutableQuintuple<A, B, C, D, E> {
    private A a;

    private B b;

    private C c;

    private D d;

    private E e;

    MutableQuintupleImpl(A a, B b, C c, D d, E e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
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
    public C getThird() {
        return c;
    }

    @Override
    public D getFourth() {
        return d;
    }

    @Override
    public E get() {
        return e;
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
    public void setThird(C c) {
        this.c = c;
    }

    @Override
    public void setFourth(D d) {
        this.d = d;
    }

    @Override
    public void set(E e) {
        this.e = e;
    }

    @Override
    public void setAll(A a, B b, C c, D d, E e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
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
    public void computeThird(UnaryOperator<C> mapper) {
        this.c = mapper.apply(c);
    }

    @Override
    public void computeFourth(UnaryOperator<D> mapper) {
        this.d = mapper.apply(d);
    }

    @Override
    public void compute(UnaryOperator<E> mapper) {
        this.e = mapper.apply(e);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Quintuple<?, ?, ?, ?, ?>)) return false;
        Quintuple<?, ?, ?, ?, ?> thatQuintuple = (Quintuple<?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatQuintuple.getFirst()) &&
                Objects.equals(this.b, thatQuintuple.getSecond()) &&
                Objects.equals(this.c, thatQuintuple.getThird()) &&
                Objects.equals(this.d, thatQuintuple.getFourth()) &&
                Objects.equals(this.e, thatQuintuple.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ")";
    }
}
