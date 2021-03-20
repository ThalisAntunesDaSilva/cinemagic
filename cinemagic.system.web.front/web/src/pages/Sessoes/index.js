import React, { useState, useEffect } from 'react';

import Header from '../../components/Sessoes/Header/Header';
import Main from '../../components/Sessoes/Main/Main';
import Footer from '../../components/Sessoes/Footer/Footer';

import css from './Sessoes.module.css';

export default function App() {
  const [filmes, setFilmes] = useState([]);

  useEffect(() => {
    const asyncFunctions = async () => {
      const res = await fetch('http://localhost:3001/results');
      const filmesJson = await res.json();

      const filmesMapeados = filmesJson.map((filme) => {
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
    };

    asyncFunctions();
  }, []);

  return (
    <div className={css.app}>
      {/* <Header /> */}
      <Main filmes={filmes} />
      {/* <Footer /> */}
    </div>
  );
}
