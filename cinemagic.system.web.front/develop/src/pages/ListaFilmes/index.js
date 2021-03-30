import React, { useState, useEffect } from 'react';
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button, Navbar, NavItem,
    NavLink
} from 'reactstrap';
import api from '../../services/api'
import './styles.css';



export default function Teste() {
    const [filme, setFilmes] = useState([]);
    const token = localStorage.getItem('token');
    const [test, setTest] = useState('')

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

    /*
    <CardText>Genero: {ses.genero.descricao}</CardText>
    */

    return (
        <>  
            <ul>
                <li><a href="">Home</a></li>
            </ul>
            <div>
                <ul>
                    <h1 className="title">Filmes cadastrados:</h1>
                    <Card body inverse color="primary">
                        {filme.map(ses => (
                            <CardBody key={ses.id}>
                                <CardImg top width="100%" src="" alt="Imagem" />
                                <CardTitle tag="h5">{ses.titulo}</CardTitle>
                                <CardSubtitle tag="h6" className="mb-2 text-muted">ID: {ses.id}</CardSubtitle>
                                <CardText>Tempo do filme: {ses.duracao}</CardText>
                                <Button>Assistir</Button>
                            </CardBody>
                        ))}
                    </Card>
                </ul>
            </div>
        </>
    );
}