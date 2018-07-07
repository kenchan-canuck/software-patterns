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


public class ToyotaSedan extends Sedan { 

   private String has4wd = "not sure";
 
   public static class Builder extends Sedan.Builder {

       private String has4wd = "not sure";
 
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

       @Override
       public Builder transmission(String _trans) {
           super.transmission(_trans);
           return self();
       }

       public Builder has4wd(String _has4wd) {
           has4wd = _has4wd;
           return self(); 
       }

       @Override
       public ToyotaSedan build() {
          return new ToyotaSedan(this);
       }

       @Override
       public Builder self() {
          return this;
       }

   } // end class Builder

   protected ToyotaSedan(Builder builder) {
       super(builder);
       has4wd = builder.has4wd;
   } 


   public String toString() {
       return "" + this.has4wd + " " + super.toString();
   }


   public static void main(String[] args) {

      ToyotaSedan toyota_camry_sedan1 = new ToyotaSedan.Builder().vin(98765).engine("hybrid engine").transmission("auto").has4wd("no-4wd").build(); 
      System.out.println("1- toyota_camry_sedan1 has " + toyota_camry_sedan1);

   }

} // end class ToyotaSedan
