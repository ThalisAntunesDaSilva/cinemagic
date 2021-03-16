import React, { useState } from 'react';
import MaterialIcon from 'material-icons-react';

import css from './horarios.module.css';

export default function Horarios(props) {
  const { sessions } = props;

  const [isOver, setIsOver] = useState(false);

  const mostrarMensagem = () => {
    if (isOver) {
      return css.aMostra;
    }
    return css.escondido;
  };

  const alternarMostrarHorarios = (event) => {
    setIsOver(!isOver);
  };

  const listarHorarios = (horarios) => {
    return horarios.join(', ');
  };

  return (
    <div className={css.containerHorario}>
      <span
        className={css.horario}
        onMouseOver={alternarMostrarHorarios}
        onMouseOut={alternarMostrarHorarios}>
        <MaterialIcon icon="schedule" size="tiny" color="#fff9fd" />
        Horários
      </span>
      <span className={`${css.horario} ${mostrarMensagem()}`}>
        {listarHorarios(sessions)}
      </span>
    </div>
  );
}
