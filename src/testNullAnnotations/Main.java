/******************************************************************************
 * Copyright (c) 2015 Ericsson
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package testNullAnnotations;

import java.util.Collections;
import java.util.List;

public class Main {
    
    static class A {
        
    }
    
    static class B extends A {
        
    }
    
    static void foo(List<A> param) {
        
    }

    public static void main(String[] args) {
        B b = new B();
        foo(Collections.singletonList(b));
    }

}
