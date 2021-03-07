import React, {useState, useEffect} from 'react';
import logoImg from '../../assets/logo.png';
import maravilha from '../../assets/maravilha.png';
import hp from '../../assets/hp.png';
import bandeira from '../../assets/bandeira.png';
import './flexboxgrid.min.css';
import api from '../../services/api';
import {Link} from 'react-router-dom';
import './styles.css';
import { FiMenu, FiSearch, FiCreditCard, FiMapPin } from 'react-icons/fi'
import {FlatList} from 'flatlist-react';

export default function Home(){

const [sessao, setSessao] = useState([]);

const id = localStorage.getItem('id');

useEffect(() =>{

    api.get('sessao', {
        headers : {
            Authorization: id,
        }
    }).then(resposta =>{
        setSessao(resposta.data)
    })}, [id])


    return(
        <>            
<div className="body">
<div className="home-container">

<section className="header col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <div className="header-esquerda">
        <Link>
            <FiMenu size={30} className="head-menuIcon" color="#ffffff"/>
                </Link>
                    <img src={logoImg} className="head-logoImg" alt="cinemagic"/>
    </div>
    <div className="header-direita">
        <FiSearch  className="head-searchIcon" size={30} color="#ffffff"/>
           
    </div>
</section>



  {/* Carrousel */}
<section className="carrousel col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <img src={maravilha} alt="maravilha"/>
</section>
{/* Botão Compra */}

<section className="botaoDeCompra col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <button className="button " type="compra">
       <FiCreditCard className="cardicon "size={20} color="#ffffff"/> 
          <label className="labelButton">Compre!</label></button>
</section>

{/* Container de Filmes */}
<section className="filmesContainer col-xs-12 col-sm-12 col-md-12 col-lg-12">
<ul>
{sessao.map(sessao =>(
<li key={sessao.id}>
    <strong>Id : </strong>
    <p>{sessao.id}</p>

    <strong> Nome: </strong>
            <p>{sessao.nome}</p>

              <strong> Valor: </strong>
            <p>{Intl.NumberFormat('pt-BR', {style:'currency', currency: 'BRL'}).format(sessao.valor) }</p>
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