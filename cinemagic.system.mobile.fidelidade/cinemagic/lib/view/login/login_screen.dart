import 'package:cinemagic/controller/controller_login.dart';
import 'package:cinemagic/view/login/components/text_common_login.dart';
import 'package:flutter/material.dart';
import 'package:flutter_mobx/flutter_mobx.dart';

class LoginScreen extends StatelessWidget {
  final ControllerLogin controllerLogin = ControllerLogin();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Entrar"),
        centerTitle: true,
      ),
      body: Container(
        alignment: Alignment.center,
        child: SingleChildScrollView(
          child: Card(
            shape:
                RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
            elevation: 0,
            margin: EdgeInsets.symmetric(horizontal: 32),
            child: Padding(
              padding: EdgeInsets.all(16),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.stretch,
                mainAxisSize: MainAxisSize.min,
                children: [
                  Text(
                    "Acessar com e-mail",
                    textAlign: TextAlign.center,
                    style: TextStyle(fontSize: 16, color: Colors.grey[900]),
                  ),
                  TextCommonLogin(
                    title: "E-mail",
                  ),
                  TextField(
                    decoration: InputDecoration(
                      border: OutlineInputBorder(),
                      isDense: true,
                    ),
                    keyboardType: TextInputType.emailAddress,
                  ),
                  SizedBox(
                    height: 16,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      TextCommonLogin(
                        title: "Senha",
                      ),
                      GestureDetector(
                        onTap: () {},
                        child: Text(
                          "Esqueceu sua senha?",
                          style: TextStyle(
                            decoration: TextDecoration.underline,
                            color: Colors.purple,
                          ),
                        ),
                      ),
                    ],
                  ),
                  Observer(builder: (_) {
                    return TextField(
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        isDense: true,
                        suffixIcon: !controllerLogin.obscure
                            ? IconButton(
                                icon: Icon(Icons.lock_open),
                                onPressed: () {
                                  controllerLogin
                                      .setObscure(!controllerLogin.obscure);
                                })
                            : IconButton(
                                onPressed: () {
                                  controllerLogin
                                      .setObscure(!controllerLogin.obscure);
                                },
                                icon: Icon(Icons.lock),
                              ),
                      ),
                      keyboardType: TextInputType.text,
                      obscureText: controllerLogin.obscure,
                    );
                  })
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
