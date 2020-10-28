/*******************************************************************************
Copyright (c) 2020 IBM Corporation and others

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/
package dev.odo.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/resource")
public class SampleResource {

	static { System.out.println
("SKPIPE: 10-222-20 of class XXXX");}
    @GET
    public String getRequest() {
    	return m1();
    }
    private String m1() {
    	return m2("xy");
    }
    
    private String m2(String x) {
	String p = "I=xy";

	int i = 200;
    System.out.println(x + " " + p + i);
    System.out.println(i + p);
    System.out.println(x + " " + p + i);

    return "Hello! Welcome to Open Liberty";
    }
}
