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


public class Test { 


    public static interface OS {

       String get_kernel_type();
       void set_kernel_type(String type);

    }

    public static class MobileOS implements OS {

        String kernel_type = "unknown";

        public MobileOS() {}

        public String get_kernel_type() { return kernel_type; }
        public void set_kernel_type(String type) { kernel_type = type; }
       
        public String toString() { return "this MobileOS has this kernel type: " + kernel_type; }

    }

    public static class iOS extends MobileOS {

        boolean support_face_id = false;

        public iOS() {}

        public boolean is_support_face_id() { return support_face_id; }
        public void set_support_face_id(boolean flag) { support_face_id = flag; }

        public String toString() { return "this iOS supports face_id = " + support_face_id; }

    }


    public static class Android extends MobileOS {

        String device_mfr = "Google";

        public Android() {}

        public String get_device_mfr() { return device_mfr; }
        public void set_device_mfr(String brand) { device_mfr = brand; }

        public String toString() { return "this Android runs on this device made by: " + device_mfr; }

    } 

    public static interface Dummy {
        
        public void show_msg();
 
    }

    public static interface Display {

        public String show_msg(String msg);

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

        // Play with Lambda 
       
        // no parameter and a single expression
        Dummy d1 = 
            () -> System.out.println("No parameter single expression lambda expression");

        // no parameter and a single body 
        Dummy d2 =
        () -> { int x=0; x++; System.out.println("No parameter and a single body with x = " + x); };

        // a single parameter with explicit type and a single expression
        String msg = "A single parameter with explicit type and single lambda expression";
        Display display1 = (m) -> "This example has " + m;
        display1.show_msg(msg);
 
        // three parameters with inferred types and a single body
        int count = 10;
        Platform<Phone<iOS>,iOS> platform1 = (ph, os, cnt) -> { 
            p2.set_model(""+os);
            String m = "I bought " + cnt + " smart phone of the same type: " + ph;
            System.out.println("I bought " + cnt + " smart phone: " + ph);
            return m;
        };
        platform1.set_phone_os_count(p2, ios1, count); 
          
    }

} 
