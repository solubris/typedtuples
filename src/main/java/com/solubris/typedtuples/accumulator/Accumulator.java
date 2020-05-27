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
package com.solubris.typedtuples.accumulator;

import java.util.function.BinaryOperator;

public class Accumulator {
    private Accumulator() {
    }

    public static <A> SingleAccumulator<A> of(BinaryOperator<A> a) {
        return new SingleAccumulatorImpl<>(a);
    }

    public static <A, B> CoupleAccumulator<A, B> of(BinaryOperator<A> a, BinaryOperator<B> b) {
        return new CoupleAccumulatorImpl<>(a, b);
    }

    public static <A, B, C> TripleAccumulator<A, B, C> of(BinaryOperator<A> a, BinaryOperator<B> b,
                                                          BinaryOperator<C> c) {
        return new TripleAccumulatorImpl<>(a, b, c);
    }

    public static <A, B, C, D> QuadrupleAccumulator<A, B, C, D> of(BinaryOperator<A> a,
                                                                   BinaryOperator<B> b, BinaryOperator<C> c, BinaryOperator<D> d) {
        return new QuadrupleAccumulatorImpl<>(a, b, c, d);
    }

    public static <A, B, C, D, E> QuintupleAccumulator<A, B, C, D, E> of(BinaryOperator<A> a,
                                                                         BinaryOperator<B> b, BinaryOperator<C> c, BinaryOperator<D> d, BinaryOperator<E> e) {
        return new QuintupleAccumulatorImpl<>(a, b, c, d, e);
    }

    public static <A, B, C, D, E, F> SextupleAccumulator<A, B, C, D, E, F> of(BinaryOperator<A> a,
                                                                              BinaryOperator<B> b, BinaryOperator<C> c, BinaryOperator<D> d, BinaryOperator<E> e,
                                                                              BinaryOperator<F> f) {
        return new SextupleAccumulatorImpl<>(a, b, c, d, e, f);
    }

    public static <A, B, C, D, E, F, G> SeptupleAccumulator<A, B, C, D, E, F, G> of(
            BinaryOperator<A> a, BinaryOperator<B> b, BinaryOperator<C> c, BinaryOperator<D> d,
            BinaryOperator<E> e, BinaryOperator<F> f, BinaryOperator<G> g) {
        return new SeptupleAccumulatorImpl<>(a, b, c, d, e, f, g);
    }

    public static <A, B, C, D, E, F, G, H> OctupleAccumulator<A, B, C, D, E, F, G, H> of(
            BinaryOperator<A> a, BinaryOperator<B> b, BinaryOperator<C> c, BinaryOperator<D> d,
            BinaryOperator<E> e, BinaryOperator<F> f, BinaryOperator<G> g, BinaryOperator<H> h) {
        return new OctupleAccumulatorImpl<>(a, b, c, d, e, f, g, h);
    }

    public static <A, B, C, D, E, F, G, H, I> NonupleAccumulator<A, B, C, D, E, F, G, H, I> of(
            BinaryOperator<A> a, BinaryOperator<B> b, BinaryOperator<C> c, BinaryOperator<D> d,
            BinaryOperator<E> e, BinaryOperator<F> f, BinaryOperator<G> g, BinaryOperator<H> h,
            BinaryOperator<I> i) {
        return new NonupleAccumulatorImpl<>(a, b, c, d, e, f, g, h, i);
    }

    public static <A, B, C, D, E, F, G, H, I, J> DecupleAccumulator<A, B, C, D, E, F, G, H, I, J> of(
            BinaryOperator<A> a, BinaryOperator<B> b, BinaryOperator<C> c, BinaryOperator<D> d,
            BinaryOperator<E> e, BinaryOperator<F> f, BinaryOperator<G> g, BinaryOperator<H> h,
            BinaryOperator<I> i, BinaryOperator<J> j) {
        return new DecupleAccumulatorImpl<>(a, b, c, d, e, f, g, h, i, j);
    }
}
