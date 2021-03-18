import React, { useState } from 'react';
import { useHistory } from 'react-router-dom'
import api from '../../services/api';
import './styles.css'

export default function Compra() {
    const [tipoPagamento, setTipoPagamento] = useState('');

    async function AcaoBotao(e) {
        localStorage.setItem("idSessao", 1)
        localStorage.setItem("qtdIngressoType1", 2)
        localStorage.setItem("qtdIngressoType0", 2)
        const token = localStorage.getItem("token")
        const idCliente = JSON.parse(localStorage.getItem("cliente"))["id"]
        const data =  {
            clienteId: idCliente,
            sessaoId: localStorage.getItem("idSessao"),
            ingressos: [
                {
                    quantidade: localStorage.getItem("qtdIngressoType0"),
                    tipoIngresso: 0
                },
                {
                    quantidade: localStorage.getItem("qtdIngressoType1"),
                    tipoIngresso: 1
                }
            ],
            tipoPagamento: tipoPagamento
        };
        try {
            const res = await api.post("compras",data,{
                headers:{
                    authorization: token
                }
            })
            alert("Compra realizada com sucesso")
        }catch(e){
            alert(e.response.data.message)
        }
    
    }


    return (
        <>
            <div className="body">
                <input className="input" type="numer" onChange={e => setTipoPagamento(e.target.value)} ></input>
                <button className="button" type="submit" onClick={AcaoBotao} > Comprar </button>
            </div>
        </>
    );

}