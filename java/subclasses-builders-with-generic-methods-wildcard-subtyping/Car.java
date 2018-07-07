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


public class Car<P extends Passenger<?>> implements Vehicle<P> { 

   private long vin = 0;
   private String engine = "engine";
   private List<P> passenger_list = null;
 
   public static class Builder<T extends Builder<T>> {

       private long vin = 0;
       private String engine = "engine";
       private List<Passenger<?>> passenger_list = null;
 
       public Builder() {
           vin = 0;
           engine = "steam engine";
           passenger_list = new ArrayList<>(); 
       }

       public T vin(long _vin) {
           vin = _vin;
           return self(); 
       }

       public T engine(String _engine) {
           engine = _engine;
           return self(); 
       }

       public <P extends Passenger<?>> T add_passenger(P passenger) {
           passenger_list.add(passenger);
           return self(); 
       }

       public <P extends Passenger<?>> Car<P> build() {
          Car<P> ret = new Car<P>(this);
          return ret;
       }

       public T self() {
          return (T)this;
       }

   } // end class Builder

   @Override
   public <T extends Vehicle<P>, P extends Passenger<?>> T vin(long _vin) {
       vin = _vin;
       return (T)this;
   }

   @Override
   public <T extends Vehicle<P>, P extends Passenger<?>> T engine(String _engine) {
       engine = _engine;
       return (T)this;
   }

   protected Car(Builder<?> builder) {
       
       vin = builder.vin;
       engine = builder.engine;
       passenger_list = (List<P>)builder.passenger_list;

   } 


   public String toString() {
       return "this vehicle has a vin = " + this.vin + " with an engine of " + this.engine + " plus carrying the following passengers: " + passenger_list ;
   }


   public static void main(String[] args) {

      Fare f1 = new Fare("Uber Premium");
      Passenger<Fare> pg1 = new Passenger.Builder<>().fare(f1).age(30).build();
      Car<Passenger<Fare>> car1 = new Car.Builder<>().vin(12345).engine("gas engine").add_passenger(pg1).<Passenger<Fare>>build();

      System.out.println("1 - car1 class is " + car1.getClass());
      System.out.println("2 - car1 has " + car1);

   }

} // end class Car

