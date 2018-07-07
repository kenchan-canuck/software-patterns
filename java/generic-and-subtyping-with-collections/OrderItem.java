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


public class OrderItem<T extends Reseller<P>, P extends Producer> extends Item<T, P> {

    private String name = null; 

    protected OrderItem() {}

    @Override
    public OrderItem<T, P> add_quantity() { super.add_quantity(); return self(); }
 
    public OrderItem<T, P> name(String nm) { name = nm; return self(); }

    @SuppressWarnings("unchecked")
    public OrderItem<T, P> self() { return this; }

    public String toString() {
    
       return "order_item1: " + hashCode() + " with name = " + name + " and item1 as " + super.toString();

    }

    public static void main(String[] args) {

       OrderItem<Reseller<Producer>,Producer> order_item1 = new OrderItem<Reseller<Producer>,Producer>();
       order_item1 = order_item1.name("television");
       OrderItem<Reseller<Producer>,Producer> order_item2 = order_item1.add_quantity().add_quantity();
       Order<OrderItem<Reseller<Producer>,Producer>,Reseller<Producer>,Producer,Buy> order1 = new Order<OrderItem<Reseller<Producer>,Producer>,Reseller<Producer>,Producer,Buy>();
       Order<OrderItem<Reseller<Producer>,Producer>,Reseller<Producer>,Producer,Buy> order2 = order1.add_item(order_item2);
       System.out.println("1 - order_item1 class is " + order_item1.getClass());
       System.out.println("2 - order_item2 = " + order_item2);
       System.out.println("3 - order1 class is " + order1.getClass());
       System.out.println("4 - order2 = " + order2);
    }

} // end class OrderItem


