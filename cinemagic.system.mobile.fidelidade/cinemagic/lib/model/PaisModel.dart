class PaisModel {
  int id;
  String nome;

  PaisModel({this.id, this.nome});

  factory PaisModel.fromJson(Map doc) {
    return PaisModel(id: doc['id'], nome: doc['nome']);
  }
}
