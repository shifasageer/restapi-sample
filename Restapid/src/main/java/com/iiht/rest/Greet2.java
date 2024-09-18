package com.iiht.rest;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//API
//API2.0
//handler
@RestController
@RequestMapping("/rest/api.2.0")
public class Greet2 {
	
	@RequestMapping("/welcome")
	@GetMapping
	public ResponseEntity<String> message() {
		ResponseEntity<String> response = new ResponseEntity<>("OLA! commas ava",HttpStatus.OK);
		
		return response;
		//through constructor
	}

	@RequestMapping("/time")
	@GetMapping
	public ResponseEntity<String> getTime() {
	
		return ResponseEntity.status(HttpStatus.OK).body(Calendar.getInstance().getTime()+ "");
		
		//through static method
	}
	
	@GetMapping
	@RequestMapping("/{gender}")
	public String genderMessage(@PathVariable String gender) {
		if(gender.equals("Female")) {
			return "Welcome Miss";
			
		}
		if(gender.equals("Male")) {
			return "Welcome Mr";
		}
		else {
			return "Welcome";
		}
	}
	
	
	@GetMapping
	@RequestMapping("/namegender/{name}/{gender}")
	public ResponseEntity<String> genderMessage2(@RequestHeader HttpHeaders headers,@PathVariable String gender,@PathVariable String name) {
		Set<String> set = headers.keySet();
		Iterator<String> keys = set.iterator();
		String keyStr=null;
		while(keys.hasNext()) {
			keyStr +=keys.next()+ "\n";
			
			
			}
		
		String keyValueStr = null;
		Set<Entry<String,List<String>>> entries = headers.entrySet();
		Iterator iter2 = entries.iterator();
		
		while(iter2.hasNext()) {
			keyValueStr += iter2.next() + "\n";
;			
		}
	     HttpHeaders headers2 = new HttpHeaders();
	     headers2.setAcceptLanguageAsLocales(null);
	     Charset charset = Charset.defaultCharset();
	     List<Charset> list = new ArrayList<>();
	     
		headers2.setAcceptCharset(list);
		headers2.setContentType(MediaType.TEXT_HTML);
		headers2.setContentLength(keyValueStr.length());
		headers2.set("ust", "Gama training room 6");
		
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers2).body(keyValueStr);
	}
	
//	@PostMapping
//	@RequestMapping(value="/namegender",consumes="MediaType.APPLICATION_JSON",produces="MediaType.APPLICATION_JSON_VALUE")
//	public ResponseEntity<String> genderMessage3(@RequestBody Member member) {
//		
//		if(member.getGender().equals("Female"))
//			return ResponseEntity.ok("Welcome Miss" + member.getName());
//			
//		else if(member.getGender().equals("Male"))
//			return ResponseEntity.ok("Welcome Mr" + member.getName());
//		else
//			return ResponseEntity.ok("Welcome" + member.getName());
//		
//	}
	
//	@RequestMapping(value="/namegender", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Member> genderMessage3(@RequestBody Member member) {
//	    // TODO: Process the POST request here
//	    member.setName(member.getName() + ""); // Modify member data if needed
//
//	    // Return ResponseEntity with modified member object and HTTP status
//	    return ResponseEntity.ok(member);
//	}
//	
	
	
		

}










