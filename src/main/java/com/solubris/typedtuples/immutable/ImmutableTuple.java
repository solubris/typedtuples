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

public class ImmutableTuple {
    private ImmutableTuple() {
    }

    public static ImmutableUnit of() {
        return ImmutableUnitImpl.INSTANCE;
    }

    public static <A> ImmutableSingle<A> of(A a) {
        return new ImmutableSingleImpl<>(a);
    }

    public static <A> ImmutableSingle<A> copyOf(Single<A> t) {
        return new ImmutableSingleImpl<>(t.get());
    }

    public static <A, B> ImmutableCouple<A, B> of(A a, B b) {
        return new ImmutableCoupleImpl<>(a, b);
    }

    public static <A, B> ImmutableCouple<A, B> copyOf(Couple<A, B> t) {
        return new ImmutableCoupleImpl<>(t.getFirst(), t.get());
    }

    public static <A, B, C> ImmutableTriple<A, B, C> of(A a, B b, C c) {
        return new ImmutableTripleImpl<>(a, b, c);
    }

    public static <A, B, C> ImmutableTriple<A, B, C> copyOf(Triple<A, B, C> t) {
        return new ImmutableTripleImpl<>(t.getFirst(), t.getSecond(), t.get());
    }

    public static <A, B, C, D> ImmutableQuadruple<A, B, C, D> of(A a, B b, C c, D d) {
        return new ImmutableQuadrupleImpl<>(a, b, c, d);
    }

    public static <A, B, C, D> ImmutableQuadruple<A, B, C, D> copyOf(Quadruple<A, B, C, D> t) {
        return new ImmutableQuadrupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.get());
    }

    public static <A, B, C, D, E> ImmutableQuintuple<A, B, C, D, E> of(A a, B b, C c, D d, E e) {
        return new ImmutableQuintupleImpl<>(a, b, c, d, e);
    }

    public static <A, B, C, D, E> ImmutableQuintuple<A, B, C, D, E> copyOf(
            Quintuple<A, B, C, D, E> t) {
        return new ImmutableQuintupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.get());
    }

    public static <A, B, C, D, E, F> ImmutableSextuple<A, B, C, D, E, F> of(A a, B b, C c, D d, E e,
            F f) {
        return new ImmutableSextupleImpl<>(a, b, c, d, e, f);
    }

    public static <A, B, C, D, E, F> ImmutableSextuple<A, B, C, D, E, F> copyOf(
            Sextuple<A, B, C, D, E, F> t) {
        return new ImmutableSextupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.get());
    }

    public static <A, B, C, D, E, F, G> ImmutableSeptuple<A, B, C, D, E, F, G> of(A a, B b, C c,
            D d, E e, F f, G g) {
        return new ImmutableSeptupleImpl<>(a, b, c, d, e, f, g);
    }

    public static <A, B, C, D, E, F, G> ImmutableSeptuple<A, B, C, D, E, F, G> copyOf(
            Septuple<A, B, C, D, E, F, G> t) {
        return new ImmutableSeptupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.get());
    }

    public static <A, B, C, D, E, F, G, H> ImmutableOctuple<A, B, C, D, E, F, G, H> of(A a, B b,
            C c, D d, E e, F f, G g, H h) {
        return new ImmutableOctupleImpl<>(a, b, c, d, e, f, g, h);
    }

    public static <A, B, C, D, E, F, G, H> ImmutableOctuple<A, B, C, D, E, F, G, H> copyOf(
            Octuple<A, B, C, D, E, F, G, H> t) {
        return new ImmutableOctupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.getSeventh(), t.get());
    }

    public static <A, B, C, D, E, F, G, H, I> ImmutableNonuple<A, B, C, D, E, F, G, H, I> of(A a,
            B b, C c, D d, E e, F f, G g, H h, I i) {
        return new ImmutableNonupleImpl<>(a, b, c, d, e, f, g, h, i);
    }

    public static <A, B, C, D, E, F, G, H, I> ImmutableNonuple<A, B, C, D, E, F, G, H, I> copyOf(
            Nonuple<A, B, C, D, E, F, G, H, I> t) {
        return new ImmutableNonupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.getSeventh(), t.getEighth(), t.get());
    }

    public static <A, B, C, D, E, F, G, H, I, J> ImmutableDecuple<A, B, C, D, E, F, G, H, I, J> of(
            A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
        return new ImmutableDecupleImpl<>(a, b, c, d, e, f, g, h, i, j);
    }

    public static <A, B, C, D, E, F, G, H, I, J> ImmutableDecuple<A, B, C, D, E, F, G, H, I, J> copyOf(
            Decuple<A, B, C, D, E, F, G, H, I, J> t) {
        return new ImmutableDecupleImpl<>(t.getFirst(), t.getSecond(), t.getThird(), t.getFourth(), t.getFifth(), t.getSixth(), t.getSeventh(), t.getEighth(), t.getNinth(), t.get());
    }
}
