import React, { useState, useEffect } from 'react';

import NavBar from '../../components/navBar';
import Main from '../../components/Sessoes/Main/Main';

import movies from '../../mock/movies.json';

import { promises as fs } from 'fs';

import css from './Sessoes.module.css';

export default function App() {
  const [filmes, setFilmes] = useState([]);

  useEffect(() => {
    const filmesMapeados = movies.map((filme) => {
      const {
        adult,
        genres,
        id,
        poster_path,
        release_date,
        runtime,
        title,
        sessions,
      } = filme;

      return {
        adult,
        genres,
        id,
        posterPath: poster_path,
        releaseDate: release_date,
        runtime,
        title,
        sessions,
      };
    });

    setFilmes(Object.assign([], filmesMapeados));
  }, []);

  return (
    <div className={css.app}>
      <NavBar />
      <Main filmes={filmes} />
    </div>
  );
}
