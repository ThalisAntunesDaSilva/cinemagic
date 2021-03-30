import React, { useState } from 'react';
import { Form, Input, Label, Button } from 'reactstrap';
import api from '../../services/api';
import { getToken } from '../../services/auth/auth'
import { useHistory } from 'react-router-dom';
import './styles.css';

const sessao = JSON.parse(localStorage.getItem('sessaoAtual'));
const cliente = JSON.parse(localStorage.getItem('cliente'));





const Example = (props) => {
  const history = useHistory();
  const [qtdInteira,setQtdInteira] = useState(0);
  const [qtdMeia,setQtdMeia] = useState(0);
  async function click(e) {
    alert(qtdMeia);
    const data = {
      clienteId: sessao.id,
      sessaoId: cliente.id,
      ingressos: [
        {
          quantidade: qtdMeia,
          tipoIngresso: 1
        },
        {
          quantidade: qtdInteira,
          tipoIngresso: 0
        }
      ],
      tipoPagamento: 0
    };
    try {

      const response = await api.post("compras", data, {
        headers: {
          authorization: getToken()
        }
      },
      );
      window.location.href = response.data.code;
      history.push(response.data.code);
    } catch (ex) {
      alert(ex.response.data.message)
    }

  }

  return (
    <bodu>
      <Form className="formularioDeSessao">

      <Label for="Nome" type="text" size="5" className="Nome text-light mt-3 w-25">Data</Label>
        <Input onChange={value => setQtdInteira(value.target.value)}/>
        
        <Label for="Nome" className="Nome text-light mt-3">Hora</Label>
        <Input onChange = {value => setQtdMeia(value.target.value)}/>

        <Label for="Nome" className="Nome text-light mt-3">Valor Inteira</Label>
        <Input onChange = {value => setQtdMeia(value.target.value)}/>

        <Label for="Nome" className="Nome text-light mt-3">Valor Meia</Label>
        <Input onChange = {value => setQtdMeia(value.target.value)}/>

        <Label for="Nome" className="Nome text-light mt-3">Situação sessão</Label>
        <Input type="select" onChange = {value => setQtdMeia(value.target.value)}>
          <option value = "1">Encerrada</option>
          <option value = "2">Em andamento</option>
        </Input>

        <Label for="Nome" className="Nome text-light mt-3">Troca por cupons</Label>
        <Input type="select" onChange = {value => setQtdMeia(value.target.value)}>
          <option value = "1">Sim</option>
          <option value = "2">Não</option>
        </Input>

        <Label for="Nome" className="Nome text-light mt-3">Valor em pontos</Label>
        <Input onChange = {value => setQtdMeia(value.target.value)}/>

        <Label for="Nome" className="Nome text-light mt-3">Filmes em cartaz</Label>
        <Input type="select" onChange = {value => setQtdMeia(value.target.value)}>
          <option value = "1">Homem Aranha</option>
        </Input>

        <Label for="Nome" className="Nome text-light mt-3">Número Sala</Label>
        <Input type="select" onChange = {value => setQtdMeia(value.target.value)}>
          <option value = "1">Homem Aranha</option>
        </Input>

        <Label for="Nome" className="Nome text-light mt-3">País</Label>
        <Input type="select" onChange = {value => setQtdMeia(value.target.value)}>
          <option value = "1">Brasil</option>
        </Input>

        <Label for="Nome" className="Nome text-light mt-3">Estado</Label>
        <Input type="select" onChange = {value => setQtdMeia(value.target.value)}>
          <option value = "1">Rio Grande do Sul</option>
        </Input>

        <Label for="Nome" className="Nome text-light mt-3">Cidade</Label>
        <Input type="select" onChange = {value => setQtdMeia(value.target.value)}>
          <option value = "1">Alegrete-RS</option>
        </Input>

        <Button color="danger" className="mt-3" onClick={click}>Cadastrar</Button>

      </Form>

      
      </bodu>
    
  );
}

export default Example;