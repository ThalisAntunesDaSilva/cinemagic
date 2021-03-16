import React from 'react';

import css from './ano.module.css';

export default function Ano(props) {
  const { releaseDate } = props;

  const getReleaseYear = (date) => {
    return new Date(date).getFullYear();
  };

  return <span className={css.ano}>{getReleaseYear(releaseDate)}</span>;
}
