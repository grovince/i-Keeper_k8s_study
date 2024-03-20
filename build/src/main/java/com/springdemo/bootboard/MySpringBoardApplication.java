package com.springdemo.bootboard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class MySpringBoardApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MySpringBoardApplication.class);
	}

	 public static void main(String[] args) {

		SpringApplication.run(MySpringBoardApplication.class, args);
	}
}
	@RestController
	class SessionController{
//--    @Value("${redis.host}")
//--    private String ip = null;

		private static String ip;

		public SessionController(@Value("${CF_INSTANCE_IP:127.0.0.1}") String ip){
			this.ip = ip;
		}

		@GetMapping("hi")
		Map uid(HttpSession session){
			UUID uid = Optional.ofNullable(UUID.class.cast(session.getAttribute("uid")))
					.orElse(UUID.randomUUID());
			session.setAttribute("uid", uid);

			Map m = new HashMap<>();
			m.put("instance_ip", this.ip);
			m.put("uuid", uid.toString());
			return m;
		}
	}