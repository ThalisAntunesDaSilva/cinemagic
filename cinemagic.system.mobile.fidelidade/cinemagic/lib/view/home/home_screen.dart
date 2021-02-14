import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Cinemagic"),
        centerTitle: true,
        actions: [
          IconButton(icon: Icon(Icons.search), onPressed: null),
        ],
      ),
      body: Container(),
    );
  }
}
