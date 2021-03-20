import React from 'react';
import MaterialIcon from 'material-icons-react';

import css from './local.module.css';

export default function Local(props) {
  const { children } = props;

  return (
    <div className={css.local}>
      <MaterialIcon icon="room" size="tiny" color="#ab0032" />
      <span>{children}</span>
    </div>
  );
}
