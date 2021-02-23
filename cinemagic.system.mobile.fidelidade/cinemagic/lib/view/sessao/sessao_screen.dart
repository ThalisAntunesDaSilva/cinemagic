import 'package:cinemagic/model/SessaoModel.dart';
import 'package:flutter/material.dart';

class SessaoScreen extends StatelessWidget {
  SessaoScreen({this.sessao});
  final SessaoModel sessao;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.transparent,
        title: Text("${sessao.filme.titulo}"),
        centerTitle: true,
      ),
      body: Container(),
    );
  }
}
