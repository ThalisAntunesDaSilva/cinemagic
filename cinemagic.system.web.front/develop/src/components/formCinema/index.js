import React from 'react';
import { Col, Button, Form, FormGroup, Label, Input, Row } from 'reactstrap';
import './styles.css';


const Example = (props) => {
    return (

        <Form className="forme">


            <Row forme>
                <Col sm="12" md={{ size: 7, offset: 3 }}>
                    <FormGroup >
                        <Label for="Nome" className="Nome">Nome do Cinema</Label>
                        <Input type="text" name="nome" id="nome" placeholder="Nome Completo" />
                    </FormGroup>
                </Col>
            </Row>

            <Row forme>
                <Col  sm="12" md={{ size: 7, offset: 3 }}>
                    <FormGroup >
                        <Label for="Cidade" className="me-sm-2">Cidade</Label>
                        <Input type="text" name="cidade" id="cidade" placeholder="Cidade" />
                    </FormGroup>
                </Col>
                </Row>

                <Row forme>
                <Col  sm="12" md={{ size: 7, offset: 3 }}>
                    <FormGroup className="mb-2 me-sm-2 mb-sm-2">
                        <Label for="Numero" className="me-sm-2">Numero de Salas</Label>
                        <Input type="numero" name="numero" id="numero" placeholder="Numero" />
                    </FormGroup>
                </Col>
                </Row>



            <Row forme>
                <Col sm="12" md={{ size: 7, offset: 3 }}>
                    <Button outline color="danger" size="lg" block>Cadastrar-se</Button>
                </Col>
            </Row>

        </Form>


    );
}

export default Example;