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

import com.solubris.typedtuples.Decuple;
import com.solubris.typedtuples.function.DecupleFunction;

import java.util.function.UnaryOperator;

public interface MutableDecuple<A, B, C, D, E, F, G, H, I, J> extends Decuple<A, B, C, D, E, F, G, H, I, J> {
    void setFirst(A a);

    void setSecond(B b);

    void setThird(C c);

    void setFourth(D d);

    void setFifth(E e);

    void setSixth(F f);

    void setSeventh(G g);

    void setEighth(H h);

    void setNinth(I i);

    void set(J j);

    void setAll(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j);

    <R> R mapAll(DecupleFunction<A, B, C, D, E, F, G, H, I, J, R> mapper);

    void computeFirst(UnaryOperator<A> mapper);

    void computeSecond(UnaryOperator<B> mapper);

    void computeThird(UnaryOperator<C> mapper);

    void computeFourth(UnaryOperator<D> mapper);

    void computeFifth(UnaryOperator<E> mapper);

    void computeSixth(UnaryOperator<F> mapper);

    void computeSeventh(UnaryOperator<G> mapper);

    void computeEighth(UnaryOperator<H> mapper);

    void computeNinth(UnaryOperator<I> mapper);

    void compute(UnaryOperator<J> mapper);
}
