import React, { useState, useEffect } from 'react';
import formCadastro from '../../components/formCadastro/index.js';
import ferramentasCadastro from '../../components/ferramentasCadastro/index.js';
import NavBar from '../../components/navBar';

export default function CadastroCliente() {
  return (
    <>
      <NavBar />
      <div className="body">
        {ferramentasCadastro({ entidade: 'Funcionario' })}
        {formCadastro()}
      </div>
    </>
  );
}
