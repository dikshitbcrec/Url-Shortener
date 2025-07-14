package com.urlshorter.service;

import java.net.URI;
import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.urlshorter.Dto.URLRequestDto;
import com.urlshorter.Dto.URLResponseDto;
import com.urlshorter.entities.UrlEntity;
import com.urlshorter.exception.NotFoundException;
import com.urlshorter.repositories.UrlShortRepository;
import com.urlshorter.service.impl.UrlService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UrlServiceImpl implements UrlService {

	@Autowired
	private UrlShortRepository shortRepository;
	
	
	@Override
	public URLResponseDto shortUrl(URLRequestDto data, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String id;
		do {
			id = RandomStringUtils.randomAlphanumeric(5, 10);
		}while(shortRepository.existsById(id));
		
		shortRepository.save(new UrlEntity(id,data.url(),LocalDateTime.now().plusMinutes(1)));
		String redirectUrl = request.getRequestURL().toString().replace("url-shorten", id);
		
		return new URLResponseDto(data.url(), redirectUrl);
	}

	@Override
	public HttpHeaders redirect(String id) {
		UrlEntity url = shortRepository.findById(id).orElseThrow(()->new NotFoundException("Short URL not found"));
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(url.getUrl()));
		return headers;
	}

}
