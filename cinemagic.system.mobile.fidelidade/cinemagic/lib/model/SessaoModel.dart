import 'package:cinemagic/model/FilmeModel.dart';
import 'package:cinemagic/model/SalaModel.dart';

class SessaoModel {
  int id;
  String data;
  String hora;
  double valorInteira;
  double valorMeia;
  bool sessaoEncerrada;
  FilmeModel filme;
  int quantidadeIngressos;
  SalaModel sala;

  SessaoModel(
      {this.id,
      this.data,
      this.hora,
      this.valorInteira,
      this.valorMeia,
      this.sessaoEncerrada,
      this.filme,
      this.quantidadeIngressos,
      this.sala});

  factory SessaoModel.fromJson(Map doc) {
    return SessaoModel(
        id: doc['id'],
        data: doc['data'],
        hora: doc['hora'],
        valorInteira: doc['valorInteira'],
        valorMeia: doc['valorMeia'],
        sessaoEncerrada: doc['sessaoEncerrada'],
        filme: FilmeModel.fromJson(doc['filme']),
        quantidadeIngressos: doc['quantidadeIngresso'],
        sala: SalaModel.fromJson(doc['sala']));
  }
}
