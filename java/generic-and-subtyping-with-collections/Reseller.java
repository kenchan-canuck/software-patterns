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


public class Reseller<T extends Producer> {

    private String name = null;
    private T producer = null;
    
    protected Reseller() {}

    public Reseller<T> name(String nm) { this.name = nm; return self(); }
    public Reseller<T> producer(T pd) { this.producer = pd; return self(); }
 
    public Reseller<T> self() { return this; }

    public String toString() {
    
       return "item1: " + hashCode() + " with name = " + name + " with producer = " + producer;

    }

    public static void main(String[] args) {

       Producer producer1 = new Producer();
       Reseller<Producer> reseller1 = new Reseller<Producer>();
       reseller1 = reseller1.name("Amazon");
       reseller1 = reseller1.producer(producer1.name("Google"));
       System.out.println("1 - reseller1 class is " + reseller1.getClass());
       System.out.println("2 - reseller1 has " + reseller1);

    }

} // end class Reseller
