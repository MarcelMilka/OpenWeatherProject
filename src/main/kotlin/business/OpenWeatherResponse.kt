package business

data class OpenWeatherResponse<T>(
    val code: Int,
    val responseMessage: String,
    val data: T?
)