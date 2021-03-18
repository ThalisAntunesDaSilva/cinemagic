class ClienteModel {
  ClienteModel({this.id, this.nome, this.auth, this.email, this.pathImage});
  int id;
  String nome;
  String email;
  String pathImage;
  bool auth = false;

  factory ClienteModel.fromJson(Map data) {
    return ClienteModel(
        id: data["id"],
        nome: data["nome"],
        email: data["email"],
        pathImage: data["pathImage"]);
  }
}
