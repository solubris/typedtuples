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

import com.solubris.typedtuples.immutable.ImmutableCouple;
import com.solubris.typedtuples.immutable.ImmutableTuple;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Another example from stack overflow
 *
 * https://stackoverflow.com/questions/39130122/java-8-nested-multi-level-group-by
 */
class StreamTest2 {
    private int key1 = 1;
    private int key2 = 1;

    static class Pojo<T, V> {
        List<Item<T, V>> items;

        public List<Item<T, V>> getItems() {
            return items;
        }
    }

    static class Item<T, V> {
        T key1;
        List<SubItem<V>> subItems;

        public List<SubItem<V>> getSubItems() {
            return subItems;
        }

        public T getKey1() {
            return key1;
        }
    }

    static class SubItem<V> {
        V key2;
        Object otherAttribute1;

        public V getKey2() {
            return key2;
        }

        @Override
        public String toString() {
            return "SubItem{" +
                    "key2=" + key2 +
                    ", otherAttribute1=" + otherAttribute1 +
                    '}';
        }
    }


    @Test
    void abstractMapSimpleImmutableEntry() throws Exception {

        Pojo<String, String> pojo = buildPojo();

        Map<String, Map<String, List<SubItem<String>>>> result = pojo.getItems().stream()
                .flatMap(item -> item.subItems.stream().map(sub -> new AbstractMap.SimpleImmutableEntry<>(item.getKey1(), sub)))
                // stream of (item.key1, subItem) -- Stream<Entry<String, SubItem<String>>>
                .collect(
                        Collectors.groupingBy(AbstractMap.SimpleImmutableEntry::getKey, // list of (item.key1, subItem)
                                Collectors.mapping(Map.Entry::getValue, Collectors.groupingBy(SubItem::getKey2))
                        )
                );

        System.out.println(result);

//        {
//            Item1={SubItem1=[SubItem{key2=SubItem1, otherAttribute1=other}], SubItem2=[SubItem{key2=SubItem2, otherAttribute1=other}]},
//            Item2={SubItem3=[SubItem{key2=SubItem3, otherAttribute1=other}], SubItem4=[SubItem{key2=SubItem4, otherAttribute1=other}]}
//        }

    }

    @Test
    void java9flatMapping() throws Exception {

        Pojo<String, String> pojo = buildPojo();

        Map<String, Map<String, List<SubItem<String>>>> result = pojo.getItems().stream()
                .collect(Collectors.groupingBy(Item::getKey1,
                        Collectors.flatMapping(item -> item.getSubItems().stream(),
                                Collectors.groupingBy(SubItem::getKey2))));

        System.out.println(result);

//        {
//            Item1={SubItem1=[SubItem{key2=SubItem1, otherAttribute1=other}], SubItem2=[SubItem{key2=SubItem2, otherAttribute1=other}]},
//            Item2={SubItem3=[SubItem{key2=SubItem3, otherAttribute1=other}], SubItem4=[SubItem{key2=SubItem4, otherAttribute1=other}]}
//        }

    }

    @Test
    void immutableTuples() throws Exception {

        Pojo<String, String> pojo = buildPojo();

        Map<String, Map<String, List<SubItem<String>>>> result = pojo.getItems().stream()
                .flatMap(item -> item.subItems.stream().map(sub -> ImmutableTuple.of(item.getKey1(), sub)))
                // stream of (item.key1, subItem) -- Stream<Entry<String, SubItem<String>>>
                .collect(
                        Collectors.groupingBy(ImmutableCouple::getFirst, // list of (item.key1, subItem)
                                Collectors.mapping(ImmutableCouple::get, Collectors.groupingBy(SubItem::getKey2))
                        )
                );

        System.out.println(result);

//        {
//            Item1={SubItem1=[SubItem{key2=SubItem1, otherAttribute1=other}], SubItem2=[SubItem{key2=SubItem2, otherAttribute1=other}]},
//            Item2={SubItem3=[SubItem{key2=SubItem3, otherAttribute1=other}], SubItem4=[SubItem{key2=SubItem4, otherAttribute1=other}]}
//        }

    }

    private Pojo<String, String> buildPojo() {
        Pojo<String, String> result = new Pojo<>();
        result.items = new ArrayList<>();
        result.items.add(buildItem());
        result.items.add(buildItem());
        return result;
    }

    private Item<String, String> buildItem() {
        Item<String, String> item = new Item<>();
        item.key1 = "Item" + (key1++);
        item.subItems = new ArrayList<>();
        item.subItems.add(buildSubItem());
        item.subItems.add(buildSubItem());
        return item;
    }

    private SubItem<String> buildSubItem() {
        SubItem<String> subItem = new SubItem<>();
        subItem.key2 = "SubItem" + (key2++);
        subItem.otherAttribute1 = "other";
        return subItem;
    }
}
