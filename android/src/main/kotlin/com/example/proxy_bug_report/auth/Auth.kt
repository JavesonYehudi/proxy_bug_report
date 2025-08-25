package com.example.proxy_bug_report.auth

import java.util.Date
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Interface for all callbacks used with Auth0 API clients
 */
public interface Callback<T, U : Exception> {

  /**
   * Method called on success with the result.
   *
   * @param result Request result
   */
  public fun onSuccess(result: T)

  /**
   * Method called on Auth0 API request failure
   *
   * @param error The reason of the failure
   */
  public fun onFailure(error: U)
}

class Auth {
  private val serialExecutor: Executor = Executors.newSingleThreadExecutor()

  internal fun getCredentials(
    callback: Callback<Credentials, Exception>
  ) {
    serialExecutor.execute {
      val accessToken =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30"

      val credentials = Credentials(
        accessToken,
        accessToken,
        "Bearer",
        "refresh_token",
        Date(System.currentTimeMillis() + 3600 * 1000),
        "openid profile email"
      )

      callback.onSuccess(credentials)
      return@execute
    }
  }
}