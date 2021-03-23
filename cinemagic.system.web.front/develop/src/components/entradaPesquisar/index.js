import React, {useState} from 'react';
import { Button, Input } from 'reactstrap';
import { FiSearch} from 'react-icons/fi';
import './styles.css';
import { Link, useHistory } from 'react-router-dom';
import api from '../../services/api';


const Example = (props) => {
 
 const [id, setId] = useState('')
  const history = useHistory();


  async function pesquisar(evento){
   
   
    evento.preventDefault();
    id = localStorage.getItem('id');
  alert('chegou 1');
  history.push('/Pesquisa');
  try{
   const resposta = await api.get(`sessoes/${id}`);
   setId(resposta.data);
   
   
   alert(id);
  
}catch(err){
    alert('Ops, nada encontrado');
}

}

 
  return (
        <form className="input-div" onSubmit={pesquisar}>
    
    <Input type="text"
        placeholder="Search"
        value={id}
        className="input w-25 p-3"
        onChange={evento => setId(evento.target.value)}
       /> 
     
      <Button color="danger" className="button" type="submit"  onClick={pesquisar}>
     
     
     
      <FiSearch className="icon-search" size={16} color="#ffffff"/>
      </Button>
    
      </form>
  
  
  );
}

export default Example;