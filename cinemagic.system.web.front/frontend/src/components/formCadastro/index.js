import React from 'react';
import { Col, Button, Form, FormGroup, Label, Input, Row } from 'reactstrap';
import './styles.css';


const Example = (props) => {
    return (

        <Form className="form">


            <Row form>
                <Col sm="12" md={{ size: 3, offset: 3 }}>
                    <FormGroup >
                        <Label for="Nome" className="Nome">Nome</Label>
                        <Input type="text" name="nome" id="nome" placeholder="Primerio nome" />
                    </FormGroup>
                </Col>

                <Col md={4} >
                    <FormGroup >
                        <Label for="Sobrenome" className="me-sm-2">Sobrenome</Label>
                        <Input type="text" name="sobrenome" id="sobrenome" placeholder="Sobrenome" />
                    </FormGroup>
                </Col>
            </Row>


            <Row form>
                <Col sm="12" md={{ size: 3, offset: 3 }}>
                    <FormGroup >
                        <Label for="Sexo" className="me-sm-2">Sexo</Label>
                        <Input type="select" name="estado" id="estado" placeholder="Sexo" >
                            <option>Masculino</option>
                            <option>Feminino</option>
                            <option>Não quero declarar</option>
                        </Input>
                    </FormGroup>
                </Col>

                <Col md={2}>
                    <FormGroup >
                        <Label for="CPF" className="me-sm-2">CPF</Label>
                        <Input type="text" name="cpf" id="cpf" placeholder="CPF" />
                    </FormGroup>
                </Col>

                <Col md={2}>
                    <FormGroup>
                        <Label for="Data Nascimento" className="me-sm-2">Data de Nascimento</Label>
                        <Input
                            type="date"
                            name="date"
                            id="exampleDate"
                            placeholder="date placeholder"
                        />
                    </FormGroup>
                </Col>
            </Row>

            <Row form>
                <Col sm="12" md={{ size: 3, offset: 3 }}>
                    <FormGroup >
                        <Label for="Telefone" className="me-sm-2">Telefone (DDD + Número)</Label>
                        <Input type="text" name="telefone" id="telefone" placeholder="Telefone" />
                    </FormGroup>
                </Col>

                <Col md={4}>
                    <FormGroup>
                        <Label for="Celular" className="me-sm-2">Celular (DDD + Número)</Label>
                        <Input type="text" name="celular" id="celular" placeholder="Celular" />
                    </FormGroup>
                </Col>
            </Row>

            <Row form>
                <Col sm="12" md={{ size: 3, offset: 3 }}>
                    <FormGroup >
                        <Label for="Cep" className="me-sm-2">CEP</Label>
                        <Input type="text" name="cep" id="cep" placeholder="CEP" />
                    </FormGroup>
                </Col>


                <Col md={2}>
                    <FormGroup >
                        <Label for="Cidade" className="me-sm-2">Cidade</Label>
                        <Input type="text" name="cidade" id="cidade" placeholder="Cidade" />
                    </FormGroup>
                </Col>

                <Col md={2}>
                    <FormGroup className="mb-2 me-sm-2 mb-sm-2">
                        <Label for="Estado" className="me-sm-2">Estado</Label>
                        <Input type="select" name="estado" id="estado">
                            <option>Acre (AC)</option>
                            <option>Alagoas (AL)</option>
                            <option>Amapá (AP)</option>
                            <option>Amazonas (AM)</option>
                            <option>Bahia (BA)</option>
                            <option>Ceará (CE)</option>
                            <option>Distrito Federal (DF)</option>
                            <option>Espírito Santo (ES)</option>
                            <option>Goiás (GO)</option>
                            <option>Maranhão (MA)</option>
                            <option>Mato Grosso (MT)</option>
                            <option>Mato Grosso do Sul (MS)</option>
                            <option>Minas Gerais (MG)</option>
                            <option>Pará (PA)</option>
                            <option>Paraíba (PB)</option>
                            <option>Paraná (PR)</option>
                            <option>Pernambuco (PE)</option>
                            <option>Piauí (PI)</option>
                            <option>Rio de Janeiro (RJ)</option>
                            <option>Rio Grande do Norte (RN)</option>
                            <option>Rio Grande do Sul (RS)</option>
                            <option>Rondônia (RO))</option>
                            <option>Roraima (RR)</option>
                            <option>Santa Catarina (SC)</option>
                            <option>São Paulo (SP)</option>
                            <option>Sergipe (SE)</option>
                            <option>Tocantins (TO)</option>
                        </Input>
                    </FormGroup>
                </Col>
            </Row>

            <Row form>
                <Col sm="12" md={{ size: 7, offset: 3 }}>
                    <FormGroup className="mb-2 me-sm-2 mb-sm-2">
                        <Label for="Endereço" className="me-sm-2">Endereço</Label>
                        <Input type="text" name="endereço" id="endereço" placeholder="Endereço" />
                    </FormGroup>
                </Col>
            </Row>


            <Row form>
                <Col sm="12" md={{ size: 3, offset: 3 }}>
                    <FormGroup >
                        <Label for="Bairro" className="me-sm-2">Bairro</Label>
                        <Input type="text" name="bairro" id="bairro" placeholder="Bairro" />
                    </FormGroup>
                </Col>

                <Col md={1}>
                    <FormGroup className="mb-2 me-sm-2 mb-sm-2">
                        <Label for="Número" className="me-sm-2">Número</Label>
                        <Input type="text" name="número" id="número" placeholder="Número" />
                    </FormGroup>
                </Col>

                <Col md={3}>
                    <FormGroup className="mb-2 me-sm-2 mb-sm-2">
                        <Label for="Complemento" className="me-sm-2">Complemento</Label>
                        <Input type="text" name="complemento" id="complemento" placeholder="Complemento" />
                    </FormGroup>
                </Col>
            </Row>

            <Row form>
                <Col sm="12" md={{ size: 7, offset: 3 }}>
                    <FormGroup className="mb-2 me-sm-2 mb-sm-2">
                        <Label for="exampleEmail" className="me-sm-2">Email</Label>
                        <Input type="email" name="email" id="email" placeholder="Email" />
                    </FormGroup>
                </Col>

                <Col sm="12" md={{ size: 7, offset: 3 }}>
                    <FormGroup className="mb-2 me-sm-2 mb-sm-2">
                        <Label for="examplePassword" className="me-sm-2">Senha</Label>
                        <Input type="password" name="password" id="password" placeholder="********" />
                    </FormGroup>
                </Col>
            </Row>

            <Row form>
                <Col sm="12" md={{ size: 7, offset: 3 }}>
                    <Button outline color="danger" size="lg" block>Cadastrar-se</Button>
                </Col>
            </Row>

        </Form>


    );
}

export default Example;