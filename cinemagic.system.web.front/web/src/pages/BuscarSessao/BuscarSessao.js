import React from 'react';

import NavBar from '../../components/BuscarSessao/NavBar/NavBar';

import CardSessao from '../../components/BuscarSessao/CardSessao/CardSessao';

const BuscarSessao = () => {
  const sessoes = [
    {
      id: 1,
      local: 'Alegrete',
      previewFilmes: [
        {
          id: 1,
          poster: `http://image.tmdb.org/t/p/w185/oZDAW4nmlC2cT9vM4fRxTQWHddE.jpg`,
          nome: 'Malcolm e Marie',
        },
        {
          id: 2,
          poster: `http://image.tmdb.org/t/p/w185/98UFAKFPUOIzF91Q0j0W7vR4ikV.jpg`,
          nome: 'Os Pequenos Vestígios',
        },
        {
          id: 3,
          poster: `http://image.tmdb.org/t/p/w185/cLqg9BjcecdzYGqURSdWgBUO3rX.jpg`,
          nome: 'Relatos do Mundo',
        },
      ],
    },
    {
      id: 2,
      local: 'Porto Alegre',
      previewFilmes: [
        {
          id: 1,
          poster: `http://image.tmdb.org/t/p/w185/sJecw4UYpvTgKE2zS9le44Nwuag.jpg`,
          nome: 'Destruição Final: O Último Refúgio',
        },
        {
          id: 2,
          poster: `http://image.tmdb.org/t/p/w185/b7BllsQkD6nTkAdtd28UVCmKqVi.jpg`,
          nome: 'Bliss: Em Busca da Felicidade',
        },
        {
          id: 3,
          poster: `http://image.tmdb.org/t/p/w185/f32ne52ClTPFL9Ew2aPUhKoVn9e.jpg`,
          nome: 'Nova Ordem Espacial',
        },
      ],
    },
    {
      id: 3,
      local: 'Gramados',
      previewFilmes: [
        {
          id: 1,
          poster: `http://image.tmdb.org/t/p/w185/4ep2AOWNbVeS0EKLpOBKcIZ8hZS.jpg`,
          nome: 'Judas e o Messias Negro',
        },
        {
          id: 2,
          poster: `http://image.tmdb.org/t/p/w185/qjO6iJTW6McMLrbt6Xz6lDZu7bF.jpg`,
          nome: 'Bela Vingança',
        },
        {
          id: 3,
          poster: `http://image.tmdb.org/t/p/w185/f32ne52ClTPFL9Ew2aPUhKoVn9e.jpg`,
          nome: 'Nova Ordem Espacial',
        },
      ],
    },
  ];

  return (
    <div>
      <NavBar />
      <ul>
        {sessoes.map((sessao) => {
          const { id, local, previewFilmes } = sessao;
          return (
            <li key={id}>
              {<CardSessao local={local} filmes={previewFilmes} />}
            </li>
          );
        })}
      </ul>
    </div>
  );
};

export default BuscarSessao;
