import React, { useState } from 'react';

import NavBar from '../../components/BuscarSessao/NavBar/NavBar';

import CardCity from '../../components/BuscarSessao/CardCity/CardCity';

import movies from '../../mock/movies.json';

const BuscarSessao = () => {
  // const sessoes = [
  //   {
  //     id: 1,
  //     local: 'Alegrete',
  //     previewFilmes: [
  //       {
  //         id: 1,
  //         poster: `http://image.tmdb.org/t/p/w185/oZDAW4nmlC2cT9vM4fRxTQWHddE.jpg`,
  //         nome: 'Malcolm e Marie',
  //       },
  //       {
  //         id: 2,
  //         poster: `http://image.tmdb.org/t/p/w185/98UFAKFPUOIzF91Q0j0W7vR4ikV.jpg`,
  //         nome: 'Os Pequenos Vestígios',
  //       },
  //       {
  //         id: 3,
  //         poster: `http://image.tmdb.org/t/p/w185/cLqg9BjcecdzYGqURSdWgBUO3rX.jpg`,
  //         nome: 'Relatos do Mundo',
  //       },
  //     ],
  //   },
  //   {
  //     id: 2,
  //     local: 'Porto Alegre',
  //     previewFilmes: [
  //       {
  //         id: 1,
  //         poster: `http://image.tmdb.org/t/p/w185/sJecw4UYpvTgKE2zS9le44Nwuag.jpg`,
  //         nome: 'Destruição Final: O Último Refúgio',
  //       },
  //       {
  //         id: 2,
  //         poster: `http://image.tmdb.org/t/p/w185/b7BllsQkD6nTkAdtd28UVCmKqVi.jpg`,
  //         nome: 'Bliss: Em Busca da Felicidade',
  //       },
  //       {
  //         id: 3,
  //         poster: `http://image.tmdb.org/t/p/w185/f32ne52ClTPFL9Ew2aPUhKoVn9e.jpg`,
  //         nome: 'Nova Ordem Espacial',
  //       },
  //     ],
  //   },
  //   {
  //     id: 3,
  //     local: 'Gramados',
  //     previewFilmes: [
  //       {
  //         id: 1,
  //         poster: `http://image.tmdb.org/t/p/w185/4ep2AOWNbVeS0EKLpOBKcIZ8hZS.jpg`,
  //         nome: 'Judas e o Messias Negro',
  //       },
  //       {
  //         id: 2,
  //         poster: `setCitiesqjO6iJTW6McMLrbt6Xz6lDZu7bF.jpg`,
  //         nome: 'Bela Vingança',
  //       },
  //       {
  //         id: 3,
  //         poster: `http://image.tmdb.org/t/p/w185/f32ne52ClTPFL9Ew2aPUhKoVn9e.jpg`,
  //         nome: 'Nova Ordem Espacial',
  //       },
  //     ],
  //   },
  // ];

  const [cities, setCities] = useState([]);

  const mappedMovies = movies
    .map((movie) => {
      const { id, poster_path, title } = movie;

      return {
        id,
        poster: `http://image.tmdb.org/t/p/w185/${poster_path}`,
        name: title,
      };
    });

  const randomNumber = (min = 0, max = 0) => {
    min = Math.ceil(min);
    max = Math.floor(max);

    return Math.floor(Math.random() * (max - min) + min);
  };

  const getRandomMovies = (numberMovies = 3, maxNumber = 0) => {
    const generatedNumbers = [];
    const selectedMovies = [];
    let i = 0;

    while (i < numberMovies) {
      const randomNum = randomNumber(0, maxNumber);

      if (generatedNumbers.indexOf(randomNum) === -1) {
        generatedNumbers.push(randomNum);
        selectedMovies.push(mappedMovies[randomNum]);
      } else {
        i--;
      }

      i++;
    }

    return selectedMovies;
  };

  return (
    <div>
      <NavBar setCities={setCities} />
      <ul>
        {cities.map((city) => {
          const randomMovies = getRandomMovies(3, mappedMovies.length);

          return (
            <li key={city}>
              <CardCity local={city} filmes={randomMovies} />
            </li>
          );
        })}
      </ul>
    </div>
  );
};

export default BuscarSessao;
