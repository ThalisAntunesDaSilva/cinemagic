import 'package:cinemagic/model/CidadeModel.dart';

class CinemaModel {
  int id;
  String nome;
  CidadeModel cidade;

  CinemaModel({this.id, this.nome, this.cidade});

  factory CinemaModel.fromJson(Map doc) {
    return CinemaModel(
      id: doc['id'],
      nome: doc['nome'],
      cidade: CidadeModel.fromJson(doc['cidade']),
    );
  }
}
