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


public class Buy {

    private String code = null;

    protected Buy() {}

    public Buy code(String code) { this.code = code; return self(); }
 
    public Buy self() { return this; }

    public String toString() {
    
       return "item1: " + hashCode() + " with code = " + code;

    }

    public static void main(String[] args) {

       Buy buy1 = new Buy();
       buy1 = buy1.code("UPC0001");
       System.out.println("1 - buy1 class is " + buy1.getClass());
       System.out.println("2 - buy1 has " + buy1);
    }

} // end class Buy
