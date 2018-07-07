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


public class TeslaSedan extends Sedan { 

   private String has4wd = "not sure";
 
   public static class Builder extends Sedan.Builder {

       private String has4wd = "not sure";
 
       public Builder() {
       }

       // override
       public Builder engine(String _engine) {
           System.out.println("Call override TeslaSedan.Builder engine(String _engine)");
           super.engine(_engine);
           return self();
       }

       // override
       public Builder transmission(String _trans) {
           System.out.println("Call override TeslaSedan.Builder transmission(String _trans)");
           super.transmission(_trans);
           return self();
       }

       public Builder has4wd(String _has4wd) {
           System.out.println("Call TeslaSedan.Builder has4wd(String _has4wd)");
           has4wd = _has4wd;
           return self(); 
       }

       @Override
       public TeslaSedan build() {
          return new TeslaSedan(this);
       }

       @Override
       public Builder self() {
          return this;
       }

   } // end class Builder

   protected TeslaSedan(Builder builder) {
       super(builder);
       has4wd = builder.has4wd;
   } 

   // override
   public Sedan engine(String _engine) {
       System.out.println("Call override Sedan engine(String _engine)");
       super.engine(_engine);
       return this;
   }

   // overload
   public Sedan transmission(String _trans) {
       System.out.println("Call overload Sedan transmission(String _trans)");
       super.transmission(_trans);
       return this;
   }

   public TeslaSedan has4wd(String _has4wd) {
       System.out.println("Call TeslaSedan has4wd(String _has4wd)");
       has4wd = _has4wd;
       return this;
   }

   public String toString() {
       return "" + this.has4wd + " " + super.toString();
   }


   public static void main(String[] args) {

      Car.Builder builder1 = new TeslaSedan.Builder().vin((long)98765).engine("ev engine"); 
      System.out.println("1 - builder1 class is " + builder1.getClass());

      Sedan.Builder builder2 = ((Sedan.Builder)builder1).transmission("electric");
      System.out.println("2 - builder2 class is " + builder2.getClass());

      TeslaSedan tesla_m3_sedan1 = ((TeslaSedan.Builder)builder2).has4wd("no-4wd").build(); 
      System.out.println("3 - test builder - tesla_m3_sedan1 has " + tesla_m3_sedan1);

      tesla_m3_sedan1.vin(678);
      System.out.println("4 - test vin - tesla_m3_sedan1 has " + tesla_m3_sedan1);

      tesla_m3_sedan1.engine("gas engine");
      System.out.println("5 - test overload engine - tesla_m3_sedan1 has " + tesla_m3_sedan1);

      tesla_m3_sedan1.transmission("manual");
      System.out.println("6 - test overload transmission - tesla_m3_sedan1 has " + tesla_m3_sedan1);

   }

} // end class TeslaSedan
