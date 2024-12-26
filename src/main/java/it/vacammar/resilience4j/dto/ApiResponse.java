package it.vacammar.resilience4j.dto;

public class ApiResponse<D> {

    private D data;
    private String message;
    private boolean success;

    public ApiResponse() {
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

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


    public static final class Builder<D> {
        private ApiResponse apiResponse;

        private Builder() {
            apiResponse = new ApiResponse();
        }

        public static Builder anApiResponse() {
            return new Builder();
        }

        public Builder withData(D data) {
            apiResponse.setData(data);
            return this;
        }

        public Builder withMessage(String message) {
            apiResponse.setMessage(message);
            return this;
        }

        public Builder withSuccess(boolean success) {
            apiResponse.setSuccess(success);
            return this;
        }

        public ApiResponse build() {
            return apiResponse;
        }
    }
}
