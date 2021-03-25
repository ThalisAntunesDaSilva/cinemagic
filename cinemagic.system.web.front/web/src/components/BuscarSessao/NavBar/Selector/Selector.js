import React from 'react';

import css from './Selector.module.css';

export default function Selector({ name, label, options, selectState }) {
  const handleChange = (event) => {
    const sigla = event.target.value.slice(-2);
    selectState(sigla);
  };

  return (
    <div className={css.wrapper}>
      <label htmlFor={name}>{label}</label>

      <select id={name} name={name} onChange={handleChange}>
        {options.map((option) => {
          const { sigla, nome } = option;

          if (sigla === undefined) {
            return option;
          }

          return <option>{`${nome} - ${sigla}`}</option>;
        })}
      </select>
    </div>
  );
}
