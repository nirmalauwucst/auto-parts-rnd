/**
 * 
 */
package it.nmadlk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Navo
 *
 */

@SpringBootApplication
public class AutoPartsLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AutoPartsLauncher.class, args);
	}

}
