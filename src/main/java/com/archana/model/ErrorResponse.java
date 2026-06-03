package com.archana.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	
	private String errorMessage;
	private Integer status;
	private LocalDateTime timestamp;

}
