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

public class Test {

    public static class C1<T1 extends B1<T2,T3>, T2 extends A1<T3>, T3 extends Comparable<?>> {

        public T1 collect = null;

        public C1() {}

        // public <T1 extends B1<T2,T3>, T2 extends A1<T3>, T3 extends Comparable<?>> T1 set(T1 col) { - compile errors
        // public C1<T1,T2,T3> set(T1 col) { - compile errors
        public T1 set(T1 col) {
       
            this.collect = col;
            return col;
        } 

        public String toString() {

            return "\nThis instance of C1 contains collect: " + collect;

        }

    }

    public static class B1<T2 extends A1<T3>, T3 extends Comparable<?>> {

        public T2 list = null;

        public B1() {}

        // public <T2 extends A1<T3>, T3 extends Comparable<?>> B1 set(T2 list) {  - compile errors
        public T2 set(T2 list) {
 
            this.list = list;
            // return (T2)(new A1<T3>()); - compile errors
            return list;
      
        } 

        public String toString() {

            return "\nThis instance of B1 has list: " + list;

        }

    }

    @SuppressWarnings("unchecked")
    public static class A1<T3 extends Comparable<?>> {

        public int value = 0;

        public A1() {}

        public <T3 extends Comparable<?>> T3 set(int val) {
        
            this.value = val;
            return (T3)("value = " + val);

        } 

        public String toString() {

            return "\nThis instance of A1 has value: " + value;

        }

    }

    
    public static void main(String[] args) {

        // C1<B1<A1<T3>>> = C1<B1<A1<T3>,T3>,A1<T3>,T3>

        List<C1<B1<A1<String>,String>,A1<String>,String>> list1 = 
            new ArrayList<C1<B1<A1<String>,String>,A1<String>,String>>();

        // String t3 = "generic is wild";
        A1<String> a1 = new A1<String>();
        String sa1 = a1.set(256);
        B1<A1<String>,String> b1 = new B1<A1<String>,String>();
        A1<String> a2 = b1.set(a1);
        C1<B1<A1<String>,String>,A1<String>,String> c1 = new C1<B1<A1<String>,String>,A1<String>,String>(); 
        b1 = c1.set(b1);

        System.out.println("c1 class is " + c1.getClass()); 
        System.out.println("c1 contains " + c1); 

        list1.add(c1);
        System.out.println("list1 contains " + list1); 

    }

} // end class Test
