import React, { useState, useEffect } from 'react';
import logoImg from '../../assets/logo.png';
import maravilha from '../../assets/maravilha.png';
import hp from '../../assets/hp.png';
import bandeira from '../../assets/bandeira.png';
import './flexboxgrid.min.css';
import api from '../../services/api';
import { Link } from 'react-router-dom';
import './styles.css';
import { FiMenu, FiSearch, FiCreditCard, FiMapPin } from 'react-icons/fi'
import { FlatList } from 'flatlist-react';
import avatar from '../Components/avatar/index.js'
import {getToken, isAuthenticaded} from '../../services/auth/auth.js'
export default function Home() {
    const [sessao, setSessao] = useState([]);
    const token = localStorage.getItem('token');
    const [test,setTest] = useState('')
    async function getApi() {
        try {
            const res = await api.get("sessoes")
            localStorage.removeItem("cinemagic-Token")
            setSessao(res.data)
            setTest(res.data[0])
        } catch (ex) {
            alert(ex.response.data.message)
        }
    }
    useEffect(() => {
        getApi()
    }, [token])


    return (
        <>
            <div className="body">
                <div className="home-container">

                    <section className="header col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div className="header-esquerda">
                            <Link>
                                <FiMenu size={30} className="head-menuIcon" color="#ffffff" />
                            </Link>
                            <img src={logoImg} className="head-logoImg" alt="cinemagic" />
                        </div>
                        <div className="header-direita">
                            <FiSearch className="head-searchIcon" size={30} color="#ffffff" />
                            
                        </div>
                        <div className ="inf-user">  
                            {avatar()}
                        </div>
                    </section>



                    {/* Carrousel */}
                    <section className="carrousel col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <img src={maravilha} alt="maravilha" />
                    </section>
                    {/* Botão Compra */}

                    <section className="botaoDeCompra col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <button className="button " type="compra">
                            <FiCreditCard className="cardicon " size={20} color="#ffffff" />
                            <label className="labelButton">Compre! {test.valorInteira} </label></button>
                    </section>

                    {/* Container de Filmes */}
                    <section className="filmesContainer col-xs-12 col-sm-12 col-md-12 col-lg-12">
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









                    <section className="rodape">

                        <div>
                            <img src={bandeira} alt="bandeira" className="bandeira" />

                        </div>
                    </section>


                </div>

            </div>
        </>
    );





}