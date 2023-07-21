package com.lcwd.userservice.payload;

import org.springframework.http.HttpStatus;

import lombok.Builder;


@Builder(builderClassName = "Builder", toBuilder = true)
public class ApiResponse {

	private String message;

	private boolean success;

	private HttpStatus status;

	public static Builder builder() {

		return new Builder();

	}

	public static class Builder {

		private String message;

		private boolean success;

		private HttpStatus status;

		public String getMessage() {

			return message;

		}

		public void setMessage(String message) {

			this.message = message;

		}

		public boolean isSuccess() {

			return success;

		}

		public void setSuccess(boolean success) {

			this.success = success;

		}

		public HttpStatus getStatus() {

			return status;

		}

		public void setStatus(HttpStatus status) {

			this.status = status;

		}

		public Object getString() {

			return String;

		}

		public void setString(Object string) {

			String = string;

		}

		public Builder(java.lang.String message, boolean success, HttpStatus status, Object string) {

			super();

			this.message = message;

			this.success = success;

			this.status = status;

			String = string;

		}

		public Object String;

		private Builder() {

		}

		public Builder message(String message) {

			this.message = message;

			return this;

		}

		public Builder success(boolean success) {

			this.success = success;

			return this;

		}

		public Builder status(HttpStatus status) {

			this.status = status;

			return this;

		}

		public ApiResponse build() {

			return new ApiResponse();

		}

	}
}
