import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import CadastroCliente from './pages/CadastroCliente';
import Login from './pages/login';
import Compra from './pages/Compra';
import Teste from './pages/Teste'



export default function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Login} />
                <Route path="/CadastroCliente" exact component={CadastroCliente} />
                <Route path="/Home" exact component={Home} />
                <Route path= "/Compra" exact component ={Compra} />
                <Route path= "/Teste" exact component ={Teste} />
            </Switch>
        </BrowserRouter>
    );

}