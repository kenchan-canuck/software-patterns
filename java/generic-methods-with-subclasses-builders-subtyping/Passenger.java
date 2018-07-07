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
 *
 */
import java.lang.*;
import java.util.*;


public class Passenger<H extends Human> extends Human { 

   private int age = 0;


   public static class Builder<T extends Builder<T, H>, H extends Human> {

       private int age = 0;
 
       public Builder() {
          
       }

       public T age(int _age) {
           age = _age;
           return self(); 
       }

       public Passenger<H> build() {
          return new Passenger<H>(this);
       }

       public T self() {
          return (T)this;
       }

   } // end class Builder

   protected Passenger(Builder<?, H> builder) {
       
       age = builder.age;

   } 


   public String toString() {
       return "" + this.age;
   }


   public static void main(String[] args) {

      Passenger<?> psg1 = new Passenger.Builder<>().age(40).build();

      System.out.println("1 - psg1 class is " + psg1.getClass());
      System.out.println("2 - psg1 has an age of " + psg1);
   }

} // end class Passenger

