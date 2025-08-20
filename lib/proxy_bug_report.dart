import 'package:proxy_bug_report/src/pigeon_generated/credentials.pigeon.dart';

class ProxyBugReport {
  final auth = Auth();

  Future<Credentials> getPlatformVersion() {
    return auth.login();
  }
}
