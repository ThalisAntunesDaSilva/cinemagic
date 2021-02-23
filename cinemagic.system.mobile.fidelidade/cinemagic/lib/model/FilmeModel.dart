import 'package:cinemagic/model/GeneroModel.dart';

class FilmeModel {
  FilmeModel({this.id, this.titulo, this.duracao, this.pathImage, this.genero});
  int id;
  String titulo;
  String duracao;
  String pathImage;
  GeneroModel genero;

  factory FilmeModel.fromJson(Map doc) {
    return FilmeModel(
        id: doc['id'],
        titulo: doc['titulo'],
        duracao: doc['duracao'],
        pathImage: doc['pathImage'],
        genero: GeneroModel.fromJson(doc['genero']));
  }
}
