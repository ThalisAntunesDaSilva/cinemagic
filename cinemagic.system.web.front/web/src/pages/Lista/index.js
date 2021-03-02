import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';

import './index.css';

export default function CadastroCliente() {

  const { releaseDate } = props;

  const getReleaseYear = (date) => {
    return new Date(date).getFullYear();
  };

function  DadosFilme(props) {
    const { adult, genres, releaseDate, runtime, title, sessions } = props;
  }  

  function Duracao(props) {
    const { runtime } = props;
  
    const leftPad = (value, size = 2, char = '0') => {
      let valueString = value.toString();
  
      while (valueString.length < size) {
        valueString = `${char}${valueString}`;
      }
  
      return valueString;
    };
  
    const formatarTempo = (minutos) => {
      const horas = Math.floor(minutos / 60);
      const minutosResto = leftPad(minutos % 60);
  
      if (minutos === 0) {
        return 'Sem informações de duração';
      }
  
      return `${horas}:${minutosResto} h`;
    }

    function FaixaEtaria(props) {
      const { adult } = props;
    
      const getFaixaEtaria = (isAdult) => {
        if (isAdult) {
          return '18+';
        }
    
        return '18-';
      }}

      function Filme(props) {
        const {
          adult,
          genres,
          posterPath,
          releaseDate,
          runtime,
          title,
          sessions,
        } = props;}

        function Filmes(props) {
          const { filmes } = props}

          function Generos(props) {
            const { genres } = props;
          
            const [isOver, setIsOver] = useState(false);
          
            const mostrarGeneros = () => {
              if (isOver) {
                return mapearGeneros(genres);
              }
              return limitarGeneros(genres);
            };
          
            const alternarMostrarGeneros = (event) => {
              setIsOver(!isOver);
            };
          
            const definirClasses = () => {
              if (isOver) {
                return `${css.generos} ${css.completos}`;
              }
              return css.generos;
            };
          
            const mapearGeneros = (generos) => {
              const nomesGeneros = generos
                .map((genero) => {
                  return genero.name;
                })
                .join(', ');
          
              return nomesGeneros;
            };
          
            const limitarGeneros = (generos) => {
              const generosMapeados = mapearGeneros(generos);
          
              if (25 < generosMapeados.length) {
                return generosMapeados.substr(0, 24) + '...';
              }
          
              return generosMapeados;
            }}

            function Horarios(props) {
              const { sessions } = props;
            
              const [isOver, setIsOver] = useState(false);
            
              const mostrarMensagem = () => {
                if (isOver) {
                  return css.aMostra;
                }
                return css.escondido;
              };
            
              const alternarMostrarHorarios = (event) => {
                setIsOver(!isOver);
              };
            
              const listarHorarios = (horarios) => {
                return horarios.join(', ');
              }}
              function Local(props) {
                const { children } = props}

                function Main(props) {
                  const { filmes } = props}

                  function Poster(props) {
                    const { posterPath, title } = props}

  }

  function Titulo(props) {
    const { children } = props}


return ( 
<>
<div>

<header className={header}>
      <div className={left}>
        <MaterialIcon icon="menu" size="medium" color="#ab0032" />
        <Logo />
      </div>

      <MaterialIcon icon="search" size="medium" color="#ab0032" />
    </header>


<span className={ano}>{getReleaseYear(releaseDate)}</span>
<ul>
      {filmes.map((filme) => {
        const {
          adult,
          genres,
          id,
          posterPath,
          releaseDate,
          runtime,
          title,
          sessions,
        } = filme;

        return (
          <li key={id}>
            <Filme
              adult={adult}
              genres={genres}
              posterPath={posterPath}
              releaseDate={releaseDate}
              runtime={runtime}
              title={title}
              sessions={sessions}
            />
          </li>
        );
      })}
    </ul>

<button className={botaoComprar}>
      <MaterialIcon icon="confirmation_number" size="medium" color="#fff9fd" />
      <span>Compre já o seu ingresso</span>
    </button>
    <div>
      <div className={titulo}>
        <Titulo>{title}</Titulo>
      </div>
      <div className={css.dados}>
        <div>
          <Ano releaseDate={releaseDate} />
          <Horarios sessions={sessions}></Horarios>
        </div>
        <div>
          <Local>Alegrete - RS</Local>
        </div>
        <div>
          <FaixaEtaria adult={adult} />
          <Duracao runtime={runtime} />
          <Generos genres={genres} />
        </div>
      </div>
    </div>
    <span className={duracao}>{formatarTempo(runtime)}</span>
    <span className={faixaEtaria}>{getFaixaEtaria(adult)}</span>
    <div className={css.filme}>
      <Poster posterPath={posterPath} title={title} />

      <div className={css.lateral}>
        <DadosFilme
          adult={adult}
          genres={genres}
          releaseDate={releaseDate}
          runtime={runtime}
          title={title}
          sessions={sessions}
        />

        <BotaoComprar />
      </div>
    </div>
    <div className={css.footer}>
      <Logo />
      <span>Mudar cidade</span>
    </div>
    <span
      className={definirClasses()}
      onMouseOver={alternarMostrarGeneros}
      onMouseOut={alternarMostrarGeneros}>
      {mostrarGeneros()}
    </span>

    <div className={containerHorario}>
      <span
        className={horario}
        onMouseOver={alternarMostrarHorarios}
        onMouseOut={alternarMostrarHorarios}>
        <MaterialIcon icon="schedule" size="tiny" color="#fff9fd" />
        Horários
      </span>
      <span className={`${horario} ${mostrarMensagem()}`}>
        {listarHorarios(sessions)}
      </span>
    </div>
    <div className={local}>
      <MaterialIcon icon="room" size="tiny" color="#ab0032" />
      <span>{children}</span>
    </div>

    <div className={logoENome}>
      <img className={logotipo} src="/img/logo.jpg" alt="Cinemagic logo" />
      <span>Cinemagic</span>
    </div>
    <div className={mainContainer}>
      <Filmes filmes={filmes} />
    </div>
    <img
      className={css.poster}
      src={`http://image.tmdb.org/t/p/w185/${posterPath}`}
      alt={`${title} poster`}
    />

<span className={css.titulo}>{children}</span>

</div>
</>
);
}