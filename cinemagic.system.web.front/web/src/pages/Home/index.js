import React, {useState} from 'react';
import logoImg from '../../assets/logo.png';
import maravilha from '../../assets/maravilha.png';
import hp from '../../assets/hp.png';
import bandeira from '../../assets/bandeira.png';
import './flexboxgrid.min.css';
import api from '../../services/api';

import {Link} from 'react-router-dom';
import './styles.css';
import { FiMenu, FiSearch, FiCreditCard, FiMapPin } from 'react-icons/fi'


export default function Home(){
    const [filme, setFilme] = useState('')
    
    function handleHome(e){
e.preventDefault();
    }    
    
    return(
        <>            
<div className="body">
<div className="home-container">

<section className="header col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <div className="header-esquerda">
        <Link>
            <FiMenu size={80} className="head-menuIcon" color="#ffffff"/>
                </Link>
                    <img src={logoImg} className="head-logoImg" alt="cinemagic"/>
    </div>
    <div className="header-direita">
        <FiSearch  className="head-searchIcon" size={80} color="#ffffff"/>
            <Link className="head-opcoes">...</Link>
    </div>
</section>


<section className="carrousel col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <img src={maravilha} alt="maravilha"/>
</section>


<section className="botaoDeCompra col-xs-12 col-sm-12 col-md-12 col-lg-12">
    
    
    
    <button className="button " type="compra">
       
        <FiCreditCard className="cardicon "size={70} color="#ffffff"/> 
         
          <label className="">Compre!</label>
                </button>



</section>









<section className="filmesContainer col-xs-12 col-sm-12 col-md-12 col-lg-12">
<div className="filme ">
<img src={hp} alt="hp" className="filmeImg"/>
    <Link className="nomeFilme">Harry Potter</Link>
    <div className="localizacao">
    <FiMapPin className="localizacaoIcon" size={60} color="#000000"/>
    <label className="localizacao">Alegrete</label>
    </div>
    
</div>

<div className="filme">
<img src={hp} alt="hp" className="filmeImg"/>
    <Link className="nomeFilme">Harry Potter</Link>
    <div className="localizacao">
    <FiMapPin className="localizacaoIcon" size={60} color="#000000"/>
    <label className="localizacao">Alegrete</label>
    </div>
    </div>

<div className="filme">
<img src={hp} alt="hp" className="filmeImg"/>
    <Link className="nomeFilme">Harry Potter</Link>
    <div className="localizacao">
    <FiMapPin className="localizacaoIcon" size={60} color="#000000"/>
    <label className="localizacao">Alegrete</label>
    </div>
    </div>
  


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