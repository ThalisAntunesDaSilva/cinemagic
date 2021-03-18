import React, { useState, useEffect } from 'react';
import logoImg from '../../assets/logo.png';
import maravilha from '../../assets/maravilha.png';
import hp from '../../assets/hp.png';
import bandeira from '../../assets/bandeira.png';                                 
import api from '../../services/api';
import { Link } from 'react-router-dom';
import './styles.css';
import { FiMenu, FiSearch, FiCreditCard, FiMapPin } from 'react-icons/fi'
import { FlatList } from 'flatlist-react';

export default function Teste() {
    const [sessao, setSessao] = useState([]);
    const token = localStorage.getItem('token');
    const [test,setTest] = useState('')
    async function getApi() {
        try {
            const res = await api.get("sessoes")
            setSessao(res.data)
            setTest(res.data[0])
        } catch (ex) {
            alert(ex)
        }
    }
    useEffect(() => {
        getApi()
    }, [token])


    return (
        <>
            <div className="body">
                <div className="home-container">
                    {/* Container de Filmes */}
                    <section className="">
                        <ul>
                            {sessao.map(ses => (
                                <li key={ses.id}>
                                    <strong>Id : </strong>
                                    <p className = "test">{ses.id}</p>

                                    <strong> Nome: </strong>
                                    <p>{ses.valorInteira}</p>

                                    <strong> Valor: </strong>
                                    <p>{Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(ses.valorInteira)}</p>
                                </li>

                            ))}

                        </ul>

                    </section>








                </div>

            </div>
        </>
    );





}