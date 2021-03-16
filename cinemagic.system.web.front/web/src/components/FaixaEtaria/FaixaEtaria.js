import React from 'react';

import css from './faixaEtaria.module.css';

export default function FaixaEtaria(props) {
  const { adult } = props;

  const getFaixaEtaria = (isAdult) => {
    if (isAdult) {
      return '18+';
    }

    return '18-';
  };

  return <span className={css.faixaEtaria}>{getFaixaEtaria(adult)}</span>;
}
