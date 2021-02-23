import 'package:cinemagic/model/CidadeModel.dart';
import 'package:cinemagic/model/CinemaModel.dart';
import 'package:cinemagic/model/EstadoModel.dart';
import 'package:cinemagic/model/FilmeModel.dart';
import 'package:cinemagic/model/GeneroModel.dart';
import 'package:cinemagic/model/PaisModel.dart';
import 'package:cinemagic/model/SalaModel.dart';
import 'package:cinemagic/model/SessaoModel.dart';
import 'package:mobx/mobx.dart';

part 'controller_home.g.dart';

class ControllerHome = _ControllerHome with _$ControllerHome;

abstract class _ControllerHome with Store {
  @observable
  bool textInput = false;
  @observable
  List<SessaoModel> sessoes = [
    SessaoModel(
      data: "18/02/2020",
      hora: "20:00",
      filme: FilmeModel(
        id: 1,
        titulo: "Homem Aranha 3",
        duracao: "3 horas",
        pathImage:
            'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7dmJrP73JexYAIFxE5wVKpSEa1OH3Kk9WPg&usqp=CAU',
        genero: GeneroModel(
          id: 1,
          descricao: "Herói",
        ),
      ),
      quantidadeIngressos: 0,
      sala: SalaModel(
        id: 1,
        numero: 1,
        capacidade: 50,
        cinema: CinemaModel(
          id: 1,
          nome: "Cinema alegrete",
          cidade: CidadeModel(
            id: 1,
            nome: "Alegrete",
            estado: EstadoModel(
              id: 1,
              nome: "Rio Grande do Sul",
              uf: "RS",
              pais: PaisModel(id: 1, nome: "Brasil"),
            ),
          ),
        ),
      ),
      sessaoEncerrada: false,
      valorInteira: 20.0,
      valorMeia: 10.0,
      id: 1,
    ),
    SessaoModel(
      data: "18/02/2020",
      hora: "20:00",
      filme: FilmeModel(
        id: 1,
        titulo: "Homem Aranha 3",
        duracao: "3 horas",
        pathImage:
            'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7dmJrP73JexYAIFxE5wVKpSEa1OH3Kk9WPg&usqp=CAU',
        genero: GeneroModel(
          id: 1,
          descricao: "Herói",
        ),
      ),
      quantidadeIngressos: 0,
      sala: SalaModel(
        id: 1,
        numero: 1,
        capacidade: 50,
        cinema: CinemaModel(
          id: 1,
          nome: "Cinema alegrete",
          cidade: CidadeModel(
            id: 1,
            nome: "Alegrete",
            estado: EstadoModel(
              id: 1,
              nome: "Rio Grande do Sul",
              uf: "RS",
              pais: PaisModel(id: 1, nome: "Brasil"),
            ),
          ),
        ),
      ),
      sessaoEncerrada: false,
      valorInteira: 20.0,
      valorMeia: 10.0,
      id: 1,
    ),
    SessaoModel(
      data: "18/02/2020",
      hora: "20:00",
      filme: FilmeModel(
        id: 1,
        titulo: "Homem Aranha 3",
        duracao: "3 horas",
        pathImage:
            'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuRZXnqn5bDrrTMcDJfXmzBFZvK3K8f0wVuA&usqp=CAU',
        genero: GeneroModel(
          id: 1,
          descricao: "Herói",
        ),
      ),
      quantidadeIngressos: 0,
      sala: SalaModel(
        id: 1,
        numero: 1,
        capacidade: 50,
        cinema: CinemaModel(
          id: 1,
          nome: "Cinema alegrete",
          cidade: CidadeModel(
            id: 1,
            nome: "Alegrete",
            estado: EstadoModel(
              id: 1,
              nome: "Rio Grande do Sul",
              uf: "RS",
              pais: PaisModel(id: 1, nome: "Brasil"),
            ),
          ),
        ),
      ),
      sessaoEncerrada: false,
      valorInteira: 20.0,
      valorMeia: 10.0,
      id: 1,
    ),
  ];

  @action
  void setTextInput(bool value) => textInput = value;
}
