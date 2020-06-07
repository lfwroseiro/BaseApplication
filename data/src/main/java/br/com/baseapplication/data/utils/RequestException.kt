package br.com.baseapplication.data.utils

import br.com.baseapplication.entity.Response

class RequestException(val error: Response.Error) : Exception()
