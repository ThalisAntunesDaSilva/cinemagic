import 'package:cinemagic/model/PaisModel.dart';

class EstadoModel {
  int id;
  String nome;
  String uf;
  PaisModel pais;

  EstadoModel({this.id, this.nome, this.uf, this.pais});

  factory EstadoModel.fromJson(Map doc) {
    return EstadoModel(
        id: doc['id'],
        nome: doc['nome'],
        uf: doc['uf'],
        pais: PaisModel.fromJson(doc['pais']));
  }
}
