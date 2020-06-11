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

import com.solubris.typedtuples.Couple;
import com.solubris.typedtuples.Decuple;
import com.solubris.typedtuples.Nonuple;
import com.solubris.typedtuples.Octuple;
import com.solubris.typedtuples.Quadruple;
import com.solubris.typedtuples.Quintuple;
import com.solubris.typedtuples.Septuple;
import com.solubris.typedtuples.Sextuple;
import com.solubris.typedtuples.Single;
import com.solubris.typedtuples.Triple;

public class MutableTuple {
    private MutableTuple() {
    }

    public static <A> MutableSingle<A> of(A a) {
        return new MutableSingleImpl<>(a);
    }

    public static <A> MutableSingle<A> copyOf(Single<A> t) {
        return new MutableSingleImpl<>(t.get());
    }

    public static <A, B> MutableCouple<A, B> of(A a, B b) {
        return new MutableCoupleImpl<>(a, b);
    }

    public static <A, B> MutableCouple<A, B> copyOf(Couple<A, B> t) {
        return new MutableCoupleImpl<>(t.getFirst(), t.get());
    }

    public static <A, B, C> MutableTriple<A, B, C> of(A a, B b, C c) {
        return new MutableTripleImpl<>(a, b, c);
    }

    public static <A, B, C> MutableTriple<A, B, C> copyOf(Triple<A, B, C> t) {
        return new MutableTripleImpl<>(t.getFirst(), t.getSecond(), t.get());
    }

    public static <A, B, C, D> MutableQuadruple<A, B, C, D> of(A a, B b, C c, D d) {
        return new MutableQuadrupleImpl<>(a, b, c, d);
    }

    public static <A, B, C, D> MutableQuadruple<A, B, C, D> copyOf(Quadruple<A, B, C, D> t) {
        return new MutableQuadrupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.get());
    }

    public static <A, B, C, D, E> MutableQuintuple<A, B, C, D, E> of(A a, B b, C c, D d, E e) {
        return new MutableQuintupleImpl<>(a, b, c, d, e);
    }

    public static <A, B, C, D, E> MutableQuintuple<A, B, C, D, E> copyOf(
            Quintuple<A, B, C, D, E> t) {
        return new MutableQuintupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.get());
    }

    public static <A, B, C, D, E, F> MutableSextuple<A, B, C, D, E, F> of(A a, B b, C c, D d, E e,
            F f) {
        return new MutableSextupleImpl<>(a, b, c, d, e, f);
    }

    public static <A, B, C, D, E, F> MutableSextuple<A, B, C, D, E, F> copyOf(
            Sextuple<A, B, C, D, E, F> t) {
        return new MutableSextupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.get());
    }

    public static <A, B, C, D, E, F, G> MutableSeptuple<A, B, C, D, E, F, G> of(A a, B b, C c, D d,
            E e, F f, G g) {
        return new MutableSeptupleImpl<>(a, b, c, d, e, f, g);
    }

    public static <A, B, C, D, E, F, G> MutableSeptuple<A, B, C, D, E, F, G> copyOf(
            Septuple<A, B, C, D, E, F, G> t) {
        return new MutableSeptupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.get());
    }

    public static <A, B, C, D, E, F, G, H> MutableOctuple<A, B, C, D, E, F, G, H> of(A a, B b, C c,
            D d, E e, F f, G g, H h) {
        return new MutableOctupleImpl<>(a, b, c, d, e, f, g, h);
    }

    public static <A, B, C, D, E, F, G, H> MutableOctuple<A, B, C, D, E, F, G, H> copyOf(
            Octuple<A, B, C, D, E, F, G, H> t) {
        return new MutableOctupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.getSeventh(), t.get());
    }

    public static <A, B, C, D, E, F, G, H, I> MutableNonuple<A, B, C, D, E, F, G, H, I> of(A a, B b,
            C c, D d, E e, F f, G g, H h, I i) {
        return new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, i);
    }

    public static <A, B, C, D, E, F, G, H, I> MutableNonuple<A, B, C, D, E, F, G, H, I> copyOf(
            Nonuple<A, B, C, D, E, F, G, H, I> t) {
        return new MutableNonupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.getSeventh(), t.getEighth(), t.get());
    }

    public static <A, B, C, D, E, F, G, H, I, J> MutableDecuple<A, B, C, D, E, F, G, H, I, J> of(
            A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
        return new MutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, j);
    }

    public static <A, B, C, D, E, F, G, H, I, J> MutableDecuple<A, B, C, D, E, F, G, H, I, J> copyOf(
            Decuple<A, B, C, D, E, F, G, H, I, J> t) {
        return new MutableDecupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.getSeventh(), t.getEighth(), t.getNinth(), t.get());
    }
}
