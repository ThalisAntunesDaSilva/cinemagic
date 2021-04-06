import React, { useState, useEffect } from 'react';
import {
    Button, Jumbotron, Row, Col, Form, FormGroup, Label, Input
} from 'reactstrap';
import api from '../../services/api'
//import './styles.css';

export default function Teste() {

    const [filme, setFilmes] = useState([]);
    const token = localStorage.getItem('token');
    const [test, setTest] = useState('')

    const [titulo, setTitulo] = useState('');
    const [id, setId] = useState('');
    const [genero, setGenero] = useState('');
    const [duracao, setDuracao] = useState('');


    async function getApi() {
        try {
            const res = await api.get("filmes")
            setFilmes(res.data)
            setTest(res.data[0])
        } catch (ex) {
            alert(ex)
        }
    }
    useEffect(() => {
        getApi()
    }, [token])


    const encaminhaTroca = ses => async e => {
        alert("Trocado");
    }


    return (
        <>
            <div className="body-section">
                <ul className="super">
                    <li><a href="">Home</a></li>
                    <li><a href="">Cinemas</a></li>
                    <li><a href="">Sessoes</a></li>
                </ul>
                <ul>
                    <h1 className="title">Editar filme</h1>
                    {filme.map(ses => (
                        <li key={ses.id}>
                            <Jumbotron>
                                <div>
                                    <FormGroup >
                                        <Label for="titulo" >ID do filme a ser modificado:</Label>
                                        <Input type="text" name="titulo" onChange={e => setId(e.target.value)} id="titulo" placeholder="Título do filme" />
                                    </FormGroup>
                                    <FormGroup >
                                        <Label for="titulo" >Novo titulo:</Label>
                                        <Input type="text" name="titulo" onChange={e => setTitulo(e.target.value)} id="titulo" placeholder="Título do filme" />
                                    </FormGroup>
                                    <FormGroup >
                                        <Label for="duracao" >Nova duração:</Label>
                                        <Input type="text" name="duracao" onChange={e => setDuracao(e.target.value)} id="duracao" placeholder="Duraçao do filme" />
                                    </FormGroup>
                                    <Button color="danger" onClick={encaminhaTroca(ses)}>Editar</Button>
                                </div>
                            </Jumbotron>
                        </li>
                    ))}
                </ul>
            </div>
        </>
    );
}