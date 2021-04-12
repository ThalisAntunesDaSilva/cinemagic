import React from 'react';
import { Button } from 'reactstrap';
import './styles.css';
import axios from "axios";

import { login, getToken } from '../../services/auth/auth.js';


const Example = (props) => {
  const [titulo, setTitulo] = useState('');
  const [genero, setGenero] = useState('');
  const [duracao, setDuracao] = useState('');


  async function acaoBotao(e) {
    const options = {
      method: 'POST',
      url: 'http://localhost:8080/filmes',
      headers: {
        'Content-Type': 'application/json',
        authorization: getToken()
      },
      data: { titulo: 'TESTE DEDECU', duracao: '1h50', genero: { id: 1 } }
    };

    e.preventDefault();

    axios.request(options).then(function (response) {
      console.log(response.data);
    }).catch(function (error) {
      console.error(error);
    });

  }
  return (

    <Button outline color="danger" size="lg" onClick={acaoBotao}>Inserir</Button>

  );
}

export default Example;