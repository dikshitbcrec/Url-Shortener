package com.urlshorter.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "urls")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UrlEntity {
	@Id
	private String id;
	private String url;
	
//	@Indexed(expireAfterSeconds = 0)
	private LocalDateTime expireAt;
}
