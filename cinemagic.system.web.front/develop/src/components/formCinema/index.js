import React, { useState }  from 'react';
import { Col, Button, Form, FormGroup, Label, Input, Row } from 'reactstrap';
import api from '../../services/api';
import { useHistory } from 'react-router-dom';
import { getToken } from '../../services/auth/auth';
import './styles.css';


const Example = (props) => {
    const history = useHistory();
    const token = localStorage.getItem('token');
    
    const [nome,setNome] = useState([]);
    const [cidadeId,setCidadeId] = useState([]);
    const [salasId,setSalasId] = useState([]);


    async function click(e) {
    e.preventDefault();
    
    const data = {
        "nome": nome,
        "cidadeId": cidadeId,
        "salasId": salasId,
        };
    try {
    const response = await api.post("cinemas", data, 
    {headers: {authorization: getToken()}});
    window.location.href = response.data.code;
    history.push(response.data.code);

    
    alert (`sucesso: ${response.status}`);


    } catch (ex) {
        alert(ex.response.data.message)
    }

    }

    return (

        <body>
        <Form className="forme">


            <Row forme>
                <Col sm="12" md={{ size: 7, offset: 3 }}>
                    <FormGroup >
                        <Label for="Nome" className="Nome">Nome do Cinema</Label>
                        <Input type="text" name="nome" id="nome" placeholder="Nome do Cinema" onChange = {e => setNome(e.target.value)} />
                    </FormGroup>
                </Col>
            </Row>

            <Row forme>
                <Col  sm="12" md={{ size: 7, offset: 3 }}>
                    <FormGroup >
                        <Label for="CidadeId" className="me-sm-2">Id da Cidade</Label>
                        <Input type="integer" name="cidadeId" id="cidadeId" placeholder="Id da Cidade" onChange = {e => setCidadeId(e.target.value)}/>
                    </FormGroup>
                </Col>
                </Row>

                <Row forme>
                <Col  sm="12" md={{ size: 7, offset: 3 }}>
                    <FormGroup className="mb-2 me-sm-2 mb-sm-2">
                        <Label for="SalasId" className="me-sm-2">Numero de Salas</Label>
                        <Input type="integer" name="salasId" id="salasId" placeholder="Numero de Salas" onChange = {e => setSalasId(e.target.value)} />
                    </FormGroup>
                </Col>
                </Row>



            <Row forme>
                <Col sm="12" md={{ size: 7, offset: 3 }}>
                    <Button outline color="danger" size="lg" onClick={click} block>Cadastrar-se</Button>
                </Col>
            </Row>

        </Form>
        </body>


    );
}

export default Example;