import React from 'react';
import MaterialIcon from 'material-icons-react';

import css from './botaoComprar.module.css';

export default function BotaoComprar() {
  return (
    <button className={css.botaoComprar}>
      <MaterialIcon icon="confirmation_number" size="medium" color="#fff9fd" />
      <span>Compre já o seu ingresso</span>
    </button>
  );
}
