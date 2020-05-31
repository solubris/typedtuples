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

import com.solubris.typedtuples.Single;
import com.solubris.typedtuples.function.SingleFunction;

import java.util.function.UnaryOperator;

public interface MutableSingle<A> extends Single<A> {
    void set(A a);

    <R> R mapAll(SingleFunction<A, R> mapper);

    void compute(UnaryOperator<A> mapper);
}
