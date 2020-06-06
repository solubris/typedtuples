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

package com.solubris.typedtuples;

import java.util.Comparator;
import java.util.function.Function;

public interface Couple<A, B> {
    A getFirst();

    B get();

    static <A extends Comparable<? super A>, B extends Comparable<? super B>> Comparator<Couple<A, B>> compareByAllFieldsInOrder(
    ) {
        Comparator<Couple<A, B>> a = Comparator.comparing(Couple::getFirst);
        Comparator<Couple<A, B>> b = Comparator.comparing(Couple::get);
        return (a).thenComparing(b);
    }

    static <A extends Comparable<? super A>, B extends Comparable<? super B>> Comparator<Couple<A, B>> compareByAllFieldsInReverseOrder(
    ) {
        Comparator<Couple<A, B>> a = Comparator.comparing(Couple::getFirst);
        Comparator<Couple<A, B>> b = Comparator.comparing(Couple::get);
        return (b).thenComparing(a);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>> Comparator<Couple<A, B>> compareByAllFieldsInOrder(
            Function<A, FA> fa, Function<B, FB> fb) {
        Comparator<Couple<A, B>> a = Comparator.comparing(fa.compose(Couple::getFirst));
        Comparator<Couple<A, B>> b = Comparator.comparing(fb.compose(Couple::get));
        return (a).thenComparing(b);
    }

    static <A, FA extends Comparable<? super FA>, B, FB extends Comparable<? super FB>> Comparator<Couple<A, B>> compareByAllFieldsInReverseOrder(
            Function<A, FA> fa, Function<B, FB> fb) {
        Comparator<Couple<A, B>> a = Comparator.comparing(fa.compose(Couple::getFirst));
        Comparator<Couple<A, B>> b = Comparator.comparing(fb.compose(Couple::get));
        return (b).thenComparing(a);
    }

    static <A, B> Comparator<Couple<A, B>> compareByAllFieldsInOrder(Comparator<? super A> ca,
                                                                     Comparator<? super B> cb) {
        Comparator<Couple<A, B>> a = Comparator.comparing(Couple::getFirst, ca);
        Comparator<Couple<A, B>> b = Comparator.comparing(Couple::get, cb);
        return (a).thenComparing(b);
    }

    static <A, B> Comparator<Couple<A, B>> compareByAllFieldsInReverseOrder(
            Comparator<? super A> ca, Comparator<? super B> cb) {
        Comparator<Couple<A, B>> a = Comparator.comparing(Couple::getFirst, ca);
        Comparator<Couple<A, B>> b = Comparator.comparing(Couple::get, cb);
        return (b).thenComparing(a);
    }
}
