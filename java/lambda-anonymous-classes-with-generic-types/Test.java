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
 *
 */
import java.lang.*;
import java.util.*;
import java.util.concurrent.*;


public class Test { 


    public static interface OS {

       String get_kernel_type();
       void set_kernel_type(String type);
       Display get_display();
       void set_display(Display display);
       String show_msg(String msg);

    }

    public static abstract class MobileOS implements OS {

        public String kernel_type = "unknown";
        public Display display = null;

        public MobileOS() {}

        public String get_kernel_type() { return kernel_type; }
        public void set_kernel_type(String type) { kernel_type = type; }
       
        public Display get_display() { return this.display; }
        public void set_display(Display display) { this.display = display; }

        public String toString() { return "this MobileOS has this kernel type: " + kernel_type; }

    }

    public static class iOS extends MobileOS {

        boolean support_face_id = false;

        public iOS() {}

        public boolean is_support_face_id() { return support_face_id; }
        public void set_support_face_id(boolean flag) { support_face_id = flag; }

        public String show_msg(String msg) { return ""; };

        public String toString() { return "this iOS supports face_id = " + support_face_id; }

    }


    public static class Android extends MobileOS {

        String device_mfr = "Google";

        public Android() {}

        public String get_device_mfr() { return device_mfr; }
        public void set_device_mfr(String brand) { device_mfr = brand; }

        public String show_msg(String msg) { return ""; };

        public String toString() { return "this Android runs on this device made by: " + device_mfr; }

    } 

    public static interface Dummy {
        
        public void show_msg();
 
    }

    public static interface Display {

        public String display_msg(String msg);

    }

    public static interface Contactable<P extends Phone<M>, M extends MobileOS> {

        public P call(P phone, M os);

    }

    public static interface Invocable<U extends UnknownClass<P,M>, P extends Phone<M>, M extends MobileOS> {

        public P set(U uc, P ph);
        public P call();

    }

    public static class InvocableClass<U extends UnknownClass<P,M>, P extends Phone<M>, M extends MobileOS> implements
        Invocable<U,P,M> {

        public U uc = null;
        public P phone = null;

        public InvocableClass() {}

        @Override
        public P set(U uc1, P ph1) {
            uc = uc1;
            phone = ph1;
            System.out.println("Setting this InvocableClass has uc = " + uc + " and phone = " + phone);
            return phone;
        }
 
        @Override
        public P call() {
            System.out.println("Calling this InvocableClass has uc = " + uc + " and phone = " + phone);
            return phone;
        }

    }

    public static interface UnknownClass<P extends Phone<M>, M extends MobileOS> {

        public P set(P ph, M mdl, int cnt);
        
        public P call();

    }

    public static class KnownClass<P extends Phone<M>, M extends MobileOS> implements
        UnknownClass<P,M> {

        P phone  = null;
        M os = null;
        int count = 0;

        public KnownClass() {};

        @Override
        public P set(P ph, M mdl, int cnt) {
            phone = ph;
            os = mdl;
            count = cnt;
            System.out.println("Setting this KnownClass has: " + phone + " and OS = " + os + " with count = " + count);
            return ph;
        };

        @Override
        public P call()  {
            System.out.println("Calling this KnownClass has: " + phone + " and OS = " + os + " with count = " + count);
            return phone;
        };

    }


    public static interface Platform<P extends Phone<O>, O extends MobileOS> {

        public String set_phone_os_count(P phone, O os, int count);

    }

    public static class Phone<T extends OS> {

        String type = "unknown";
        String model = "not applicable";
        T phone_os = null;
 
        public Phone() {}
 
        public String get_type() { return type; }
        public void set_type(String brand) { type = brand; }

        public String get_model() { return model; }
        public void set_model(String m) { model = m; }

        public List<String> get_type_model() {
            List<String> l1 = new ArrayList<String>();
            l1.add(type);
            l1.add(model);
            return l1;
        }

        public void set_type_model(String m, String t) {
            type = t;
            model = m;
        }

        public T get_os() { return phone_os; }
        public void set_os(T os) { phone_os = os; }

        public String toString() { return "this Phone has type = " + type + " and model= " + model + " with phone os = " + phone_os; }

    }


