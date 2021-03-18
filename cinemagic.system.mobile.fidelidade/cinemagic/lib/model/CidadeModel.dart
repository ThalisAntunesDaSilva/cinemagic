import 'package:cinemagic/model/EstadoModel.dart';

class CidadeModel {
  int id;
  String nome;
  EstadoModel estado;

  CidadeModel({this.id, this.nome, this.estado});

  factory CidadeModel.fromJson(Map doc) {
    return CidadeModel(
        id: doc['id'],
        nome: doc['nome'],
        estado: EstadoModel.fromJson(doc['estado']));
  }
}
