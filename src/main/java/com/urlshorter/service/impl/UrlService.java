package com.urlshorter.service.impl;

import org.springframework.http.HttpHeaders;

import com.urlshorter.Dto.URLRequestDto;
import com.urlshorter.Dto.URLResponseDto;

import jakarta.servlet.http.HttpServletRequest;

public interface UrlService {
	
	URLResponseDto shortUrl(URLRequestDto data,HttpServletRequest request);
	HttpHeaders redirect(String id);

}
