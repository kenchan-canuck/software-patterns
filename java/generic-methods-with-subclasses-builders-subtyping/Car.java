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


public class Car<P extends Passenger<H>, H extends Human> implements Vehicle<P, H> { 

   private long vin = 0;
   private String engine = "engine";
 
   public static class Builder<T extends Builder<T>> {

       private long vin = 0;
       private String engine = "engine";
 
       public Builder() {
          
       }

       public T vin(long _vin) {
           vin = _vin;
           return self(); 
       }

       public T engine(String _engine) {
           engine = _engine;
           return self(); 
       }

       public <P extends Passenger<H>, H extends Human> Car<P, H> build() {
          Car<P, H> ret = new Car<P, H>(this);
          return ret;
       }

       public T self() {
          return (T)this;
       }

   } // end class Builder

   @Override
   public <T extends Vehicle<P, H>, P extends Passenger<H>, H extends Human> T vin(long _vin) {
       vin = _vin;
       return (T)this;
   }

   @Override
   public <T extends Vehicle<P, H>, P extends Passenger<H>, H extends Human> T engine(String _engine) {
       engine = _engine;
       return (T)this;
   }

   protected Car(Builder<?> builder) {
       
       vin = builder.vin;
       engine = builder.engine;

   } 


   public String toString() {
       return "" + this.vin + " " + this.engine;
   }


   public static void main(String[] args) {

      Car<Passenger<Adult>, Adult> car1 = new Car.Builder<>().vin(12345).engine("gas engine").<Passenger<Adult>, Adult>build();

      System.out.println("1 - car1 class is " + car1.getClass());
      System.out.println("2 - car1 has " + car1);

   }

} // end class Car

