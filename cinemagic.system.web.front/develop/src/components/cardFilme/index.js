import hp from '../../assets/hp.png'
import './styles.css';
import React, { useState, useEffect } from 'react';      
import api from '../../services/api';
import { useHistory } from 'react-router-dom';
import {
  Card, CardText, CardBody, CardLink,
  CardTitle, CardSubtitle, Button
} from 'reactstrap';


const Example = (props) => {
  const history = useHistory();
  const [sessao, setSessao] = useState([]);
  const sessaoSelecionada = localStorage.getItem('id');
 // sessao = JSON.parse(sessaoSelecionada);
  
  
  
  async function getSessaoSelecionada(evento){
    evento.preventDefault(); 
  try{
   setSessao(sessao);
  
  }catch(err){
    alert('Ops, nada encontrado');
}}



  useEffect(() => {
    getSessaoSelecionada()
  })
 
 
 
 
 
  return (
    <div>
  
      <Card>
        <CardBody>

          <CardTitle tag="h5">Seção Alegrete-RS</CardTitle>
          <CardSubtitle tag="h6" className="mb-2 text-muted">Filmes em sessão</CardSubtitle>
        </CardBody>


       <div className="filmes">
        <img width="20%" height="20%" src={hp} alt="Card image cap" />
        <img width="20%" height="20%" src={hp} alt="Card image cap" />
        <img width="20%" height="20%" src={hp} alt="Card image cap" />
              </div>
       
        <CardBody>
    <div className="filmes">
          <CardText></CardText>
          <CardText>sessao.nome</CardText>
          <CardText>Todo Poderoso: 20:00</CardText>
      </div>
         </CardBody>
    
      </Card>
    </div>
  );
};

export default Example;