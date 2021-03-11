import 'package:cinemagic/app/app_module.dart';
import 'package:cinemagic/controller/controller_page.dart';
import 'package:flutter/material.dart';
import 'package:flutter_modular/flutter_modular.dart';
import 'package:get_it/get_it.dart';

void main() {
  setupLocations();
  runApp(ModularApp(
    module: AppModule(),
  ));
}

void setupLocations() {
  GetIt.I.registerSingleton(ControllerPage());
}
