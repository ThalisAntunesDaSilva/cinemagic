import React from 'react';

import Ano from '../Ano/Ano';
import Duracao from '../Duracao/Duracao';
import Horarios from '../Horarios/Horarios';
import FaixaEtaria from '../FaixaEtaria/FaixaEtaria';
import Generos from '../Generos/Generos';
import Local from '../Local/Local';
import Titulo from '../Titulo/Titulo';

import css from './dadosFilme.module.css';

export default function DadosFilme(props) {
  const { adult, genres, releaseDate, runtime, title, sessions } = props;

  return (
    <div>
      <div className={css.titulo}>
        <Titulo>{title}</Titulo>
      </div>
      <div className={css.dados}>
        <div>
          <Ano releaseDate={releaseDate} />
          <Horarios sessions={sessions}></Horarios>
        </div>
        <div>
          <Local>Alegrete - RS</Local>
        </div>
        <div>
          <FaixaEtaria adult={adult} />
          <Duracao runtime={runtime} />
          <Generos genres={genres} />
        </div>
      </div>
    </div>
  );
}
