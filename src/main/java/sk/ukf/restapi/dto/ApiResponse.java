package sk.ukf.restapi.dto;

import java.time.OffsetDateTime;
import java.time.ZoneId;

public class ApiResponse<T> {
    private String message;
    private T data;

    private OffsetDateTime datetime;

    public ApiResponse(T data, String message) {
        this.data = data;
        this.message = message;
        this.datetime = OffsetDateTime.now(ZoneId.of("Europe/Bratislava"));
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, null);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(data, message);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(null, message);
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public OffsetDateTime getDatetime() { return datetime; }
    public void setDatetime(OffsetDateTime datetime) { this.datetime = datetime; }
}
