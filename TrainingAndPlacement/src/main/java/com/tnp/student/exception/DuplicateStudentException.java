package com.tnp.student.exception;

	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY)
		public class DuplicateStudentException extends RuntimeException {

		private static final long serialVersionUID = 1L;
			public DuplicateStudentException(String message) {
				super(message);

			}
		}