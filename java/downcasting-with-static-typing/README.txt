Purpose
=======
    These files contain sample java codes with java classes and
interfaces that illustrate the application of downcasting to inform
the compiler of the actual type of subclass object. This way, 
the compiler may allow the type conversion at compile-time and 
can delegate the type checking of the type cast to the run-time.

    Without the casting, the compiler would not know the actual type. 
As a result, the code would fail the structural type checking since
the compiler would not be able to apply the type substitution to verify
the class of the object.


Contact Information
===================
Author and Developer: Ken Chan
Organization: Timeleap Inc.
Location: Toronto, Ontario, Canada
Website: https://www.timeleap.com
Email: ken@timeleap.com
Date Created: July 1, 2018 (Canada National Day)


Requirements
============
. Java >= 1.8 (OpenJDK and Oracle JVMS have been tested)


Getting started
===============

1. javac -Xlint *.java (to view all the warnings as well)

2. java <One of the Class names>



