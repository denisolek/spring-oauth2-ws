package pl.denisolek.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody MultiValueMap<String, String> map) {
		return "OK";
	}
}
