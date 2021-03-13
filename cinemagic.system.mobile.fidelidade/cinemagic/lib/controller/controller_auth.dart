import 'package:mobx/mobx.dart';
import 'package:shared_preferences/shared_preferences.dart';
part 'controller_auth.g.dart';

class ControllerAuth = _ControllerAuth with _$ControllerAuth;

abstract class _ControllerAuth with Store {
  @observable
  String token;

  @action
  Future<void> setToken(String value) async {
    token = value;
    SharedPreferences sp = await getShared;
    sp.setString("token", value);
  }

  @computed
  Future<String> get getToken async {
    SharedPreferences sp = await getShared;
    return sp.getString("token");
  }

  @action
  Future<void> initToken() async {
    SharedPreferences sp = await getShared;
    token = sp.getString("token");
  }

  Future<SharedPreferences> get getShared async {
    SharedPreferences sp = await SharedPreferences.getInstance();
    return sp;
  }
}
