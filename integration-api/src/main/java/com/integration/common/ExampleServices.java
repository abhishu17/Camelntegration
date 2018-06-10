package com.integration.common;

/**
 * a Mock class to show how some other layer
 * (a persistence layer, for instance)
 * could be used insida a Camel
 * 
 */
public class ExampleServices {

    public static void example(MyBean bodyIn) {
    	System.out.println("MyBeab "+bodyIn.getName());
        bodyIn.setName( "Hello, " + bodyIn.getName() );
        bodyIn.setId(bodyIn.getId()*10);
    }
}