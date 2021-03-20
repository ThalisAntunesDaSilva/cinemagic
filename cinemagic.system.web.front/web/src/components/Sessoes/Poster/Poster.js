import React from 'react';

import css from './poster.module.css';

export default function Poster(props) {
  const { posterPath, title } = props;
  return (
    <img
      className={css.poster}
      src={`http://image.tmdb.org/t/p/w185/${posterPath}`}
      alt={`${title} poster`}
    />
  );
}
