/**
 * 
 */
package it.nmadlk.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Navo
 *
 */
@RestController
public class DisplayController {
	
	@RequestMapping("/description")
	public String displayDescription() {
		return "Automobile Spare Parts Reseller/Vendor";
	}

}
