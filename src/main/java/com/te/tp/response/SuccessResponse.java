package com.te.tp.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SuccessResponse {
	private String message;
	private Object data;
	private HttpStatus status;
	private LocalDateTime timestamp;

}
