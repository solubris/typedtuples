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

import com.solubris.typedtuples.Nonuple;
import com.solubris.typedtuples.function.NonupleFunction;

import java.util.Objects;
import java.util.function.UnaryOperator;

final class MutableNonupleImpl<A, B, C, D, E, F, G, H, I> implements MutableNonuple<A, B, C, D, E, F, G, H, I> {
    private A a;

    private B b;

    private C c;

    private D d;

    private E e;

    private F f;

    private G g;

    private H h;

    private I i;

    MutableNonupleImpl(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
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
    public E getFifth() {
        return e;
    }

    @Override
    public F getSixth() {
        return f;
    }

    @Override
    public G getSeventh() {
        return g;
    }

    @Override
    public H getEighth() {
        return h;
    }

    @Override
    public I getNinth() {
        return i;
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
    public void setFifth(E e) {
        this.e = e;
    }

    @Override
    public void setSixth(F f) {
        this.f = f;
    }

    @Override
    public void setSeventh(G g) {
        this.g = g;
    }

    @Override
    public void setEighth(H h) {
        this.h = h;
    }

    @Override
    public void setNinth(I i) {
        this.i = i;
    }

    @Override
    public void setAll(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }

    @Override
    public <R> R transform(
            NonupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? super H, ? super I, R> mapper) {
        return mapper.apply(a, b, c, d, e, f, g, h, i);
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
    public void computeFifth(UnaryOperator<E> mapper) {
        this.e = mapper.apply(e);
    }

    @Override
    public void computeSixth(UnaryOperator<F> mapper) {
        this.f = mapper.apply(f);
    }

    @Override
    public void computeSeventh(UnaryOperator<G> mapper) {
        this.g = mapper.apply(g);
    }

    @Override
    public void computeEighth(UnaryOperator<H> mapper) {
        this.h = mapper.apply(h);
    }

    @Override
    public void computeNinth(UnaryOperator<I> mapper) {
        this.i = mapper.apply(i);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Nonuple<?, ?, ?, ?, ?, ?, ?, ?, ?>)) return false;
        Nonuple<?, ?, ?, ?, ?, ?, ?, ?, ?> thatNonuple = (Nonuple<?, ?, ?, ?, ?, ?, ?, ?, ?>) that;
        return Objects.equals(this.a, thatNonuple.getFirst()) && 
                Objects.equals(this.b, thatNonuple.getSecond()) && 
                Objects.equals(this.c, thatNonuple.getThird()) && 
                Objects.equals(this.d, thatNonuple.getFourth()) && 
                Objects.equals(this.e, thatNonuple.getFifth()) && 
                Objects.equals(this.f, thatNonuple.getSixth()) && 
                Objects.equals(this.g, thatNonuple.getSeventh()) && 
                Objects.equals(this.h, thatNonuple.getEighth()) && 
                Objects.equals(this.i, thatNonuple.getNinth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e, f, g, h, i);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h + ", " + i + ")";
    }
}
