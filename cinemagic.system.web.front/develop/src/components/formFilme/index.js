import React from 'react';
import { Row, Col, Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';
import './styles.css';



const Example = (props) => {
  return (
   
   <Form className="form">
   <h1>Insira os dados do Filme</h1>
   <div className="layout">

       <div className="ld1">
        <Label for="titulo" >Título</Label>
        <Input type="text" name="titulo" id="titulo" placeholder="Título do filme" />
        <Label for="produtor">Produtor</Label>
        <Input type="produtor" name="produtor" id="produtor" placeholder="Produtor" />
       <Label for="ano">Ano</Label>
        <Input type="ano" name="ano" id="ano" placeholder="Ano" />
        </div>
      <div className="ld2">
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
        <Label for="descricao">Descrição</Label>
        <Input type="descricao" name="descricao" id="descricao" placeholder="Descrição do Filme" />
        <Label for="exampleFile">Cartaz do Filme</Label>      
        <Input type="file" name="file" id="exampleFile" />
        <Input type="descricao"  className="mt-3"  name="descricao" id="descricao" placeholder="url imagem" />
        <Button  color="danger"  className="mt-3" size="lg" block>Inserir</Button>
        </div>
        </div>
    </Form>

  );
}

export default Example;
