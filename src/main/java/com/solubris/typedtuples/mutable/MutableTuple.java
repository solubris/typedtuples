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
import com.solubris.typedtuples.function.CoupleFunction;
import com.solubris.typedtuples.function.DecupleFunction;
import com.solubris.typedtuples.function.NonupleFunction;
import com.solubris.typedtuples.function.OctupleFunction;
import com.solubris.typedtuples.function.QuadrupleFunction;
import com.solubris.typedtuples.function.QuintupleFunction;
import com.solubris.typedtuples.function.SeptupleFunction;
import com.solubris.typedtuples.function.SextupleFunction;
import com.solubris.typedtuples.function.SingleFunction;
import com.solubris.typedtuples.function.TripleFunction;

import java.util.function.Function;

public class MutableTuple {
    private MutableTuple() {
    }

    public static <A> MutableSingle<A> of(A a) {
        return new MutableSingleImpl<>(a);
    }

    public static <A> MutableSingle<A> copyOf(Single<A> t) {
        return new MutableSingleImpl<>(t.get());
    }

    public static <A, R> Function<MutableSingle<A>, R> to(SingleFunction<? super A, R> mapper) {
        return t -> t.mapAll(mapper);
    }

    public static <A, B> MutableCouple<A, B> of(A a, B b) {
        return new MutableCoupleImpl<>(a, b);
    }

    public static <A, B> MutableCouple<A, B> copyOf(Couple<A, B> t) {
        return new MutableCoupleImpl<>(t.getFirst(), t.getSecond());
    }

    public static <A, B, R> Function<MutableCouple<A, B>, R> to(
            CoupleFunction<? super A, ? super B, R> mapper) {
        return t -> t.mapAll(mapper);
    }

    public static <A, B, C> MutableTriple<A, B, C> of(A a, B b, C c) {
        return new MutableTripleImpl<>(a, b, c);
    }

    public static <A, B, C> MutableTriple<A, B, C> copyOf(Triple<A, B, C> t) {
        return new MutableTripleImpl<>(t.getFirst(), t.getSecond(), t.getThird());
    }

    public static <A, B, C, R> Function<MutableTriple<A, B, C>, R> to(
            TripleFunction<? super A, ? super B, ? super C, R> mapper) {
        return t -> t.mapAll(mapper);
    }

    public static <A, B, C, D> MutableQuadruple<A, B, C, D> of(A a, B b, C c, D d) {
        return new MutableQuadrupleImpl<>(a, b, c, d);
    }

    public static <A, B, C, D> MutableQuadruple<A, B, C, D> copyOf(Quadruple<A, B, C, D> t) {
        return new MutableQuadrupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth());
    }

    public static <A, B, C, D, R> Function<MutableQuadruple<A, B, C, D>, R> to(
            QuadrupleFunction<? super A, ? super B, ? super C, ? super D, R> mapper) {
        return t -> t.mapAll(mapper);
    }

    public static <A, B, C, D, E> MutableQuintuple<A, B, C, D, E> of(A a, B b, C c, D d, E e) {
        return new MutableQuintupleImpl<>(a, b, c, d, e);
    }

    public static <A, B, C, D, E> MutableQuintuple<A, B, C, D, E> copyOf(
            Quintuple<A, B, C, D, E> t) {
        return new MutableQuintupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth());
    }

    public static <A, B, C, D, E, R> Function<MutableQuintuple<A, B, C, D, E>, R> to(
            QuintupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, R> mapper) {
        return t -> t.mapAll(mapper);
    }

    public static <A, B, C, D, E, F> MutableSextuple<A, B, C, D, E, F> of(A a, B b, C c, D d, E e,
            F f) {
        return new MutableSextupleImpl<>(a, b, c, d, e, f);
    }

    public static <A, B, C, D, E, F> MutableSextuple<A, B, C, D, E, F> copyOf(
            Sextuple<A, B, C, D, E, F> t) {
        return new MutableSextupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth());
    }

    public static <A, B, C, D, E, F, R> Function<MutableSextuple<A, B, C, D, E, F>, R> to(
            SextupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, R> mapper) {
        return t -> t.mapAll(mapper);
    }

    public static <A, B, C, D, E, F, G> MutableSeptuple<A, B, C, D, E, F, G> of(A a, B b, C c, D d,
            E e, F f, G g) {
        return new MutableSeptupleImpl<>(a, b, c, d, e, f, g);
    }

    public static <A, B, C, D, E, F, G> MutableSeptuple<A, B, C, D, E, F, G> copyOf(
            Septuple<A, B, C, D, E, F, G> t) {
        return new MutableSeptupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.getSeventh());
    }

    public static <A, B, C, D, E, F, G, R> Function<MutableSeptuple<A, B, C, D, E, F, G>, R> to(
            SeptupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, R> mapper) {
        return t -> t.mapAll(mapper);
    }

    public static <A, B, C, D, E, F, G, H> MutableOctuple<A, B, C, D, E, F, G, H> of(A a, B b, C c,
            D d, E e, F f, G g, H h) {
        return new MutableOctupleImpl<>(a, b, c, d, e, f, g, h);
    }

    public static <A, B, C, D, E, F, G, H> MutableOctuple<A, B, C, D, E, F, G, H> copyOf(
            Octuple<A, B, C, D, E, F, G, H> t) {
        return new MutableOctupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.getSeventh(), t.getEighth());
    }

    public static <A, B, C, D, E, F, G, H, R> Function<MutableOctuple<A, B, C, D, E, F, G, H>, R> to(
            OctupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? super H, R> mapper) {
        return t -> t.mapAll(mapper);
    }

    public static <A, B, C, D, E, F, G, H, I> MutableNonuple<A, B, C, D, E, F, G, H, I> of(A a, B b,
            C c, D d, E e, F f, G g, H h, I i) {
        return new MutableNonupleImpl<>(a, b, c, d, e, f, g, h, i);
    }

    public static <A, B, C, D, E, F, G, H, I> MutableNonuple<A, B, C, D, E, F, G, H, I> copyOf(
            Nonuple<A, B, C, D, E, F, G, H, I> t) {
        return new MutableNonupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.getSeventh(), t.getEighth(), t.getNinth());
    }

    public static <A, B, C, D, E, F, G, H, I, R> Function<MutableNonuple<A, B, C, D, E, F, G, H, I>, R> to(
            NonupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? super H, ? super I, R> mapper) {
        return t -> t.mapAll(mapper);
    }

    public static <A, B, C, D, E, F, G, H, I, J> MutableDecuple<A, B, C, D, E, F, G, H, I, J> of(
            A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
        return new MutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, j);
    }

    public static <A, B, C, D, E, F, G, H, I, J> MutableDecuple<A, B, C, D, E, F, G, H, I, J> copyOf(
            Decuple<A, B, C, D, E, F, G, H, I, J> t) {
        return new MutableDecupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.getSeventh(), t.getEighth(), t.getNinth(), t.getTenth());
    }

    public static <A, B, C, D, E, F, G, H, I, J, R> Function<MutableDecuple<A, B, C, D, E, F, G, H, I, J>, R> to(
            DecupleFunction<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? super G, ? super H, ? super I, ? super J, R> mapper) {
        return t -> t.mapAll(mapper);
    }
}
