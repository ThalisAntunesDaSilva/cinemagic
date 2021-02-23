import 'package:cinemagic/view/sessao/sessao_screen.dart';
import 'package:flutter/material.dart';
import 'package:cinemagic/app/app_widget.dart';
import 'package:cinemagic/controller/controller_home.dart';
import 'package:cinemagic/view/home/home_screen.dart';
import 'package:cinemagic/view/splash_screen.dart';
import 'package:flutter_modular/flutter_modular.dart';

class AppModule extends MainModule {
  //classes que deseja Injetar no seu projeto (ex: bloc, dependency)
  @override
  List<Bind> get binds => [
        Bind((i) => ControllerHome()), //usando bloc
      ];

  // rotas do módulo
  @override
  List<ModularRouter> get routers => [
        ModularRouter('/', child: (_, __) => SplashScreen()),
        ModularRouter('/home', child: (_, __) => HomeScreen()),
        ModularRouter('/sessao',
            child: (_, args) => SessaoScreen(
                  sessao: args.data,
                )),
      ];

  //adicione seu widget principal aqui
  @override
  Widget get bootstrap => AppWidget();
}
