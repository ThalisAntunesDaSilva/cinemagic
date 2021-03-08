import React, {useState} from 'react';
import {useHistory} from 'react-router-dom'
import api from '../../services/api';
import login from '../../assets/login.jpeg'
import cinemagic from '../../assets/cinemagic.jpeg';
import logo from '../../assets/logo.png'
import {Link} from 'react-router-dom';
import './styles.css';
import { FiMenu, FiSearch, FiCreditCard, FiMapPin } from 'react-icons/fi'
import { FiPrinter } from 'react-icons/fi'
import axios from 'axios';
import jwt from 'jwt-decode'
export default function Home(){
    
    let history = useHistory()
    
  
    const [email,setEmail] = useState('');
    const [senha,setSenha] = useState('');


    async function AcaoBotao (e){
       try{
            const res = await api.post("/login", {
                "email": email,
                "senha": senha
            })
            const token = res.headers["authorization"]   
            const decoded = jwt(token)
            localStorage.setItem('token',token)
            const clientRes = await api.get("/clientes",{
                params:{
                    email: "gabriel@gmail.com"
                },
                headers:{
                    authorization: localStorage.getItem("token")
                }
            })
            localStorage.setItem('cliente',JSON.stringify(clientRes.data))

            const test = JSON.parse(localStorage.getItem('cliente'))
            history.push("/Home")
        }catch(ex){
            alert(ex)
        }
        
    
 
    }


    return (
        <>

            <div className="home-container">

                <section className="header col-xs-11 col-sm-12 col-md-11 col-lg-12">

                    <div className="header-centro">
                        <img src={logo} className="header-centro" alt="logo" />

                        <div className="header-centro2">
                            <img src={cinemagic} className="header-centro" alt="cinemagic" />
                        </div>
                    </div>

                </section>
            </div>

            <div className="body">

                <label for="email"> E-mail</label>
                <input className="input" type="email" name="email" id="email" placeholder="Digite seu e-mail" onChange={e => setEmail(e.target.value)} ></input>

                <label for="password"> Senha</label>
                <input className="input" type="password" name="password" id="password" placeholder="Digite a sua senha" onChange={e => setSenha(e.target.value)}></input>

                <label for="agreement" id="agreement-label"> Caso não tenha cadastro<a> clique aqui</a></label>

                <button className="button" type="submit" onClick={AcaoBotao} > Login </button>

            </div>
        </>
    );





}