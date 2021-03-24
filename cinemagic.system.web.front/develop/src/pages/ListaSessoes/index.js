import React, { useState, useEffect } from 'react';                               
import api from '../../services/api';

import cardListadeSessoes from '../../components/cardListadeSessoes/index.js';



export default function Teste() {
    const [sessao, setSessao] = useState([]);
    const token = localStorage.getItem('token');
    const [test,setTest] = useState('')
    async function getApi() {
        try {
            const res = await api.get("sessoes")
            setSessao(res.data)
            setTest(res.data[0])
        } catch (ex) {
            alert(ex)
        }
    }
    useEffect(() => {
        getApi()
    }, [token])


    return (
        <>
          
          
          <div className="sessao">
          {cardListadeSessoes()}
          
          
          
                
                    </div>

        </>
    );





}