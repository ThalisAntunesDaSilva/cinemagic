import 'package:cinemagic/app/app_module.dart';
import 'package:cinemagic/controller/controller_auth.dart';
import 'package:cinemagic/controller/controller_page.dart';
import 'package:flutter/material.dart';
import 'package:flutter_modular/flutter_modular.dart';
import 'package:get_it/get_it.dart';
import 'package:shared_preferences/shared_preferences.dart';

void main() {
  setupLocations();

  runApp(ModularApp(
    module: AppModule(),
  ));
  GetIt.I<ControllerAuth>().initToken();
}

void setupLocations() {
  GetIt.I.registerSingleton(ControllerPage());
  GetIt.I.registerSingleton(ControllerAuth());
}
