import React from 'react';

import css from './duracao.module.css';

export default function Duracao(props) {
  const { runtime } = props;

  const leftPad = (value, size = 2, char = '0') => {
    let valueString = value.toString();

    while (valueString.length < size) {
      valueString = `${char}${valueString}`;
    }

    return valueString;
  };

  const formatarTempo = (minutos) => {
    const horas = Math.floor(minutos / 60);
    const minutosResto = leftPad(minutos % 60);

    if (minutos === 0) {
      return 'Sem informações de duração';
    }

    return `${horas}:${minutosResto} h`;
  };

  return <span className={css.duracao}>{formatarTempo(runtime)}</span>;
}
