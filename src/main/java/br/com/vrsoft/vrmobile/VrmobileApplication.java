package br.com.vrsoft.vrmobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.net.InetAddress;
import java.util.Collections;

@SpringBootApplication
@PropertySource(value = "file:///vr/vr.properties")
public class VrmobileApplication {
	@Autowired
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		try {
			SpringApplicationBuilder builder = new SpringApplicationBuilder(VrmobileApplication.class);

			builder.properties(Collections.singletonMap("server.port", 9010));

			context = builder.run(args);
			
			System.out.println("IP: " + InetAddress.getLocalHost().getHostAddress());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
