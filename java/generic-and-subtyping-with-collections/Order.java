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

public class Order<T extends Item<R, P>, R extends Reseller<P>, P extends Producer, B extends Buy> extends Cart<B>  {

    private int number_of_items = 0;

    private List<OrderItem<R,P>> items = null;
    // private List<T extends Item<R,P>, R extends Reseller<P>, P extends Producer>> items = null; - compile errors
    // private List<T extends Item<R extends Reseller<P extends Producer>, P extends Producer>> items = null; - compile errors

    // private List<? extends Item<?,?>> items = null; - compile errors
    // private List<? extends Item<? extends Reseller<? extends Producer>, ? extends Producer>> items = null; - compile errors
    // private List<OrderItem<Reseller<Producer>,Producer>> items = null; - compile errors


    protected Order() { items = new ArrayList<>(); }
    // protected Order() { items = new ArrayList<T<R<P>,P>>(); } - compile errors
    // protected Order() { items = new ArrayList<OrderItem<Reseller<Producer>,Producer>>(); } - compile erorrs

    // public <T extends Item<R, P>, R extends Reseller<P>, P extends Producer, B extends Buy> Order<T,R,P,B> add_item(T item) {  - compile errors
    // public <T extends Item<R, P>, R extends Reseller<P>, P extends Producer, B extends Buy> Order<T,R,P,B> add_item(T<R<P>,P> item) {  - compile errors

    // public Order<T,R,P,B> add_item(T<R<P>,P> item) { - compile errors
    // public Order<T,R,P,B> add_item(T item) {  - compile errors
    // public Order<T,R,P,B> add_item(OrderItem<Reseller<Producer>,Producer> item) {  - compile errors
    // public Order<T,R,P,B> add_item(OrderItem<R,P> item) {  - compile errors

    public <O extends OrderItem<R,P>> Order<T,R,P,B> add_item(O item) { 

        // items.add(item);
        this.add_item_to_items(item);
        number_of_items++; 
        return self();

    }


    // public void add_item_to_items(OrderItem<R,P> item) { - compile errors
    public <T extends OrderItem<R,P>> void add_item_to_items(T item) {
    // public void add_item_to_items(OrderItem<Reseller<Producer>,Producer> item) { - compule errors
        items.add(item);
    }


    // public <T extends Item<R, P>, R extends Reseller<P>, P extends Producer, B extends Buy> Order<T,R,P,B> self() { return this; }
    public Order<T,R,P,B> self() { return this; }

    public String toString() {

       return "order has " + hashCode() + " with number of items =  " + number_of_items + " with items = " + items;

    }

    public static void main(String[] args) {

       Producer producer1 = new Producer();
       Reseller<Producer> reseller1 = new Reseller<Producer>();
       reseller1 = reseller1.name("Amazon");
       reseller1 = reseller1.producer(producer1.name("Google"));

       Buy buy1 = new Buy();
       buy1.code("UPC12345");
       OrderItem<Reseller<Producer>,Producer> order_item1 = new OrderItem<Reseller<Producer>,Producer>();
       OrderItem<Reseller<Producer>,Producer> order_item2 = order_item1.add_quantity().add_quantity().add_quantity();
       System.out.println("1 - order_item1 class is " + order_item1.getClass());
       System.out.println("2 - order_item2 = " + order_item2);

       Order<OrderItem<Reseller<Producer>,Producer>,Reseller<Producer>,Producer,Buy> order1 = 
           new Order<OrderItem<Reseller<Producer>,Producer>,Reseller<Producer>,Producer,Buy>();
       Order<OrderItem<Reseller<Producer>,Producer>,Reseller<Producer>,Producer,Buy> order2 = 
           order1.self().add_item(order_item2).add_item(order_item2).add_item(order_item2);
       System.out.println("3 - order1 class is " + order1.getClass());
       System.out.println("4 - order1 = " + order1);

       System.out.println("5 - order2 class is " + order2.getClass());
       System.out.println("6 - order2 = " + order2);
    }

} // end class Order

