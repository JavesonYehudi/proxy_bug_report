import 'package:pigeon/pigeon.dart';

@ConfigurePigeon(
  PigeonOptions(
    dartOut: 'lib/src/pigeon_generated/credentials.pigeon.dart',
    kotlinOut:
        'android/src/main/kotlin/com/example/proxy_bug_report/generated/CredentialsApi.g.kt',
    dartPackageName: 'com.example.proxy_bug_report',
  ),
)
@ProxyApi(
  kotlinOptions: KotlinProxyApiOptions(
    fullClassName: 'com.example.proxy_bug_report.Auth',
  ),
)
abstract class Auth {
  Auth();

  @async
  Credentials login();
}

@ProxyApi(
  kotlinOptions: KotlinProxyApiOptions(
    fullClassName: 'com.example.proxy_bug_report.Credentials',
  ),
)
abstract class Credentials {
  late final String accessToken;
}
