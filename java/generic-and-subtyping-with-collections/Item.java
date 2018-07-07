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


public class Item<T extends Reseller<P>, P extends Producer> {

    private T reseller = null;
    private int quantity = 0;

    protected Item() {}

    public Item<T,P> reseller(T res) { reseller = res; return self(); }
    public Item<T,P> add_quantity() { quantity++; return self(); }
 
    @SuppressWarnings("unchecked")
    public Item<T,P> self() { return this; }

    public String toString() {
    
       return "item1: " + hashCode() + " with reseller = " + reseller + " with quantity = " + quantity;

    }

    public static void main(String[] args) {

       Item<Reseller<Producer>,Producer> item1 = new Item<Reseller<Producer>,Producer>();
       Reseller<Producer> reseller1 = new Reseller<Producer>();
       Producer producer1 = new Producer();

       reseller1 = reseller1.producer(producer1);
       item1 = item1.reseller(reseller1);
       item1 = item1.add_quantity().add_quantity();
       System.out.println("1 - item1 class is " + item1.getClass());
       System.out.println("2 - item1 = " + item1);
    }

} // end class Item
