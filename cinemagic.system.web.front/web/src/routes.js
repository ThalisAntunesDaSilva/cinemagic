import React, { Component } from 'react';
import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import CadastroCliente from './pages/CadastroCliente';
import Teste from './pages/Teste';
import PaginaInicial from './pages/PaginaInicial'
import {isAuthenticaded} from './services/auth/auth.js';
import ResultadoPesquisaTeste from './pages/ResultadoPesquisaTeste';


const PrivateRoute = ({component: Component, ...rest}) => (
  <Route
    {...rest}
    render = {props =>
        isAuthenticaded()? (
            <Component {...props}/>
        ): (
            <Redirect to = {{ pathname: "/Login",state: {from: props.location}}} />
        )

    }
  />  
);
const PrivateRouteLogin = ({component: Component, ...rest}) => (
    <Route
      {...rest}
      render = {props =>
          !isAuthenticaded()? (
              <Component {...props}/>
          ): (
              <Redirect to = {{ pathname: "/",state: {from: props.location}}} />
          )
  
      }
    />  
  );


export default function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                
                <Route path="/" exact component={Home} />
                <Route path="/CadastroCliente" exact component={CadastroCliente} />
              
              
                <Route path= "/ResultadoPesquisaTeste" exact component ={ResultadoPesquisaTeste} />
                <Route path= "/Teste" exact component ={Teste} />

                <Route path= "/PaginaInicial" exact component ={PaginaInicial} />
                <Route path="/BuscarSessao" exact component={BuscarSessao} />
                <Route path="/Sessoes" exact component={Sessoes} />

            </Switch>
        </BrowserRouter>
    );

}