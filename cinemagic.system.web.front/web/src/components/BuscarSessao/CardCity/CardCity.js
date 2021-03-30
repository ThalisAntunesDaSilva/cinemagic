import React from 'react';
import Filme from '../Filme/Filme';
import { Link } from 'react-router-dom';

import css from './CardCity.module.css';

export default function CardSessao(props) {
  const { local, filmes } = props;
  return (
    <div className={css.card}>
      <p className={css.local}>{local}</p>
      <p>Filmes em cartaz:</p>
      <ul className={css.horizontalList}>
        {filmes.map((filme) => {
          const { id, poster, name } = filme;

          return (
            <li key={id} className={css.listItem}>
              <Filme poster={poster} nome={name} />
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
