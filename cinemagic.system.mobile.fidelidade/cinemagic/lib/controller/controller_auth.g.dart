// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'controller_auth.dart';

// **************************************************************************
// StoreGenerator
// **************************************************************************

// ignore_for_file: non_constant_identifier_names, unnecessary_brace_in_string_interps, unnecessary_lambdas, prefer_expression_function_bodies, lines_longer_than_80_chars, avoid_as, avoid_annotating_with_dynamic

mixin _$ControllerAuth on _ControllerAuth, Store {
  Computed<Future<String>> _$getTokenComputed;

  @override
  Future<String> get getToken =>
      (_$getTokenComputed ??= Computed<Future<String>>(() => super.getToken,
              name: '_ControllerAuth.getToken'))
          .value;

  final _$tokenAtom = Atom(name: '_ControllerAuth.token');

  @override
  String get token {
    _$tokenAtom.reportRead();
    return super.token;
  }

  @override
  set token(String value) {
    _$tokenAtom.reportWrite(value, super.token, () {
      super.token = value;
    });
  }

  final _$setTokenAsyncAction = AsyncAction('_ControllerAuth.setToken');

  @override
  Future<void> setToken(String value) {
    return _$setTokenAsyncAction.run(() => super.setToken(value));
  }

  final _$initTokenAsyncAction = AsyncAction('_ControllerAuth.initToken');

  @override
  Future<void> initToken() {
    return _$initTokenAsyncAction.run(() => super.initToken());
  }

  @override
  String toString() {
    return '''
token: ${token},
getToken: ${getToken}
    ''';
  }
}
