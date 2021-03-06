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

   private String transmission = "manual";
 
   public static class Builder extends Car.Builder { 

       private String transmission = "manual";
 
       public Builder() {
       }

       @Override
       public Builder vin(long _vin) {
           super.vin(_vin);
           return self(); 
       }

       @Override
       public Builder engine(String _engine) {
           super.engine(_engine);
           return self(); 
       }

       public Builder transmission(String _trans) {
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


   public String toString() {
       return "" + this.transmission + " " + super.toString();
   }


   public static void main(String[] args) {

      Sedan sedan1 = new Sedan.Builder().vin(54321).engine("ev engine").transmission("auto").build(); 
      System.out.println("1- sedan1 has " + sedan1);

   }

} // end class Sedan

