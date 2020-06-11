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

import com.solubris.typedtuples.Octuple;
import com.solubris.typedtuples.function.OctupleFunction;

import java.util.function.UnaryOperator;

public interface MutableOctuple<A, B, C, D, E, F, G, H> extends Octuple<A, B, C, D, E, F, G, H> {
    void setFirst(A a);

    void setSecond(B b);

    void setThird(C c);

    void setFourth(D d);

    void setFifth(E e);

    void setSixth(F f);

    void setSeventh(G g);

    void set(H h);

    void setAll(A a, B b, C c, D d, E e, F f, G g, H h);

    <R> R mapAll(
            OctupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? super H, R> mapper);

    void computeFirst(UnaryOperator<A> mapper);

    void computeSecond(UnaryOperator<B> mapper);

    void computeThird(UnaryOperator<C> mapper);

    void computeFourth(UnaryOperator<D> mapper);

    void computeFifth(UnaryOperator<E> mapper);

    void computeSixth(UnaryOperator<F> mapper);

    void computeSeventh(UnaryOperator<G> mapper);

    void compute(UnaryOperator<H> mapper);
}
