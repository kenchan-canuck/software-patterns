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
import java.util.*;

public class Car { 

   protected long vin = 0;
   protected String engine = "engine";

   public Car() {
   } 

   public Car vin(long _vin) {
       vin = _vin;
       return this;
   }

   public Car engine(String _engine) {
       engine = _engine;
       return this;
   }

   public String toString() {
       return "" + this.vin + " " + this.engine;
   }


   public static void main(String[] args) {

      Car car1 = new Car().vin(12345).engine("gas engine");

      System.out.println("car1 has " + car1);
   }

} // end class Car

