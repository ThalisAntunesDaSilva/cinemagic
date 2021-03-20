import React from 'react';
import MaterialIcon from 'material-icons-react';

import Logo from '../Logo/Logo';

import css from './header.module.css';

export default function Header(props) {
  return (
    <header className={css.header}>
      <div className={css.left}>
        <MaterialIcon icon="menu" size="medium" color="#ab0032" />
        <Logo />
      </div>

      <MaterialIcon icon="search" size="medium" color="#ab0032" />
    </header>
  );
}
