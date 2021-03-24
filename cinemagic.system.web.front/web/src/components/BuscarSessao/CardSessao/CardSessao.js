import React from 'react';
import Filme from '../Filme/Filme';
import { Link } from 'react-router-dom';

import css from './CardSessao.module.css';

export default function CardSessao(props) {
  const { local, filmes } = props;
  return (
    <div className={css.card}>
      <p className={css.local}>{local}</p>
      <p>Filmes em cartaz:</p>
      <ul className={css.horizontalList}>
        {filmes.map((filme) => {
          const { id, poster, nome } = filme;

          return (
            <li key={id}>
              <Filme poster={poster} nome={nome} />
            </li>
          );
        })}
      </ul>

      <Link to="/Sessoes">
        <button className={css.botao}>Ver mais</button>
      </Link>
    </div>
  );
}
