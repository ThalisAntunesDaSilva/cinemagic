import React from 'react';
import { NavLink } from 'react-router-dom';
import navbar from '../../navBar';
import css from './NavBar.module.css';

import cidadesEstado from '../../../mock/cidadesEstadosBrasil.json';
import Selector from './Selector/Selector';

export default function NavBar({ setCities }) {
  const buscarCidades = (sigla) => {
    const estadoEncontrado = cidadesEstado.estados.find((estado) => {
      return sigla === estado.sigla;
    });

    return estadoEncontrado.cidades;
  };

  const selectState = (sigla) => {
    const cidades = buscarCidades(sigla);

    setCities(Object.assign(cidades));
  };

  return (
    <navbar className={css.navbar}>
      <Selector
        name="estado"
        label="Selecione um estado"
        options={cidadesEstado.estados}
        selectState={selectState}
      />
    </navbar>
  );
}
