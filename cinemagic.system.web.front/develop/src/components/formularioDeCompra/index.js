import React from 'react';
import { Form, Input, Label, Button } from 'reactstrap';
import './styles.css';

const Example = (props) => {
  return (
   <body>
   <Form className="formularioCompra">
    
    
      <Label for="Nome" className="Nome text-light mt-3">Cinema</Label>
        <Input type="select">
        <option>Alegrete-RS</option>
        <option>Porto Alegre-RS</option>
        <option>Florianópolis-SC</option>
      </Input>
     
      <Label for="Nome" className="Nome text-light mt-3">Sessão</Label>
        <Input type="select">
        <option>Cinema Oswaldo Aranha</option>
        <option>Cinema Getulio Vargas</option>
        <option>Cinema Pedro Alvares Cabral</option>
      </Input>
     
      <Label for="Nome" className="Nome text-light mt-3">Ingressos meio</Label>
        <Input type="select">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </Input>
     
      <Label for="Nome" className="Nome text-light mt-3">Ingressos meio</Label>
  <Input type="select">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </Input>
     
   
    
    </Form>

<div className="compra"> <Button color="danger">Compre já</Button></div>

</body>
  );
}

export default Example;