    public static void main(String[] args) {

        Android android1 = new Android();              
        iOS ios1 = new iOS();              

        android1.set_kernel_type("mono");
        ios1.set_kernel_type("micro");
        android1.set_device_mfr("Samsung");
        ios1.set_support_face_id(true);

        Phone<Android> p1 = new Phone<Android>();
        Phone<iOS> p2 = new Phone<>();
  
        String samsung_name = "Samsung";
        String galaxy_name = "Galaxy 8";
        String apple_name = "Apple";
        String iphone_name = "iPhone X";
 
        p1.set_type(samsung_name);
        p1.set_model(galaxy_name);
        p2.set_type(apple_name);
        p2.set_model(iphone_name);
        p1.set_os(android1);
        p2.set_os(ios1);

        System.out.println("Phone p1 = " + p1);
        System.out.println("Phone p2 = " + p2);

        // Play with Lambda Expressions and Functional Interfaces and Anonymous Classes 
        // as Anonymous Functions with Generic Types

        // no parameter and a single expression

        Dummy d1 = 
            () -> System.out.println("No parameter single expression lambda ");
        d1.show_msg();


        // no parameter and a single body 

        Runnable r1 =
            () -> { int x=0; x++; System.out.println("No parameter and a single body with x = " + x); };
        r1.run();


        // no parameter and a single body with return type

        Callable<Integer> c1 =
            () -> { 
                int y=3; 
                System.out.println("No parameter and a single body with y = " + y);
                return y; };
        try {
            int i1 = c1.call();
            System.out.print("y = " + i1);
        } catch (Exception ex1) {
            ex1.printStackTrace();
        };


        // a single parameter with explicit type and a single expression

        Display display1 = (String m) -> "A lambda with one explicitly typed parameter " + m;
        display1.display_msg(" in a single expression"); 


        // a single parameter with inferred type and a single expression

        String msg = "A single parameter with explicit type and single lambda expression";
        Display display2 = (m) -> "This example has " + m;
        display2.display_msg(msg);

 
        // three parameters with inferred types and a single body

        int count = 10;
        String rc1 = "";
        Platform<Phone<iOS>,iOS> platform1 = (ph, os, cnt) -> { 
            ph.set_model(""+os);
            String m = "I bought " + cnt + " smart phone of the same type: " + ph;
            System.out.println("" + m);
            return m;
        };
        rc1 = platform1.set_phone_os_count(p2, ios1, count); 
	System.out.println("The return value is: " + rc1);

        Platform<Phone<Android>,Android> platform2 = (ph, os, cnt) -> {
            ph.set_model(""+os);
            String m = "I bought " + cnt + " smart phone of the same type: " + ph;
            System.out.println("" + m);
            return m;
        };
        count = 20;
        rc1 = platform2.set_phone_os_count(p1, android1, count); 
        System.out.println("The return value is: " + rc1);


        // multiple parameters with anonymous classes and generic types

        InvocableClass<UnknownClass<Phone<iOS>,iOS>,Phone<iOS>,iOS> invoke1 = 
            new InvocableClass<UnknownClass<Phone<iOS>,iOS>,Phone<iOS>,iOS>() {
 
                @Override
                public Phone<iOS> set(UnknownClass<Phone<iOS>,iOS> uc1, Phone<iOS> ph1) {
                    Phone<iOS> phone1 = super.set(uc1, ph1); 
                    phone1 = uc1.set(ph1, ios1, 1);
                    System.out.println("Setting this InvocableClass has uc1 = " + uc1 + " and phone1 = " + phone1);
                    return phone1;
                };

            };

        Phone<iOS> ph2 = invoke1.set(new UnknownClass<Phone<iOS>,iOS>() {

            Phone<iOS> phone = null;
            iOS ios = null;
            int count =  33;

            @Override
            public Phone<iOS> call() {
                phone = null;
                ios = null;
                count =  33;
                System.out.println("Calling this UnknownClass has phone = " + phone + " and OS = " + ios + " and count = " + count);
                return phone;
            };

            @Override
            public Phone<iOS> set(Phone<iOS> ph, iOS os, int cnt) {
                phone = ph;
                ios = os;
                count += cnt;
                System.out.println("Setting this UnknownClass has phone = " + phone + " and OS = " + ios + " and count = " + count);
                return ph;
            };

        }, p2);

        ph2 = invoke1.call();
        System.out.println("The return phone object is: " + ph2);

      
        // generic types with multiple parameters in an anonymous (lambda) function

        Contactable<Phone<Android>,Android> contact1 = (ph, os) -> {
            ph.set_model(""+os);
            String m = "I am phoning using a smart phone of the same type: " + ph + " with OS = " + os;
            System.out.println("" + m);
            return ph;
        };
        Phone<Android> phone1 = contact1.call(p1, android1);
        System.out.println("The return Phone object is: " + phone1);

        // generic types with multiple parameters in a function interface

        Contactable<Phone<Android>,Android> contact2 = (ph, os) -> {

            ph.set_model(""+os);
            
            String m = "I am phoning using a smart phone of the same type: " + ph + " with OS = " + os;
            System.out.println("" + m);

            Display disp1 = (String x) -> { 
               String str1 = "Who is the boss? " + x;
               System.out.println("Use functional interface and lambda with a parameter - " + str1);
               return str1;
            };
            disp1.display_msg("Google");

            return ph;

        };
        Phone<Android> phone2 = contact2.call(p1, android1);
        System.out.println("The return Phone object is: " + phone2);

    }

} 
