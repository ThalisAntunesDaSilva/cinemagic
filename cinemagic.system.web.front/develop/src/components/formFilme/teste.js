import React, { useState, useEffect } from 'react';
import { Row, Col, Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';
import { useHistory } from 'react-router-dom';
import api from '../../services/api';
import { login, getToken } from '../../services/auth/auth.js';
import './styles.css';



const Example = (props) => {
    let history = useHistory();

    const [erroLogin, setErroLogin] = useState("");
    const [generos, setGeneros] = useState([]);

    const [titulo, setTitulo] = useState('');
    const [genero, setGenero] = useState('');
    const [duracao, setDuracao] = useState('');

    async function acaoBotao(e) {
        e.preventDefault();

        const data = {
            titulo: titulo,
            duracao: duracao,
            filmes: [
                {
                    titulo: titulo,
                    duracao: duracao
                }
            ]
        };

        try {

            const res = await api.post("/filmes", data, {
                headers: {
                    authorization: getToken()
                }
            },
            );
            window.location.href = res.data.code;
            history.push(res.data.code);

        } catch (ex) {
            alert(ex.response.data.message)
        }
    }

    async function getGeneros() {
        try {
            const res = await api.get("generos");
            setGeneros(res.data);
        } catch (e) {
            alert(e);
        }
    }

    return (
        <Form className="form">
            <Col sm="20" md={{ size: 4, offset: 4 }}>
                <FormGroup >
                    <Label for="titulo" >Título</Label>
                    <Input type="text" name="titulo" onChange={e => setTitulo(e.target.value)} id="titulo" placeholder="Título do filme" />
                </FormGroup>
                <FormGroup >
                    <Label for="duracao" >Duraçao</Label>
                    <Input type="text" name="duracao" onChange={e => setDuracao(e.target.value)} id="duracao" placeholder="Duraçao do filme" />
                </FormGroup>

            </Col>
            <Col sm="20" md={{ size: 4, offset: 4 }}>
                <FormGroup>
                    <Label for="generos">Gêneros</Label>
                    <Input type="select" name="select" id="exampleSelect" onChange={e => getGeneros(e.target.value)}>
                        <select name="estado" id="estado" onChange={e => setGenero(e.target.value)} onClick={getGeneros}>
                            <option>Selecione um genro</option>
                            {generos.map(genero => (
                                <option value={genero.id}>{genero.nome}</option>
                            ))}
                        </select>
                    </Input>
                </FormGroup>
            </Col>
            <Row form>
                <Col sm="20" md={{ size: 4, offset: 4 }}>
                    <Button outline color="danger" size="lg" onClick={acaoBotao}>Inserir</Button>
                </Col>
            </Row>
        </Form>
    );
}

export default Example;
