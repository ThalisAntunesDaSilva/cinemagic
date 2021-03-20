import React from 'react';

import css from './titulo.module.css';

export default function Titulo(props) {
  const { children } = props;

  return <span className={css.titulo}>{children}</span>;
}
