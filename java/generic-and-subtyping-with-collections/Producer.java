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


public class Producer {

    private String name = null;

    protected Producer() {}

    public Producer name(String nm) { this.name = nm; return self(); }
 
    public Producer self() { return this; }

    public String toString() {
    
       return "item1: " + hashCode() + " with name = " + name;

    }

    public static void main(String[] args) {

       Producer producer1 = new Producer();
       producer1 = producer1.name("Apple");
       System.out.println("1 - producer1 class is " + producer1.getClass());
       System.out.println("2 - producer1 has " + producer1);
    }

} // end class Producer
