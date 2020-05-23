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

public interface Tuple {
    static Identity of() {
        return Identity.INSTANCE;
    }

    static <A> Unit<A> of(A a) {
        return new Unit<>(a);
    }

    static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<>(a, b);
    }

    static <A, B, C> Triplet<A, B, C> of(A a, B b, C c) {
        return new Triplet<>(a, b, c);
    }

    static <A, B, C, D> Quartet<A, B, C, D> of(A a, B b, C c, D d) {
        return new Quartet<>(a, b, c, d);
    }

    static <A, B, C, D, E> Quintet<A, B, C, D, E> of(A a, B b, C c, D d, E e) {
        return new Quintet<>(a, b, c, d, e);
    }

    static <A, B, C, D, E, F> Sextet<A, B, C, D, E, F> of(A a, B b, C c, D d, E e, F f) {
        return new Sextet<>(a, b, c, d, e, f);
    }

    static <A, B, C, D, E, F, G> Septet<A, B, C, D, E, F, G> of(A a, B b, C c, D d, E e, F f, G g) {
        return new Septet<>(a, b, c, d, e, f, g);
    }

    static <A, B, C, D, E, F, G, H> Octet<A, B, C, D, E, F, G, H> of(A a, B b, C c, D d, E e, F f,
            G g, H h) {
        return new Octet<>(a, b, c, d, e, f, g, h);
    }

    static <A, B, C, D, E, F, G, H, I> Ennead<A, B, C, D, E, F, G, H, I> of(A a, B b, C c, D d, E e,
                                                                                                      F f, G g, H h, I i) {
        return new Ennead<>(a, b, c, d, e, f, g, h, i);
    }

    static <A, B, C, D, E, F, G, H, I, J> Decade<A, B, C, D, E, F, G, H, I, J> of(A a, B b, C c,
                                                                                                            D d, E e, F f, G g, H h, I i, J j) {
        return new Decade<>(a, b, c, d, e, f, g, h, i, j);
    }
}
