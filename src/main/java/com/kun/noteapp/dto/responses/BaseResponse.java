package com.kun.noteapp.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Builder
@SuperBuilder(toBuilder = true)
public class BaseResponse {
	String message;
	String status;

}