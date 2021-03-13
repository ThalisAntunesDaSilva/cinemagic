import 'package:cinemagic/controller/controller_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter_mobx/flutter_mobx.dart';
import 'package:flutter_modular/flutter_modular.dart';
import 'package:get_it/get_it.dart';

class CustomDrawerHeader extends StatelessWidget {
  final ControllerAuth controllerAuth = GetIt.I<ControllerAuth>();
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Modular.to.pushNamed('/login');
      },
      child: Container(
          color: Colors.purple,
          height: 95,
          padding: EdgeInsets.symmetric(horizontal: 20),
          child: Row(
            children: [
              Icon(
                Icons.person,
                color: Colors.white,
              ),
              SizedBox(
                width: 20,
              ),
              Observer(builder: (_) {
                return Expanded(
                    child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    controllerAuth.token != null
                        ? Text("Ola")
                        : (Text("Acesse sua conta agora!"))
                  ],
                ));
              })
            ],
          )),
    );
  }
}
