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
 * Author: Ken Chan
 * Organization: Timeleap Inc.
 * Web: https://www.timeleap.com
 * Location: Toronto, Ontario, Canada
 * Email: ken@timeleap.com
 * Date Created: July 1, 2018 (Canada National Day)
 *
 */
import java.lang.*;
import java.util.*;

public class Car { 

   private int vin = 0;
   private Object engine = "unknown engine";
 
   public static class Builder {

       private int vin = 0;
       private Object engine = "unknown engine";
 
       public Builder() {
          
       }

       public Builder vin(int _vin) {
           System.out.println("Call Car.Builder vin(int _vin)");
           vin = _vin;
           return self(); 
       }

       public Builder engine(Object _engine) {
           System.out.println("Call Car.Builder engine(Object _engine)");
           engine = _engine;
           return self(); 
       }

       public Car build() {
          return new Car(this);
       }

       public Builder self() {
          return this;
       }

   } // end class Builder

   protected Car(Builder builder) {
       vin = builder.vin;
       engine = builder.engine;
   } 

   public Car vin(int _vin) {
       System.out.println("Call Car vin(int _vin)");
       vin = _vin;
       return this; 
   }

   public Car engine(Object _engine) {
       System.out.println("Call Car engine(Object _engine)");
       engine = _engine;
       return this; 
   }

   public String toString() {
       return "" + this.vin + " " + this.engine;
   }


   public static void main(String[] args) {

      Car car1 = new Car.Builder().vin(12345).engine("gas engine").build();

      System.out.println("1 - test builder - car1 class is " + car1.getClass());
      System.out.println("2 - test builder - car1 has " + car1);

   }

} // end class Car

