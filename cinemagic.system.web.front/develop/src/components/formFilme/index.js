import React, { useState, useEffect } from 'react';
import { Row, Col, Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';
import './styles.css';

import { useHistory } from 'react-router-dom';
import api from '../../services/api';




const Example = (props) => {
  let history = useHistory()

  const [titulo, setTitulo] = useState('');
  const [genero, setGenero] = useState('');
  const [duracao, setDuracao] = useState('');

  async function AcaoBotao(e) {
    e.preventDefault();
    try {

      const res = await api.post("/filmes", {
        "titulo": titulo,
        "genero": genero,
        "duracao": duracao
      })

    } catch (ex) {
      alert("Erro caiu no try");
    }
  }

  return (
    <Form className="form">
      <Col sm="20" md={{ size: 4, offset: 4 }}>
        <FormGroup >
          <Label for="titulo" >Título</Label>
          <Input type="text" name="titulo" id="titulo" placeholder="Título do filme" />
        </FormGroup>
      </Col>
      <Col sm="20" md={{ size: 4, offset: 4 }}>
        <FormGroup>
          <Label for="produtor">Produtor</Label>
          <Input type="produtor" name="produtor" id="produtor" placeholder="Produtor" />
        </FormGroup>
      </Col>
      <Col sm="20" md={{ size: 4, offset: 4 }}>
        <FormGroup>
          <Label for="ano">Ano</Label>
          <Input type="ano" name="ano" id="ano" placeholder="Ano" />
        </FormGroup>
      </Col>
      <Col sm="20" md={{ size: 4, offset: 4 }}>
        <FormGroup>
          <Label for="generos">Gêneros</Label>
          <Input type="select" name="select" id="exampleSelect">
            <option>Ação</option>
            <option>Aventura</option>
            <option>Cinema de arte</option>
            <option>Comédia</option>
            <option>Comédia de ação</option>
            <option>Comédia de terror</option>
            <option>Comédia dramática</option>
            <option>Comédia romântica</option>
            <option>Dança</option>
            <option>Documentário</option>
            <option>Drama</option>
            <option>Faroeste</option>
            <option>Fantasia</option>
            <option>Fantasia científica</option>
            <option>Ficção científica</option>
            <option>Filmes com truques</option>
            <option>Filmes de guerra</option>
            <option>Musical</option>
            <option>Filme policial</option>
            <option>Romance</option>
            <option>Suspense</option>
            <option>Terror</option>
          </Input>
        </FormGroup>
      </Col>
      <Col sm="20" md={{ size: 4, offset: 4 }}>
        <FormGroup>
          <Label for="descricao">Descrição</Label>
          <Input type="descricao" name="descricao" id="descricao" placeholder="Descrição do Filme" />
        </FormGroup>
      </Col>
      <Col sm="20" md={{ size: 4, offset: 4 }}>
        <FormGroup>
          <Label for="exampleFile">Cartaz do Filme</Label>
          <Input type="file" name="file" id="exampleFile" />
          <FormText color="muted">
            This is some placeholder block-level help text for the above input.
            It's a bit lighter and easily wraps to a new line.
        </FormText>
        </FormGroup>
      </Col>
      <Row form>
        <Col sm="20" md={{ size: 4, offset: 4 }}>
          <Button outline color="danger" size="lg" block>Inserir</Button>
        </Col>
      </Row>
    </Form>
  );
}

export default Example;
