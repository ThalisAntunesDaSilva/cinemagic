import React from 'react';

import css from './logo.module.css';

export default function Logo() {
  return (
    <div className={css.logoENome}>
      <img className={css.logotipo} src="/img/logo.jpg" alt="Cinemagic logo" />
      <span>Cinemagic</span>
    </div>
  );
}
