import React from 'react';
import { NavLink } from 'react-router-dom';
import navbar from '../../navBar';
import css from './NavBar.module.css';

export default function NavBar() {
  return (
    <navbar className={css.navbar}>
      <label for="estado">
        Selecione um estado
        <select name="estado" id="estado">
          <option>Acre (AC)</option>
          <option>Alagoas (AL)</option>
          <option>Amapá (AP)</option>
          <option>Amazonas (AM)</option>
          <option>Bahia (BA)</option>
          <option>Ceará (CE)</option>
          <option>Distrito Federal (DF)</option>
          <option>Espírito Santo (ES)</option>
          <option>Goiás (GO)</option>
          <option>Maranhão (MA)</option>
          <option>Mato Grosso (MT)</option>
          <option>Mato Grosso do Sul (MS)</option>
          <option>Minas Gerais (MG)</option>
          <option>Pará (PA)</option>
          <option>Paraíba (PB)</option>
          <option>Paraná (PR)</option>
          <option>Pernambuco (PE)</option>
          <option>Piauí (PI)</option>
          <option>Rio de Janeiro (RJ)</option>
          <option>Rio Grande do Norte (RN)</option>
          <option>Rio Grande do Sul (RS)</option>
          <option>Rondônia (RO)</option>
          <option>Roraima (RR)</option>
          <option>Santa Catarina (SC)</option>
          <option>São Paulo (SP)</option>
          <option>Sergipe (SE)</option>
          <option>Tocantins (TO)</option>
        </select>
      </label>

      <label for="cinema">
        Selecione um cinema
        <select name="estado" id="estado">
          <option>Alegrete</option>
          <option>Porto Alegre</option>
          <option>Gramados</option>
        </select>
      </label>
    </navbar>
  );
}
