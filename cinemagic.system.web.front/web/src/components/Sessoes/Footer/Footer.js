import React from 'react';

import Logo from '../Logo/Logo';

import css from './footer.module.css';

export default function Footer() {
  return (
    <div className={css.footer}>
      <Logo />
      <span>Mudar cidade</span>
    </div>
  );
}
