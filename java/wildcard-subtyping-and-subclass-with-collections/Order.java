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


public class Order<T extends Item<T>> {

    private int number_of_items = 0;
    private List<Item<?>> items = null;

    protected Order() { items = new ArrayList<>(); }

    public Order<T> add_item(Item<?> item) { 
        items.add(item);
        number_of_items++; 
        return self();
    }

    @SuppressWarnings("unchecked") 
    public <T1 extends Order<T>> T1 self() { return (T1)this; }

    public String toString() {

       return "order has " + hashCode() + " with number of items =  " + number_of_items + " with items = " + items;

    }

    public static void main(String[] args) {

       OrderItem<?> order_item1 = new OrderItem<>();
       OrderItem<?> order_item2 = order_item1.add_quantity().add_quantity().add_quantity();
       System.out.println("1 - order_item1 class is " + order_item1.getClass());
       System.out.println("2 - order_item2 = " + order_item2);

       Order<?> order1 = new Order<>();
       Order<?> order2 = order1.self().add_item(order_item2).add_item(order_item2).add_item(order_item2);
       System.out.println("3 - order1 class is " + order1.getClass());
       System.out.println("4 - order2 = " + order2);
    }

} // end class Order

