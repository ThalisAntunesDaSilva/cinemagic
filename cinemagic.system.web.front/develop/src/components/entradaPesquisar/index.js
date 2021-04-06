import React, {useState} from 'react';
import { Button, Input, Dropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import { FiSearch} from 'react-icons/fi';
import './styles.css';
import { Link, useHistory } from 'react-router-dom';
import api from '../../services/api';




const Example = (props) => {
  const [dropdownOpen, setDropdownOpen] = useState(false);

  const toggle = () => setDropdownOpen(prevState => !prevState);
 
 const [entrada, setEntrada] = useState('')
 const [tituloFilme, setTituloFilme] = useState('')
  const history = useHistory();



  async function pesquisar(evento){
    evento.preventDefault();

  try{
   
    if(evento.target.innerText == "Filme"){
      const response = await api.get(`sessoes/filme/${entrada}`); 
     localStorage.setItem('filmePesquisado', JSON.stringify(response.data));
    }else
     if(evento.target.innerText == "Cidade"){
    const resposta = await api.get(`sessoes/cidade/nome/${entrada}`);

 localStorage.setItem('cidadePesquisada', JSON.stringify(resposta.data));
}
  history.push('/ResultadoPesquisa');
  
}catch(err){
    alert(err.message);
}

}


 
  return (
        <form className="input-div" onSubmit={pesquisar}>
   <Dropdown  isOpen={dropdownOpen} toggle={toggle}>
      <DropdownToggle caret color="danger" className="dropdown">
        Pesquisar por
      </DropdownToggle>
      <DropdownMenu>
        <DropdownItem onClick={pesquisar}>Filme</DropdownItem>
        <DropdownItem onClick={pesquisar}>Cidade</DropdownItem>
       
      </DropdownMenu>
    </Dropdown>



    <Input type="text"
        placeholder="Digite aqui"
        value={entrada}
        className="input w-25 p-3"
        onChange={evento => setEntrada(evento.target.value)}
       /> 
     
      <Button color="danger" className="button" type="submit"  onClick={pesquisar}>
     
     
     
      <FiSearch className="icon-search" size={16} color="#ffffff"/>
      </Button>
    
      </form>
  
  
  );
}

export default Example;