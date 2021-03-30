import 'package:cinemagic/model/SessaoModel.dart';
import 'package:flutter/material.dart';
import 'package:flutter_modular/flutter_modular.dart';

class FilmeScreen extends StatelessWidget {
  FilmeScreen({this.sessao});
  final SessaoModel sessao;
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Modular.to.pushNamed('/sessao', arguments: sessao);
      },
      child: Card(
          color: Colors.purpleAccent.withAlpha(15),
          elevation: 0,
          margin: EdgeInsets.symmetric(horizontal: 15, vertical: 10),
          child: Padding(
            padding: const EdgeInsets.only(bottom: 20),
            child: Column(
              children: [
                Image.network(
                  sessao.filme.pathImage,
                  height: MediaQuery.of(context).size.height / 3,
                  fit: BoxFit.fill,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                        '${sessao.sala.cinema.cidade.nome} ${sessao.sala.cinema.cidade.estado.uf}'),
                    Text('${sessao.data} ${sessao.hora}'),
                    Text('${sessao.valorInteira}')
                  ],
                ),
              ],
            ),
          )),
    );
  }
}
