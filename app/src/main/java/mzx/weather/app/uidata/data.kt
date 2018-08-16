package mzx.weather.app.uidata

sealed class DataUI

object Initial : DataUI()
object ErrorData : DataUI()
object Loading : DataUI()
class Response<T> constructor(val respponse: T) : DataUI()
