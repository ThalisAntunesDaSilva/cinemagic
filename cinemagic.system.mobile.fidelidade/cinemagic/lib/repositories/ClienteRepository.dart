import 'package:cinemagic/controller/controller_auth.dart';
import 'package:cinemagic/helpers/end_points.dart';
import 'package:cinemagic/model/ClienteModel.dart';
import 'package:cinemagic/model/LoginModel.dart';
import 'package:dio/dio.dart';
import 'package:get_it/get_it.dart';
import 'package:jwt_decoder/jwt_decoder.dart';
import 'package:shared_preferences/shared_preferences.dart';

class ClienteRepository {
  final ControllerAuth controllerAuth = GetIt.I<ControllerAuth>();
  Future<ClienteModel> login(String email, String password) async {
    LoginModel login = LoginModel(email: email, password: password);
    Response response = await Dio().post(API + LOGIN, data: login.toMap());
    String token = response.headers.value("authorization");
    Map<String, dynamic> decoded = JwtDecoder.decode(token.substring(7));
    String emailDecoded = decoded['sub'];
    Response clienteResponse = await Dio().get(
      API + CLIENTES,
      queryParameters: <String, dynamic>{'email': emailDecoded},
      options: Options(headers: <String, dynamic>{'authorization': token}),
    );
    controllerAuth.setToken(token);
    return ClienteModel.fromJson(clienteResponse.data);
  }
}
