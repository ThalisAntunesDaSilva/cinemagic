import 'package:cinemagic/model/CinemaModel.dart';

class SalaModel {
  int id;
  int numero;
  int capacidade;
  CinemaModel cinema;

  SalaModel({this.id, this.numero, this.capacidade, this.cinema});

  factory SalaModel.fromJson(Map doc) {
    return SalaModel(
        id: doc['id'],
        numero: doc['numero'],
        capacidade: doc['capacitade'],
        cinema: CinemaModel.fromJson(doc['cinema']));
  }
}
