import React from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';



const Example = (props) => {
  return (
          <Form column>
    
      <FormGroup className="oi mb-2 me-sm-2 mb-sm-0 ">
    
        <Label for="exampleEmail" className="me-sm-2 mt-3 text-light">Email</Label>
        <Input className="input mt-3"type="email" name="email" id="exampleEmail" placeholder="something@idk.cool" />
      </FormGroup>
      <FormGroup className="mb-2 me-sm-2 mb-sm-0">
        <Label for="examplePassword" className="me-sm-2 mt-3 text-light">Senha</Label>
        <Input className="input mt-3"type="password" name="password" id="examplePassword" placeholder="don't tell!" />
      </FormGroup>
      <Button color="danger" className="button mt-3">Login</Button>
  
    </Form>
  
  
  );
}

export default Example;