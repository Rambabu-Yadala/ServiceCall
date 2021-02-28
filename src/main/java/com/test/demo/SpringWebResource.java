/**
 * 
 */
package com.test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jani basha shaik
 *
 */
@RestController
public class SpringWebResource {
	@Autowired
	DemoService demoService;
	
	@GetMapping("/getService")
	public String getServiceDetails() {
		return "Hellos";
	}
	
	@GetMapping("/getSpecifiedService")
	public String getSpecifiedService() {
		return demoService.getResponseForService();
	}
	
}
