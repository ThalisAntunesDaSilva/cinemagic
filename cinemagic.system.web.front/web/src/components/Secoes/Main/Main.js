import React from 'react';

import Filmes from '../Filmes/Filmes';

import css from './main.module.css';

export default function Main(props) {
  const { filmes } = props;

  return (
    <div className={css.mainContainer}>
      <Filmes filmes={filmes} />
    </div>
  );
}
