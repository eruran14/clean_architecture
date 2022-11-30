package com.eru.clean_architecture.data.base
import com.eru.clean_architecture.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            val data = request()
            emit(Resource.Success(data))
        } catch (e: java.io.IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Неизвестная ошибка"))
        }
    }.flowOn(Dispatchers.IO)
}