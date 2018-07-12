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


// This test case is to compare the static nested class builder versus
// inner class builder using nested subtypes

public class Test { 

    public static class A1 {

        public String prop1 = "";

        public A1() {};

        public String toString() {
            return "this A1 has prop = " + this.prop1;
        }

    } // end class A1

    public static class B1<T extends A1> extends A1 { 

        public T prop2 = null;

        public B1() {};

        public String toString() {
            return "this B1 has prop1 = " + this.prop1 + " and prop2 = " + this.prop2;
        }

    } // end class B1

    public static class C1<U1 extends B1<U2>, U2 extends A1> extends B1<U2> { 

        private String f1 = "";
        private U1 f2 = null;
        private U2 f3 = null;

        // static nested class builder 
        public static class NestedBuilder<T1 extends NestedBuilder<T1,T2,T3>, T2 extends B1<T3>, T3 extends A1> {

            private String f1 = "";
            private T2 f2 = null;
            private T3 f3 = null;
 
            public NestedBuilder() { } 

            public NestedBuilder<T1,T2,T3> set_f1(String _f1) {
                f1 = _f1;
                return self(); 
            }

            public NestedBuilder<T1,T2,T3> set_f2(T2 _f2) {
                f2 = _f2;
                return self(); 
            }

            public NestedBuilder<T1,T2,T3> set_f3(T3 _f3) {
                f3 = _f3;
                return self(); 
            }

            public C1 build() { return new C1(this); }

            public NestedBuilder<T1,T2,T3> self() { return this; }

        } // end class C1 NestedBuilder

        // non-static nested class (inner class) builder 
        public class InnerBuilder<T1 extends InnerBuilder<T1>> {

            // shadow fields
            private String f1 = "";
            private U1 f2 = null;
            private U2 f3 = null;

            public InnerBuilder() {} 

            public T1 set_f1(String _f1) {
                f1 = _f1;
                return self(); 
            }

            public <X1 extends B1<A1>> T1 set_f2(X1 _f2) {
                f2 = (U1)_f2;
                return self(); 
            }

            public <X2 extends A1> T1 set_f3(X2 _f3) {
                f3 = (U2)_f3;
                return self(); 
            }

            public C1 build() { return new C1(this); }

            public T1 self() { return (T1)this; }

        } // end class C1 InnerBuilder

        private C1(NestedBuilder<?,?,?> builder) {
            f1 = builder.f1;
            f2 = (U1)builder.f2;
            f3 = (U2)builder.f3;
        } 

        private C1(InnerBuilder<?> builder) {
            f1 = builder.f1;
            f2 = builder.f2;
            f3 = builder.f3;
        } 

        public C1() {}

        public String toString() {
            return "this C1 has f1 of String = " + this.f1 + " and f2 of B1 = " + this.f2 + " and f3 of A1 = " + f3;
        }


    } // end class C1


    public static void main(String[] args) {

        A1 a1 = new A1();
        a1.prop1 = "alpha";
        B1<A1> b1 = new B1<>();
        b1.prop1 = "beta";
        b1.prop2 = a1;

        C1<B1<A1>,A1> inst1 = new C1.NestedBuilder<>().set_f1("Nested builder pattern is better")
                                                      .set_f2(b1)
                                                      .set_f3(a1)
                                                      .build();

        System.out.println("inst1 has: " + inst1);

        C1<B1<A1>,A1> inst2 = new C1<>();
        C1<B1<A1>,A1>.InnerBuilder<?> inner_builder1 = inst2.new InnerBuilder<>();
        inst2 = inner_builder1.set_f1("Inner builder pattern is interesting")
                                                     .set_f2(b1)
                                                     .set_f3(a1)
                                                     .build();

        System.out.println("inst2 has: " + inst2);

    }


} // end class Test

