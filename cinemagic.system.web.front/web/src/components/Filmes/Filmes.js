import React from 'react';

import Filme from '../Filme/Filme';

import './filmes.module.css';

export default function Filmes(props) {
  const { filmes } = props;
  return (
    <ul>
      {filmes.map((filme) => {
        const {
          adult,
          genres,
          id,
          posterPath,
          releaseDate,
          runtime,
          title,
          sessions,
        } = filme;

        return (
          <li key={id}>
            <Filme
              adult={adult}
              genres={genres}
              posterPath={posterPath}
              releaseDate={releaseDate}
              runtime={runtime}
              title={title}
              sessions={sessions}
            />
          </li>
        );
      })}
    </ul>
  );
}
