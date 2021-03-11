import 'package:mobx/mobx.dart';
part 'controller_login.g.dart';

class ControllerLogin = _ControllerLogin with _$ControllerLogin;

abstract class _ControllerLogin with Store {
  @observable
  bool obscure = true;

  @action
  void setObscure(bool value) => obscure = value;
}
