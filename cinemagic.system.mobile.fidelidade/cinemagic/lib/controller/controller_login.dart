import 'package:cinemagic/repositories/ClienteRepository.dart';
import 'package:mobx/mobx.dart';
import 'package:cinemagic/helpers/extensions.dart';
part 'controller_login.g.dart';

class ControllerLogin = _ControllerLogin with _$ControllerLogin;

abstract class _ControllerLogin with Store {
  ClienteRepository _clienteRepository = ClienteRepository();
  @observable
  bool obscure = true;

  @observable
  String email;

  @observable
  String password;

  @observable
  bool loading = false;

  @action
  void setObscure(bool value) => obscure = value;

  void setEmail(String value) => email = value;

  void setPassword(String value) => password = value;

  @computed
  bool get emailValid => email != null && email.isEmailValid();
  String get emailErr {
    if (email == null || emailValid) {
      return null;
    }
    if (email.isEmpty) {
      return "Campo obrigatório";
    } else {
      return "E-mail inválido";
    }
  }

  @computed
  bool get passValid => password != null && password.length >= 6;
  String get passErr {
    if (password == null || password.length >= 6) {
      return null;
    }
    if (password.isEmpty) {
      return "Campo obrigatório";
    } else {
      return "A senha deve ser maior que 6 caracteres";
    }
  }

  @computed
  bool get fieldsValid => emailValid || passValid;
  @computed
  Function get loginPressed => fieldsValid && !loading ? _login : null;

  @action
  Future<void> _login() async {
    loading = true;
    await Future.delayed(Duration(seconds: 3));
    await _clienteRepository.login(email, password);
    loading = false;
  }
}
