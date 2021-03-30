class GeneroModel {
  GeneroModel({this.id, this.descricao});
  int id;
  String descricao;

  factory GeneroModel.fromJson(Map doc) {
    return GeneroModel(id: doc['id'], descricao: doc['descricao']);
  }
}
