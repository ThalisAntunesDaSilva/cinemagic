import React, {useState} from 'react';
import {useHistory} from 'react-router-dom'
import api from '../../services/api';
import {Link} from 'react-router-dom';
import './styles.css';
import { FiPrinter } from 'react-icons/fi'
import axios from 'axios';
import jwt from 'jwt-decode'
export default function Home(){
    
    let history = useHistory()
    
  
    const [email,setEmail] = useState('');
    const [senha,setSenha] = useState('');


    async function AcaoBotao (e){
       try{
            const res = await api.post("/login", {
                "email": email,
                "senha": senha
            })
            const token = res.headers["authorization"]   
            const decoded = jwt(token)
            localStorage.setItem('token',token)
            const clientRes = await api.get("/clientes",{
                params:{
                    email: "gabriel@gmail.com"
                },
                headers:{
                    authorization: localStorage.getItem("token")
                }
            })
            localStorage.setItem('cliente',JSON.stringify(clientRes.data))

            const test = JSON.parse(localStorage.getItem('cliente'))
            history.push("/Home")
        }catch(ex){
            alert(ex)
        }
        
    
 
    }

    

    return(
        <>            
            <div className="body">
               <input className="input" type = "email"  onChange={e => setEmail(e.target.value)} ></input>
               <input className= "input" type = "password"  onChange={e => setSenha(e.target.value)}></input>
               <button className = "button" type ="submit" onClick = {AcaoBotao} > Entrar </button>
            </div>
        </>
    );





}