import React from 'react';
import { Button, Form, Label, Input } from 'reactstrap';
import './styles.css';


const Example = (props) => {
    return (
        <Form>
          <h1>Insira os dados do Cinema</h1>
  <div className="formularioDeSessao">
   
        <div className="lado1">
      <Label for="Nome" type="text" size="5" className="Nome text-light mt-3 w-25">Estado</Label>
        <Input/>
        
        <Label for="Nome" className="Nome text-light mt-3">Cidade</Label>
        <Input size="md"/>

      
        </div>
        <div className="lado2">
        <Label for="Nome" className="Nome text-light mt-3">Número de salas</Label>
        <Input>
          
        </Input>

        <Button color="danger" className="mt-5">Cadastrar</Button>
        </div>



     
        </div>      
                     

        </Form>


    );
}

export default Example;