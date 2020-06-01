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

package com.solubris.typedtuples.immutable;

final class ImmutableUnitImpl implements ImmutableUnit {
    static final ImmutableUnitImpl INSTANCE = new ImmutableUnitImpl();

    private ImmutableUnitImpl() {
    }

    @Override
    public <X0> ImmutableSingle<X0> add(X0 x0) {
        return new ImmutableSingleImpl<>(x0);
    }

    @Override
    public String toString() {
        return "()";
    }
}
