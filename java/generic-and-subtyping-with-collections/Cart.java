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
 * Author and Developer: Ken Chan
 * Organization: Timeleap Inc.
 * Website: https://www.timeleap.com
 * Location: Toronto, Ontario, Canada
 * Email: ken@timeleap.com
 * Date Created: July 1, 2018 (Canada National Day)
 *
 */
import java.lang.*;


public class Cart<T extends Buy> {

    private String cart_name = null;
    private T buy = null;
    
    protected Cart() {}

    public Cart<T> cart_name(String nm) { this.cart_name = nm; return self(); }
    public Cart<T> buy(T buy) { this.buy = buy; return self(); }
 
    public Cart<T> self() { return this; }

    public String toString() {
    
       return "item1: " + hashCode() + " with cart_name = " + cart_name + " with buy = " + buy;

    }

    public static void main(String[] args) {

       Buy buy1 = new Buy();
       Cart<Buy> cart1 = new Cart<Buy>();
       cart1 = cart1.cart_name("Amazon");
       cart1 = cart1.buy(buy1.code("UPC098765"));
       System.out.println("1 - cart1 class is " + cart1.getClass());
       System.out.println("2 - cart1 has " + cart1);

    }

} // end class Cart
