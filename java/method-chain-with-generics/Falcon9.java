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

public class Falcon9<T extends Falcon9<T>> extends Rocket<T> {

    private int landing_status = 0;

    protected Falcon9() { super(); }

    public T landing() { landing_status++; return self(); }

    @SuppressWarnings("unchecked") 
    public T self() { return (T)this; }

    public String toString() {

       return "" + super.toString() + " " + landing_status;
    }

    public static void main(String[] args) {

       // Falcon9 falcon1 = new Falcon9<>();
       Falcon9<?> falcon1 = new Falcon9<>();
       System.out.println("1 - falcon1 class is " + falcon1.getClass());
       System.out.println("2 - falcon1 = " + falcon1);

       falcon1.self().landing().launch().launch().reentry().reentry().landing().landing().landing();
       System.out.println("3 - falcon1 = " + falcon1);
    }

} // end class Falcon9

