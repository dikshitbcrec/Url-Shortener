package com.urlshorter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.urlshorter.Dto.URLRequestDto;
import com.urlshorter.Dto.URLResponseDto;
import com.urlshorter.service.UrlServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class UrlShortController {
	@Autowired
	private UrlServiceImpl urlService;
	
	@PostMapping("/url-shorten")
	public ResponseEntity<URLResponseDto> shortenUrl(@RequestBody URLRequestDto data,HttpServletRequest request) {
		
		return ResponseEntity.ok( urlService.shortUrl(data, request));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Void> redirect(@PathVariable("id") String id) {
		HttpHeaders headers= urlService.redirect(id);
		return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
	}
	

}
