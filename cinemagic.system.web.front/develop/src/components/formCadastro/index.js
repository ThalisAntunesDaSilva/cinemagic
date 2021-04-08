import React from 'react';
import { Col, Button, Form, FormGroup, Label, Input, Row } from 'reactstrap';
import './styles.css';


const Example = (props) => {
    return (
        <Form>
            <h1>Insira os dados do cliente</h1>
     <div className="layout">
<div className="lado1">  
                        <Label for="Nome" className="Nome">Nome</Label>
                        <Input type="text" name="nome" id="nome" placeholder="Primerio nome" />
                   
                        <Label for="Sobrenome" className="me-sm-2">Sobrenome</Label>
                        <Input type="text" name="sobrenome" id="sobrenome" placeholder="Sobrenome" />
                 
                        <Label for="Sexo" className="me-sm-2">Sexo</Label>
                        <Input type="select" name="estado" id="estado" placeholder="Sexo" >
                            <option>Masculino</option>
                            <option>Feminino</option>
                            <option>Não quero declarar</option>
                        </Input>
                 
                        <Label for="CPF" className="me-sm-2">CPF</Label>
                        <Input type="text" name="cpf" id="cpf" placeholder="CPF" />
                
                        <Label for="Data Nascimento" className="me-sm-2">Data de Nascimento</Label>
                        <Input
                            type="date"
                            name="date"
                            id="exampleDate"
                            placeholder="date placeholder"
                        />
                  
                        <Label for="Telefone" className="me-sm-2">Telefone (DDD + Número)</Label>
                        <Input type="text" name="telefone" id="telefone" placeholder="Telefone" />
                 
                        <Label for="Celular" className="me-sm-2">Celular (DDD + Número)</Label>
                        <Input type="text" name="celular" id="celular" placeholder="Celular" />
                
                        <Label for="Cep" className="me-sm-2">CEP</Label>
                        <Input type="text" name="cep" id="cep" placeholder="CEP" />
                        </div>
                        <div className="lado2">
                        <Label for="Cidade" className="me-sm-2">Cidade</Label>
                        <Input type="text" name="cidade" id="cidade" placeholder="Cidade" />
                
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
               
                        <Label for="Endereço" className="me-sm-2">Endereço</Label>
                        <Input type="text" name="endereço" id="endereço" placeholder="Endereço" />
                
                        <Label for="Bairro" className="me-sm-2">Bairro</Label>
                        <Input type="text" name="bairro" id="bairro" placeholder="Bairro" />
               
                        <Label for="Número" className="me-sm-2">Número</Label>
                        <Input type="text" name="número" id="número" placeholder="Número" />
             
                        <Label for="Complemento" className="me-sm-2">Complemento</Label>
                        <Input type="text" name="complemento" id="complemento" placeholder="Complemento" />
                 
                        <Label for="exampleEmail" className="me-sm-2">Email</Label>
                        <Input type="email" name="email" id="email" placeholder="Email" />
                  
                        <Label for="examplePassword" className="me-sm-2">Senha</Label>
                        <Input type="password" name="password" id="password" placeholder="********" />
                  
               
                    <Button className="mt-5" color="danger" size="lg" block>Cadastrar-se</Button>
                    </div>   </div>
        </Form>


    );
}

export default Example;