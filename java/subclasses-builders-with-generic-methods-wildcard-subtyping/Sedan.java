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


public class Sedan<P extends Passenger<?>> extends Car<P> { 

   private String transmission = "manual";
 
   public static class Builder<T extends Builder<T>> extends Car.Builder<T> { 

       private String transmission = "manual";
 
       public Builder() {
          super();
       }

       public T transmission(String _trans) {
           transmission = _trans;
           return self(); 
       }

       @Override
       public <P extends Passenger<?>> Sedan<P> build() {
          return new Sedan<P>(this);
       }

       @Override
       public T self() {
          return (T)this; 
       }

   } // end class Builder

   public <T extends Sedan<P>, P extends Passenger<?>> T transmission(String _trans) {
       transmission = _trans;
       return (T)this;
   }

   protected Sedan(Builder<?> builder) {
       super(builder);
       transmission = builder.transmission;
   } 


   public String toString() {
       return "this sedan has transmission = " + this.transmission + " " + super.toString();
   }


   public static void main(String[] args) {


      Fare f1 = new Fare("Lyft Limo");
      Passenger<Fare> pg1 = new Passenger.Builder<>().fare(f1).age(50).build();
      Sedan<Passenger<Fare>> sedan1 = new Sedan.Builder<>().vin(54321).engine("ev engine").transmission("auto").add_passenger(pg1).<Passenger<Fare>>build();

      System.out.println("1 - sedan1 class is " + sedan1.getClass());
      System.out.println("2 - sedan1 has " + sedan1);

      // sedan1.transmission("cvt").vin((long)246813579).engine("hybrid engine");
      sedan1 = sedan1.vin((long)246813579).engine("hybrid engine");
      System.out.println("3 - sedan1 class is " + sedan1.getClass());
      System.out.println("4 - sedan1 has " + sedan1);

      sedan1 = sedan1.transmission("cvt");
      System.out.println("5 - sedan1 class is " + sedan1.getClass());
      System.out.println("6 - sedan1 has " + sedan1);

      sedan1 = sedan1.engine("phev engine").vin((long)369246);
      System.out.println("7 - sedan1 class is " + sedan1.getClass());
      System.out.println("8 - sedan1 has " + sedan1);

   }

} // end class Sedan

