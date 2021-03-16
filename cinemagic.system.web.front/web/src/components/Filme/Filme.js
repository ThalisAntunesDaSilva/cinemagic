import React from 'react';

import Poster from '../Poster/Poster';
import DadosFilme from '../DadosFilme/DadosFilme';
import BotaoComprar from '../BotaoComprar/BotaoComprar';

import css from './filme.module.css';

export default function Filme(props) {
  const {
    adult,
    genres,
    posterPath,
    releaseDate,
    runtime,
    title,
    sessions,
  } = props;

  return (
    <div className={css.filme}>
      <Poster posterPath={posterPath} title={title} />

      <div className={css.lateral}>
        <DadosFilme
          adult={adult}
          genres={genres}
          releaseDate={releaseDate}
          runtime={runtime}
          title={title}
          sessions={sessions}
        />

        <BotaoComprar />
      </div>
    </div>
  );
}
