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


public class Street<T extends House<?>> {

    private String name = "na";
    private List<House<?>> house_list = null;

    protected Street() { house_list = new ArrayList<House<?>>(); }

    public Street<?> name(String nm) { this.name = nm; return self(); }
    public Street<?> add_house(House<?> house) { house_list.add(house); return self(); }
 
    @SuppressWarnings("unchecked")
    public Street<?> self() { return this; }

    public String toString() {
    
       return "street1: " + hashCode() + " with name = " + name + " and size of house list = " + house_list.size();

    }

    public static void main(String[] args) {

       Street<?> street1 = new Street<>();
       Street<?> street2 = new Street<>();
       House<?> house1 = new House<>().address("123 main st").street(street1);
       street1.name("main").add_house(house1);
       House<?> house2 = new House<>().address("456 water st").street(street2);
       street2.name("water").add_house(house1);
       street2.name("water").add_house(house2);

       System.out.println("1 - house1 class is " + house1.getClass());
       System.out.println("2 - house2 = " + house2);
       System.out.println("3 - street1 class is " + street1.getClass());
       System.out.println("4 - street1 = " + street1);
       System.out.println("5 - street2 class is " + street2.getClass());
       System.out.println("6 - street2 = " + street2);
    }

} // end class Street
