/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * Author and Developer: Ken Chan
 * Organization: Timeleap Inc.
 * Website: https://www.timeleap.com
 * Location: Toronto, Ontario, Canada
 * Email: ken@timeleap.com
 * Date Created: July 1, 2018 (Canada National Day)
 *
 */
import java.lang.*;
import java.util.*;


public class Item<T extends Item<T>> {

    private int quantity = 0;
    private Item<T> item = null;

    protected Item() {}

    public Item<T> add_quantity() { quantity++; return self(); }
    public Item<T> add_item(Item<T> item) { this.item = item; return self(); }
 
    @SuppressWarnings("unchecked")
    public Item<T> self() { return this; }

    public String toString() {
    
       return "item1: " + hashCode() + " with quantity = " + quantity;

    }

    public static void main(String[] args) {

       Item<?> item1 = new Item<>();
       Item<?> item2 = item1.add_quantity().add_quantity();
       Order<?> order1 = new Order<>();
       Order<?> order2 = order1.add_item(item2);
       System.out.println("1 - item1 class is " + item1.getClass());
       System.out.println("2 - item2 = " + item2);
       System.out.println("3 - order1 class is " + order1.getClass());
       System.out.println("4 - order2 = " + order2);
    }

} // end class Item
