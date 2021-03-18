import React, { useState } from 'react';

import css from './generos.module.css';

export default function Generos(props) {
  const { genres } = props;

  const [isOver, setIsOver] = useState(false);

  const mostrarGeneros = () => {
    if (isOver) {
      return mapearGeneros(genres);
    }
    return limitarGeneros(genres);
  };

  const alternarMostrarGeneros = (event) => {
    setIsOver(!isOver);
  };

  const definirClasses = () => {
    if (isOver) {
      return `${css.generos} ${css.completos}`;
    }
    return css.generos;
  };

  const mapearGeneros = (generos) => {
    const nomesGeneros = generos
      .map((genero) => {
        return genero.name;
      })
      .join(', ');

    return nomesGeneros;
  };

  const limitarGeneros = (generos) => {
    const generosMapeados = mapearGeneros(generos);

    if (25 < generosMapeados.length) {
      return generosMapeados.substr(0, 24) + '...';
    }

    return generosMapeados;
  };

  return (
    <span
      className={definirClasses()}
      onMouseOver={alternarMostrarGeneros}
      onMouseOut={alternarMostrarGeneros}>
      {mostrarGeneros()}
    </span>
  );
}
