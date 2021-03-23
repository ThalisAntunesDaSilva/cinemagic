import React from 'react';
import css from './Filme.module.css';

export default function Filme(props) {
  const { poster, nome } = props;
  return (
    <div className={css.filme}>
      <img className={css.poster} src={poster} alt={`${nome} poster`} />
      <span className={css.nome}>{nome}</span>
    </div>
  );
}
