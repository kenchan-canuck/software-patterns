import java.lang.*;
import java.util.*;


public class Test {

    public static class A1<T extends Object> {

        public T composite = null;

        public T get() { return composite; }

        public boolean hasCompositeAs(T obj) { return composite.equals(obj); }

        @Override
        public String toString() { return "This A1 has: " + composite; }
  
    }

    public static class B1 extends C1 {

        @Override
        public String toString() { return "This B1 has: " + hashCode(); }
  
    }

    public static class C1 {

        @Override
        public String toString() { return "This C1 has: " + hashCode(); }

    }

    public static class D1<T extends B1> {


        public T composite = null;

        public T get() { return composite; }

        public boolean hasCompositeAs(T obj) { return composite.equals(obj); }
  
        @Override
        public String toString() { return "This D1 has: " + composite; }
  
    }

    public static class E1<T extends C1> {

        public T composite = null;

        public T get() { return composite; }

        public boolean hasCompositeAs(T obj) { return composite.equals(obj); }
  
        public String toString() { return "This E1 has: " + composite; }
  
    } 

    public static class F1<T extends D1<U>, U extends B1> extends A1<T> {

        public boolean hasCompositeAs(T obj) { return composite.equals(obj); }
  
        @Override
        public String toString() { return "This F1 has: " + composite; }
  
    } 

    public static void main(String[] args) {

        Map<String,Integer> hmap1 = new HashMap<String,Integer>() {
            {
                 put("one", 1); 
                 put("two", 2); 
                 put("three", 3); 
                 put("four", 4); 
            }
        };

        A1<D1<B1>> a1 = new A1<>();
        B1 b1 = new B1();
        C1 c1 = new C1();
        D1<B1> d1 = new D1<>();
	E1<B1> e1 = new E1<>();
	E1<C1> e2 = new E1<>();
        A1<B1> a2 = new A1<>();
        F1<D1<B1>,B1> f1 = new F1<>();

        a1.composite = d1;
        a2.composite = b1;
        d1.composite = b1;
        e1.composite = b1;
        e2.composite = c1;
        f1.composite = d1;
        
        System.out.println("a1 has: " + a1);
        System.out.println("a2 has: " + a2);
        System.out.println("d1 has: " + d1);
        System.out.println("e1 has: " + e1);
        System.out.println("e2 has: " + e2);
        System.out.println("f1 has: " + f1);

        System.out.println("a1.composite and f1.composite are the same:  " + a1.hasCompositeAs(f1.composite)); 
        System.out.println("f1.composite and d1 are the same: " + f1.hasCompositeAs(d1)); 
        System.out.println("Initialized hmap1 has: " + hmap1);

    }

}

