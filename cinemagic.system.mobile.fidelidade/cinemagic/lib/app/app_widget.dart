import 'package:flutter_modular/flutter_modular.dart';
import 'package:flutter/material.dart';

class AppWidget extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Cinemagic',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.purple,
        backgroundColor: Colors.purple,
        scaffoldBackgroundColor: Colors.purple,
        visualDensity: VisualDensity.adaptivePlatformDensity,
        appBarTheme: AppBarTheme(
          elevation: 0,
        ),
      ),
      initialRoute: "/",
      navigatorKey: Modular.navigatorKey,
      //adicione o Modular para que ele possa gerenciar o sistema de rotas.
      onGenerateRoute: Modular.generateRoute,
    );
  }
}
