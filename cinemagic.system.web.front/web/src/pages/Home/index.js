import React from 'react';
import logoImg from '../../assets/logo.png';
import maravilha from '../../assets/maravilha.png';
import hp from '../../assets/hp.png';
import bandeira from '../../assets/bandeira.png';
import {Link} from 'react-router-dom';
import './styles.css';
import { FiMenu, FiSearch, FiCreditCard, FiMapPin } from 'react-icons/fi'

//api
export default function Home(){
    return(
        <>
            
<div className="body">
<div className="home-container">

<section className="head">
<Link>
<FiMenu size={80} className="head-menuIcon" color="#ffffff"/>
</Link>
<img src={logoImg} className="head-logoImg" alt="cinemagic"/>
<h1>Cinamgic</h1>
<FiSearch  className="head-searchIcon" size={80} color="#ffffff"/>
<Link className="head-opcoes">...</Link>
</section>

<section className="carrousel">
<img src={maravilha} alt="maravilha"/>
</section>

<section className="botaoDeCompra">
<button className="button" type="compra">
   <FiCreditCard className="cardicon"size={80} color="#ffffff"/> 
     Compre já seu ingresso
     </button>
</section>

<section className="Filmes">

<div className="filme">
<img src={hp} alt="hp" className="filmeImg"/>
    <Link className="nomeFilme">Harry Potter</Link>
    <div className="localizacao">
    <FiMapPin className="localizacaoIcon" size={60} color="#000000"/>
    <label className="localizacao">Alegrete</label>
    </div>
    
</div>

<div className="filme2">
<img src={hp} alt="hp" className="filmeImg"/>
    <Link className="nomeFilme">Harry Potter</Link>
    <div className="localizacao">
    <FiMapPin className="localizacaoIcon" size={60} color="#000000"/>
    <label className="localizacao">Alegrete</label>
    </div>
    </div>

    <div className="filme3">
<img src={hp} alt="hp" className="filmeImg"/>
    <Link className="nomeFilme">Harry Potter</Link>
    <div className="localizacao">
    <FiMapPin className="localizacaoIcon" size={60} color="#000000"/>
    <label className="localizacao">Alegrete</label>
    </div>
    </div>
    <div className="filme4">
<img src={hp} alt="hp" className="filmeImg"/>
    <Link className="nomeFilme">Homem Aranha</Link>
    <div className="localizacao">
    <FiMapPin className="localizacaoIcon" size={60} color="#000000"/>
    <label className="localizacao">Alegrete</label>
    </div>
    </div>


</section>




<section className="rodape">
<img src={logoImg} alt="cinemagic"/>
<h1>Cinamgic</h1>
<Link className="mudarPais">Mudar País</Link>
<Link className="mudarCidade">Mudar Cidade</Link>
<img src={bandeira} alt="bandeira" className="bandeira" />

</section>


</div>

</div>
</>
    );





}