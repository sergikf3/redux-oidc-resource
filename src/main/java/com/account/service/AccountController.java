package com.account.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

class Message {

	String id;
	String title;
	String description;
	String thumbnail;

	public Message(String id, String title, String description, String thumbnail) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

}

@CrossOrigin(origins = { "https://localhost:8080", "http://localhost:8080" }, maxAge = 3600)
@RestController
public class AccountController {
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@RequestMapping(value = "/userdata", method = RequestMethod.GET)
	public ResponseEntity<Object> getUserData(Principal principal) {
		Message message1 = new Message("1", principal.getName(), "description1", "userdata1");
		Message message2 = new Message("2", principal.getName(), "description2", "userdata2");
		List<Message> result = new ArrayList<Message>();
		result.add(message1);
		result.add(message2);

		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@RequestMapping(value = "/legacydata", method = RequestMethod.GET)
	public ResponseEntity<Object> getLegacyData(Principal principal) {
		Message message1 = new Message("1", principal.getName(), "description1", "legacydata1");
		Message message2 = new Message("2", principal.getName(), "description2", "legacydata2");
		List<Message> result = new ArrayList<Message>();
		result.add(message1);
		result.add(message2);

		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

}
