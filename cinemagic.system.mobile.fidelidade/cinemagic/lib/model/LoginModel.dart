class LoginModel {
  LoginModel({this.email, this.password});
  String email;
  String password;

  Map<String, dynamic> toMap() {
    return <String, dynamic>{'email': email, 'senha': password};
  }
}
