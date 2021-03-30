import React, { useState } from 'react';
import { Col, Button, Form, FormGroup, Label, Input, Row } from 'reactstrap';
import api from '../../services/api';
import './styles.css';
import {getToken} from '../../services/auth/auth.js';



const Example = (props) => {


    /*const [nome, setNome] = useState('');
    const [cidade, setCidade] = useState('');
    const [salas, setSalas] = useState('');
    const token = localStorage.getItem('token');

    const [cinema, setCinema] = useState([]);
    const [test, setTest] = useState('');

    async function getApi() {
        try {
            const res = await api.get("cinema")
            setCinema(res.data)
            setTest(res.data[0])
        } catch (ex) {
            alert(ex)
        }
    }

    useEffect(() => {
        getApi()
    }, [token]) 

    async function signup(e) {
        e.preventDefault();

        const data = {
            cinemaId : cinema.id,
            cinemaId: nome,
            cinemaId: cidade,
            cinemaId: salas,
            cinema: [
                {
                    nome: 1,
                    cidade: 1,
                    sala: 2
                }

            ]

        };
                    try {
                const resposta = await api.post("cinema", data, {
                    headers: {
                        authorization: getToken()
                    }
                    },
                    );
                    

                    window.location.href = response.data.code;
                    history.push(response.data.code);

                } catch (ex) {
                    alert(ex.response.data.message)
                }
        }
    */
        return (

            <Form className="forme">
    
    
                <Row forme>
                    <Col sm="12" md={{ size: 7, offset: 3 }}>
                        <FormGroup >
                            <Label for="Nome" className="Nome">Nome do Cinema</Label>
                            <Input type="text" name="nome" id="nome" placeholder="Nome Completo" /* onChange={e => setNome(e.target.value)} *//>
                        </FormGroup>
                    </Col>
                </Row>
    
                <Row forme>
                    <Col  sm="12" md={{ size: 7, offset: 3 }}>
                        <FormGroup >
                            <Label for="Cidade" className="me-sm-2">Cidade</Label>
                            <Input type="text" name="cidade" id="cidade" placeholder="Cidade" /*onChange={e => setCidade(e.target.value)}*/ />
                        </FormGroup>
                    </Col>
                    </Row>
    
                    <Row forme>
                    <Col  sm="12" md={{ size: 7, offset: 3 }}>
                        <FormGroup className="mb-2 me-sm-2 mb-sm-2">
                            <Label for="Salas" className="me-sm-2">Numero de Salas</Label>
                            <Input type="text" name="salas" id="salas" placeholder="Numero de Salas" /*onChange={e => setSalas(e.target.value)}*/ />
                        </FormGroup>
                    </Col>
                    </Row>
    
                <Row forme>
                    <Col sm="12" md={{ size: 7, offset: 3 }}>
                        <Button outline color="danger" size="lg" /*onClick={signup}*/ block>Cadastrar-se</Button>
                    </Col>
                </Row>
    
            </Form>
    
    
        );
    
    }
    



export default Example; 