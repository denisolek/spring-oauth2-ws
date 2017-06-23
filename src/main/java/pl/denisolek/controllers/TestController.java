package pl.denisolek.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class TestController {

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	@ResponseBody
	public String ping() {
		return "pong";
	}

	@RequestMapping(value = "/api/ping", method = RequestMethod.GET)
	@ResponseBody
	public String apiPing() {
		return "apiPong";
	}

	@MessageMapping("socketmsg")
	@SendTo("/topic/socketmsg")
	public String socketmsg() throws Exception {
		return "Hello !";
	}

	@MessageMapping("principal")
	@SendTo("/topic/principal")
	public String principal(Principal principal) throws Exception {
		return "Hello !" + principal.getName();
	}

	@MessageMapping("bezpieczny")
	@SendTo("/topic/bezpieczny")
	public String bezpieczny(Principal principal) throws Exception {
		return "Hello !" + principal.getName();
	}



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody MultiValueMap<String, String> map) {
		return "OK";
	}
}
