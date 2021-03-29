import React, {useState} from 'react';
import { Button, Input } from 'reactstrap';
import { FiSearch} from 'react-icons/fi';
import './styles.css';
import { Link, useHistory } from 'react-router-dom';
import api from '../../services/api';


const Example = (props) => {
 
 const [nomeCidade, setNomeCidade] = useState('')
  const history = useHistory();
  const [sessao, setSessao] = useState([]);


  async function pesquisar(evento){
    evento.preventDefault();

  try{
   const resposta = await api.get(`sessoes/cidade/nome/${nomeCidade}`);
   

  const cidade = localStorage.setItem('cidadePesquisada', JSON.stringify(resposta));

  history.push('/ResultadoPesquisa');
  
}catch(err){
    alert('Ops, nada encontrado');
}

}

 
  return (
        <form className="input-div" onSubmit={pesquisar}>
    
    <Input type="text"
        placeholder="Search"
        value={nomeCidade}
        className="input w-25 p-3"
        onChange={evento => setNomeCidade(evento.target.value)}
       /> 
     
      <Button color="danger" className="button" type="submit"  onClick={pesquisar}>
     
     
     
      <FiSearch className="icon-search" size={16} color="#ffffff"/>
      </Button>
    
      </form>
  
  
  );
}

export default Example;