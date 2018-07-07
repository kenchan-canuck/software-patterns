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
 * Author and Developer: Ken Chan
 * Organization: Timeleap Inc.
 * Website: https://www.timeleap.com
 * Location: Toronto, Ontario, Canada
 * Email: ken@timeleap.com
 * Date Created: July 1, 2018 (Canada National Day)
 *
 */
import java.util.*;

public class Sedan extends Car { 

   protected String transmission = "not sure"; 
 

   public Sedan() {
   } 

   public Sedan transmission(String _trans) {
       transmission = _trans;
       return this;
   }

   public String toString() {
       return "" + this.vin + " " + this.engine + " " + this.transmission;
   }


   public static void main(String[] args) {

      Car car1 = new Sedan();
      Sedan sedan1 = (Sedan)car1;
      System.out.println("car1 class is " + car1.getClass());

      Car car2 = sedan1.vin(12345).engine("gas engine");
      System.out.println("car2 class is " + car2.getClass());

      Car car3 = ((Sedan)car2).transmission("manual");
      System.out.println("car3 class is " + car3.getClass());
      System.out.println("car3 has " + car3);

      Sedan sedan2 = (Sedan)car3.vin(54321).engine("ev engine");
      System.out.println("sedan2 class is " + sedan2.getClass());
      System.out.println("sedan2 has " + sedan2);

      Sedan sedan3 = sedan2.transmission("auto");
      System.out.println("sedan3 class is " + sedan3.getClass());
      System.out.println("sedan3 has " + sedan3);

   }

} // end class Sedan

