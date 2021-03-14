import React from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';



const Example = (props) => {
  return (
   <div>
          <Form column>
      <FormGroup className="oi mb-2 me-sm-2 mb-sm-0">
        <Label for="exampleEmail" className="me-sm-2">Email</Label>
        <Input type="email" name="email" id="exampleEmail" placeholder="something@idk.cool" />
      </FormGroup>
      <FormGroup className="mb-2 me-sm-2 mb-sm-0">
        <Label for="examplePassword" className="me-sm-2">Senha</Label>
        <Input className="input"type="password" name="password" id="examplePassword" placeholder="don't tell!" />
      </FormGroup>
      <Button color="danger" className="button">Login</Button>
    </Form>
    </div>

  );
}

export default Example;