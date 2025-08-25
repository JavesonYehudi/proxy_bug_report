import 'package:proxy_bug_report/src/pigeon_generated/credentials.pigeon.dart';

class ProxyBugReport {
  final auth = Auth();

  Future<Credentials> getCredentials() {
    return auth.getCredentials();
  }
}
