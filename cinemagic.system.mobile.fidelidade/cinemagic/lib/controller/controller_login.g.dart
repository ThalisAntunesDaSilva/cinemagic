// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'controller_login.dart';

// **************************************************************************
// StoreGenerator
// **************************************************************************

// ignore_for_file: non_constant_identifier_names, unnecessary_brace_in_string_interps, unnecessary_lambdas, prefer_expression_function_bodies, lines_longer_than_80_chars, avoid_as, avoid_annotating_with_dynamic

mixin _$ControllerLogin on _ControllerLogin, Store {
  Computed<bool> _$emailValidComputed;

  @override
  bool get emailValid =>
      (_$emailValidComputed ??= Computed<bool>(() => super.emailValid,
              name: '_ControllerLogin.emailValid'))
          .value;
  Computed<bool> _$passValidComputed;

  @override
  bool get passValid =>
      (_$passValidComputed ??= Computed<bool>(() => super.passValid,
              name: '_ControllerLogin.passValid'))
          .value;
  Computed<bool> _$fieldsValidComputed;

  @override
  bool get fieldsValid =>
      (_$fieldsValidComputed ??= Computed<bool>(() => super.fieldsValid,
              name: '_ControllerLogin.fieldsValid'))
          .value;
  Computed<Function> _$loginPressedComputed;

  @override
  Function get loginPressed =>
      (_$loginPressedComputed ??= Computed<Function>(() => super.loginPressed,
              name: '_ControllerLogin.loginPressed'))
          .value;

  final _$obscureAtom = Atom(name: '_ControllerLogin.obscure');

  @override
  bool get obscure {
    _$obscureAtom.reportRead();
    return super.obscure;
  }

  @override
  set obscure(bool value) {
    _$obscureAtom.reportWrite(value, super.obscure, () {
      super.obscure = value;
    });
  }

  final _$emailAtom = Atom(name: '_ControllerLogin.email');

  @override
  String get email {
    _$emailAtom.reportRead();
    return super.email;
  }

  @override
  set email(String value) {
    _$emailAtom.reportWrite(value, super.email, () {
      super.email = value;
    });
  }

  final _$passwordAtom = Atom(name: '_ControllerLogin.password');

  @override
  String get password {
    _$passwordAtom.reportRead();
    return super.password;
  }

  @override
  set password(String value) {
    _$passwordAtom.reportWrite(value, super.password, () {
      super.password = value;
    });
  }

  final _$loadingAtom = Atom(name: '_ControllerLogin.loading');

  @override
  bool get loading {
    _$loadingAtom.reportRead();
    return super.loading;
  }

  @override
  set loading(bool value) {
    _$loadingAtom.reportWrite(value, super.loading, () {
      super.loading = value;
    });
  }

  final _$_loginAsyncAction = AsyncAction('_ControllerLogin._login');

  @override
  Future<void> _login() {
    return _$_loginAsyncAction.run(() => super._login());
  }

  final _$_ControllerLoginActionController =
      ActionController(name: '_ControllerLogin');

  @override
  void setObscure(bool value) {
    final _$actionInfo = _$_ControllerLoginActionController.startAction(
        name: '_ControllerLogin.setObscure');
    try {
      return super.setObscure(value);
    } finally {
      _$_ControllerLoginActionController.endAction(_$actionInfo);
    }
  }

  @override
  String toString() {
    return '''
obscure: ${obscure},
email: ${email},
password: ${password},
loading: ${loading},
emailValid: ${emailValid},
passValid: ${passValid},
fieldsValid: ${fieldsValid},
loginPressed: ${loginPressed}
    ''';
  }
}
