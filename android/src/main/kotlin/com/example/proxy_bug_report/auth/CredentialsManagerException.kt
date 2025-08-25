package com.example.proxy_bug_report.auth

public class CredentialsManagerException {

  internal enum class Code {
    INVALID_CREDENTIALS,
    NO_CREDENTIALS,
    NO_REFRESH_TOKEN,
    RENEW_FAILED,
    STORE_FAILED,
    REVOKE_FAILED,
    LARGE_MIN_TTL,
    NO_NETWORK,
    API_ERROR,
    SSO_EXCHANGE_FAILED,
    UNKNOWN_ERROR
  }
}