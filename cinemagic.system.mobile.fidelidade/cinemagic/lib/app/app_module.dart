import 'package:cinemagic/controller/controller_page.dart';
import 'package:cinemagic/view/base/base_screen.dart';
import 'package:cinemagic/view/login/login_screen.dart';
import 'package:cinemagic/view/sessao/sessao_screen.dart';
import 'package:flutter/material.dart';
import 'package:cinemagic/app/app_widget.dart';
import 'package:cinemagic/controller/controller_home.dart';
import 'package:cinemagic/view/splash_screen.dart';
import 'package:flutter_modular/flutter_modular.dart';
import "package:get_it/get_it.dart";

class AppModule extends MainModule {
  //classes que deseja Injetar no seu projeto (ex: bloc, dependency)

  void setupLocations() {
    GetIt.I.registerSingleton(ControllerPage());
  }

  @override
  List<Bind> get binds => [
        Bind((i) => ControllerHome()), //usando bloc
      ];

  // rotas do módulo
  @override
  List<ModularRouter> get routers => [
        ModularRouter('/', child: (_, __) => SplashScreen()),
        ModularRouter('/base', child: (_, __) => BaseScreen()),
        ModularRouter('/sessao',
            child: (_, args) => SessaoScreen(
                  sessao: args.data,
                )),
        ModularRouter('/login', child: (_, __) => LoginScreen()),
      ];

  //adicione seu widget principal aqui
  @override
  Widget get bootstrap => AppWidget();
}
