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


public class Sedan extends Car { 

   private Object transmission = "manual";
 
   public static class Builder extends Car.Builder { 

       private Object transmission = "manual";
 
       public Builder() {
       }

       // override
       public Builder vin(long _vin) {
           System.out.println("Call override Sedan.Builder vin(long _vin)");
           super.vin((int)_vin);
           return self(); 
       }

       // override
       public Builder engine(String _engine) {
           System.out.println("Call override Sedan.Builder engine(String _engine)");
           super.engine(_engine);
           return self(); 
       }

       public Builder transmission(Object _trans) {
           System.out.println("Call Sedan.Builder transmission(Object _trans)");
           transmission = _trans;
           return self(); 
       }

       @Override
       public Sedan build() {
          return new Sedan(this);
       }

       @Override
       public Builder self() {
          return this; 
       }

   } // end class Builder

   protected Sedan(Builder builder) {
       super(builder);
       transmission = builder.transmission;
   } 

   // overload
   public Car vin(long _vin) {
       System.out.println("Call overload Car vin(long _vin)");
       super.vin((int)_vin);
       return this; 
   }

   // overload 
   public Car engine(String _engine) {
       System.out.println("Call overload Car engine(String _engine)");
       super.engine(_engine); 
       return this; 
   }

   public Sedan transmission(Object _trans) {
       System.out.println("Call Sedan transmission(Object _trans)");
       transmission = _trans;
       return this; 
   }


   public String toString() {
       return "" + this.transmission + " " + super.toString();
   }


   public static void main(String[] args) {

      Car.Builder builder1 = new Sedan.Builder().vin((long)54321).engine("ev engine"); 
      System.out.println("1 - test builder - builder1 class is " + builder1.getClass());

      // Sedan.Builder builder2 = builder1;  - compile time error
      Sedan.Builder builder2 = ((Sedan.Builder)builder1); 
      System.out.println("2 - builder2 class is " + builder2.getClass());

      Sedan sedan1 = builder2.transmission("auto").build(); 
      System.out.println("3 - test builder - sedan1 has " + sedan1);

      sedan1.vin(123); 
      System.out.println("4 - test overload vin - sedan1 has " + sedan1);

      sedan1.engine(new StringBuffer("rocket booster")); 
      System.out.println("5 - test overload engine - sedan1 has " + sedan1);

      sedan1.transmission(new String("cvt")); 
      System.out.println("6 - test transmission - sedan1 has " + sedan1);

   }

} // end class Sedan

