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


public class House<T extends Street<?>> {

    private String address = "N/A";
    private Street<?> street = null;

    protected House() {}

    public House<?> address(String addr) { this.address = addr; return self(); }
    public House<?> street(Street<?> st) { this.street = st; return self(); }
 
    @SuppressWarnings("unchecked")
    public House<?> self() { return this; }

    public String toString() {
    
       return "house1: " + hashCode() + " with address = " + address + " and street = " + street.hashCode();

    }

    public static void main(String[] args) {

       House<?> house1 = new House<>();
       Street<?> street1 = new Street<>();
       house1.address("123 main st").street(street1);
       street1.name("main").add_house(house1);

       System.out.println("1 - house1 class is " + house1.getClass());
       System.out.println("2 - house1 = " + house1);
       System.out.println("3 - street1 class is " + street1.getClass());
       System.out.println("4 - street1 = " + street1);
    }

} // end class House
