import React, { useState } from 'react';
import cinemagicClient2 from '../../assets/logo.png';
import './styles.css';

const Example = (props) => {
  const { entidade } = props;

  return (
    <div className="home-container">
      <section className="header col-xs-11 col-sm-12 col-md-11 col-lg-12">
        <div className="header-centro">
          <img
            src={cinemagicClient2}
            // className="header-centro"
            alt="cinemagicClient2"
          />
          <h1 className="titulo">Cadastro de {`${entidade}`}</h1>
        </div>
      </section>
    </div>
  );
};

export default Example;
