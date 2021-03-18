import 'package:cinemagic/controller/controller_home.dart';
import 'package:cinemagic/view/components/custom_drawer.dart';
import 'package:cinemagic/view/filme/filme_screen.dart';
import 'package:cinemagic/view/home/utils/region_filter.dart';
import 'package:flutter/material.dart';
import 'package:flutter_mobx/flutter_mobx.dart';

class HomeScreen extends StatelessWidget {
  final ControllerHome controllerHome = new ControllerHome();
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        drawer: CustomDrawer(),
        appBar: PreferredSize(
          preferredSize: Size.fromHeight(60),
          child: Observer(builder: (_) {
            return AppBar(
              backgroundColor: Colors.transparent,
              title: controllerHome.textInput
                  ? Card(
                      shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(120)),
                      child: Padding(
                        padding: const EdgeInsets.only(left: 10),
                        child: TextFormField(
                          autofocus: controllerHome.textInput,
                        ),
                      ),
                    )
                  : Text(
                      "Cinemagic",
                      style: TextStyle(color: Colors.black),
                    ),
              centerTitle: true,
              actions: [
                controllerHome.textInput
                    ? IconButton(
                        icon: Icon(Icons.close),
                        onPressed: () {
                          controllerHome
                              .setTextInput(!controllerHome.textInput);
                        })
                    : IconButton(
                        icon: Icon(Icons.search),
                        onPressed: () {
                          controllerHome
                              .setTextInput(!controllerHome.textInput);
                        }),
              ],
            );
          }),
        ),
        body: Column(
          children: [
            RegionFilter(),
            Observer(builder: (_) {
              return Expanded(
                child: ListView.builder(
                  itemCount: controllerHome.sessoes.length,
                  itemBuilder: (context, index) {
                    return FilmeScreen(
                      sessao: controllerHome.sessoes[index],
                    );
                  },
                ),
              );
            }),
          ],
        ),
      ),
    );
  }
}
